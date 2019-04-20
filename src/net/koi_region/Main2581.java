package net.koi_region;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

// Baekjoon KOI 2006 중등부 지역본선 1번 홀수 문제 풀이
public class Main2581 {
    static BufferedReader br;
    public static void main(String[] args) throws IOException {
        List<Integer> primes = new ArrayList<>();
        boolean[] isNotPrime = new boolean[10000 + 1];
        isNotPrime[1] = true;
        for(int k = 2; k <= 10000; k++){
            if(!isNotPrime[k]) primes.add(k);
            for(int l = k * 2; l <= 10000; l += k){
                isNotPrime[l] = true;
            }
        }

        br = new BufferedReader(new InputStreamReader(System.in));
        int from = Integer.parseInt(br.readLine());
        int to = Integer.parseInt(br.readLine());

        List<Integer> tmp = primes.stream().filter(o -> o >= from && o <= to).collect(Collectors.toList());
        if(tmp.size() == 0){
            System.out.println(-1);
        } else {
            System.out.println(tmp.stream().reduce((o1, o2) -> o1 + o2).get());
            System.out.println(Collections.min(tmp));
        }
    }
}
