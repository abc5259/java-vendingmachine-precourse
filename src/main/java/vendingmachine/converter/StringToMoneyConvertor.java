package vendingmachine.converter;

import vendingmachine.domain.Money;

public class StringToMoneyConvertor implements Converter<String, Money> {
    @Override
    public Money convert(String source) {
        int amount = new StringToIntConverter().convert(source);
        return new Money(amount);
    }
}
