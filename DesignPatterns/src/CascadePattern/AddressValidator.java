/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CascadePattern;



/**
 *
 * @author windows
 */

//This umbrella class which is converted into cascade pattern
//class AddressValidator {
//    public static boolean validate(Address address){
//        return zipCodeValidator.validate(address.getZipCode())&&
//                cityValidator.validate(address.getCity())&&
//                countryValidator.validate(address.getCountry());
//    }
//}

interface AddressValidator{
    abstract boolean validate(Address address);
}

class zipCodeValidator implements AddressValidator{
    @Override
    public  boolean validate(Address address) {
        return ZipCodeDAO.getInstance().zipCodeSet.contains(address.getZipCode());
    }
}

class cityValidator implements AddressValidator{
    @Override
    public boolean validate(Address address) {
        return true;
    }
}

class countryValidator implements AddressValidator {
    @Override
    public boolean validate(Address address) {
        return true;
    }
}


