package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_MONEY_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    private static final String INPUT_ITEMS_MESSAGE = "상품명과 가격, 수량을 입력해 주세요.";

    public String inputMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
        return Console.readLine();
    }

    public String inputItems() {
        System.out.println();
        System.out.println(INPUT_ITEMS_MESSAGE);
        return Console.readLine();
    }
}
