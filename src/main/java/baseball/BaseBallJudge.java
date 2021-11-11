package baseball;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BaseBallJudge {

    private static final int MAX_NUMBER_SIZE = 3;

    private final List<String> messages = new ArrayList<>();

    // 얼마나 맞추었는지를 판단
    public List<String> judgeNumbers(int[] userNumbers, int[] computerNumbers) {
        judgeStrike(userNumbers, computerNumbers);
        judgeBall(userNumbers, computerNumbers);
        if (messages.size() == 1) {
            messages.add("낫싱");
        }
        return formatMessage();
    }

    // 문제에서 조언한 메시지대로 다시 포맷팅한다
    private List<String> formatMessage() {
        int strikeCount = (int) messages.stream().filter(e->e.equals("스트라이크")).count();
        int ballCount = (int) messages.stream().filter(e -> e.equals("볼")).count();

        List<String> resultMessages = new LinkedList<>();
        if (strikeCount > 0) {
            resultMessages.add(strikeCount + "스트라이크");
        }
        if (ballCount > 0) {
            resultMessages.add(ballCount + "볼");
        }

        if (resultMessages.size() == 0) {
            resultMessages.add("낫싱");
        }
        return resultMessages;
    }

    private void judgeStrike(int[] userNumbers, int[] computerNumbers) {
        for (int i = 0; i < MAX_NUMBER_SIZE; i++) {
            int userNumber = userNumbers[i];
            int computerNumber = computerNumbers[i];
            if (userNumber == computerNumber) {
                messages.add("스트라이크");
            }
        }
    }

    private void judgeBall(int[] userNumbers, int[] computerNumbers) {
        for (int i = 0; i < MAX_NUMBER_SIZE; i++) {
            for (int j = 0; j < MAX_NUMBER_SIZE; j++) {
                if (i == j) {
                    continue;
                }
                int userNumber = userNumbers[i];
                int computerNumber = computerNumbers[j];
                if (userNumber == computerNumber) {
                    messages.add("볼");
                }
            }
        }
    }

}
