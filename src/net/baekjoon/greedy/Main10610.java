package net.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

// Baekjoon 10610 번 30 문제 풀이
public class Main10610 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        char[] arr = br.readLine().toCharArray();
        int sum = 0;
        boolean containZero = false;
        for(int k = 0; k < arr.length; k++){
            if(arr[k] == '0') containZero = true;
            int tmp = arr[k] - '0';
            sum += tmp;
            pq.offer(tmp);
        }

        if(sum % 3 == 0 && containZero){
            StringBuilder sb = new StringBuilder();
            while(!pq.isEmpty()){
                int tmp = pq.poll();
                sb.append(tmp);
            }
            System.out.println(sb.toString());
        } else {
            System.out.println(-1);
        }
    }
}
