package net.koi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Baekjoon KOI 2012 초등부 카드놀이 문제 풀이
public class Main2511 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();

        String[] stA = a.split(" ");
        String[] stB = b.split(" ");

        int scoreA = 0, scoreB = 0;
        for(int k = 0; k < 10; k++){
            int tmpA = Integer.parseInt(stA[k]);
            int tmpB = Integer.parseInt(stB[k]);

            if(tmpA > tmpB) scoreA += 3;
            else if(tmpA < tmpB) scoreB += 3;
            else {
                ++scoreA;
                ++scoreB;
            }
        }

        System.out.println(scoreA + " " + scoreB);
        if(scoreA > scoreB){
            System.out.println("A");
        } else if(scoreA < scoreB) {
            System.out.println("B");
        } else {
            int k = 9;
            char d = '-';
            while(k >= 0){
                int tmpA = Integer.parseInt(stA[k]);
                int tmpB = Integer.parseInt(stB[k]);
                if(tmpA > tmpB) {
                    d = 'A';
                    break;
                } else if(tmpA < tmpB) {
                    d = 'B';
                    break;
                }
                k -= 1;
            }
            System.out.println(d == '-' ? 'D' : d);
        }
    }
}
