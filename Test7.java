package lesson7;

public class Test7 {

    public static void main(String[] args) {
    Graph graph = new GraphImpl(10);
    testGraph(graph);
    testDfs(graph);
    }

    private static void testGraph(Graph graph) {

        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Липецк");
        graph.addVertex("Воронеж");
        graph.addVertex("Ступино");
        graph.addVertex("Ефремов");
        graph.addVertex("Елец");
        graph.addVertex("Рязань");
        graph.addVertex("Тамбов");
        graph.addVertex("Саратов");


        graph.addEdge(5, "Москва", "Тула");
        graph.addEdge(4, "Тула", "Липецк");
        graph.addEdge(6, "Липецк", "Воронеж");
        graph.addEdge(3, "Москва", "Ступино");
        graph.addEdge(2, "Ступино", "Ефремов");
        graph.addEdge(1, "Ефремов", "Елец");
        graph.addEdge(6, "Елец", "Воронеж");
        graph.addEdge(3, "Москва", "Рязань");
        graph.addEdge(2, "Рязань", "Тамбов");
        graph.addEdge(4, "Тамбов", "Саратов");
        graph.addEdge(4, "Саратов", "Воронеж");

        System.out.println("Size of graph is " + graph.getSize());
        graph.display();
    }

    private static void testDfs(Graph graph) {
        graph.dfs("Москва");
    }

}
