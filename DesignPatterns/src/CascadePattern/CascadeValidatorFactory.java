/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CascadePattern;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author windows
 */
class MasterValidator{
    ArrayList<AddressValidator> validatorList;

    public MasterValidator(ArrayList<AddressValidator> validatorList) {
        this.validatorList=validatorList;
    }
    
    public boolean cascadeValidator(Address address){
        for(AddressValidator validator: validatorList){
            if(!validator.validate(address)){
                //point of failure
                return false;
            }
        }
        return true;
    }

}



public class CascadeValidatorFactory {
    public static HashMap<String, MasterValidator> clientValidatorMap;
    private static CascadeValidatorFactory cascadeValidatorFactory=null;
    
    private CascadeValidatorFactory(){
        clientValidatorMap=new HashMap<>();
        //this initialization has to be singleton DAO class
        AddressValidator zipCodeValidator=new zipCodeValidator();
        AddressValidator cityValidator=new countryValidator();
        AddressValidator countryValidator=new cityValidator();
        
        ArrayList<AddressValidator> validatorList1=new ArrayList<>();
        validatorList1.add(zipCodeValidator);
        validatorList1.add(countryValidator);
        
        ArrayList<AddressValidator> validatorList2=new ArrayList<>();
        validatorList1.add(zipCodeValidator);
        validatorList1.add(cityValidator);
        
        clientValidatorMap.put("client1", new MasterValidator(validatorList1));
        clientValidatorMap.put("client1", new MasterValidator(validatorList2));
    }
    
    public static CascadeValidatorFactory getInstance(){
        if(cascadeValidatorFactory==null){
            cascadeValidatorFactory=new CascadeValidatorFactory();
        }
        return cascadeValidatorFactory;
    }
    
    public MasterValidator getMasterValidator(String clientCode) throws ClientNotFound{
        if(clientValidatorMap.containsKey(clientCode)){
            return clientValidatorMap.get(clientCode);
        }else{
            throw new ClientNotFound();
        }
    }
}
