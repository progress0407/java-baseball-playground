package baseball;

import java.util.ArrayList;
import java.util.List;

public class BaseBallJudge {

    private static final int MAX_NUMBER_SIZE = 3;

    private List<String> meessages = new ArrayList<>();

    // 얼마나 맞추었는지를 판단
    public List<String> judgeNumbers(int[] userNumbers, int[] computerNumbers) {
        judgeStrike(userNumbers, computerNumbers);
        judgeBall(userNumbers, computerNumbers);
        if (meessages.size() == 1) {
            meessages.add("낫싱");
        }
        return meessages;
    }

    private void judgeStrike(int[] userNumbers, int[] computerNumbers) {
        for (int i = 0; i < MAX_NUMBER_SIZE; i++) {
            int userNumber = userNumbers[i];
            int computerNumber = computerNumbers[i];
            if (userNumber == computerNumber) {
                meessages.add("스트라이크");
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
                    meessages.add("볼");
                }
            }
        }
    }

}
