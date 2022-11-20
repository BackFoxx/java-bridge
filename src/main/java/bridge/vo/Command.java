package bridge.vo;

import java.util.Arrays;

public enum Command {
    R,
    Q;

    public static final String INVALID_VALUE_MESSAGE = "R, Q 어느 쪽에도 해당하지 않는 값입니다.";

    public static Command getByValue(String value) {
        return Arrays.stream(Command.values())
                .filter(command -> command.toString().equals(value))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_VALUE_MESSAGE));
        // TODO: IllegalArgumentException 이 적절하지 않을 수 있다.
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
