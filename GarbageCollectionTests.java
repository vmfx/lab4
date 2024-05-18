import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GarbageCollectionTests {

    @Test
    public void verifyThatUnreferencedObjectsAreCollected() {
        Object[] objects = new Object[1024];

        for (int i = 0; i < objects.length; i++) {
            objects[i] = new Object();
        }

        long allocatedMemoryBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        System.gc();

        long allocatedMemoryAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        assertTrue(allocatedMemoryAfter < allocatedMemoryBefore, "Expected to free up some memory");
    }
}
