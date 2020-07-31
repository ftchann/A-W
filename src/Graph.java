import java.util.ArrayList;

public class Graph {
    public ArrayList<Integer>[] list;
    public Graph(int n){
        list = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<Integer>();
        }
    }
    public void addEdge(int u, int v){
        list[u].add(v);
        list[v].add(u);
    }
}
