package net.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// Baekjoon 1931번 문제 풀이
// 회의실 배정
public class Main1931 {
    static class Time implements Comparable<Time> {
        int start;
        int end;

        public Time(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Time o) {
            if(this.end == o.end){
                return this.start - o.start;
            } else {
                return this.end - o.end;
            }
        }

        @Override
        public String toString(){
            return String.format("[%d %d]", this.start, this.end);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Time[] times = new Time[N];
        StringTokenizer st;
        for(int k=0;k<N;k++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            times[k] = new Time(start, end);
        }
        Arrays.sort(times);

        int cnt = 0;
        int end = -1;

        for(int k=0;k<N;k++){
            if(end <= times[k].start){
                end = times[k].end;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
