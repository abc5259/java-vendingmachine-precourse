package vendingmachine;

import vendingmachine.controller.IteratorInputHandler;
import vendingmachine.controller.IteratorInputTemplate;
import vendingmachine.controller.VendingmachineController;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        IteratorInputTemplate iteratorInputTemplate = new IteratorInputTemplate(outputView);
        IteratorInputHandler iteratorInputHandler = new IteratorInputHandler(inputView, iteratorInputTemplate);
        VendingmachineController vendingmachineController = new VendingmachineController(
                iteratorInputHandler,
                outputView);
        vendingmachineController.process();
    }
}
