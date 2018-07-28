package pojo;

/**
 * @author panke
 * @date created in 2018/7/27 20:43
 */
public class ContactInfoCollection {

    private Integer userId;
    private ContactInfo contactInfo;

    public ContactInfoCollection() {
    }

    public ContactInfoCollection(Integer userId, ContactInfo contactInfo) {
        this.userId = userId;
        this.contactInfo = contactInfo;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }
}
