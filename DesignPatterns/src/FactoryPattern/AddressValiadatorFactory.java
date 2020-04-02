/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FactoryPattern;

import java.util.HashMap;
import sun.security.jca.GetInstance;

/**
 *
 * @author windows
 */

class CountryCodeNotFound extends Exception{
    
}


enum CountryCodes{
    USA, IND
}

public class AddressValiadatorFactory {
    public HashMap<CountryCodes,AddressValidator> countryCodeValidatorMap;
    private static AddressValiadatorFactory addressValiadatorFactory=null;
    
    private AddressValiadatorFactory(){
        countryCodeValidatorMap=new HashMap<>();
        countryCodeValidatorMap.put(CountryCodes.USA, new UsaAddressValidator());
        countryCodeValidatorMap.put(CountryCodes.IND, new IndAddressValidator());
    }
    
    public static AddressValiadatorFactory getInstance(){
        if(addressValiadatorFactory==null){
            addressValiadatorFactory=new AddressValiadatorFactory();
        }
        return addressValiadatorFactory;
    }
    
    public AddressValidator getAddresssValidator(String countryCode) throws CountryCodeNotFound{
        CountryCodes cc=CountryCodes.valueOf(countryCode);
        if(countryCodeValidatorMap.containsKey(cc)){
            return countryCodeValidatorMap.get(cc);
        }else{
            throw new CountryCodeNotFound();
        }
    }
}
