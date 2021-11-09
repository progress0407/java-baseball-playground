import java.util.Scanner;

public class StringCalculator {

    public static void main(String[] args) {
        StringCalculator calculator = new StringCalculator();
        calculator.input();
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("input> ");
        String[] values = sc.nextLine().split(" ");
        int a =0;
        int b;
        char op = ' ';
        boolean afterOp = false;
        double result = 0;

        for (String value : values) {

            if (Character.isDigit(value.charAt(0))) {
                if (!afterOp) {
                    result = Integer.parseInt(value);
                } else {
                    a = Integer.parseInt(value);
                    switch (op) {
                        case '+':
                            result += a;
                            break;
                        case '-':
                            result -= a;
                            break;
                        case '*':
                            result *= a;
                            break;
                        case '/':
                            result /= a;
                            break;
                    }
                }
                afterOp = false;
            } else if (!Character.isDigit(value.charAt(0))) {
                op = value.charAt(0);
                afterOp = true;
            }
        }

        System.out.println("result = " + result);
    }
}
