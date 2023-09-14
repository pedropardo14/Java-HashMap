//Pedro Pardo
//UIN - 656286719
//NetID - ppardo3
//This class is for the creation of Priority Queues.
//It will be used to help create hash maps

import java.util.Iterator;

public class GenericQueue<T> extends GenericList<T> implements Iterable<T>  {
     private Node<T> tail;

    public GenericQueue(T data){
        //constructor that sets the data to the tail
        Node<T> newNode = new Node<T>(data);
        setHead(newNode);
        this.tail = newNode;
        setLength(getLength()+1);
    }
    @Override
    public void add(T data) {
        //this takes in new data and creates a new node to the back of the list
        Node<T> newNode = new Node<T>(data);
        if (getHead() == null) {
            setHead(newNode);
            tail = getHead();
        }
        else {
            tail.next = newNode;
            tail = newNode;
        }
        setLength(getLength()+1);
    }

    public void add(T data, int code) {
        //overloaded function, but this time
        //this takes in new data, and a code value and
        // creates a new node to the back of the list
        Node<T> newNode = new Node<T>(data, code);
        if (getHead() == null) {
            setHead(newNode);
            tail = getHead();
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        setLength(getLength()+1);
    }

    @Override
    public T delete() {
        //this deletes a node from the FRONT of the list since that node will have the most
        //priority in the list
        if (getHead() == null){
            return null;
        }
        else{
            Node<T> curr = getHead();
            setHead(getHead().next);

            if(getHead() == null){
                tail = null;
            }
            setLength(getLength()-1);

            return curr.data;
        }
    }

    public void enqueue(T data) {
        add(data);
    }
    //calls add

    public T dequeue() {
        return delete();
    }
    //calls delete

    public Iterator<T> iterator(){
        //this is an iterator call to loop through the priority queue
        return new GLLIterator(getHead());
    }

}
