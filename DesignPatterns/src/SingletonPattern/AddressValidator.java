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
class AddressValidator {
    public static boolean validate(Address address){
        return zipCodeValidator.validate(address.getZipCode())&&
                cityValidator.validate(address.getCity())&&
                countryValidator.validate(address.getCountry());
    }
}

class zipCodeValidator{
    public static boolean validate(String zipCode) {
        return ZipCodeDAO.getInstance().zipCodeSet.contains(zipCode);
    }
}

class cityValidator{
    public static boolean validate(String city) {
        return true;
    }
}

class countryValidator {
    public static boolean validate(String country) {
        return true;
    }
}


