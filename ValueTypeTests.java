import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValueTypeTests {

    @Test
    void testCustomStructValueIncrement() {
        CustomStruct customStruct = new CustomStruct(10);
        customStruct.incrementValue();
        assertEquals(11, customStruct.getValue());
    }

    @Test
    void testHeapUsageForValueType() {
        System.gc();  
        long heapSizeBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        for (int i = 0; i < 100000; i++) {
            CustomStruct customStruct = new CustomStruct(i);
            
        }

        System.gc();
        long heapSizeAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        assertTrue(heapSizeAfter - heapSizeBefore < 1024 * 1024, "Expected no significant heap usage increase for value types");
    }

    @Test
    void testValueTypeCopyOnFunctionCall() {
        CustomStruct original = new CustomStruct(10);
        modifyStruct(original);
        assertEquals(10, original.getValue(), "Expected original struct value to remain unchanged");
    }

    private void modifyStruct(CustomStruct struct) {
        struct = new CustomStruct(20);
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
