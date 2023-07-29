package 图_Kruskal;

public class UnionFind {
    int n;
    int[] parent;
    int[] size;

    public UnionFind(int n){
        this.n = n;
        this.parent = new int[n];
        this.size = new int[n];

        for (int i = 0; i < n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int x){
        while (parent[x] != x){
            parent[x] = parent[parent[x]];
            x = parent[x];
        }

        return x;
    }

    public void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY){
            return;
        }

        // 小树接到大树
        if (size[rootX] > size[rootY]){
            parent[rootY] = rootX;
            size[rootX] += size[rootY];
        }else{
            parent[rootX] = rootY;
            size[rootY] += size[rootX];
        }

        n--;
    }

    public boolean isConnected(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        return rootX == rootY;
    }

    // 连通分量个数
    public int getCount(){
        return n;
    }
}
