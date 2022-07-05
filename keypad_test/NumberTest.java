import static org.junit.Assert.*;
import org.junit.Test;

public class NumberTest {
  
    @Test
    public void testNumber1() {
        Keypad k = new Keypad(new String[][]{{"1","2","3"},{"4","5","6"},{"7","8","9"},{"*","0","#"}});
        assertTrue(k.checkEasyNumber("08523665414"));
    }

    @Test
    public void testNumber2() {
        Keypad k = new Keypad(new String[][]{{"1","2","3"},{"4","5","6"},{"7","8","9"},{"*","0","#"}});
        assertTrue(k.checkEasyNumber("096 368 07412"));
    }

    @Test
    public void testNumber3() {
        Keypad k = new Keypad(new String[][]{{"1","2","3"},{"4","5","6"},{"7","8","9"},{"*","0","#"}});
        assertFalse(k.checkEasyNumber("096 348 07412"));
    }

    @Test
    public void testNumber4() {
        Keypad k = new Keypad(new String[][]{{"1","2","3"},{"4","5","6"},{"7","8","9"},{"*","0","#"}});
        assertFalse(k.checkEasyNumber("083 169 73111"));
    }

    @Test
    public void alternateKeypadLayou1() {
        Keypad k = new Keypad(new String[][]{{"*","0","#"},{"7","8","9"},{"4","5","6"},{"1","2","3"}});
        assertTrue(k.checkEasyNumber("125 698 741"));
    }

    @Test
    public void alternateKeypadLayout2() {
        Keypad k = new Keypad(new String[][]{{"*","0","#"},{"7","8","9"},{"4","5","6"},{"1","2","3"}});
        assertFalse(k.checkEasyNumber("789 456 123"));
    }

    @Test
    public void alternateKeypadLayout3() {
        Keypad k = new Keypad(new String[][]{{"*","0","#"},{"1","2","3"}});
        assertTrue(k.checkEasyNumber("123"));
    }
}
