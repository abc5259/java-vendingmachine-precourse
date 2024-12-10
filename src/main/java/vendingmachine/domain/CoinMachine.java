package vendingmachine.domain;

import static vendingmachine.domain.Coin.COIN_10;
import static vendingmachine.domain.Coin.COIN_100;
import static vendingmachine.domain.Coin.COIN_50;
import static vendingmachine.domain.Coin.COIN_500;
import static vendingmachine.domain.Coin.findAmountsLessOrEqual;
import static vendingmachine.domain.Coin.findCoin;

import java.util.LinkedHashMap;
import java.util.Map;
import vendingmachine.domain.strategy.PickNumberInListStrategy;

public class CoinMachine {

    public Coins generatorCoins(Money money, PickNumberInListStrategy pickNumberInListStrategy) {
        Map<Coin, Integer> coins = new LinkedHashMap<>() {{
            put(COIN_10, 0);
            put(COIN_50, 0);
            put(COIN_100, 0);
            put(COIN_500, 0);
        }};

        while (!money.isLess(COIN_10.getAmount())) {
            int amount = pickNumberInListStrategy.pickNumberInList(findAmountsLessOrEqual(money.getAmount()));
            Coin coin = findCoin(amount);
            coins.put(coin, coins.get(coin) + 1);
            money = money.minus(amount);
        }
        return new Coins(coins);
    }
}
