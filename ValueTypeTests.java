import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValueTypeTests {

    @Test
    void testPrimitiveValueIncrement() {
        int value = 10;
        value++;
        assertEquals(11, value);
    }

    @Test
    void testHeapUsageForPrimitiveTypes() {
        System.gc();
        long heapSizeBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        for (int i = 0; i < 100000; i++) {
            int value = i; 
        }

        System.gc();
        long heapSizeAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        assertTrue(heapSizeAfter - heapSizeBefore < 1024 * 1024, "Expected no significant heap usage increase for primitive types");
    }

    @Test
    void testPrimitiveCopyOnFunctionCall() {
        int original = 10;
        modifyValue(original);
        assertEquals(10, original, "Expected original primitive value to remain unchanged");
    }

    private void modifyValue(int value) {
        value = 20;
    }
}
