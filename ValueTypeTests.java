import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ValueTypeTests {

    @Test
    void testCustomStructValueIncrement() {
        CustomStruct customStruct = new CustomStruct(10);
        customStruct.incrementValue();
        assertEquals(11, customStruct.getValue());
    }

    private static class CustomStruct {
        private int value;

        CustomStruct(int value) {
            this.value = value;
        }

        void incrementValue() {
            value++;
        }

        int getValue() {
            return value;
        }
    }
}
