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
public class Client {
    public static void main(String[] args) throws CountryCodeNotFound {
         //Factory Pattern
        //Problem: Many times depending on parameter client has to call differnt logic implmented by differnt classes.
        //         If client uses if-else statements then we can have following issues: 
        //          1. Dirty Code
        //          2. Testing
        //          3. Scope for mistake
        //          4. Backward Compatability
        //          5. No abstraction - need to know about countries.
        //Solution: We can provide mapping for such switching at our end. But still writing if-else creates
        //          Many issues listed above at our end. To effectively provide mapping we can create hashmap in singleton class and 
        //          then provide differnt classes as per witching logic but as map can have only class as it value parameter,
        //          storing different classes becomes issue. To solve this problem we can create interface whic all classes has to implment.
        //Example:  Consider client which expects differnt types of addressValidator depending on country code to run validate method from validator
        //          at his end. To solve this problem we can create AddressValidator factory with HashMap<CountryCode, AddressValidator>
        //          where AddressValidator is an interface which different Country specific validator can implement.
        
        
        //client's code
        String addressLines[]={"R Corner Hostel", "Vadgaon Bk"};
        FactoryPattern.Address address=new FactoryPattern.Address.Builder(addressLines, "422102", "IND").setCity("Pune").setHouseNo("6").build();
        System.out.println(AddressValiadatorFactory.getInstance().getAddresssValidator(address.getCountryCode()).validate(address));
    }
}
