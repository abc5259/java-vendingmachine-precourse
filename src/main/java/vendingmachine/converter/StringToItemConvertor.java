package vendingmachine.converter;

import vendingmachine.domain.Item;
import vendingmachine.domain.Money;

public class StringToItemConvertor implements Converter<String, Item> {
    @Override
    public Item convert(String source) {
        if (source == null || source.isEmpty()) {
            throw new IllegalArgumentException("빈값입니다.");
        }

        source = source.trim();
        if (!source.startsWith("[") || !source.endsWith("]")) {
            throw new IllegalArgumentException("잘못된 입력 형식입니다.");
        }

        String subStringSource = source.substring(1, source.length() - 1);
        String[] splitSource = subStringSource.split(",");
        if (splitSource.length != 3) {
            throw new IllegalArgumentException("잘못된 입력 형식입니다.");
        }
        StringToIntConverter stringToIntConverter = new StringToIntConverter();
        return new Item(
                splitSource[0],
                new Money(stringToIntConverter.convert(splitSource[1])),
                stringToIntConverter.convert(splitSource[2])
        );
    }
}
