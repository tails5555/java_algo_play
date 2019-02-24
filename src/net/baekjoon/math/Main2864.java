package net.baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Baekjoon 2864 번 5와 6의 차이 문제 풀이
public class Main2864 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        char[] a = st.nextToken().toCharArray();
        char[] b = st.nextToken().toCharArray();

        for(int k = 0; k < a.length; k++){
            if(a[k] == '5')
                a[k] = '6';
        }

        for(int k = 0; k < b.length; k++){
            if(b[k] == '5')
                b[k] = '6';
        }

        int max = Integer.parseInt(new String(a)) + Integer.parseInt(new String(b));

        for(int k = 0; k < a.length; k++){
            if(a[k] == '6')
                a[k] = '5';
        }

        for(int k = 0; k < b.length; k++){
            if(b[k] == '6')
                b[k] = '5';
        }

        int min = Integer.parseInt(new String(a)) + Integer.parseInt(new String(b));

        System.out.printf("%d %d\n", min, max);
    }
}
