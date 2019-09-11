package lesson_7;

public class Lesson_7_DZ {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Рязань");
        graph.addVertex("Калуга");

        graph.addVertex("Тамбов");
        graph.addVertex("Липецк");
        graph.addVertex("Орел");
        graph.addVertex("Саратов");
        graph.addVertex("Курск");
        graph.addVertex("Воронеж");

        graph.addEdge("Москва", "Тула");
        graph.addEdge("Москва", "Рязань");
        graph.addEdge("Москва", "Калуга");
        graph.addEdge("Тула", "Калуга");
        graph.addEdge("Рязань", "Тамбов");
        graph.addEdge("Липецк", "Орел");
        graph.addEdge("Тамбов", "Воронеж");
        graph.addEdge("Орел", "Курск");
        graph.addEdge("Саратов", "Воронеж");

        String path = graph.findShortestPath("Москва", "Воронеж");
        System.out.println("\n The shortest path: ");
        System.out.println(path);
    }
}
