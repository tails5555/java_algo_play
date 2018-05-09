package net.kang.oasis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static int N;
    static int[] heights;
    // static Scanner s = new Scanner(System.in);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void input() throws IOException {
        /*
        N = s.nextInt();
        heights = new int[N];
        for(int k=0;k<N;k++){
            heights[k]=s.nextInt();
        }
        */
        N = Integer.parseInt(br.readLine());
        heights = new int[N];
        for(int k=0;k<N;k++){
            heights[k]=Integer.parseInt(br.readLine());
        }
    }
    public static long solution(){
        LinkedList<Integer> q = new LinkedList<Integer>();
        long count = 0;
        for(int k = 0; k < N-1; k++){
            q.addLast(heights[k]);
            for(int l = k+1; l<N; l++){
                if(q.peekFirst() >= heights[l]){
                    System.out.println(q);
                    if(k == N-2) count+=1;
                    q.addLast(heights[l]);
                }else{
                    System.out.println("NOT"+q);
                    count += q.size();
                    break;
                }
            }
            q.clear();
        }
        return count;
    }
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solution());
    }
}
