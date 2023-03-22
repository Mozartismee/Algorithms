public class UnionFind {
    private int[] parent;  // 存储节点的父节点
    private int[] size;  // 存储连通分量的大小
    private int count;  // 连通分量的数量

    // 初始化并查集
    public UnionFind(int n) {
        count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    // 查找节点所在连通分量的根节点
    public int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];  // 路径压缩
            p = parent[p];
        }
        return p;
    }

    // 判断两个节点是否连通
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    // 将两个节点所在的连通分量合并为一个
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;

        // 加权并查集：将小规模的树连接到大规模的树上
        if (size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        } else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
        count--;
    }

    // 返回连通分量的数量
    public int count() {
        return count;
    }
}
![case I](image/截圖 2023-03-22 下午1.35.07.png)
