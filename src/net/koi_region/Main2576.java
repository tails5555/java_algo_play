package net.koi_region;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Baekjoon KOI 2006 초등부 지역본선 1번 홀수 문제 풀이
public class Main2576 {
    static BufferedReader br;
    static List<Integer> odds;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        odds = new ArrayList<>();
        for(int k = 0; k < 7; k++){
            int tmp = Integer.parseInt(br.readLine());
            if(tmp % 2 == 1) odds.add(tmp);
        }
        if(odds.size() == 0){
            System.out.println(-1);
        } else {
            System.out.println(odds.stream().reduce((o1, o2) -> o1 + o2).get());
            System.out.println(Collections.min(odds));
        }
    }
}
