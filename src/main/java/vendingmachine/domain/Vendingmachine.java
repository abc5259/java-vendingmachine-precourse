package vendingmachine.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Vendingmachine {
    private final Coins coins;
    private final List<Item> items;

    public Vendingmachine(Coins coins, List<Item> items) {
        this.coins = coins;
        this.items = items;
    }

    public Money purchase(Item purchaseItem, Money purchaseMoney) {
        return purchaseItem.purchase(purchaseMoney);
    }

    public Item findItem(String itemName) {
        return items.stream()
                .filter(item -> item.isEqualName(itemName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 상품 이름입니다."));
    }

    public boolean isPurchaseItem(Money money) {
        return items.stream()
                .anyMatch(item -> item.isPurchase(money));
    }

    public Coins changeCoins(Money money) {
        Map<Coin, Integer> coinMap = new LinkedHashMap<>();
        Optional<Coin> mostMoneyCoin;
        while ((mostMoneyCoin = coins.findMostMoney(money.getAmount())).isPresent()) {
            Coin coin = mostMoneyCoin.get();
            this.coins.minusCoin(coin);
            coinMap.put(coin, coinMap.getOrDefault(coin, 0) + 1);
            money = money.minus(coin.getAmount());
        }
        return new Coins(coinMap);
    }
}
