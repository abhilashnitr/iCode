package main.FAANG.GraphUtils;

import java.util.*;

public class EvaluateDivision {
    /*
You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.
You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.
Return the answers to all queries. If a single answer cannot be determined, return -1.0.
Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.
    */

    /*
    Please note that during DFS,
Rejection case should be checked before accepting case.
Accepting case is (graph.get(u).containsKey(v)) rather than (u.equals(v)) for it takes O(1) but (u.equals(v)) takes O(n) for n is the length of the longer one between u and v.
    */

    public static void main(String[] args) {
        String[][] equations={{"a","b"},{"b","c"}};
        double[] values={2.0,3.0};
        String[][] queries={{"a","c"},{"b","a"}};

        EvaluateDivision evaluateDivision = new EvaluateDivision();
        System.out.println(evaluateDivision.calcEquation(equations,values,queries));
    }
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {

        /* Build graph. */
        Map<String, Map<String, Double>> graph = buildGraph(equations, values);
        double[] result = new double[queries.length];

        for (int i = 0; i < queries.length; i++) {
            result[i] = getPathWeight(queries[i][0], queries[i][1], new HashSet<>(), graph);
        }

        return result;
    }

    private double getPathWeight(String start, String end, Set<String> visited, Map<String, Map<String, Double>> graph) {

        /* Rejection case. */
        if (!graph.containsKey(start))
            return -1.0;

        /* Accepting case. */
        if (graph.get(start).containsKey(end))
            return graph.get(start).get(end);

        visited.add(start);
        for (Map.Entry<String, Double> neighbour : graph.get(start).entrySet()) {
            if (!visited.contains(neighbour.getKey())) {
                double productWeight = getPathWeight(neighbour.getKey(), end, visited, graph);
                if (productWeight != -1.0)
                    return neighbour.getValue() * productWeight;
            }
        }

        return -1.0;
    }

    private Map<String, Map<String, Double>> buildGraph(String[][] equations, double[] values) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        String u, v;

        for (int i = 0; i < equations.length; i++) {
            u = equations[i][0];
            v = equations[i][1];
            graph.putIfAbsent(u, new HashMap<>());
            graph.get(u).put(v, values[i]);
            graph.putIfAbsent(v, new HashMap<>());
            graph.get(v).put(u, 1 / values[i]);
        }

        return graph;
    }
}
