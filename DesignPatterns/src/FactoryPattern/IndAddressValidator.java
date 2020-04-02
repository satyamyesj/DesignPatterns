/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FactoryPattern;

/**
 *
 * @author windows
 */
class IndAddressValidator implements AddressValidator{
    @Override
    public  boolean validate(Address address){
        return IndZipCodeValidator.validate(address.getZipCode())&&
                IndCityValidator.validate(address.getCity());
    }
}

class IndZipCodeValidator{
    public static boolean validate(String zipCode) {
        //logic for validating zipCode
        return true;
    }
}

class IndCityValidator{
    public static boolean validate(String city) {
        //logic for validating city
        return true;
    }
}


