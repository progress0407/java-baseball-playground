package baseball;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BaseBallJudge {

    private static final int MAX_NUMBER_SIZE = 3;

    private List<JudgeStatus> messages;

    // 얼마나 맞추었는지를 판단
    public List<String> judgeNumbers(int[] userNumbers, int[] computerNumbers) {
        messages = new ArrayList<>();
        judgeStrike(userNumbers, computerNumbers);
        judgeBall(userNumbers, computerNumbers);
        if (messages.size() == 1) {
            messages.add(JudgeStatus.NOTHING);
        }
        return formatMessage();
    }

    // 문제에서 조언한 메시지대로 다시 포맷팅한다
    private List<String> formatMessage() {
        List<String> resultMessages = new LinkedList<>();
        int strikeCount = getJudgeStatusCount(JudgeStatus.STRIKE);
        int ballCount = getJudgeStatusCount(JudgeStatus.BALL);

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

    // 상태별 개수
    private int getJudgeStatusCount(JudgeStatus status) {
        return (int) messages.stream().filter(e -> e == status).count();
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

    public boolean isAllStrike() {
        return getJudgeStatusCount(JudgeStatus.STRIKE) == 3;
    }
}
