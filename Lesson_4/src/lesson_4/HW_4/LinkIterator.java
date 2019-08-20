package lesson_4.HW_4;

import java.util.Iterator;

public class LinkIterator implements Iterator<Node> {

    private LinkedListImpl linkedList;
    private Node current;
    private boolean firstIterate = true;

    public LinkIterator(LinkedListImpl linkedList, Node current) {
        this.linkedList = linkedList;
        this.current = current;
    }

    @Override
    public boolean hasNext() {
        return firstIterate || current.getNextNode() != null;
    }

    @Override
    public Node next() {
        if (firstIterate) {
            firstIterate = false;
            current = linkedList.firstElement;
            return current;
        } else {
            return current = current.getNextNode();
        }
    }

    @Override
    public void remove() {
        linkedList.delete(current.getData());
    }
}
