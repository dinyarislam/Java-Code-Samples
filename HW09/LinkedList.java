//I worked on the homework assignment alone, using only course materials.
import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
*This class represents an LinkedList
*@author Dinyar Islam
*@version 1.0
*@param <T> type of data
*/

public class LinkedList<T> {
    private Node<T> head;
    private int size;

    /**
    *Creates a LinkedList (constructor)
    */
    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    /**
    *This method adds another Node at the specified index in the LinkedList.
    *@param data the data of the new node
    *@param index position in the LinkedList where new node is to be added
    */
    public void addAtIndex(T data, int index) {
        Node<T> node1 = new Node<T>(data, head);
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Index Out Of Bounds");
        } else {
            if (head == null) {
                head = node1;
            } else if (index == 0) {
                node1.setNext(head);
                head = node1;
            } else {
                Node<T>  current = head;
                while ((index - 1) > 0) {
                    current = current.getNext();
                    index = index - 1;
                }
                node1.setNext(current.getNext());
                current.setNext(node1);
            }
            size++;
        }
    }

    /**
    *This method removes the Node at the index that is specified.
    *@param index position of the node in the LinkedList that is to be removed.
    *@return the data that was removed.
    */
    public T removeFromIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index Out Of Bounds");
        } else {
            Node<T> current = head;
            T removedData;
            if (index == 0) {
                removedData = head.getData();
                head = head.getNext();
            } else {
                while ((index - 1) > 0) {
                    current = current.getNext();
                    index = index - 1;
                }
                removedData = current.getNext().getData();
                Node<T> temp = current.getNext().getNext();
                current.setNext(temp);
            }
            size--;
            return removedData;
        }
    }

    /**
    *This method will clear out the entire linked list.
    */
    public void clear() {
        head = null;
        size = 0;
    }

    /**
    *This method will find data at the specified index in the LinkedList and return it.
    *@param index position of the node in the LinkedList that is to be found.
    *@return the data at the specified index in the LinkedList
    */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index Out Of Bounds");
        } else {
            Node<T> current = head;
            T target;
            if (index == 0) {
                target = head.getData();
            } else {
                while ((index - 1) > 0) {
                    current = current.getNext();
                    index = index - 1;
                }
                target = current.getNext().getData();
            }
            return target;
        }
    }

    /**
    *This method will return true or false based on if the LinkedList is currently empty.
    *@return a boolean indicating that the LinkedList is empty
    */
    public boolean isEmpty() {
        return (head == null);
    }

    /**
    *This method converts the LinkedList to an ArrayList.
    *@return the ArrayList that was created
    */
    public ArrayList<T> toArrayList() {
        ArrayList<T> retList = new ArrayList<>(size);
        Node<T> current = head;
        while (current != null) {
            retList.add(current.getData());
            current = current.getNext();
        }
        return retList;
    }

    /**
    *This method takes in a data that’s in the LinkedList, removes that element,
    *and moves that element to the front.
    *@param data data to be removed from and moved to the front of the LinkedList
    */
    public void toTheFront(T data) {
        Node<T> current = head;
        boolean found = false;
        if ((head != null) && data.equals(current.getData())) {
            found = true;
        }
        while ((current.getNext() != null) && (!found)) {
            if (data.equals(current.getNext().getData())) {
                found = true;
                Node<T> temp = current.getNext().getNext();
                Node<T> tempHead = current.getNext();
                tempHead.setNext(head);
                head = tempHead;
                current.setNext(temp);
            } else {
                current = current.getNext();
            }
        }
        if (!found) {
            throw new NoSuchElementException();
        }
    }

    /**
    *This method finds the middle element of the linked list and returns it.
    *@return middle element of the LinkedList
    */
    public T accessMiddle() {
        int mid = 0;
        if (head == null) {
            return null;
        } else {
            if ((size % 2) == 1) {
                mid = size / 2 + 1;
            } else {
                mid = size / 2;
            }
            Node<T> current = head;
            T midData;
            while ((mid - 1) > 0) {
                current = current.getNext();
                mid = mid - 1;
            }
            midData = current.getNext().getData();
            return midData;
        }
    }

    /*public static void main(String[] args) {
        T data1 = new T("Jack", 10);
        T data2 = new T("Joe", 11);
        T data3 = new T("Sam", 12);
        T data4 = new T("Tim", 13);
        LinkedList <T> list = new LinkedList<>();
        list.addAtIndex(data1, 0);
        list.addAtIndex(data2, 1);
        list.addAtIndex(data3, 2);
        list.addAtIndex(data4, 3);
        System.out.println(list);
    }*/
}