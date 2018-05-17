package net.kang.acm_craft;
import java.util.LinkedList;
import java.util.Scanner;

// Backjoon 1005번 문제
public class Main {
    static Scanner s = new Scanner(System.in);
    public static int[] topological(boolean[][] edges, int[] times, int[] indegrees){
        LinkedList<Integer> q = new LinkedList<>();
        int[] result = new int[indegrees.length];
        for(int k=1;k<indegrees.length;k++){
            if(indegrees[k] == 0){
                result[k] = times[k];
                q.add(k);
            }
        }
        while(!q.isEmpty()){
            int current = q.removeFirst();
            for(int k=1;k<indegrees.length;k++){
                if(edges[current][k]){
                    result[k] = Math.max(result[k], result[current] + times[k]);
                    if(--indegrees[k] == 0) q.add(k);
                }
            }
        }
        return result;
    }
    public static int solve(){
        int V = s.nextInt(); // 정점 수
        int E = s.nextInt(); // 간선 수
        int[] times = new int[V+1];
        int[] indegrees = new int[V+1];
        boolean[][] edges = new boolean[V+1][V+1];
        for(int k=1;k<=V;k++){
            times[k] = s.nextInt();
        }
        for(int k=0;k<E;k++){
            int v1 = s.nextInt();
            int v2 = s.nextInt();
            indegrees[v2] = indegrees[v2] + 1;
            edges[v1][v2]=true;
        }
        int W = s.nextInt();
        int[] result = topological(edges, times, indegrees);
        return result[W];
    }
    public static void main(String[] args){
        int T = s.nextInt();
        int[] res = new int[T];
        for(int k=0;k<T;k++) {
            res[k]=solve();
        }
        for(int i : res){
            System.out.println(i);
        }
    }
}
