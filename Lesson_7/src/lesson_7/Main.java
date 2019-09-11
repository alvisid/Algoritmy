package lesson_7;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("A", "D");

        graph.addEdge("B", "E");
        graph.addEdge("B", "F");
        graph.addEdge("B", "G");

        System.out.println("DFS: ");
        graph.dfs("A");

        System.out.println("");
        System.out.println("-----------------");
        System.out.println("BFS");
        graph.bfs("A");

    }
}
