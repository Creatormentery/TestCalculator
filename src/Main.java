import java.util.Scanner;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {

        // Scanner sc = new Scanner(System.in);
        // System.out.println("Enter data: ");
        // String[] s = sc.nextLine().split(" ");
        try {
            Scanner sc = new Scanner(System.in);
            File file = new File("input.txt");
            sc = new Scanner(file);

            FileWriter nFile = new FileWriter("output.txt");

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                nFile.write(line + " = " + calculate(line) + "\n");
            }
            sc.close();
            nFile.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

    }


        public static String calculate(String line){
            String[] s = line.split(" ");
            double a = 0, b = 0;
            boolean flag = true;
            try {
                a = Double.parseDouble(s[0]);
                b = Double.parseDouble(s[2]);
            } catch (NumberFormatException ex) {
                flag = false;
                return "Error! Not number";
            }
            if ("+-*/".contains(s[1]) && flag) {
                switch (s[1]) {
                    case "+": {
                        return Double.toString(a + b);
                    }
                    case "-": {
                        return Double.toString(a - b);
                    }
                    case "*": {
                        return Double.toString(a * b);
                    }
                    case "/": {
                        try {
                            if ((a / b) == Double.POSITIVE_INFINITY) {
                                throw new ArithmeticException();
                            } else {
                                System.out.println(a / b);
                                return Double.toString(a / b);
                            }
                        } catch (ArithmeticException ex) {
                            return "Error! Division by zero";
                        }

                    }
                }
            } else {
                return "Operation Error!";
            }
            return line;
        }

}