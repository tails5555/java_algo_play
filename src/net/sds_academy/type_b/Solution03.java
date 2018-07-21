package net.sds_academy.type_b;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution03 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long[] result = new long[T + 1];
        int N;
        List<Integer> plusList;
        for (int k=1;k<=T;k++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), " ");
            plusList = new LinkedList<Integer>();
            for(int l=0;l<N;l++){
                plusList.add(Integer.parseInt(st.nextToken()));
            }
            while(plusList.size() != 1) {
                long calculate = Long.MAX_VALUE;
                int idx = -1;
                for (int l = 0; l < plusList.size() - 1; l++) {
                    long tmp = (long)(plusList.get(l) + plusList.get(l + 1));
                    if(calculate > tmp){
                        calculate = tmp;
                        idx = l;
                    }
                }
                result[k] += calculate;
                plusList.set(idx, Integer.valueOf((int) calculate));
                plusList.remove(idx + 1);
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
