//Pedro Pardo
//UIN - 656286719
//NetID - ppardo3
//This class is for the ultilization of a linked list for Priority Queue Usage.
//It will help traverse a linked list from the tail to the head as an iterator value

import java.util.Iterator;

public class ReverseGLLIterator<T> implements Iterator<T> {

    //initializing nodes used to traverse through the list
    private GenericList<T>.Node<T> curr;
    private GenericList<T>.Node<T> prev;
    private GenericList<T>.Node<T> head2;
    private GenericList<T>.Node<T> next;

    public ReverseGLLIterator(GenericList<T>.Node<T> head){
        //constructor for the iterator
        //reverses the linked list
       prev = null;
       curr = head;
       next = null;
       while(curr != null) {
           next = curr.next;
           curr.next = prev;
           prev = curr;
           curr = next;
       }
       this.head2 = prev;
    }


    @Override
    public boolean hasNext(){
        return head2 != null;
    }
    //returns a boolean to the trust of the next node in respect to current

    @Override
    public T next(){
        //goes to the next node and returns the data of current
        T data = this.head2.data;
        head2 = head2.next;
        return data;
    }
}
