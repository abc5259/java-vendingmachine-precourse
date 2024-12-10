package vendingmachine.domain;

public class Item {
    private final String name;
    private final Money money;
    private final int count;

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
}
