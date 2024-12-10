package vendingmachine.domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

public class Coins {
    private final Map<Coin, Integer> coins;

    public Coins(Map<Coin, Integer> coins) {
        this.coins = coins;
    }

    public Map<Coin, Integer> getCoins() {
        return Collections.unmodifiableMap(coins);
    }

    public Optional<Coin> findMostMoney(int amount) {
        List<Coin> coins = this.coins.entrySet().stream()
                .filter(entry -> entry.getValue() > 0 && entry.getKey().isLessOrEqual(amount))
                .map(Entry::getKey)
                .sorted()
                .toList();

        return coins.stream().findFirst();
    }

    public void minusCoin(Coin coin) {
        coins.put(coin, coins.get(coin) - 1);
    }
}
