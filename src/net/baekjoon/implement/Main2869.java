package net.baekjoon.implement;

// 백준 2869번 문제 풀이 완료
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.valueOf(st.nextToken());
        int B = Integer.valueOf(st.nextToken());
        int V = Integer.valueOf(st.nextToken());
        int tmpHeight = 0;
        int date = 1;
        while(tmpHeight < V){
            tmpHeight += A;
            if(tmpHeight >= V) break;
            date++;
            tmpHeight -= B;
        }
        System.out.println(date);
    }
}
