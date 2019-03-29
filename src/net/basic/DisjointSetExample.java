package net.basic;

// 서로소 집합(Disjoint Set) 자료구조
class DisjointSet {
    private int[] parent;
    private int[] c_cnt;

    public DisjointSet(int size){
        this.parent = new int[size + 1];
        this.c_cnt = new int[size + 1];
        for(int k = 0; k <= size; k++){
            this.parent[k] = k; // 단일 집합으로 지정. (0), (1), (2), (3)...
        }
    }

    public int find(int child){
        if(parent[child] == child) return child;
        return parent[child] = find(parent[child]);
    }

    public void merge(int a, int b){
        a = find(a);
        b = find(b);
        if (a == b) return;
        if (c_cnt[a] > c_cnt[b]) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        parent[b] = a;
        if(c_cnt[a] == c_cnt[b]) c_cnt[b]++;
    }
}

public class DisjointSetExample {
    public static void main(String[] args){
        DisjointSet d_set = new DisjointSet(40);

        // 집합 여부 확인
        for(int k = 0; k < 20; k++){
            int a = (k % 10) * 2 + 1;
            int b = (k % 10) * 2 + 2;
            if(k < 10) {
                System.out.printf("%d %d Union\n", a, b);
                d_set.merge(a, b);
            } else {
                System.out.printf("%d AND %d Set Testing\n", a, b);
                if(d_set.find(a) == d_set.find(b)){
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}
