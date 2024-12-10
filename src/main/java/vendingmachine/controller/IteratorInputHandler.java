package vendingmachine.controller;


import java.util.List;
import vendingmachine.converter.StringToItemsConvertor;
import vendingmachine.converter.StringToMoneyConvertor;
import vendingmachine.domain.Item;
import vendingmachine.domain.Money;
import vendingmachine.domain.Vendingmachine;
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

    public List<Item> inputItems() {
        return iteratorInputTemplate.execute(
                inputView::inputItems,
                new StringToItemsConvertor()
        );
    }

    public Money inputPutMoney() {
        return iteratorInputTemplate.execute(
                inputView::inputPutAmount,
                new StringToMoneyConvertor()
        );
    }

    public Item inputPurchaseItemName(Vendingmachine vendingmachine) {
        return iteratorInputTemplate.execute(
                inputView::inputPurchaseItemName,
                name -> {
                    if (name == null || name.isEmpty()) {
                        throw new IllegalArgumentException("이름을 입력하세요.");
                    }
                    return vendingmachine.findItem(name);
                }
        );
    }
}
