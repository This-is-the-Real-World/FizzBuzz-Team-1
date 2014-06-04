package io.github.patriqdesigns;

/**
 * Created with IntelliJ IDEA.
 * User: André
 * <p>
 * Date: 04/06/2014
 * Time: 20:54
 */
public class FizzBuzzPatriq {

    public static void main(String[] args) {// main method

        StringBuilder s = new StringBuilder(); //this will help us formatting our answer

        for(int i = 1; i<=1000; i++){ //this will loop from 1 to 1000
            s.setLength(0); //set the builder length to 0 because we are starting a new answer
            if(i%3 == 0) s.append("Fizz"); //if its multiple of 3 append Fizz to the answer
            if(i%5 == 0) s.append("Buzz"); //if its multiple of 5 append Buzz to the answer
            if(s.length() > 0) s.append(": "); //if we have Fizz or Buzz in our answer append :
            System.out.println(s.append(i)); //last we append the number that we are in
        }

    }

}
