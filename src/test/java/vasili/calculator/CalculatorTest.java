package vasili.calculator;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;


public class CalculatorTest {
    Logger log = LoggerFactory.getLogger(CalculatorTest.class);

    @Test
    public void getResult() {
        String string = "3 + 45.7 - ( 12 + 5.6 * -7)";
        var calc = new Calculator(string);
        var result = calc.getResult();
        log.info("Result = {} ", result);
        double expected = 75.9;
        assertEquals(expected, result, 0.01);
    }
}
