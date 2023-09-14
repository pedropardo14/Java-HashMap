//Pedro Pardo
//UIN - 656286719
//NetID - ppardo3
//This class is for the ultilization of a linked list for Priority Queue Usage.
//It will help traverse a linked list from head to tail checking every node for a next


import java.util.Iterator;
public class GLLIterator<T> implements Iterator<T> {
    private GenericQueue<T>.Node<T> current;

    public GLLIterator(GenericQueue<T>.Node<T> head) {
        //sets head to the current node for traversal
        this.current = head;
    }

    @Override
    public boolean hasNext() {
        //this checks to see if the current isn't null to keep iterating
        return current != null;
    }

    @Override
    public T next() {
        //this function traverses to the next node
        T data = current.data;
        current = current.next;
        return data;
    }

}
