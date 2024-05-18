import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ValueTypeTests {

    @Test
    void testPrimitiveValueIncrement() {
        int originalValue = 10;
        int incrementedValue = incrementValue(originalValue);
        assertEquals(11, incrementedValue);
    }

    private int incrementValue(int value) {
        return value + 1;
    }
}
