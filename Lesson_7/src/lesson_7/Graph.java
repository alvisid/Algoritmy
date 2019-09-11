package lesson_7;

import java.util.*;

public class Graph {

    private final int MAX_VERTS = 32;

    private Vertex[] vertexList;
    private int[][] adjMat;
    private int size;

    public Graph() {
        this.vertexList = new Vertex[MAX_VERTS];
        this.size = 0;

        adjMat = new int[MAX_VERTS][MAX_VERTS];
        initAdjMat();
    }

    public void addVertex(String label) {
        this.vertexList[size++] = new Vertex(label);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void addEdge(String startLabel, String endLabel) {
        addEdge(getVertexPosition(startLabel), getVertexPosition(endLabel));
    }

    public int getSize() {
        return size;
    }

    public void displayVertex(int vertex) {
        displayVertex(vertexList[vertex]);
    }

    public void displayVertex(Vertex vertex) {
        System.out.println(vertex + " ");
    }

    private void initAdjMat() {
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = 0;
            }
        }
    }

    public void bfs(String vertexLabel) {
        bfs(vertexLabel, null);
    }

    private Vertex bfs(String vertexLabel, String finishVertexLabel) {
        Queue<Vertex> queue = new LinkedList<>();

        int startIndex = getVertexPosition(vertexLabel);
        Vertex vertex = vertexList[startIndex];

        visit(vertex);
        queue.add(vertex);

        while (!queue.isEmpty()) {
            vertex = queue.remove();

            if (finishVertexLabel != null && vertex.getLabel().equals(finishVertexLabel)) {
                return vertex;
            }

            Vertex v = getAdjUnvisitedVertex(vertex);
            while (v != null) {
                visit(v);
                queue.add(v);
                v.setPreviousVertex(vertex);
                v = getAdjUnvisitedVertex(vertex);
            }
        }
        resetVertexState();

        return null;
    }

    public void dfs(String vertexLabel) {
        Stack<Vertex> stack = new Stack();

        int startIndex = getVertexPosition(vertexLabel);

        Vertex currentVertex = vertexList[startIndex];
        visit(currentVertex);
        stack.push(currentVertex);

        while (!stack.isEmpty()) {
            Vertex v = getAdjUnvisitedVertex(stack.peek());
            if (v != null) {
                visit(v);
                stack.push(v);
            } else {
                stack.pop();
            }
        }
        resetVertexState();
    }

    private Vertex getAdjUnvisitedVertex(Vertex currentVertex) {
        int index = getVertexPosition(currentVertex);

        if (index == -1) {
            throw new IllegalStateException("Failed to found vertex " + currentVertex);
        }

        for (int i = 0; i < size; i++) {
            if (adjMat[index][i] == 1 && !vertexList[i].isWasVisited()) {
                return vertexList[i];
            }
        }
        return null;
    }

    private int getVertexPosition(Vertex currentVertex) {
        return getVertexPosition(currentVertex.getLabel());
    }

    private int getVertexPosition(String vertexLabel) {
        for (int i = 0; i < size; i++) {
            if (vertexList[i].getLabel().equals(vertexLabel)) {
                return i;
            }
        }
        return -1;
    }

    private void resetVertexState() {
        for (int i = 0; i < size; i++) {
            vertexList[i].setWasVisited(false);
        }
    }

    private void visit(Vertex currentVertex) {
        displayVertex(currentVertex);
        currentVertex.setWasVisited(true);
    }

    public String findShortestPath(String startLabel, String finishLabel) {
        Vertex targetVertex = bfs(startLabel, finishLabel);
        List<String> labels = new ArrayList<>();

        Vertex currentVertex = targetVertex;
        while (currentVertex != null) {
            labels.add(currentVertex.getLabel());
            currentVertex = currentVertex.getPreviousVertex();
        }
        Collections.reverse(labels);

        return String.join(" -> ", labels);
    }
}
