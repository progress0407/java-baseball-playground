package baseball;

import java.util.*;

import static java.lang.System.out;

public class Prompt {

    private static final int MAX_NUMBER_SIZE = 3;

    private final int[] computerNumbers = new int[MAX_NUMBER_SIZE];

    private int[] userNumbers;


    private BaseBallJudge baseBallJudge = new BaseBallJudge();

    public void initWithSpecificNumbers(String input) {
        int[] numbers = convertStringToIntArray(input);
        computerNumbers[0] = numbers[0];
        computerNumbers[1] = numbers[1];
        computerNumbers[2] = numbers[2];
    }

    // 랜덤 값 생성
    public void initComputerNumbers() {
        computerNumbers[0] = 1 + new Random().nextInt(9);
        computerNumbers[1] = 1 + new Random().nextInt(9);
        computerNumbers[2] = 1 + new Random().nextInt(9);
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        List<String> messages;
        while (true) {
            print(scanner);
            if (baseBallJudge.isAllStrike()) {
                out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                int inputNumber = scanner.nextInt();
                if (inputNumber == 1) {
                    continue;
                }
                if (inputNumber == 2) {
                    break;
                }
            }
        }
        scanner.close();
    }

    private void print(Scanner scanner) {
        out.print("숫자를 입력해 주세요 : ");
        userNumbers = inputNumbers(scanner);
        List<String> messages;
        messages = baseBallJudge.judgeNumbers(userNumbers, computerNumbers);
    }

    private int[] inputNumbers(Scanner scanner) {

        String inputNumber = scanner.next();

        return convertStringToIntArray(inputNumber);
    }

    private int[] convertStringToIntArray(String inputNumber) {
        String[] stringNumbers = inputNumber.split("");
        return Arrays.stream(stringNumbers)
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
