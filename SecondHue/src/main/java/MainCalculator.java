import java.util.Scanner;

public class MainCalculator {
    public static Scanner s = new Scanner(System.in, "Windows-1252");

    public static void main(String[] args) {


        ComplexCalculator c = new ComplexCalculator((Number x, Number y) -> {
            return new Number(x.getA() + y.getA(), x.getB() + y.getB());

        }, (Number x, Number y) -> {

            return new Number(x.getA() - y.getA(), x.getB() - y.getB());

        }, (Number x, Number y) -> {

            Number a = new Number(x.getA() * y.getA(), x.getA() * y.getB());

            Number b = new Number(x.getB() * y.getA(), x.getB() * y.getB());

            return new Number(a.getA() + b.getB() * (-1), a.getB() + b.getA());

        }, (Number x, Number y) -> {

            Number eins = new Number(x.getA() * y.getA(), x.getA() * y.getB() * (-1));

            Number zwei = new Number(x.getB() * y.getA(), x.getB() * y.getB() * (-1));

            Number drei = new Number(eins.getA() + zwei.getB() * (-1), eins.getB() + zwei.getA());

            Number uno = new Number(y.getA() * y.getA(), y.getA() * y.getB() * (-1));

            Number dos = new Number(y.getB() * y.getA(), y.getB() * y.getB() * (-1));

            Number tres = new Number(uno.getA() * dos.getB() * (-1), 0);

            return new Number(drei.getA() / tres.getA(), drei.getB() / tres.getA());
        });

        RationalCalculator r = new RationalCalculator((Number x, Number y) -> {


            double gemN = x.getB() * y.getB();

            return new Number(x.getA() * gemN, y.getA() * gemN);

        }, (Number x, Number y) -> {
            double gemN = x.getB() * y.getB();

            return new Number((x.getA() * gemN), (y.getA() * gemN));
        }, (Number x, Number y) -> {


            return new Number((x.getA() * y.getA()), (y.getB() * x.getB()));
        }, (Number x, Number y) -> {


            return new Number((x.getA() * y.getB()), (y.getA() * x.getB()));
        });

        VectorCalculator v = new VectorCalculator((Number x, Number y) -> {

            return new Number(x.getA() + y.getA(), x.getB() + y.getB());

        }, (Number x, Number y) -> {
            return new Number(x.getA() + y.getA(), x.getB() + y.getB());
        }, (Number x, Number y) -> {

            double uno = x.getA() * y.getB();

            double dos = x.getB() * y.getA();

            return new Number(uno - dos, 0);
        }, (Number x, Number y) -> {

            double uno = x.getA() / x.getB();

            double dos = y.getA() / y.getB();

            return new Number(uno + dos, 0);
        });

        int eingabe = 0;
        System.out.println("Choose calculator:");
        System.out.println("1 - Relational calculator");
        System.out.println("2 - Vector calculator");
        System.out.println("3 - Complex calculator");
        System.out.println("4 - Exit");
        eingabe = Integer.parseInt(s.nextLine());
        if (eingabe < 1 || eingabe > 5) {
            System.out.println("Falsche eingabe");
        }

        System.out.println("Zahl 1x");
        double zahl1 = Double.parseDouble(s.nextLine());
        System.out.println("Zahl 1y");
        double zahl2 = Double.parseDouble(s.nextLine());
        System.out.println("Zahl 2x");
        double zahl3 = Double.parseDouble(s.nextLine());
        System.out.println("Zahl 2y");
        double zahl4 = Double.parseDouble(s.nextLine());
        Number a = new Number(zahl1, zahl2);
        Number b = new Number(zahl3, zahl4);

        switch (eingabe) {

            case 1:
                switch (operation()) {
                    case 1:
                        System.out.println(r.add(a, b).getA());
                        System.out.println(r.add(a, b).getB());
                        break;
                    case 2:
                        System.out.println(r.subtract(a, b).getA());
                        System.out.println(r.subtract(a, b).getB());
                        break;
                    case 3:
                        System.out.println(r.multiply(a, b).getA());
                        System.out.println(r.multiply(a, b).getB());
                        break;
                    case 4:
                        System.out.println(r.divide(a, b).getA());
                        System.out.println(r.divide(a, b).getB());
                        break;
                }

                break;

            case 2:
                switch (operation()) {
                    case 1:
                        System.out.println(v.add(a, b).getA());
                        System.out.println(v.add(a, b).getB());
                        break;
                    case 2:
                        System.out.println(v.subtract(a, b).getA());
                        System.out.println(v.subtract(a, b).getB());
                        break;
                    case 3:
                        System.out.println(v.multiply(a, b).getA());

                        break;
                    case 4:
                        System.out.println(v.divide(a, b).getA());

                        break;
                }
                break;

            case 3:
                switch (operation()) {
                    case 1:
                        System.out.println(c.add(a, b).getA());
                        System.out.println(c.add(a, b).getB());
                        break;
                    case 2:
                        System.out.println(c.subtract(a, b).getA());
                        System.out.println(c.subtract(a, b).getB());
                        break;
                    case 3:
                        System.out.println(c.multiply(a, b).getA());
                        System.out.println(c.multiply(a, b).getB());
                        break;
                    case 4:
                        System.out.println(c.divide(a, b).getA());
                        System.out.println(c.divide(a, b).getB());
                        break;
                }
                break;

                
            case 4:
                System.exit(0);
                break;


        }

    }


    public static int operation() {
        System.out.println("Choose operation :\n" +
                "1 − add\n" +
                "2 − subtract\n" +
                "3 − multiply\n" +
                "4 − divide\n" +
                "5 − enter numbers again");
        int eingabe = Integer.parseInt(s.nextLine());
        if (eingabe == 5) {
            operation();

        }
        return eingabe;
    }


}
