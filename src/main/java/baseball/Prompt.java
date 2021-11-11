package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

public class Prompt {

    private static final int MAX_NUMBER_SIZE = 3;

    private int[] computerNumbers;

    private int[] userNumbers;

    private List<String> messages;

    public void initComputerNumbers() {

        computerNumbers = new int[MAX_NUMBER_SIZE];

        computerNumbers[0] = 4;
        computerNumbers[1] = 5;
        computerNumbers[2] = 6;

        /*for (int i = 0; i < MAX_NUMBER_SIZE; i++) {
            computerNumbers[i] = Random
        }*/
    }

    public void print() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            out.print("숫자를 입력해 주세요 : ");
            userNumbers = inputNumbers(scanner);
            judgeNumbers();
            out.println(messages);
            break;
        }
        scanner.close();
    }

    // 얼마나 맞추었는지를 판단
    private void judgeNumbers() {
        for (int i = 0; i < MAX_NUMBER_SIZE; i++) {
            if (computerNumbers[i] == userNumbers[i]) {
                messages.add("스트라이크");
            }
        }
    }

    private int[] inputNumbers(Scanner scanner) {

        String inputNumber = scanner.nextLine();

        String[] stringNumbers = inputNumber.split("");
        return Arrays.stream(stringNumbers)
                .mapToInt(Integer::parseInt)
                .toArray();

    }
}
