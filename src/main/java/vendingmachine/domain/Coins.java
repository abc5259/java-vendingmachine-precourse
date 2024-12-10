package vendingmachine.domain;

import java.util.Map;

public class Coins {
    private final Map<Coin, Integer> coins;

    public Coins(Map<Coin, Integer> coins) {
        this.coins = coins;
    }
}
