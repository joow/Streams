import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import static org.testng.Assert.*;

public class StreamsTest {
    @Test
    public void itShouldMapNullToNull() {
        assertNull(Streams.map(null, null));
    }

    @Test
    public void itShouldMapNotNullToNotNull() {
        assertNotNull(Streams.map(Arrays.asList(1), Function.<Integer>identity()));
    }

    @Test
    public void itShouldMapToListOfSameSize() {
        final List<Integer> integers = Arrays.asList(1, 2, 3);
        assertEquals(Streams.map(integers, Function.<Integer>identity()).size(), integers.size());
    }

    @Test
    public void itShouldReverseNullList() {
        assertNull(Streams.reverse(null));
    }

    @Test
    public void itShouldReverseEmptyList() {
        assertTrue(Streams.reverse(Collections.emptyList()).isEmpty());
    }

    @Test
    public void itShouldReverseList() {
        final List<Integer> integers = Arrays.asList(1, 2, 3);
        assertEquals(Streams.reverse(integers), Arrays.asList(3, 2, 1));
    }

    @Test
    public void itShouldGetLastOfANullList() {
        assertNull(Streams.last(null));
    }

    @Test
    public void itShouldGetLastOfAnEmptyList() {
        assertNull(Streams.last(Collections.EMPTY_LIST));
    }

    @Test
    public void itShouldGetLastOf() {
        assertEquals(Streams.last(Arrays.asList(1, 2, 3)), Integer.valueOf(3));
    }
}