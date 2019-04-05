public class Graph {

    public int n;	//number of vertices
    public int[][] A;	//the adjacency matrix
    private final int WHITE = 2;
    private final int GRAY = 3;
    private final int BLACK = 4;
    int[] color = {0, 0, 0, 0, 0, 0, 0, 0};
    int[] distance = {0, 0, 0, 0, 0, 0, 0, 0};
    int[] parent = {0, 0, 0, 0, 0, 0, 0, 0};
    int[] finish = {0, 0, 0, 0, 0, 0, 0, 0};
    int time;

    public Graph () {
        n = 0;
        A = null;
    }

    public Graph (int _n, int[][] _A) {
        this.n = _n;
        this.A = _A;
    }

    /*
     * Input: s denotes the index of the source node
     * Output: the array dist, where dist[i] is the distance between the i-th node to s
     */
    public int[] bfs (int s) {
        for (int i = 0; i < n; i++) {
            color[i] = WHITE;
            distance[i] = Integer.MAX_VALUE;
        }
        color[s] = GRAY;
        distance[s] = 0;
        Queue queue = new Queue(n);
        queue.enqueue(s);
        while (!queue.isEmpty()) {
            int u = queue.dequeue();
            for (int i = 0; i < n; i++) { // for each node
                if (A[u][i] > 0) { // that adjacent
                    if (color[i] == WHITE) {
                        color[i] = GRAY;
                        distance[i] = distance[u] + 1;
                        queue.enqueue(i);
                    }
                }
            }
            color[u] = BLACK;
        }
        return distance;

    }

    public void print_array (int[] array) {
        for (int i = 0; i < array.length; i++)
            System.out.println(i + ": " + array[i]);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int n = 8;
        int[][] A =
                       {{0, 1, 0, 0, 1, 0, 0, 0},
                        {1, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 1, 0, 1, 1, 0},
                        {0, 0, 1, 0, 0, 0, 1, 1},
                        {1, 0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 1, 0, 0, 0, 1, 0},
                        {0, 0, 1, 1, 0, 1, 0, 1},
                        {0, 0, 0, 1, 0, 0, 1, 0}};
        Graph g = new Graph(n, A);
        g.print_array(g.bfs(1));
    }

}
