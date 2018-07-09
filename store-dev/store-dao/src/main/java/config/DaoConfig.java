package config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import mapper.Mapper;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * @author panke
 * @date created in 2018/6/10 19:19
 */

@Configuration
@MapperScan(basePackageClasses = Mapper.class)
@PropertySource("classpath:jdbc.properties")
public class DaoConfig {

    private Environment environment;

    @Autowired
    public DaoConfig(Environment environment) {
        this.environment = environment;
    }

    /**
     * 配置连接池
     *
     * @return 连接池实例
     */
    @Bean
    public DruidDataSource dataSource() {

        DruidDataSource dataSource = new DruidDataSource();

        dataSource.setDriverClassName(environment.getProperty("jdbc.driverClass"));
        dataSource.setUrl(environment.getProperty("jdbc.url"));
        dataSource.setUsername(environment.getProperty("jdbc.username"));
        dataSource.setPassword(environment.getProperty("jdbc.password"));

        dataSource.setInitialSize(1);
        dataSource.setMinIdle(1);
        dataSource.setMaxActive(10);

        dataSource.setMaxWait(5000);

        dataSource.setTimeBetweenEvictionRunsMillis(10000);

        return dataSource;
    }

    /**
     * 配置mybatis的mapper映射
     *
     * @return SqlSessionFactoryBean对象
     * @throws Exception getObject
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        sqlSessionFactoryBean.setTypeAliasesPackage("pojo");
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("mapper/*.xml"));
        sqlSessionFactoryBean.setConfigLocation(
                new DefaultResourceLoader().getResource("mybatis-config.xml"));

        return sqlSessionFactoryBean.getObject();
    }

    /**
     * 配置注解事务管理器
     *
     * @return 事务管理器
     */

    @Bean
    public DataSourceTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }
}
