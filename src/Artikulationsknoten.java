import java.util.Arrays;

public class Artikulationsknoten {
    boolean[] isArt;
    int[] dfs;
    int[] low;
    Graph graph;
    int num;
    int rootNode;
    int rootNeighbours;
    public Artikulationsknoten(){
        int n = 13;
        num = 0;
        graph = new Graph(n);
        isArt = new boolean[n];
        dfs = new int[n];
        low = new int[n];
        rootNode = 1;
        rootNeighbours = 0;
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(3,4);
        graph.addEdge(4,5);
        graph.addEdge(5,6);
        graph.addEdge(6,7);
        graph.addEdge(7,8);
        graph.addEdge(8,6);
        graph.addEdge(8,4);
        graph.addEdge(2,9);
        graph.addEdge(1,9);
        graph.addEdge(3 , 9);
    }
    public int dfs(int v, int parent){
        num++;
        dfs[v] = num;
        low[v] = num;
        for(int w: graph.list[v]){
            if(dfs[w] == 0){ //unvisited
                if(v == rootNode) rootNeighbours++;
                int val = dfs(w, v);
                if(val >= dfs[v]){
                    isArt[v] = true;
                }
                low[v] = Math.min(low[v], val);
            }
            else if(w != parent){
                low[v] = Math.min(low[v], dfs[w]);
            }
        }
        if(v == rootNode && rootNeighbours > 1) isArt[rootNode] = true;
        else if(v == rootNode) isArt[rootNode] = false;
        return low[v];
    }
    public static void main(String[] args) {

        //Find artikulationsknoten
        Artikulationsknoten art= new Artikulationsknoten();
        art.dfs(1, 0);
        for (int i = 1; i < 13; i++) {
            if(art.isArt[i])
                System.out.println(i);
        }
    }

}
