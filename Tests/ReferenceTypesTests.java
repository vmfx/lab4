import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReferenceTypesTests {

    @Test
    public void testReferenceTypes() {
        StringBuilder sb1 = new StringBuilder("Hello");
        StringBuilder sb2 = sb1;

        sb1.append(", world!");

        assertEquals("Hello, world!", sb2.toString(), "Expected content of sb2 to be modified by sb1");
    }
}
