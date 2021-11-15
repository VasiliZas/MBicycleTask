package vasili.fibonacci;

import java.util.LinkedList;
import java.util.List;


public class Fibonacci {

    private static volatile Fibonacci instance;

    private final List<Integer> fibonacciList = new LinkedList<>();
    private Integer a;
    private Integer b;
    private Integer sum;

    private Fibonacci() {
        //singleton
    }

    public static Fibonacci getInstance() {
        if (instance == null) {
            synchronized (Fibonacci.class) {
                if (instance == null) {
                    instance = new Fibonacci();
                }
            }
        }
        return instance;
    }

    public List<Integer> getFibonacciList(int count) {
        a = 0;
        b = 1;
        for (int i = 1; i <= count; ++i) {
            fibonacciList.add(a);
            sum = a + b;
            a = b;
            b = sum;
        }
        return fibonacciList;
    }

    public List<Integer> getFibonacciListWithStartValue(int start, int count) {
        a = start;
        b = a + 1;
        for (int i = 1; i <= count; ++i) {
            fibonacciList.add(a);
            sum = a + b;
            a = b;
            b = sum;
        }
        return fibonacciList;
    }
}
