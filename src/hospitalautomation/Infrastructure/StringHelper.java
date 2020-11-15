/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalautomation.Infrastructure;

/**
 *
 * @author Monster
 */
public class StringHelper {
    public static String pluralize(String className){
        if (className.endsWith("s")) {
            return className + "es"; 
        }
        else if(className.endsWith("y")){
            return  className.substring(0,className.length() -1) +"ies";
        }
        return className + "s";
    }
}
