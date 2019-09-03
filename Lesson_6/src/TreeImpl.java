import java.util.Stack;

public class TreeImpl implements Tree {

    private Node root;
    private int maxLevel;

    public TreeImpl(int maxLevel) {
        this.maxLevel = maxLevel;
    }

    @Override
    public void insert(Person value) {
        int key = value.getId();
        Node node = new Node(value);

        if (root == null) {
            root = node;
        } else {
            Node current = root;
            Node parent = current;
            int level = 1;
            do {
                level++;
                parent = current;
                if (key < current.getKey()) {
                    current = current.getLeftChild();
                } else {
                    current = current.getRightChild();
                }
            } while (current != null);

            if (level > maxLevel)
                return;

            if (key < parent.getKey()) {
                parent.setLeftChild(node);
            } else {
                parent.setRightChild(node);
            }
        }
    }

    @Override
    public boolean remove(Person value) {
        return remove(value.getId());
    }

    @Override
    public boolean remove(int key) {
        Node current = root;
        Node parent = root;

        while (current != null && current.getKey() != key) {
            parent = current;
            if (key < current.getKey()) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }
        }

        if (current == null) {
            return false;
        }

        if (current.getLeftChild() == null && current.getRightChild() == null) {
            if (current == root) {
                root = null;
            } else if (parent.isLeftChild(current)) {
                parent.setLeftChild(null);
            } else {
                parent.setRightChild(null);
            }
        } else if (current.getLeftChild() == null || current.getRightChild() == null) {
            Node child;
            if (current.getLeftChild() == null) {
                child = current.getRightChild();
                current.setRightChild(null);
            } else {
                child = current.getLeftChild();
                current.setLeftChild(null);
            }
            if (parent.isLeftChild(current)) {
                parent.setLeftChild(child);
            } else {
                parent.setRightChild(child);
            }
        } else {
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (parent.isLeftChild(current)) {
                parent.setLeftChild(successor);
            } else {
                parent.setRightChild(successor);
            }

            successor.setLeftChild(current.getLeftChild());
        }

        return true;
    }

    private Node getSuccessor(Node node) {
        Node current = node.getRightChild();
        Node successorParent = node;
        Node successor = node;

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeftChild();
        }

        if (successor == node.getRightChild()) {
            return successor;
        } else {
            successorParent.setLeftChild(successor.getRightChild());
            successor.setRightChild(node.getRightChild());
            return successor;
        }
    }

    @Override
    public Person find(int key) {
        Node current = root;
        while (current != null && current.getKey() != key) {
            if (key < current.getKey()) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }
        }

        return current != null ? current.getData() : null;
    }

    @Override
    public void displayTree() {
        Stack<Node> globalStack = new Stack();
        globalStack.push(root);
        int nBlanks = 64;

        boolean isRowEmpty = false;
        System.out.println("................................................................");

        while (!isRowEmpty) {
            Stack<Node> localStack = new Stack<>();

            isRowEmpty = true;
            for (int i = 0; i < nBlanks; i++) {
                System.out.print(" ");
            }

            while (!globalStack.isEmpty()) {
                Node tempNode = globalStack.pop();
                if (tempNode != null) {
                    System.out.print(tempNode.getKey());
                    localStack.push(tempNode.getLeftChild());
                    localStack.push(tempNode.getRightChild());
                    if (tempNode.getLeftChild() != null || tempNode.getRightChild() != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++) {
                    System.out.print(" ");
                }
            }

            System.out.println();

            while (!localStack.isEmpty()) {
                globalStack.push(localStack.pop());
            }

            nBlanks /= 2;
        }
        System.out.println("................................................................");
    }

    @Override
    public void traverse(TraverseType type) {
        switch (type) {
            case PRE_ORDER:
                preOrder(root);
                break;
            case POST_ORDER:
                postOrder(root);
                break;
            case IN_ORDER:
                inOrder(root);
                break;
            default:
                throw new IllegalArgumentException("Unknown type of traverse: " + type);
        }
    }

    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.getLeftChild());
            node.display();
            inOrder(node.getRightChild());
        }
    }

    private void postOrder(Node node) {
        if (node != null) {
            inOrder(node.getLeftChild());
            inOrder(node.getRightChild());
            node.display();
        }
    }

    private void preOrder(Node node) {
        if (node != null) {
            node.display();
            inOrder(node.getLeftChild());
            inOrder(node.getRightChild());
        }
    }

    @Override
    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        return (node == null) ||
                isBalanced(node.getLeftChild()) &&
                        isBalanced(node.getRightChild()) &&
                        Math.abs(height(node.getLeftChild()) - height(node.getRightChild())) <= 1;
    }

    private int height(Node node) {
        return node == null ? 0 : 1 + Math.max(height(node.getLeftChild()), height(node.getRightChild()));
    }
}
