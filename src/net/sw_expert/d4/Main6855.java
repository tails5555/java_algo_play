package net.sw_expert.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// SW Expert D4 신도시 전기 연결하기
public class Main6855 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int k = 0; k < T; k++){
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            int[] arr = new int[N];
            int idx = 0;
            for(int l = 0; l < N; l++){
                arr[idx++] = Integer.parseInt(st.nextToken());
            }

            PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
            for(int l = 0; l < N - 1; l++){
                queue.offer(Math.abs(arr[l] - arr[l + 1]));
            }

            for(int l = 0; l < K - 1; l++){
                if(!queue.isEmpty())
                queue.poll();
            }
            int sum = 0;
            while(!queue.isEmpty()){
                int tmp = queue.poll();
                sum += tmp;
            }
            System.out.printf("#%d %d\n", k+1, sum);
        }
    }
}
