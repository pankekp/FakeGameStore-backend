package pojo;

/**
 * @author panke
 * @date created in 2018/7/21 15:51
 */
public class ContactInfo {

    private Integer id;
    private String name;
    private String phone;
    private String address;
    private String postcode;

    public ContactInfo() {
    }

    public ContactInfo(Integer id, String name, String phone, String address, String postcode) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.postcode = postcode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
}
