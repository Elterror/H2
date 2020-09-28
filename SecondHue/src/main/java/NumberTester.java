public class NumberTester {
    public NumberTester (String fileName ) {}

    NumberTest oddTester;
    NumberTest palindromeTester;
    NumberTest primeTester;


    public void setOddEvenTester (NumberTest oddTester ) {
        this.oddTester = oddTester;
    }
    public void setPrimeTester(NumberTest primeTester){
        this.primeTester = primeTester;
    }
    public void setPalindromeTester(NumberTest palindromeTester){
        this.palindromeTester = palindromeTester;
    }

    public void testFile(){
        oddTester.testNumber(4);
    }

}
