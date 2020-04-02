/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SingletonPattern;

/**
 *
 * @author windows
 */
public class Address {

    private String addressLines[];
    private String landmark = null;
    private String zipCode = null;
    private String city = null;
    private String state = null;
    private String country = null;
    private String houseNo = null;
    
    private Address(Builder builder){
        this.addressLines=builder.addressLines;
        this.landmark=builder.landmark;
        this.zipCode=builder.zipCode;
        this.city=builder.city;
        this.state=builder.state;
        this.country=builder.country;
        this.houseNo=builder.houseNo;
    }

    public static class Builder {

        private String addressLines[];
        private String landmark = null;
        private String zipCode = null;
        private String city = null;
        private String state = null;
        private String country = null;
        private String houseNo = null;

        public Builder(String addressLines[], String zipCode, String Country) {
            //mandatory fields
            this.addressLines = addressLines;
            this.zipCode = zipCode;
            this.country = country;
        }

        public Builder setLandmark(String landmark) {
            this.landmark = landmark;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setState(String state) {
            this.state = state;
            return this;
        }

        public Builder setHouseNo(String houseNo) {
            this.houseNo = houseNo;
            return this;
        }

        public Address build(){
            Address obj=new Address(this);
            return obj;
        }
    }

    public String[] getAddressLines() {
        return addressLines;
    }

    public String getLandmark() {
        return landmark;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getHouseNo() {
        return houseNo;
    }
    
    
}
