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

    public int getAmount() {
        return amount;
    }

    public Money minus(int amount) {
        return new Money(this.amount - amount);
    }

    public Money minus(Money money) {
        return new Money(this.amount - money.amount);
    }

    public boolean isLess(int amount) {
        return this.amount < amount;
    }

    public boolean isLessOrEqual(Money money) {
        return this.amount <= money.amount;
    }
}
