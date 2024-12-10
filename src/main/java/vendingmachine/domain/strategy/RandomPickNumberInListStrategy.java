package vendingmachine.domain.strategy;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomPickNumberInListStrategy implements PickNumberInListStrategy {
    @Override
    public int pickNumberInList(List<Integer> list) {
        return Randoms.pickNumberInList(list);
    }
}
