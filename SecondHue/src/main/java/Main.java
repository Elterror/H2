import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        NumberTester t = new NumberTester("Data");

        t.setOddEvenTester((number) -> (number % 2) == 0);

        t.setPrimeTester((number) -> {
            if (number <= 1) {
                return false;
            }

            for (int i = 2; i < number; i++) {
                if (number % i == 0)
                    return false;
            }
            return true;
        });

        t.setPrimeTester((number) -> {
            int palindrome = number; // copied number into variable
            int reverse = 0;

            while (palindrome != 0) {
                int remainder = palindrome % 10;
                reverse = reverse * 10 + remainder;
                palindrome = palindrome / 10;
            }

            // if original and reverse of number is equal means
            // number is palindrome in Java
            if (number == reverse) {
                return true;
            }
            return false;


        });


    }
}
