package bridge.view;

import bridge.system.util.BridgeMessageMaker;
import bridge.vo.StepResult;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public static final String GAME_STARTING_MESSAGE_FORMAT = "다리 건너기 게임을 시작합니다.%n%n";
    public static final String ASKING_BRIDGE_SIZE_MESSAGE_FORMAT = "다리의 길이를 입력해주세요.%n";
    public static final String ASKING_NEXT_STEP_MESSAGE_FORMAT = "이동할 칸을 선택해주세요. (위: U, 아래: D)%n";
    private final BridgeMessageMaker bridgeMessageMaker;

    public OutputView(BridgeMessageMaker bridgeMessageMaker) {
        this.bridgeMessageMaker = bridgeMessageMaker;
    }

    public void printGameStartMessage() {
        System.out.printf(GAME_STARTING_MESSAGE_FORMAT);
    }

    public void printAskingBridgeSizeMessage() {
        System.out.printf(ASKING_BRIDGE_SIZE_MESSAGE_FORMAT);
    }

    public void printAskingNextStepMessage() {
        System.out.printf(ASKING_NEXT_STEP_MESSAGE_FORMAT);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<StepResult> stepResults) {
        System.out.println(bridgeMessageMaker.makeBridgeMessage(stepResults));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    public void printAskingGameCommandMessage() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }
}
