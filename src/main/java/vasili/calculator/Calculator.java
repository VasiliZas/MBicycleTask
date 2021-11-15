package vasili.calculator;


import java.util.EmptyStackException;
import java.util.Stack;

import static java.lang.Double.parseDouble;

public class Calculator {

    private final PrioritetOperator priorities;

    private final StringIterator iterator;

    private final Stack<Double> numbers;

    private final Stack<String> operators;

    public Calculator(String string) {
        this.priorities = new PrioritetOperator();
        this.iterator = new StringIterator(string);
        numbers = new Stack<>();
        operators = new Stack<>();
        priorities.addOperator("+", 1);
        priorities.addOperator("-", 1);
        priorities.addOperator("*", 2);
        priorities.addOperator("/", 2);
    }

    public Double getResult() throws NullPointerException, EmptyStackException {
        while (iterator.hasNext()) {
            String element = iterator.next();
            try {
                double number = parseDouble(element);
                numbers.push(number);
            } catch (NumberFormatException e) {
                if (element.equals("(")) {
                    operators.push(element);
                } else if (element.equals(")")) {
                    while (!operators.peek().equals("("))
                        calculate();
                    operators.pop();
                } else { if (!operators.empty()) {
                        while (checkOperatorsAndPriority(priorities,operators, priorities. getPriority(element))) {
                            calculate();
                        }
                    }
                    operators.push(element);
                }
            }
        }
        while (!operators.empty()) {
            calculate();
        }
        return numbers.pop();
    }

    private boolean checkOperatorsAndPriority (PrioritetOperator priorities, Stack<String> operators, Integer priority){
        return (!operators.empty() && !operators.peek().equals("(") && !operators.peek().equals(")") &&
                priority <= priorities.getPriority(operators.peek()));
    }

    private void calculate() throws EmptyStackException {
        String operator = operators.pop();
        Double n2 = numbers.pop();
        Double n1 = numbers.pop();
        Double result = switch (operator) {
            case "+" -> n1 + n2;
            case "-" -> n1 - n2;
            case "*" -> n1 * n2;
            case "/" -> n1 / n2;
            default -> null;
        };
        numbers.push(result);
    }
}


