package lesson_4.HW_4;

import java.util.Iterator;

public class ExListIterator implements Iterator<Person> {

    private Node current;
    private Node previous;
    private LinkedListImpl list;

    public ExListIterator(LinkedListImpl list) {
        this.list = list;
        this.reset();
    }

    public void reset() {
        current = null;
        previous = null;
    }

    public boolean atEnd() {
        if (current == null) {
            return list.isEmpty();
        } else {
            return current.getNextNode() == null;
        }
    }

    public void nextNode() {
        previous = current;
        if (current == null) {
            current = list.firstElement;
        } else {
            current = current.getNextNode();
        }
    }

    public Node getCurrent() {
        return current;
    }

    public void insertAfter(Person person) {
        Node newNode = new Node(person);
        if (list.isEmpty()) {
            list.firstElement = newNode;
            current = newNode;
        } else {
            newNode.setNextNode(current.getNextNode());
            current.setNextNode(newNode);
            nextNode();
        }
    }

    public void insertBefore(Person person) {
        Node newNode = new Node(person);
        if (previous == null) {
            newNode.setNextNode(list.firstElement);
            list.firstElement = newNode;
            reset();
        } else {
            newNode.setNextNode(previous.getNextNode());
            previous.setNextNode(newNode);
            current = newNode;
        }
    }

    public String deleteCurrent() {
        String name = current.getData().getName();
        if (previous == null) {
            list.firstElement = current.getNextNode();
            reset();
        } else {
            previous.setNextNode(current.getNextNode());
            if (atEnd())
                reset();
            else
                current = current.getNextNode();
        }
        return name;
    }

    @Override
    public boolean hasNext() {
        return !atEnd();
    }

    @Override
    public Person next() {
        nextNode();
        return getCurrent().getData();
    }

    @Override
    public void remove() {
        deleteCurrent();
    }
}
