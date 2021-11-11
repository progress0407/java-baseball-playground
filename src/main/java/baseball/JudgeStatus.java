package baseball;

public enum JudgeStatus {
    STRIKE("스트라이크"), BALL("볼"), NOTHING("낫싱");

    final String name;

    JudgeStatus(String name) {
        this.name = name;
    }
}
