/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CascadePattern;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author windows
 */
class ZipCodeDAO{
    Set<String> zipCodeSet;
    private static ZipCodeDAO zipCodeDAO=null;
    private ZipCodeDAO(){
        //create database connection 
        //and fetch the zipCode list
        zipCodeSet=new HashSet<>();
        zipCodeSet.add("422102");
        zipCodeSet.add("422101");
        zipCodeSet.add("422103");
        zipCodeSet.add("422104");
        zipCodeSet.add("422105");
    }
    
    public static ZipCodeDAO getInstance(){
        if(zipCodeDAO==null){
            zipCodeDAO=new ZipCodeDAO();
        }
        return zipCodeDAO;
    }
}
