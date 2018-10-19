package net.baekjoon.bfsdfs;
import java.util.Scanner;

// Baekjoon 1987번 알파벳 문제 풀이
public class Main1987 {
    static char[][] map;
    static int result=1;
    static int count=1;
    static int[] dx={0, 1, 0, -1};
    static int[] dy={1, 0, -1, 0};
    static Scanner s=new Scanner(System.in);
    static int R, C;
    // 초기 문제에 대해 입력을 받는다.
    public static void input(){
        R = s.nextInt();
        if(R<1 && R>20) return;
        C = s.nextInt();
        if(C<1 && C>20) return;
        map = new char[R][C];
        for(int k=0;k<R;k++){
            String tmp = s.next();
            if(tmp.length() == C){
                map[k] = tmp.toCharArray();
            }
        }
    }
    public static void dfs(int x, int y, boolean[] visited){
        // 첫 알파벳에 대해서는 방문처리를 한다.
        visited[map[x][y]-'A']=true;
        // 각 4방향으로 왔다리 갔다리 한다.
        for(int k=0;k<dx.length;k++){
            int mx=x+dx[k];
            int my=y+dy[k];
            if((mx>=0 && mx<R) && (my>=0 && my<C)){
                // 다음 알파벳에 대해서 비교를 해서 방문을 안 한 경우에는
                if(!visited[map[mx][my]-'A']){
                    // 처음의 result의 수치와 count를 1씩 더한 수치를 비교한다.
                    result = Math.max(result, ++count);
                    dfs(mx, my, visited);
                }
            }
        }
        // 백트래킹에서 가장 중요한 것은 최대값을 알아보고 난 뒤에 초기화를 하는 것이다.
        visited[map[x][y]-'A']=false;
        --count;
    }
    public static void main(String[] args){
        input();
        boolean[] visited=new boolean[26];
        dfs(0, 0, visited);
        System.out.println(result);
    }
}
