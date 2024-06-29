import java.util.*;

public class AncestorsOfGraphNodes {

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        // Initialize the adjacency list for the graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // Populate the adjacency list with edges
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }
        
        // List to store the ancestors of each node
        List<Set<Integer>> ancestors = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ancestors.add(new HashSet<>());
        }
        
        // DFS for each node to find its ancestors
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            findAncestors(i, i, graph, ancestors, visited);
        }
        
        // Convert the set of ancestors to a sorted list
        List<List<Integer>> result = new ArrayList<>();
        for (Set<Integer> set : ancestors) {
            List<Integer> list = new ArrayList<>(set);
            Collections.sort(list);
            result.add(list);
        }
        
        return result;
    }

    // DFS function to find all ancestors of a node
    private void findAncestors(int start, int current, List<List<Integer>> graph, List<Set<Integer>> ancestors, boolean[] visited) {
        for (int neighbor : graph.get(current)) {
            if (!visited[neighbor]) {
                visited[neighbor] = true;
                ancestors.get(neighbor).add(start);
                findAncestors(start, neighbor, graph, ancestors, visited);
            }
        }
    }

    public static void main(String[] args) {
        AncestorsOfGraphNodes solution = new AncestorsOfGraphNodes();
        int n = 8;
        int[][] edges = {
            {0, 3}, {0, 4}, {1, 3}, {2, 4}, {2, 7}, {3, 5}, {3, 6}, {3, 7}, {4, 6}
        };
        List<List<Integer>> result = solution.getAncestors(n, edges);
        System.out.println(result);
    }
}
