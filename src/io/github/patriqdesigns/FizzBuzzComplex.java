package io.github.patriqdesigns;

import io.github.patriqdesigns.fizzbuzz.FizzBuzzSuper;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: André
 * <p/>
 * Date: 10/06/2014
 * Time: 18:44
 */
public class FizzBuzzComplex {
    public static void main(String[] args) {
        try{
            //Makes a new instance of the FizzBuzz class
            FizzBuzzSuper.FizzBuzz fizzBuzz = FizzBuzzSuper.FizzBuzz.class.newInstance();
            //Gets the declared method of that class called evaluate, and that takes an int
            Method e = FizzBuzzSuper.FizzBuzz.class.getDeclaredMethod("evaluate", int.class);
            //sets the method accessible since he is protected and we can't access it from here
            e.setAccessible(true);
            //loops through all of the numbers from 1 to 1000
            for(int i = 1; i <= 1000; i++){
                //invokes the evaluate method from fizzBuzz instance and prints it out with the following i
                System.out.println(e.invoke(fizzBuzz, i).toString().concat(String.valueOf(i)));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
