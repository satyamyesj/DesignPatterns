/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SingletonPattern;

import BuilderPattern.*;

/**
 *
 * @author windows
 */
public class Client {
    public static void main(String[] args) {
        //Singleton Pattern
        //Problem:  There are few classes for which only 1 object is expected to be created to save on memory and processing power
        //          Example of such classes are as follow:
        //              1. All Controller classes in MVC design.
        //              2. DAO - Database Access Object
        //              3. Database Connections.
        //Solution: To implment such class we can create private constructor and then can expose public static
        //          getInstance() method ensuring that only one copy of class's object exist whic is made static
        //          field in class itself.
        //Example: To demonstrate this we can take exmple of validators building in a E-Commerce platform
        //         (Asked in AMAZON SDE 2).
        //      #Single Responsiblity Principle:
        //            To hold address with all of its different field we need to have
        //            Address class with Builder in it. Now for creating validator which can validate all address field
        //            given Address object, we can create Validator class. Note that creating Validator class inside
        //            Address class itself is not good design choice as we violate Single Responsability Principle
        //            which states that each class should have only single reponsibility and single type of behaviour.
        //            Again each filed in Address class requires differnt validation logic. Hence we create differnt classes
        //            for each field and then combine them in Validator class.
        //      #Singleton Pattern for DAO:
        //            In each Validator the standard values of list is required, which has to be loaded from
        //            database but it has to be loaded only one time and to be store in memory for all other accesses
        //            hance this DAO objects are implemented using Sinleton Pattern.
        
        
        
        //client's code
        String addressLines[]={"R Corner Hostel", "Vadgaon Bk"};
        Address address=new Address.Builder(addressLines, "422102", "India").setCity("Pune").setHouseNo("6").build();
        System.out.println(AddressValidator.validate(address));
    }
}
