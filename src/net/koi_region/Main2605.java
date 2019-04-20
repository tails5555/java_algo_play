package net.koi_region;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// Baekjoon 2605 번 KOI 2004 초등부 지역본선 줄 세우기 문제 풀이
public class Main2605 {
    static BufferedReader br;
    static StringTokenizer st;
    static int N;
    static int[] order;

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        order = new int[N + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for(int k = 1; k <= N; k++){
            order[k] = Integer.parseInt(st.nextToken());
        }
    }

    static void solution() {
        LinkedList<Integer> students = new LinkedList<>();
        students.add(1); // 1번 학생은 0번을 뽑을 수 밖에 없어 언제나 첫 바운드에 시작한다.
        for(int k = 2; k <= N; k++){
            if(order[k] == 0) students.addLast(k);
            else students.add(k - order[k] - 1, k);
        }
        for(int k : students){
            System.out.printf("%d ", k);
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
}
