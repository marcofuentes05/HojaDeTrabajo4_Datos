import static org.junit.jupiter.api.Assertions.*;

class CalculatorImpTest {

    @org.junit.jupiter.api.Test
    void calculate() {
        int n1 = 5;
        int n2 = 5;
        String op = "+";
        int expected = 10;
        CalculatorImp c = new CalculatorImp();

        assertEquals(10, c.calculate(n1,n2,op));
    }
}