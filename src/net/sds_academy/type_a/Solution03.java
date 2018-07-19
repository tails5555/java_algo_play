package net.sds_academy.type_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] result = new int[T+1];
        int N, S, J, K;
        for(int k=1;k<=T;k++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            N = Integer.parseInt(st.nextToken());
            S = Integer.parseInt(st.nextToken());
            J = Integer.parseInt(st.nextToken());

            Set<Integer> rests = new HashSet<Integer>();
            for(int l=S;l<=N;l=l+(J+1)){
                rests.add(l);
            }

            K = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), " ");
            Set<Integer> pages = new HashSet<Integer>();

            while(st.hasMoreTokens()){
                pages.add(Integer.parseInt(st.nextToken()));
            }

            pages.removeAll(rests);

            result[k] = K - pages.size();
        }
        for(int k=1;k<=T;k++){
            System.out.printf("#%d %d\n", k, result[k]);
        }
    }
}
