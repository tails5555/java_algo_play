package net.sds_academy.type_b;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution03 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long[] result = new long[T + 1];
        int N;
        PriorityQueue<Long> plusList;
        for (int k=1;k<=T;k++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), " ");
            plusList = new PriorityQueue<Long>();
            for(int l=0;l<N;l++){
                plusList.add(Long.parseLong(st.nextToken()));
            }
            long putting = 0;
            while(true) {
                putting = (plusList.size() > 0 ? plusList.poll() : 0) + (plusList.size() > 0 ? plusList.poll() : 0);
                result[k] += putting;
                if(plusList.isEmpty()) break;
                if(plusList.size() >= 1)
                    plusList.add(putting);
            }
            if(k != T)
                bw.append(String.format("#%d %d\n", k, result[k]));
            else
                bw.append(String.format("#%d %d", k, result[k]));
        }
        bw.flush();
        bw.close();
    }
}
