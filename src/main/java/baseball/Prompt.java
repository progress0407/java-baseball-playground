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

    public void initComputerNumbers() {
        computerNumbers[0] = 4;
        computerNumbers[1] = 2;
        computerNumbers[2] = 5;
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

        String[] stringNumbers = inputNumber.split("");
        return Arrays.stream(stringNumbers)
                .mapToInt(Integer::parseInt)
                .toArray();

    }
}
