public interface Tree {

    void insert(Person value);

    boolean remove(Person value);

    boolean remove(int key);

    Person find(int key);

    void displayTree();

    public void traverse(TraverseType type);

    boolean isBalanced();
}
