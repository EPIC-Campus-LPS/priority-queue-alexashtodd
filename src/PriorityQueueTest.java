import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PriorityQueueTest {

    @Test
    public void testAddAndPeek() {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(5);
        pq.add(2);
        pq.add(1);

        assertEquals(1, pq.peek());
    }

    @Test
    public void testPoll() {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(4);
        pq.add(2);
        pq.add(7);

        assertEquals(2, pq.poll());
        assertEquals(4, pq.peek());
    }

    @Test
    public void testContains() {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(10);

        assertTrue(pq.contains(10));
        assertFalse(pq.contains(5));
    }

    @Test
    public void testRemove() {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(1);
        pq.add(3);
        pq.add(2);

        assertTrue(pq.remove(3));
        assertFalse(pq.contains(3));
    }

    @Test
    public void testSize() {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(1);
        pq.add(2);

        assertEquals(2, pq.size());
    }

    @Test
    public void testEmptyQueue() {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        assertNull(pq.peek());
        assertNull(pq.poll());
    }}
