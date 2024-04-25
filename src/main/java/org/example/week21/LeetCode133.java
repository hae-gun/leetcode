package org.example.week21;

public class LeetCode133 {
    public Node cloneGraph(Node node) {
        Node[] graph = new Node[101];
        if (node == null) {
            return null;
        } else if (node.neighbors == null) {
            return new Node(1);
        }
        return clone(node, graph);
    }
    private Node clone(Node target, Node[] graph) {
        int v = target.val;

        if (graph[v] == null) {
            graph[v] = new Node(v);

            for (Node neighbor : target.neighbors) {
                Node clone = clone(neighbor, graph);
                graph[v].neighbors.add(clone);
            }
        }

        return graph[v];
    }
}
