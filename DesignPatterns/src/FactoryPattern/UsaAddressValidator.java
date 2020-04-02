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
class UsaAddressValidator implements AddressValidator{
    @Override
    public  boolean validate(Address address){
        return UsaZipCodeValidator.validate(address.getZipCode())&&
                UsaCityValidator.validate(address.getCity());
    }
}

class UsaZipCodeValidator{
    public static boolean validate(String zipCode) {
        //logic of validating zip code
        return true;
    }
}

class UsaCityValidator{
    public static boolean validate(String city) {
        //logic for validating city
        return true;
    }
}


