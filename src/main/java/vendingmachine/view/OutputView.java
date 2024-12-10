package vendingmachine.view;

import java.util.Map;
import vendingmachine.domain.Coin;
import vendingmachine.domain.Coins;
import vendingmachine.domain.Money;

public class OutputView {

    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] %s%n";
    private static final String COIN_FORMAT = "%d원 - %d개%n";
    private static final String PUT_MONEY_FORMAT = "투입 금액: %d원%n";

    public void printErrorMessage(Exception exception) {
        System.out.printf(ERROR_MESSAGE_FORMAT, exception.getMessage());
    }

    public void printCoins(Coins coins) {
        System.out.println();
        System.out.println("자판기가 보유한 동전");
        Map<Coin, Integer> coinMap = coins.getCoins();
        coinMap.forEach((coin, count) -> System.out.printf(COIN_FORMAT, coin.getAmount(), count));
    }

    public void printSmallCoins(Coins coins) {
        System.out.println("잔돈");
        Map<Coin, Integer> coinMap = coins.getCoins();
        coinMap.forEach((coin, count) -> System.out.printf(COIN_FORMAT, coin.getAmount(), count));
    }

    public void printPutMoney(Money putMoney) {
        System.out.println();
        System.out.printf(PUT_MONEY_FORMAT, putMoney.getAmount());
    }
}
