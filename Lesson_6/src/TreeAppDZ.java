import java.util.Random;

public class TreeAppDZ {

    public static void main(String[] args) {
//        Tree theTree = new TreeImpl(6);

        Random rand = new Random();
        int treeCount = 20;
        int maxLevel = 4;
        int nodeCount = (int) (Math.pow(2, maxLevel) - 1);

        int maxValue = 100;

        int balancedTreeCount = 0;

        boolean treeView = false;

        for (int i = 0; i < treeCount; i++) {
            Tree theTree = new TreeImpl(maxLevel);
            initTree(rand, nodeCount, maxValue, theTree);
            if (theTree.isBalanced()) {
                balancedTreeCount++;
                if (!treeView) {
                    treeView = true;
                    theTree.displayTree();
                }
            }
        }

        System.out.println("Balanced Tree Count = " + ((balancedTreeCount / (treeCount * 1.0)) * 100) + "%");
//
//        theTree.insert(new Person("Oleg", 25, 60));
//        theTree.insert(new Person("Oleg", 25, 25));
//        theTree.insert(new Person("Oleg", 25, 66));
//        theTree.insert(new Person("Oleg", 25, 15));
//        theTree.insert(new Person("Oleg", 25, 45));
//        theTree.insert(new Person("Oleg", 25, 5));
//        theTree.insert(new Person("Oleg", 25, 20));
//        theTree.insert(new Person("Oleg", 25, 30));
//        theTree.insert(new Person("Oleg", 25, 55));

//        theTree.displayTree();
    }

    private static void initTree(Random rand, int nodeCount, int maxValue, Tree theTree) {
        for (int j = 0; j < nodeCount; j++) {
            theTree.insert(new Person("Oleg", 25, rand.nextInt(maxValue * 2 + 1) - maxValue));
        }
    }
}
