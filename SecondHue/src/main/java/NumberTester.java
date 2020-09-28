import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NumberTester {
    Operator operator;
    List<Operator> list = new ArrayList<>();

    public NumberTester(String fileName) {


        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line = br.readLine();
            int numberTests = Integer.parseInt(line);
            line = br.readLine();
            while (line != null) {
                String[] spliter = line.split(" ");
                operator = new Operator(Integer.parseInt(spliter[0]), Integer.parseInt(spliter[1]));
                list.add(operator);
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
        for (Operator operator :
                list) {
            if(operator.getNumber1() == 1){
                if(oddTester.testNumber(operator.getNumber2())){
                    System.out.println("EVEN");
                }else System.out.println("UNEVEN");
            }
            else if (operator.getNumber1() == 2) {
                if(primeTester.testNumber(operator.getNumber2())){
                    System.out.println("PRIME");
                }else System.out.println("NOT PRIME");

            }else if (operator.getNumber1() == 3) {
                if(palindromeTester.testNumber(operator.getNumber2())){
                    System.out.println("PALINDROM");
                }else System.out.println("NO PALINDROM");

            }
        }
    }

}
