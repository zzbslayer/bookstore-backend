package com.zzbslayer.bookstore.utils;

public class AddressRow {
    private String shippingaddress;
    private String recipient;
    private String phone;
    private Integer addressid;

    public AddressRow update(AddressRow addressRow){
        this.setShippingaddress(addressRow.getShippingaddress());
        this.setRecipient(addressRow.getRecipient());
        this.setPhone(addressRow.getPhone());
        return this;
    }

    public void setAddressid(Integer addressid) {
        this.addressid = addressid;
    }

    public Integer getAddressid() {
        return addressid;
    }

    public void setShippingaddress(String shippingaddress) {
        this.shippingaddress = shippingaddress;
    }

    public String getShippingaddress() {
        return shippingaddress;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }
}
