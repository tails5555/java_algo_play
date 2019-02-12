package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// SW Expert D3 암호생성기 문제 풀이
public class Main1225 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int k = 0; k < 10; k++){
            int test = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            LinkedList<Integer> queue = new LinkedList<>();
            while(st.hasMoreTokens()){
                int tmp = Integer.parseInt(st.nextToken());
                queue.offer(tmp);
            }

            int cnt = 0;
            while(true){
                cnt = cnt % 5 + 1;
                int tmp = queue.poll();
                if(tmp - cnt < 0)
                    queue.offer(0);
                else
                    queue.offer(tmp - cnt);
                if(queue.peekLast() == 0) break;
            }
            StringBuilder sb = new StringBuilder();
            while(!queue.isEmpty()){
                sb.append(queue.poll() + " ");
            }
            System.out.printf("#%d %s\n", test, sb.toString());
        }
    }
}
