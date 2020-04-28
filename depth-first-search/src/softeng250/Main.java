package softeng250;

import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        String[] vertices = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};

        // this only needs to be a singly-linked list, but we're using a doubly-linked list because I couldn't find
        //   a singly-linked list. Also this initialisation looks horrible, let me know if you find a better way :)
        LinkedList<Integer>[] graph = (LinkedList<Integer>[]) new LinkedList<?>[vertices.length];
        graph[0] = new LinkedList<>(Arrays.asList(1, 2, 3));
        graph[1] = new LinkedList<>(Arrays.asList(0, 4, 5));
        graph[2] = new LinkedList<>(Arrays.asList(0, 3, 5, 6));
        graph[3] = new LinkedList<>(Arrays.asList(0, 2, 7));
        graph[4] = new LinkedList<>(Arrays.asList(1));
        graph[5] = new LinkedList<>(Arrays.asList(1, 2));
        graph[6] = new LinkedList<>(Arrays.asList(2, 7, 8, 9));
        graph[7] = new LinkedList<>(Arrays.asList(3, 6));
        graph[8] = new LinkedList<>(Arrays.asList(6));
        graph[9] = new LinkedList<>(Arrays.asList(6));

        int startVertex = 3;
        if (startVertex < graph.length) {
            DepthFirstSearch depthFirstSearch = new DepthFirstSearch(graph, startVertex);

            System.out.println("The DFS Tree of the vertex " + vertices[startVertex] + " is:");
            for (Pair<Integer, Integer> edge : depthFirstSearch._bfsTree) {
                // check if we've reached the end of the tree
                if (edge == null) {
                    break;
                }

                // print the edge
                String left = vertices[edge.getLeft()];
                String right = vertices[edge.getRight()];
                System.out.println("(" + left + ", " + right + ")");
            }
        }
    }
}
