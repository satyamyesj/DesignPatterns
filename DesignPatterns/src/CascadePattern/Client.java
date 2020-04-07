package CascadePattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author windows
 */
public class Client {
    public static void main(String[] args) throws ClientNotFound {
        //Cascade Pattern
        //Problem: In Adress validator where every field in Address class is needed to validated
        //         according different logic hence we create different class having public static validate
        //         method, and we then call them in umbrella class's (AddressValidator) validate method.
        //         There are four problem with this approach as follow:
        //         1. suppose different client requires different set of validator to be
        //            applied and not all.
        //         2. Point of failure is not found.
        //         3. To find point of failure if-else bracnching will increase
        //         4. if relation between different validator is required then 
        //            more branching will require.
        //Solution: The differnt Validator can be out into list and then loop can be run to execute
        //          them in required order also this will figure out point of failure.
        //          for different client's need we can have differnt list's that is factory class
        //          which will expose MasterValidator having CascadeValidator method.
        
        String addressLines[]={"R Corner Hostel", "Vadgaon Bk"};
        CascadePattern.Address address=new CascadePattern.Address.Builder(addressLines, "422102", "IND").setCity("Pune").setHouseNo("6").build();
        
        System.out.println(CascadeValidatorFactory.getInstance().getMasterValidator("client1").cascadeValidator(address));
    }
}
