package india.com.laundryapp.model;

/**
 * Created by luis on 3/11/15.
 */
public class Address {
    private String addressName;
    private String addressPerson;
    private String addressDirection;

    public Address(String addressName, String addressPerson, String addressDirection){
        setAddressName(addressName);
        setAddressPerson(addressPerson);
        setAddressDirection(addressDirection);
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getAddressPerson() {
        return addressPerson;
    }

    public void setAddressPerson(String addressPerson) {
        this.addressPerson = addressPerson;
    }

    public String getAddressDirection() {
        return addressDirection;
    }

    public void setAddressDirection(String addressDirection) {
        this.addressDirection = addressDirection;
    }
}
