package vasili.fibonacci;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static vasili.fibonacci.Fibonacci.getInstance;

public class FibonacciTest {

    Logger log = LoggerFactory.getLogger("Test");

    @Test
    public void getFibonacciList() {
        log.info("Fibonacci Test {} ", getInstance().getFibonacciList(25));
        Integer expected = 8;
        Integer actual = getInstance().getFibonacciList(8).get(6);
        assertEquals(expected, actual);
    }

    @Test
    public void getFibonacciListWithStartValue() {
        log.info("Fibonacci Test with start value {} ", getInstance().getFibonacciListWithStartValue(5, 11));
        Integer expected = 73;
        Integer actual = getInstance().getFibonacciList(8).get(6);
        assertEquals(expected, actual);
    }
}
