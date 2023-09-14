//Pedro Pardo
//UIN - 656286719
//NetID - ppardo3
//This class is for the ultilization of a linked list for Priority Queue Usage.
//It creates a list of nodes when called upon within HashMaps

import java.util.ArrayList;
import java.util.Iterator;

public abstract class GenericList<T> implements Iterable<T>{
    public class Node<T> {
        //Constructor for a linked list
        T data;
        int code;
        Node<T> next;
        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public Node(T data, int code) {
            this.data = data;
            this.code = code;
            this.next = null;
        }

    }

    private Node<T> head;
    private int length;

    public GenericList() {
        //Constructor for basic linked list
        this.head = null;
        this.length = 0;
    }
    public void print(){
        //Function to print the items of the list, one value per line.
        // If the list is empty it will  print “Empty List."
        if(head == null){
            System.out.println("Empty List");
        }
        Node <T> curr = head;
        while (curr != null){
            System.out.println(curr.data);
            curr = curr.next;
        }
    }
    public abstract void add(T data);
    //adds the value to the list

    public abstract T delete();
    //deletes nodes from the list

    public ArrayList<T> dumpList(){
        // this method stores and returns all values currently in the list
        // and forms it into an ArrayList and returns it.
        ArrayList<T> storedData = new ArrayList<T>();
        Node<T> curr = head;

        while (curr != null){
            storedData.add(curr.data);
            curr = curr.next;
        }
        return storedData;
    }
    public T get(int index){
        //returns the value at the specified index
        // or null if the index is out of bounds
        if(index < 0 || index >= length){
            return null;
        }

        else{
            Node<T> curr = head;
            for (int i = 0; i < index; ++i){
                curr = curr.next;
            }
            return curr.data;
        }
    }

    public T set(int index, T element){
        //replace the element at specified position in the list
        // with the specified element and return the element previously at the specified position.
        if(index < 0 || index >= length){
            //Return null if index is out of bounds
            return null;
        }

        else {
            Node<T> curr = head;
            T oldNode;
            for (int i = 0; i < index; ++i) {
                curr = curr.next;
            }
            oldNode = curr.data;
            curr.data = element;

            return oldNode;
        }
    }
    public int getLength(){
        return length;
    }
    //getter for the length of the list
    public void setLength(int length){
        this.length = length;
    }
    //sets the length of the list

    public Node<T> getHead(){
        return head;
    }
    //gets the head node of the list

    public void setHead(Node<T> head){
        this.head = head;
    }
    //sets the head of the list

    public Iterator<T> descendingIterator() {
        //returns an iterator over the elements of the list in reverse order
        //from tail to head of the list
        return new ReverseGLLIterator(head);
    }
//





}
