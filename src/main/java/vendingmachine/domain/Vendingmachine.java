package vendingmachine.domain;

import java.util.List;

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
}
