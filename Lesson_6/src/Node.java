public class Node {

    private final Person data;
    private Node leftChild;
    private Node rightChild;

    public Node(Person data) {
        this.data = data;
    }

    public Person getData() {
        return data;
    }

    public int getKey() {
        return data.getId();
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public void display() {
        System.out.println(getKey());
    }

    public boolean isLeftChild(Node node) {
        if (node == null || leftChild == null)
            return false;
        else
            return leftChild.getData().equals(node.getData());
    }

    public boolean isRightChild(Node node) {
        if (node == null || rightChild == null)
            return false;
        else
            return rightChild.getData().equals(node.getData());
    }
}