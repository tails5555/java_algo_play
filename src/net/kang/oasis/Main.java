package net.kang.oasis;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    static int N;
    static int[] heights;
    static Scanner s = new Scanner(System.in);
    public static void input(){
        N = s.nextInt();
        heights = new int[N];
        for(int k=0;k<N;k++){
            heights[k]=s.nextInt();
        }
    }
    public static int solution(){
        Stack<Integer> s = new Stack<Integer>();
        int count = 0;
        s.push(heights[0]);
        for(int k=1;k<N;k++){
            if(s.peek() > heights[k]){
                s.pop();
                s.push(heights[k]);

            }else{
                s.push(heights[k]);
            }
        }
        return count;
    }
    public static void main(String[] args){
        input();
        System.out.println();
    }
}
