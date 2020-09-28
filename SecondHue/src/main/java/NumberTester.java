import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NumberTester {
    public Map<Integer, Integer> numbers = new HashMap<>();

    public NumberTester(String fileName) {


        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line = br.readLine();
            int numberTests = Integer.parseInt(line);
            line = br.readLine();
            while (line != null) {
                String[] spliter = line.split(" ");
                numbers.put(Integer.parseInt(spliter[0]), Integer.parseInt(spliter[1]));
                line = br.readLine();
            }
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(NumberTester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    NumberTest oddTester;
    NumberTest palindromeTester;
    NumberTest primeTester;


    public void setOddEvenTester(NumberTest oddTester) {
        this.oddTester = oddTester;
    }

    public void setPrimeTester(NumberTest primeTester) {
        this.primeTester = primeTester;
    }

    public void setPalindromeTester(NumberTest palindromeTester) {
        this.palindromeTester = palindromeTester;
    }

    public void testFile() {
        for (int i :
                numbers.keySet()) {
            if(i == 1){
                if(oddTester.testNumber(numbers.get(i))){
                    System.out.println("EVEN");
                }else System.out.println("UNEVEN");
            }
            else if (i == 2) {
                if(primeTester.testNumber(numbers.get(i))){
                    System.out.println("PRIME");
                }else System.out.println("NOT PRIME");

            }else if (i == 3) {
                if(palindromeTester.testNumber(numbers.get(i))){
                    System.out.println("PALINDROM");
                }else System.out.println("NO PALINDROM");

            }
        }
    }

}
