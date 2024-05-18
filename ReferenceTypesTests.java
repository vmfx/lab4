import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReferenceTypesTests {

    @Test
    public void testHeapUsageForReferenceType() throws InterruptedException {
     
        System.gc();
        Thread.sleep(1000);
        long heapSizeBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        StringBuilder[] builders = new StringBuilder[1000000];
        for (int i = 0; i < builders.length; i++) {
            builders[i] = new StringBuilder("Hello");
        }

        System.gc();
        Thread.sleep(1000);
        long heapSizeAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        assertTrue(heapSizeAfter > heapSizeBefore, "Expected heap usage to increase for reference types");
    }
}
