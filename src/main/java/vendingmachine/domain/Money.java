package vendingmachine.domain;

public class Money {

    private final int amount;

    public Money(int amount) {
        validateAmount(amount);
        this.amount = amount;
    }

    private void validateAmount(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("금액은 음수가 될 수 없습니다.");
        }
    }
}