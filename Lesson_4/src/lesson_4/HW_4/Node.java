package lesson_4.HW_4;

public class Node {

    private final Person data;
    private Node nextNode;

    public Node(Person data) {
        this.data = data;
    }

    public Person getData() {
        return data;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
