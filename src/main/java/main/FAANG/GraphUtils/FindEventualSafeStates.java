package main.FAANG.GraphUtils;

import java.util.ArrayList;
import java.util.List;

/*
We start at some node in a directed graph, and every turn, we walk along a directed edge of the graph. If we reach a
terminal node (that is, it has no outgoing directed edges), we stop.
We define a starting node to be safe if we must eventually walk to a terminal node. More specifically, there is a natural
number k, so that we must have stopped at a terminal node in less than k steps for any choice of where to walk.

Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.

The directed graph has n nodes with labels from 0 to n - 1, where n is the length of graph. The graph is given in the
following form: graph[i] is a list of labels j such that (i, j) is a directed edge of the graph, going from node i to node j.

*/
public class FindEventualSafeStates {


    public static void main(String[] args) {
        FindEventualSafeStates main = new FindEventualSafeStates();
        int[][] graph={{1,2},{2,3},{5},{0},{5},{},{}};
        System.out.println(main.eventualSafeNodes(graph));
    }
    enum State {
        SAFE,
        UNSAFE
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> safeNodes = new ArrayList<>(graph.length);
        State[] states = new State[graph.length];
        for (int node = 0; node < graph.length; node++) {
            if (isSafe(graph, node, states)) {
                safeNodes.add(node);
            }
        }
        return safeNodes;
    }

    private boolean isSafe(int[][] graph, int node, State[] states) {
        if (states[node] != null) {
            return states[node] == State.SAFE;
        }

        states[node] = State.UNSAFE;

        for (int next : graph[node]) {
            if (!isSafe(graph, next, states)) return false;
        }

        states[node] = State.SAFE;
        return true;
    }
    //Simillar to FInd Cycle
}
