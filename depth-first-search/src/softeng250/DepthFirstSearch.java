package softeng250;

import java.util.LinkedList;

public class DepthFirstSearch {
    private LinkedList<Integer>[] _graph;
    private boolean[] _explored;
    public Pair<Integer, Integer>[] _bfsTree;
    private int _bfsTreeIndex;

    DepthFirstSearch(LinkedList<Integer>[] graph, int startVertex) {
        _graph = graph;

        // _explored[i] is true if the vertex has been fully explored
        _explored = new boolean[_graph.length];

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
        performSearchRecursively(startVertex);
    }

    public void performSearchRecursively(int vertex) {
        _explored[vertex] = true;

        // check all the edges of the vertex
        for (int otherVertex : _graph[vertex]) {
            // check if the other vertex hasn't been processed
            if (!_explored[otherVertex]) {
                // add the edge to the BFS tree
                _bfsTree[_bfsTreeIndex] = new Pair<>(vertex, otherVertex);
                _bfsTreeIndex++;

                performSearchRecursively(otherVertex);
            }
        }
    }
}
