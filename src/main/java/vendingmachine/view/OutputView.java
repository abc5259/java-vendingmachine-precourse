package vendingmachine.view;

import java.util.Map;
import vendingmachine.domain.Coin;
import vendingmachine.domain.Coins;

public class OutputView {

    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] %s%n";
    private static final String COIN_FORMAT = "%d원 - %d개%n";

    public void printErrorMessage(Exception exception) {
        System.out.printf(ERROR_MESSAGE_FORMAT, exception.getMessage());
    }

    public void printCoins(Coins coins) {
        System.out.println();
        Map<Coin, Integer> coinMap = coins.getCoins();
        coinMap.forEach((coin, count) -> System.out.printf(COIN_FORMAT, coin.getAmount(), count));
    }
}
