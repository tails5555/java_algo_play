package net.kang.safe_nawabari;

// BaekJoon 2468번 문제.
import java.util.Scanner;

public class Main {
    static int[][] m;
    static boolean[][] visited;
    static int N;
    static int max;
    static int[] dx={1, 0, -1, 0};
    static int[] dy={0, 1, 0, -1};
    static Scanner s = new Scanner(System.in);
    public static void input(){
        N = s.nextInt();
        m = new int[N][N];
        for(int k=0;k<N;k++){
            for(int l=0;l<N;l++){
                m[k][l]=s.nextInt();
                if(max<m[k][l]) max=m[k][l];
            }
        }
    }
    public static void dfs(int x, int y, int h){
        if(visited[x][y]) return;
        visited[x][y]=true;
        int ax, ay;
        for(int k=0;k<dx.length;k++){
            ax=x+dx[k];
            ay=y+dy[k];
            if((ax>=0 && ax<N) && (ay>=0 && ay<N)){
                if(m[ax][ay]>h && !visited[ax][ay]){
                    dfs(ax, ay, h);
                }
            }
        }
    }
    public static void solution(){
        int cnt, result=1;
        for(int i=1;i<=max;i++){
            cnt=0;
            visited = new boolean[N][N];
            for(int j=0;j<N;j++){
                for(int k=0;k<N;k++){
                    if(m[j][k]>i && !visited[j][k]) {
                        cnt=cnt+1;
                        dfs(j, k, i);
                    }
                }
            }
            if(result < cnt) result=cnt;
        }
        System.out.println(result);
    }
    public static void main(String[] args){
        input();
        solution();
    }
}
