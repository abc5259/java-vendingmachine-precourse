package vendingmachine.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public static List<Integer> findAmountsLessOrEqual(int amount) {
        return Arrays.stream(Coin.values())
                .filter(coin -> coin.isLessOrEqual(amount))
                .map(coin -> coin.amount)
                .collect(Collectors.toList());
    }

    public static Coin findCoin(int amount) {
        return Arrays.stream(Coin.values())
                .filter(coin -> coin.amount == amount)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 코인입니다."));
    }

    public int getAmount() {
        return amount;
    }

    private boolean isLessOrEqual(int amount) {
        return this.amount <= amount;
    }

}
