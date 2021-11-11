package baseball;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BaseBallJudge {

    private static final int MAX_NUMBER_SIZE = 3;

    private final List<JudgeStatus> messages = new ArrayList<>();

    // 얼마나 맞추었는지를 판단
    public List<String> judgeNumbers(int[] userNumbers, int[] computerNumbers) {
        judgeStrike(userNumbers, computerNumbers);
        judgeBall(userNumbers, computerNumbers);
        if (messages.size() == 1) {
            messages.add(JudgeStatus.NOTHING);
        }
        return formatMessage();
    }

    // 문제에서 조언한 메시지대로 다시 포맷팅한다
    private List<String> formatMessage() {
        int strikeCount = (int) messages.stream().filter(e->e == JudgeStatus.STRIKE).count();
        int ballCount = (int) messages.stream().filter(e -> e == JudgeStatus.BALL).count();

        List<String> resultMessages = new LinkedList<>();
        if (strikeCount > 0) {
            resultMessages.add(strikeCount + JudgeStatus.STRIKE.name);
        }
        if (ballCount > 0) {
            resultMessages.add(ballCount + JudgeStatus.BALL.name);
        }

        if (resultMessages.size() == 0) {
            resultMessages.add(JudgeStatus.NOTHING.name);
        }
        return resultMessages;
    }

    private void judgeStrike(int[] userNumbers, int[] computerNumbers) {
        for (int i = 0; i < MAX_NUMBER_SIZE; i++) {
            int userNumber = userNumbers[i];
            int computerNumber = computerNumbers[i];
            if (userNumber == computerNumber) {
                messages.add(JudgeStatus.STRIKE);
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
                    messages.add(JudgeStatus.BALL);
                }
            }
        }
    }

}
