package net.kang.line_number;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

// 백준 2667번 문제 풀이
public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static int N;
    static class Pos{
        int x;
        int y;
        public Pos(int x, int y){
            this.x=x;
            this.y=y;
        }
    }

    public static boolean isInside(int x, int y){
        return (x>=0 && x<N) && (y>=0 && y<N);
    }

    public static int dfs(int x, int y){
        visited[x][y] = true;
        int result = 1;
        Stack<Pos> stack = new Stack<Pos>();
        stack.push(new Pos(x, y));
        while(!stack.isEmpty()){
            Pos pos = stack.pop();
            map[pos.x][pos.y]=0;
            for(int k=0;k<4;k++){
                int mx = pos.x+dx[k];
                int my = pos.y+dy[k];
                if(isInside(mx, my)){
                    if(map[mx][my] == 1 && !visited[mx][my]){
                        visited[mx][my]=true;
                        stack.push(new Pos(mx, my));
                        result++;
                    }
                }
            }
        }
        return result;
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        N = s.nextInt();
        map = new int[N][N];
        visited = new boolean[N][N];
        for(int k=0;k<N;k++){
            String tmp = s.next();
            int l=0;
            for(char c : tmp.toCharArray()){
                map[k][l++]=c-'0';
            }
        }
        List<Integer> list = new ArrayList<Integer>();
        for(int k=0;k<N;k++){
            for(int l=0;l<N;l++){
                if(map[k][l] == 1){
                    list.add(dfs(k, l));
                }
            }
        }
        System.out.println(list.size());
        list.sort((a, b) -> {
            return a.intValue() - b.intValue();
        });
        for(int i : list){
            System.out.println(i);
        }
    }
}
