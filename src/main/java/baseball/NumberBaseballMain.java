package baseball;

import java.util.Random;

public class NumberBaseballMain {

    public static void main(String[] args) {
        Prompt prompt = new Prompt();
//        prompt.initWithSpecificNumbers("425");
        prompt.initComputerNumbers();
        prompt.run();
    }
}
