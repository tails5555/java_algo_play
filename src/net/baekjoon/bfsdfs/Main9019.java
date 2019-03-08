package net.baekjoon.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// Baekjoon 9019번 문제
// DSLR
public class Main9019 {
    static class Status {
        int num;
        String command;

        public Status(int num, String command){
            this.num = num;
            this.command = command;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        boolean[] visited;
        for(int k = 0; k < T; k++){
            st = new StringTokenizer(br.readLine(), " ");
            int current = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            visited = new boolean[10000];
            visited[current] = true;

            Queue<Status> queue = new LinkedList<>();
            queue.offer(new Status(current, ""));

            while(!queue.isEmpty()){
                Status tmp = queue.poll();if(tmp.num == target){
                    System.out.println(tmp.command);
                    break;
                }

                int d_num = (tmp.num * 2) % 10000;
                if(!visited[d_num]){
                    visited[d_num] = true;
                    queue.offer(new Status(d_num, tmp.command + "D"));
                }

                int s_num = tmp.num - 1 < 0 ? 9999 : tmp.num - 1;
                if(!visited[s_num]){
                    visited[s_num] = true;
                    queue.offer(new Status(s_num, tmp.command + "S"));
                }

                int l_num = (tmp.num % 1000) * 10 + (tmp.num / 1000);
                if(!visited[l_num]){
                    visited[l_num] = true;
                    queue.offer(new Status(l_num, tmp.command + "L"));
                }

                int r_num = (tmp.num % 10) * 1000 + (tmp.num / 10);
                if(!visited[r_num]){
                    visited[r_num] = true;
                    queue.offer(new Status(r_num, tmp.command + "R"));
                }
            }
        }
    }
}
