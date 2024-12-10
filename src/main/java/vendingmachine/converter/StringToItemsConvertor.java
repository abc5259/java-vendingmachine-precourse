package vendingmachine.converter;

import java.util.Arrays;
import java.util.List;
import vendingmachine.domain.Item;

public class StringToItemsConvertor implements Converter<String, List<Item>> {
    @Override
    public List<Item> convert(String source) {
        if (source == null || source.isEmpty()) {
            throw new IllegalArgumentException("빈값입니다.");
        }
        String[] sources = source.split(";");
        if (sources.length == 0) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        StringToItemConvertor stringToItemConvertor = new StringToItemConvertor();
        return Arrays.stream(sources)
                .map(stringToItemConvertor::convert)
                .toList();
    }
}
