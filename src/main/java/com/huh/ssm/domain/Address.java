package com.huh.ssm.domain;

public class Address {

    private int addressId;

    private String address;

    private String phone;

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAddressId() {
        return addressId;
    }

    public String getAddress() {
        return address;
    }
}
