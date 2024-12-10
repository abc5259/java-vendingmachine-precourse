package vendingmachine.controller;

import java.util.List;
import vendingmachine.domain.CoinMachine;
import vendingmachine.domain.Coins;
import vendingmachine.domain.Item;
import vendingmachine.domain.Money;
import vendingmachine.domain.Vendingmachine;
import vendingmachine.domain.strategy.RandomPickNumberInListStrategy;
import vendingmachine.view.OutputView;

public class VendingmachineController {

    private final IteratorInputHandler iteratorInputHandler;
    private final OutputView outputView;

    public VendingmachineController(IteratorInputHandler iteratorInputHandler, OutputView outputView) {
        this.iteratorInputHandler = iteratorInputHandler;
        this.outputView = outputView;
    }

    public void process() {
        Money money = iteratorInputHandler.inputMoney();
        Coins coins = new CoinMachine().generatorCoins(money, new RandomPickNumberInListStrategy());
        outputView.printCoins(coins);

        List<Item> items = iteratorInputHandler.inputItems();
        Money putMoney = iteratorInputHandler.inputPutMoney();
        Vendingmachine vendingmachine = new Vendingmachine(coins, items);
        do {
            outputView.printPutMoney(putMoney);
            if (!vendingmachine.isPurchaseItem(putMoney)) {
                break;
            }

            Item item = iteratorInputHandler.inputPurchaseItemName(vendingmachine);
            putMoney = putMoney.minus(vendingmachine.purchase(item, putMoney));
        } while (true);

    }
}
