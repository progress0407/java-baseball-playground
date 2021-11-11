package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

public class Prompt {

    private static final int MAX_NUMBER_SIZE = 3;

    private final int[] computerNumbers = new int[MAX_NUMBER_SIZE];

    private int[] userNumbers;

    private List<String> messages;

    private BaseBallJudge baseBallJudge = new BaseBallJudge();

    public void initWithSpecificNumbers(String input) {
        int[] numbers = convertStringToIntArray(input);
        computerNumbers[0] = numbers[0];
        computerNumbers[1] = numbers[1];
        computerNumbers[2] = numbers[2];
    }

    public void initComputerNumbers() {

    }

    public void print() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            out.print("숫자를 입력해 주세요 : ");
            userNumbers = inputNumbers(scanner);
            messages = baseBallJudge.judgeNumbers(userNumbers, computerNumbers);
            out.println(messages);
            break;
        }
        scanner.close();
    }

    private int[] inputNumbers(Scanner scanner) {

        String inputNumber = scanner.nextLine();

        return convertStringToIntArray(inputNumber);
    }

    private int[] convertStringToIntArray(String inputNumber) {
        String[] stringNumbers = inputNumber.split("");
        return Arrays.stream(stringNumbers)
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
