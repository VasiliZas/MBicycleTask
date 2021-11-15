package vasili.calculator;

import java.util.HashMap;
import java.util.Map;

public class PrioritetOperator {

    private final Map<String, Integer> map;

    public PrioritetOperator() {
        map = new HashMap<>();}

    public Integer getPriority(String operator) {
        return map.get(operator);}

    public void addOperator(String operator, int priority) {
        map.put(operator, priority);}
}
