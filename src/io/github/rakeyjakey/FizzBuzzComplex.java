package io.github.rakeyjakey;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jake on 6/4/14.
 */
public class FizzBuzzComplex {

    /**
     * If the number is divisible by 3 then "[Fizz]: " is printed.
     * If the number is divisible by 5 then "[Buzz]: " is printed.
     * If the number is divisible by 3 and 5 then "[FizzBuzz]: " is printed.
     * The number is then printed after.
     */

    public static void main(String[] args) {

        List<Integer> fizzList = new ArrayList<>();
        List<Integer> buzzList = new ArrayList<>();
        List<Integer> fizzBuzzList = new ArrayList<>();

        for (int i = 1; i <= 1000; i++) {

            /**
             * This is true if the number is divisible by 3.
             */
            final boolean fizz = i % 3 == 0;

            /**
             * This is true if the number is divisible by 5.
             */
           final boolean buzz = i % 5 == 0;

            /**
             * This is true if the number is divisible by 3 and 5.
             */
            final boolean fizzbuzz = i % 3 == 0 && i % 5 == 0;

            /*
             * If the number is divisible by 3 then "[Fizz]: " is printed.
             * If the number is divisible by 5 then "[Buzz]: " is printed.
             * If the number is divisible by 3 and 5 then "[FizzBuzz]: " is printed.
             * The number is then printed after.
             */

            if (fizzbuzz) {
                System.out.print("[FizzBuzz]: ");
                fizzBuzzList.add(i);
                fizzList.add(i);
                buzzList.add(i);
            } else if (fizz) {
                System.out.print("[Fizz]: ");
                fizzList.add(i);
            } else if (buzz) {
                System.out.print("[Buzz]: ");
                buzzList.add(i);
            }

            System.out.println(i);
        }

        /*
        All of the numbers in their categories are printed.
         */
        System.out.println("\n");

        System.out.println("All of the following were Fizz numbers: ");
        System.out.println(fizzList + "\n");

        System.out.println("All of the following were Buzz numbers: ");
        System.out.println(buzzList + "\n");

        System.out.println("All of the following were FizzBuzz numbers: ");
        System.out.println(fizzBuzzList + "\n");

    }
}
