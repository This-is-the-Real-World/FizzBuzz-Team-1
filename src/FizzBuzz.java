public class FizzBuzz {

    // Not packaged correctly or formatted.
    // Only uploaded by me because Eclipse is a pain for this and I will get Qosmiof2PB using IDEA next week.
public static void main(String[] args) {

        for (int i = 1; i < 1000; i++) {

        // Simple
        if (i % 3 == 0 && i % 5 == 0) {
        System.out.println("FizzBuzz: " + i);
        } else if (i % 3 == 0) {
        System.out.println("Fizz: " + i);
        } else if (i % 5 == 0){
        System.out.println("Buzz: " + i);
        } else {
        System.out.println(i);
        }
        }

        }}