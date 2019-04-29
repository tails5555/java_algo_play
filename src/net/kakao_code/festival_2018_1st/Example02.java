package net.kakao_code.festival_2018_1st;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Example02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] dolls = new int[N];

        int x = 0;
        st = new StringTokenizer(br.readLine(), " ");
        while(st.hasMoreTokens()){
            dolls[x++] = Integer.parseInt(st.nextToken());
        }

        double minStandard = Double.MAX_VALUE;
        for(int i=0;i<N-K+1;i++){
            for(int h=K;h<=N-i;h++) {
                double sum = 0;
                for (int j = i; j < i + h; j++) {
                    sum += dolls[j];
                }
                double avg = (sum / h);
                double vSum = 0;
                for (int j = i; j < i + h; j++) {
                    vSum += Math.pow((dolls[j] - avg), 2);
                }
                double standard = Math.sqrt(vSum / h);
                if (minStandard > standard) minStandard = standard;
            }
        }
        System.out.printf("%.11f", minStandard);
    }
}
