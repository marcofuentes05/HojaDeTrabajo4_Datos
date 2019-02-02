import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Es la clase de pruebas de JUnit
 */
class PilaTest {

    @Test
    void push() {
    }

    @Test
    void pop() {
    }

    @Test
    void peek() {
        Pila<String> f = new Pila<String>();
        Boolean esperado = true;
        assertEquals(esperado, f.empty());
    }

    @Test
    void empty() {
    }

    @Test
    void size() {
    }
}