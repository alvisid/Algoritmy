package lesson_4.HW_4;

import java.util.Iterator;

public class LinkedListImpl implements LinkedList {

    protected Node firstElement;
    protected int currentSize;

    public LinkedListImpl() {
        this.firstElement = null;
    }

    @Override
    public Person getFirst() {
        return firstElement.getData();
    }

    @Override
    public void insert(Person data) {
        Node newNode = new Node(data);
        newNode.setNextNode(firstElement);
        firstElement = newNode;
        currentSize++;
    }

    @Override
    public Person delete() {
        Node value = firstElement;
        boolean deleted = delete(value.getData());
        return deleted ? value.getData() : null;
    }

    @Override
    public boolean delete(Person value) {
        Node currentNode = firstElement;
        Node previousNode = firstElement;

        while (currentNode != null) {
            if (currentNode.getData().equals(value)) {
                if (currentNode == firstElement) {
                    firstElement = firstElement.getNextNode();
                } else {
                    previousNode.setNextNode(currentNode.getNextNode());
                }
                currentSize--;
                return true;
            }
            previousNode = currentNode;
            currentNode = currentNode.getNextNode();
        }

        return false;
    }

    @Override
    public void display() {
        Node tempNode = firstElement;
        while (tempNode != null) {
            System.out.println(tempNode);
            tempNode = tempNode.getNextNode();
        }
    }

    @Override
    public boolean isEmpty() {
        return firstElement == null;
    }

    @Override
    public boolean contains(Person value) {
        return find(value) != null;
    }

    private Node find(Person value) {
        Node tempNode = firstElement;
        while (tempNode != null) {
            if (tempNode.getData().equals(value)) {
                return tempNode;
            }
            tempNode = tempNode.getNextNode();
        }

        return null;
    }

    @Override
    public int getSize() {
        return currentSize;
    }

    @Override
    public Iterator<Person> iterator() {
        return new ExListIterator(this);
    }
}
