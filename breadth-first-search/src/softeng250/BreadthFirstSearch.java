package softeng250;

import java.util.Arrays;
import java.util.LinkedList;

public class BreadthFirstSearch {
    private LinkedList<Integer>[] _graph;
    public Pair<Integer, Integer>[] _bfsTree;

    BreadthFirstSearch(LinkedList<Integer>[] graph, int startVertex) {
        _graph = graph;

        // count the number of edges so we know the (maximum) size of _bfsTree
        int numberOfEdges = 0;
        for (LinkedList<Integer> vertexEdges : _graph) {
            for (Integer otherVertex : vertexEdges) {
                numberOfEdges++;
            }
        }
        // we counted each edge twice, so divide it by two
        numberOfEdges /= 2;

        // initialise the BFS tree
        // this isn't great code so if you know of a better way please let me know :)
        _bfsTree = (Pair<Integer, Integer>[]) new Pair<?, ?>[numberOfEdges];
        performSearch(startVertex);
    }

    public void performSearch(int startVertex) {
        // the index that we're putting the latest edge into
        int bfsTreeIndex = 0;

        // added[i] is true if the vertex i has been processed
        boolean[] added = new boolean[_graph.length];
        added[startVertex] = true;

        // create a queue of vertices to process, add the starting vertex to it
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(startVertex);

        while (!queue.isEmpty()) {
            int vertex = queue.getFirst();

            // check all the edges of the vertex
            for (int otherVertex :  _graph[vertex]) {
                // check if the other vertex hasn't been processed
                if (!added[otherVertex]) {
                    // add the other vertex to the queue
                    queue.addLast(otherVertex);
                    added[otherVertex] = true;

                    // add the edge to the BFS tree
                    _bfsTree[bfsTreeIndex] = new Pair<>(vertex, otherVertex);
                    bfsTreeIndex++;
                }
            }

            // after all the edges have been visited, remove the vertex from the queue
            //   we could do this in a single call by doing `int vertex = queue.removeFirst();` on line 38
            queue.removeFirst();
        }
    }
}
