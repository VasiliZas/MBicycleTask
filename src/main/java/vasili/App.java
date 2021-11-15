package vasili;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vasili.calculator.Calculator;
import vasili.fibonacci.Fibonacci;

import java.util.EmptyStackException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Logger log = LoggerFactory.getLogger(App.class);
        var list = Fibonacci.getInstance().getFibonacciList(8);
        log.info("Fibonacci values = {} ", list);

        Scanner scanner = new Scanner(System.in);
        log.info("Enter your string");
        String str = scanner.nextLine();
        scanner.close();

        Calculator calculator = new Calculator(str);

        try {
            Double result = calculator.getResult();
            log.info("Result calculate = {}", result);
        } catch (NullPointerException | EmptyStackException e) {
            log.warn(e.getMessage());
        }
    }
}
