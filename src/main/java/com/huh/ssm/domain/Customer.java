package com.huh.ssm.domain;

public class Customer {

    private String firstName;
    private String lastName;
    private Address address;
    private String email;
    private int customerId;
    private String lastUpdate;
    private int storeId;
    private String createDate;
    private int active;
    private int addressId;

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getActive() {
        return active;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Address getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    @Override
    public String toString() {
        return "[" + getFirstName() + ", " + getLastName() + ", " + getEmail() + ", " + getAddress().getAddress() + ", " + getLastUpdate() + "]";
    }
}
