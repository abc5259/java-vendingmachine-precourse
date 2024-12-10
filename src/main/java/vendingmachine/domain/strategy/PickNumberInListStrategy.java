package vendingmachine.domain.strategy;

import java.util.List;

public interface PickNumberInListStrategy {
    int pickNumberInList(List<Integer> list);
}
