import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Iterator;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
public class GQTest {

    @Test
    public void testPrintEmpty() {
        GenericList<Integer> list = new GenericQueue<>(null);
        list.print();
    }
    @Test
    public void testPrintPopulatedList() {
        GenericList<Integer> list = new GenericQueue<>(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.print();
        assertEquals(0, list.get(0));
        assertEquals(1,list.get(1));
        assertEquals(2, list.get(2));
        assertEquals(3, list.get(3));
    }
    @Test
    public void testDeleteWithList() {
        GenericList<Integer> list = new GenericQueue<>(1);
        list.add(2);
        list.add(3);
        list.delete();
        assertEquals(list.getLength(), 2);
        assertEquals(list.get(0), 2);
        assertEquals(list.get(1), 3);
    }
    @Test
    public void testEnqueueAndDequeue() {
        GenericQueue<Integer> queue = new GenericQueue<>(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(3,queue.getLength());
        assertEquals(1, queue.dequeue());
        assertEquals(2,queue.getLength());
        assertEquals(2, queue.dequeue());
        assertEquals(1,queue.getLength());
        assertEquals(3, queue.dequeue());
        assertEquals(0,queue.getLength());
        assertNull(queue.dequeue());

    }
    @Test
    public void testDumpList() {
        GenericList<Integer> list = new GenericQueue<>(1);
        list.add(2);
        list.add(3);
        ArrayList<Integer> dumpedList = list.dumpList();
        assertEquals(dumpedList.size(), 3);
        assertEquals(dumpedList.get(0), 1);
        assertEquals(dumpedList.get(1), 2);
        assertEquals(dumpedList.get(2),3);
    }

    @Test
    public void testGet() {
        GenericList<Integer> list = new GenericQueue<>(1);
        list.add(2);
        list.add(3);
        assertEquals(list.get(0),1);
        assertEquals(list.get(1),2);
        assertEquals(list.get(2),3);
    }

    @Test
    public void testSet() {
        GenericList<Integer> list = new GenericQueue<>(1);
        list.add(2);
        list.add(3);
        int oldData = list.set(2, 62);
        assertEquals(oldData,3);
        assertEquals(list.get(2), 62);
    }

    @Test
    public void testAddInQueue() {
        GenericQueue<Integer> queue = new GenericQueue<>(1);
        queue.add(2);
        queue.add(3);
        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
        assertNull(queue.dequeue());
    }

    @Test
    public void testGetListLength() {
        GenericList<Integer> list = new GenericQueue<>(1);
        list.add(2);
        list.add(3);
        assertEquals(list.getLength(), 3);
    }

    @Test
    public void testAddWithCode() {
        GenericQueue<Item> queue = new GenericQueue<>(new Item("A", 304020));
        queue.add(new Item("B", 2030), 2030);
        queue.add(new Item("C", 3020), 3020);
        assertEquals("A", queue.dequeue().name);
        assertEquals(2030, queue.dequeue().code);
        assertEquals("C", queue.dequeue().name);
        assertNull(queue.dequeue());
    }

    @Test
    public void testDeleteForQueue() {
        GenericQueue<Integer> queue = new GenericQueue<>(1);
        queue.add(2);
        queue.add(3);
        assertEquals(1, queue.delete());
        assertEquals(2, queue.delete());
        assertEquals(3, queue.delete());
        assertNull(queue.delete());
    }

    @Test
    public void testIterator() {
        GenericQueue<Integer> queue = new GenericQueue<>(1);
        queue.enqueue(2);
        queue.enqueue(3);
        int sum = 0;
        for (int i : queue) {
            sum += i;
        }
        assertEquals(6, sum);
    }

    @Test
    public void testIterator2() {
        GenericQueue<Integer> queue = new GenericQueue<>(2);
        queue.enqueue(4);
        queue.enqueue(8);
        int mult = 1;
        for (int i : queue) {
            mult *= i;
        }
        assertEquals(64, mult);
    }

    @Test
    public void testConstructors() {
        GenericQueue<String> queue1 = new GenericQueue<>("A");
        assertEquals("A", queue1.dequeue());
        assertNull(queue1.dequeue());
        GenericQueue<String> queue2 = new GenericQueue<>("B");
        queue2.add("C");
        assertEquals("B", queue2.dequeue());
        assertEquals("C", queue2.dequeue());
        assertNull(queue2.dequeue());
    }

    @Test
    public void testConstructors2() {
        GenericQueue<Boolean> queue1 = new GenericQueue<>(false);
        assertEquals(false, queue1.dequeue());
        assertNull(queue1.dequeue());
        GenericQueue<Boolean> queue2 = new GenericQueue<>(true);
        queue2.add(false);
        assertEquals(true, queue2.dequeue());
        assertEquals(false, queue2.dequeue());
        assertNull(queue2.dequeue());
    }

    @Test
    public void testDescendingIterator() {
        GenericQueue<String> queue = new GenericQueue<>("lol");
        queue.add("lmao");
        queue.add("haha");
        queue.add("hehe");
        StringBuilder result = new StringBuilder();
        Iterator<String> string = queue.descendingIterator();
        while (string.hasNext()) {
            String str = string.next();
            result.append(str);
        }
        assertEquals("hehehahalmaolol", result.toString());
    }
    @Test
    public void testDescendingIterator2() {
        GenericList<Integer> list = new GenericQueue<>(1);
        list.add(2);
        list.add(3);
        Iterator<Integer> iterator = list.descendingIterator();
        assertEquals(iterator.hasNext(), true);
        assertEquals(iterator.next(), 3);
        assertEquals(iterator.hasNext(), true);
        assertEquals(iterator.next(),2);
        assertEquals(iterator.hasNext(), true);
        assertEquals(iterator.next(), 1);
        assertEquals(iterator.hasNext(), false);
    }

    private static class Item {
        private String name;
        private int code;

        public Item(String name, int code) {
            this.name = name;
            this.code = code;
        }
    }
}
