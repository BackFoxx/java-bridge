package bridge.mock;

import bridge.controller.GameController;
import bridge.service.BridgeGame;
import bridge.system.util.BridgeMaker;
import bridge.system.util.BridgeMessageMaker;
import bridge.view.inputview.InputViewExceptionHandlingProxy;
import bridge.view.inputview.InputViewInterface;
import bridge.view.outputview.OutputView;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.List;

public class MockObjectMaker {
    public static GameController makeMockGameController(List<Integer> answers, String... mockInputs) {
        OutputView outputView = new OutputView(new BridgeMessageMaker());
        InputViewInterface inputView = makeMockProxyInputView(mockInputs);

        return new GameController(
                inputView,
                outputView,
                new BridgeMaker(new MockNumberGenerator(answers)),
                new BridgeGame(outputView, inputView)
        );
    }

    public static InputViewInterface makeMockProxyInputView(String... mockInputs) {
        InputViewInterface target = new MockInputView(mockInputs);
        InvocationHandler invocationHandler
                = new InputViewExceptionHandlingProxy(target, new OutputView(new BridgeMessageMaker()));
        return (InputViewInterface) Proxy.newProxyInstance(
                InputViewInterface.class.getClassLoader(),
                new Class[]{InputViewInterface.class},
                invocationHandler);
    }
}