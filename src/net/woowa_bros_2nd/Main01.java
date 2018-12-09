package net.woowa_bros_2nd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

// 우아한형제들 베짱Yee 당첨자 추첨 문제 풀이
// n 1 ~ 10^7
// d 1은 시계 방향, 0은 반시계 방향
// k, j는 1 ~ 10^6
public class Main01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken()); // person count
        int d = Integer.parseInt(st.nextToken()); // direction
        int k = Integer.parseInt(st.nextToken()); // k
        int j = Integer.parseInt(st.nextToken()); // j

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=1;i<=n;i++){
            int next = (i == n) ? 1 : i + 1;
            if(d == 1)
                map.put(i, next);
            else
                map.put(next, i);
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(1);

        Set<Integer> failure = new HashSet<>();

        k = k - j;
        int moving;
        int result = 0;

        while(!stack.isEmpty()){
            int vtx = stack.pop();
            int mVtx = vtx;

            if(failure.size() == n - 1) {
                while (true) {
                    mVtx = map.get(mVtx);
                    if (!failure.contains(mVtx)) break;
                }
                result = mVtx;
                break;
            }

            k += j;
            if(failure.contains(vtx)) {
                while (true) {
                    mVtx = map.get(mVtx);
                    if (!failure.contains(mVtx)) break;
                }
                moving = (k - 1) % (n - failure.size());
            } else {
                moving = k % (n - failure.size());
            }

            for(int i=0;i < moving;i++) {
                while(true) {
                    mVtx = map.get(mVtx);
                    if(!failure.contains(mVtx)) break;
                }
            }

            stack.push(mVtx);
            failure.add(mVtx);
        }

        System.out.println(result);
    }
}
