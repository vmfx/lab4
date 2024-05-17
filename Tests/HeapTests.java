import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class HeapTests {

    @Test
    public void testHeapObjectCreationAndManipulation() {
        List<String> strings = new ArrayList<>();
        
        strings.add("Apple");
        strings.add("Banana");
        strings.add("Orange");

        assertEquals(3, strings.size(), "Expected list to contain 3 objects");

        assertTrue(strings.contains("Apple"), "Expected list to contain 'Apple'");
        assertTrue(strings.contains("Banana"), "Expected list to contain 'Banana'");
        assertTrue(strings.contains("Orange"), "Expected list to contain 'Orange'");

        strings.set(1, "Grapes");

        assertFalse(strings.contains("Banana"), "Expected list not to contain 'Banana'");
        assertTrue(strings.contains("Grapes"), "Expected list to contain 'Grapes'");
    }
}
