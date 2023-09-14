//Pedro Pardo
//UIN - 656286719
//NetID - ppardo3
//This class is for the iteration of a hash map.
//It will help to loop through a hash map from index 0 to 10

import java.util.Iterator;
public class HMIterator<T> implements Iterator<T> {
    private final MyHashMap<T> MyHashMap;
    private int currentIndex;
    private GenericQueue<T>.Node<T> currentNode;

    public HMIterator(MyHashMap<T> MyHashMap) {
        //constructor sets values to 0
        this.MyHashMap = MyHashMap;
        this.currentIndex = 0;
        this.currentNode = null;
    }

    public boolean hasNext() {
        //this checks the next data value to see if its there or not
        //will either return true or false
        if (currentNode != null && currentNode.next != null) {
            return true;
        }

        for (int i = currentIndex; i < MyHashMap.map.size(); i++) {
            //checks for populated index's
            if (MyHashMap.map.get(i) != null && MyHashMap.map.get(i).getLength() > 0) {
                return true;
            }
        }
        return false;
    }

    public T next() {
        //this goes to the next value and returns the value of the current node

        if (currentNode == null) {
            //when the node is empty give it the value of the head
            currentNode = MyHashMap.map.get(currentIndex).getHead();
        }
        if (currentNode != null && currentNode.next != null) {
            //when both aren't null, continue on
            currentNode = currentNode.next;
            return currentNode.data;

        }
        else{
            for (int i = currentIndex; i < MyHashMap.map.size(); i++) {
                if (MyHashMap.map.get(i) != null && MyHashMap.map.get(i).getHead() != null) {
                    currentIndex = i;
                    currentNode = MyHashMap.map.get(currentIndex).getHead();
                    return currentNode.data;
                }
            }
        }
        return currentNode.data;
    }

}

