import java.io.File;

public class Main {
    public static void main(String[] args) {
        NumberTester t = new NumberTester("Data");

        NumberTest oddTester = (number) -> (number % 2) == 0;
        t.setOddEvenTester(oddTester);


    }
}
