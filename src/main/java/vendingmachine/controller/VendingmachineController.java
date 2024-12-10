package vendingmachine.controller;

import vendingmachine.domain.CoinMachine;
import vendingmachine.domain.Coins;
import vendingmachine.domain.Money;
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
    }
}
