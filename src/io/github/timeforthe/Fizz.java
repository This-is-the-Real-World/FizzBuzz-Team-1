package io.github.timeforthe;

public class Fizz {

    public static void main(String[] args) {

        String a;

        for (int j = 1; j <= 1000; j++) {

            if (j % 3 == 0 && j % 5 == 0) {
                a = "FizzBuzz: ";
            } else if (j % 3 == 0) {
                a = "Fizz: ";
            } else if (j % 5 == 0) {
                a = "Buzz: ";
            } else {
                a = "";
            }

            System.out.println(a + j);

        }
    }

}
