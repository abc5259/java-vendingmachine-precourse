package vendingmachine.controller;


import vendingmachine.converter.StringToMoneyConvertor;
import vendingmachine.domain.Money;
import vendingmachine.view.InputView;

public class IteratorInputHandler {

    private final InputView inputView;
    private final IteratorInputTemplate iteratorInputTemplate;

    public IteratorInputHandler(InputView inputView, IteratorInputTemplate iteratorInputTemplate) {
        this.inputView = inputView;
        this.iteratorInputTemplate = iteratorInputTemplate;
    }

    public Money inputMoney() {
        return iteratorInputTemplate.execute(
                inputView::inputMoney,
                new StringToMoneyConvertor()
        );
    }
}
