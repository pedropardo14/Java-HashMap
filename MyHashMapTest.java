import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Iterator;
import org.junit.jupiter.api.BeforeAll;

public class MyHashMapTest {
    static MyHashMap<String> stringMap;
    static MyHashMap<Integer> intMap;

    @BeforeAll
    static void setUp() {
        stringMap = new MyHashMap<String>("key", "value");
    }
    @BeforeAll
    static void setUp2() {
        intMap = new MyHashMap<Integer>("pos", 0);
    }

    @Test
    public void testPutString() {
        stringMap.put("newKey", "newValue");
        assertEquals(2, stringMap.size());
        assertEquals("newValue", stringMap.get("newKey"));
    }
    @Test
    public void testPutInt() {
        intMap.put("newPos", 1);
        intMap.put("newPos", 2);
        assertEquals(3, intMap.size());
        assertEquals(1, intMap.get("newPos"));
    }

    @Test
    public void testSizeString() {
        assertEquals(2, stringMap.size());
    }

    @Test
    public void testSizeInt() {
        assertEquals(3, intMap.size());
    }

    @Test
    public void testIsEmpty() {
        assertFalse(stringMap.isEmpty());
        MyHashMap<String> emptyMap = new MyHashMap<String>(null, null);
        assertTrue(emptyMap.isEmpty());
    }

    @Test
    public void testGet() {
        assertEquals("value", stringMap.get("key"));
        assertNull(stringMap.get("fake"));
    }

    @Test
    public void testContains() {
        assertTrue(stringMap.contains("key"));
        assertFalse(stringMap.contains("fake"));
        assertFalse(stringMap.contains("lmao"));
    }

    @Test
    public void testReplace() {
        assertEquals("value", stringMap.replace("key", "newValue"));
        assertEquals("newValue", stringMap.get("key"));
        assertNull(stringMap.replace("fake", "newValue"));
    }

    @Test
    public void TestHashIterator() {
        MyHashMap<String> map = new MyHashMap<>("support","Ana");
        int hashNum = "Ana".hashCode();
        int index = hashNum & 9;
        System.out.println("New queue created at index " + index + " with head node: " + map.map.get(index).getHead().data + " (code: " + map.map.get(index).getHead().code + ")");
        map.put("support","Baptiste");
        int hashNum2 = "Baptiste".hashCode();
        int index2 = hashNum2 & 9;
        System.out.println("New queue created at index " + index2 + " with head node: " + map.map.get(index2).getHead().data + " (code: " + map.map.get(index2).getHead().code + ")");
        map.put("support","Brigitte");
        map.put("support","Kiriko");
        map.put("support","Lúcio");
//        map.put("support","Mercy");
//        map.put("support","Moira");
//        map.put("support","Zenyatta");
//        map.put("dps","Ashe");
//        map.put("dps","Bastion");
//        map.put("dps","Cassidy");
//        map.put("dps","Echo");
//        map.put("dps","Genji");
//        map.put("dps","Hanzo");
//        map.put("dps","Junkrat");
//        map.put("dps","Mei");
//        map.put("dps","Pharah");
//        map.put("dps","Reaper");
//        map.put("dps","Sojounr");
//        map.put("dps","Soldier:76");
//        map.put("dps","Sombra");
//        map.put("dps","Symmetra");
//        map.put("dps","Torbjorn");
//        map.put("dps","Tracer");
//        map.put("dps","Widowmaker");
//        map.put("tank","D.Va");
//        map.put("tank","Doomfist");
//        map.put("tank","JunkerQueen");
//        map.put("tank","Orisa");
//        map.put("tank","Reinhardt");
//        map.put("tank","Roadhog");
//        map.put("tank","Sigma");
//        map.put("tank","Winston");
//        map.put("tank","WreckingBall");
//        map.put("tank","Zarya");



        Iterator<String> it = map.iterator();
        assertTrue(it.hasNext());
        assertEquals("Ana", it.next());
        assertTrue(it.hasNext());
//        assertEquals(2, it.next());
//        assertTrue(it.hasNext());
//        assertEquals(3, it.next());
//        assertFalse(it.hasNext());
    }

    @Test
    public void testConstructors() {
        MyHashMap<String> emptyMap = new MyHashMap<String>(null, null);
        assertTrue(emptyMap.isEmpty());
        MyHashMap<String> map = new MyHashMap<String>("key1", "value1");
        map.put("key2", "value2");
        assertEquals("value1", map.get("key1"));
        assertEquals("value2", map.get("key2"));
        assertEquals(2, map.size());
    }

}
