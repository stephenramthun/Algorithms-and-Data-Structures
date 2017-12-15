package com.stephenramthun.algorithms.graph;

import com.stephenramthun.datastructures.Graph;
import com.stephenramthun.datastructures.Vertex;
import com.stephenramthun.datastructures.PriorityQueue;

import java.util.HashSet;
import java.util.Map;

public class Dijkstra {

    @SuppressWarnings("unchecked")
    public static boolean run(Graph graph, Vertex source) {
        if (!graph.isDirected() || !graph.isWeighted()) {
            return false;
        }

        PriorityQueue<Vertex> queue = new PriorityQueue<>();
        HashSet<Vertex> inQueue = new HashSet<>();

        for (Object o : graph.getVertices()) {
            Vertex v = (Vertex)o;
            v.setDistance(Double.MAX_VALUE);
            v.setPrevious(null);
        }

        source.setDistance(0);
        queue.add(source);
        inQueue.add(source);

        while (!queue.isEmpty()) {
            Vertex v = queue.poll();

            Map map = v.getEdges();

            for (Object o : map.entrySet()) {
                Map.Entry<Vertex, Double> edge = (Map.Entry<Vertex, Double>)o;
                Vertex vertex = edge.getKey();
                double weight = edge.getValue();

                double distance = v.getDistance() + weight;

                if (distance < vertex.getDistance()) {
                    vertex.setDistance(distance);
                    vertex.setPrevious(v);
                    // If vertex not in queue, add to queue
                    if (!inQueue.contains(vertex)) {
                        queue.add(vertex);
                        inQueue.add(vertex);
                    }
                }
            }
        }

        return true;
    }
}
