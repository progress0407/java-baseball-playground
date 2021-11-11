package calculator;

import java.util.Scanner;

public class StringCalculator {

    private String[] values;

    public static void main(String[] args) {
        StringCalculator calculator = new StringCalculator();
        calculator.input();
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("input> ");
        values = sc.nextLine().split(" ");
    }

    public void inputAuto(String inputString) {
        values = inputString.split(" ");
    }

    public double calc() {
        int a =0;
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
        return result;
    }
}
