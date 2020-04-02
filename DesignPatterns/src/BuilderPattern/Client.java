/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BuilderPattern;

/**
 *
 * @author windows
 */
public class Client {
    public static void main(String[] args) {
           //Builder Pattern
        //Problem: Constructor with lots of parameters creates following issues where we do not want client change object after
        //         being intialized once i.e. we do not want to expose setters to client.
        //          1. Unclear readibilty can lead to buggier code
        //          2. Backward Compatability
        //          3. Forces client to remember order of parameters
        //          4. No abstraction is provided to client as he is exposed to different constructor
        //Solution: Instead of passing of long list of parameters we can pass builder class which can have both mandatory
        //          and non-mandatory parameters, this class can be static inner class to actual class for which constructor
        //          has to be written so as to solve problem of logic binding and initializing builder class itself.
        //          builder can class can have setter exposed to client as it only serve purpose of intializing class of interest.
        //Example: In this example we are building Product class for ecommerce listing which can be initialized by client's code with
        //         required parameter without knowing implementation details of Product class
        
        
        //client's code
        Product product=new Product.Builder("1001","101", "Toothpaste", Float.valueOf(23))
                                      .setDescription("New flavour with brand new packing")
                                      .setDiscount(Float.valueOf(5))
                                      .build();
        System.out.println(product);
    }
}
