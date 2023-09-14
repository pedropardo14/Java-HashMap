//Pedro Pardo
//UIN - 656286719
//NetID - ppardo3
//This class is for the ultilization of a hash map made up of PriorityQueues


import java.util.ArrayList;
import java.util.Iterator;

public class MyHashMap<T> implements Iterable<T>{
    public ArrayList<GenericQueue<T>> map;
    private int size;


    public MyHashMap(String key, T value){
        //constructor that it will initialize the ArrayList map to 10 and add the
        //first key/value pair into the ArrayList map
        size=0;
        if(key == null || value == null) {
            return;
        }
        else {
            map = new ArrayList<GenericQueue<T>>(10);
            for (int i = 0; i < 10; i++) {
                map.add(new GenericQueue<>(null));
            }
            put(key, value);
        }
    }

    public void put(String key, T value) {
        //this method will take a key value pair and
        //create a hash code and hash value using the key passed into the method
        //if there isn't a value there already it creates a queue based off the index

        int hashNum = key.hashCode();
        int index = hashNum & 9;
        if (map.get(index) == null) {
            map.set(index, new GenericQueue<>(value));
            GenericQueue<T>.Node<T> curr = new GenericQueue<T>(null).new Node<>(value, hashNum);
            map.get(index).setHead(curr);

        } else {
            map.get(index).add(value, hashNum);
        }
        size++;
    }
    public int size(){
        return size;
    }
    //returns the size of the hashmap

    public boolean isEmpty(){
        return size == 0;
    }
    //returns a boolean that sees if the list is empty or not

    public T get(String key){
        // this method will return the value at the given key
        // or return null if it does not exist.
        //loops through the hashmap to check all values

        int hashNum = key.hashCode();
        int index = hashNum&9;
        if(map.get(index) == null){
            return null;
        }
        else{
            GenericQueue<T>.Node<T> curr = map.get(index).getHead();
            while(curr != null){
                if(curr.code == hashNum){
                    return curr.data;
                }
                curr = curr.next;
            }
            return null;
        }
    }

    public boolean contains(String key) {
        //this method will check to see if the given key exists in the HashMap
        // and return true if yes and false if no.
        int hashNum = key.hashCode();
        int index = hashNum&9;
        if (map.get(index) == null) {
            return false;
        }
        else{
            GenericQueue<T>.Node<T> curr = map.get(index).getHead();
            while(curr != null){
                if(curr.code == hashNum){
                    return true;
                }
                curr = curr.next;
            }
            return false;
        }
    }

    public T replace(String key, T value){
        //replaces the entry for the specified key only
        //if it is currently mapped to some value.
        int hashNum = key.hashCode();
        int index = hashNum&9;

        if (map.get(index) == null) {
            return null;
        }
        else{
            GenericQueue<T>.Node<T> curr = map.get(index).getHead();
            while(curr != null){
                if(curr.code == hashNum){
                    T oldNum = curr.data;
                    curr.data = value;
                    return oldNum;
                }
                curr = curr.next;
            }
            return null;
        }
    }

    public Iterator<T> iterator() {
        //this is a class call to iterate through a hashmap
        return new HMIterator(this);
    }
}
