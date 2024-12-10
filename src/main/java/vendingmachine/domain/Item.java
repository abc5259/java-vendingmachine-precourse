package vendingmachine.domain;

public class Item {
    private final String name;
    private final Money money;
    private int count;

    public Item(String name, Money money, int count) {
        validateName(name);
        validateCount(count);
        this.name = name;
        this.money = money;
        this.count = count;
    }

    private void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("상품 이름을 입력하세요.");
        }
    }

    private void validateCount(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("수량은 0보다 작을 수 없습니다.");
        }
    }

    public boolean isEqualName(String itemName) {
        return this.name.equals(itemName);
    }

    public boolean isPurchase(Money money) {
        return this.count > 0 && this.money.isLessOrEqual(money);
    }

    public Money purchase(Money purchaseMoney) {
        if (!isPurchase(purchaseMoney)) {
            throw new IllegalArgumentException("구매할 수 없는 상품입니다.");
        }

        count -= 1;
        return this.money;
    }
}
