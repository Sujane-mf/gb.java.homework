package lesson7;

import java.util.Stack;

public interface Graph {

    void addVertex(String label);

    boolean addEdge(int weight, String startLabel, String secondLabel, String... others);

    int getSize();

    void display();

    /**
     * англ. Depth-first search, DFS
     */
    void dfs(String startLabel);

    /**
     * англ. breadth-first search, BFS
     */
    void bfs(String startLabel);

//    Stack<String> findShortPathViaBfs(String startLabel, String finishLabel);

}
