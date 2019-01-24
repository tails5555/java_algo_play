package net.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// 코딩 테스트에서 대표적으로 나온 문제
// 유효한 IP 주소에 대하여 출력하는 문제. 예를 들어 주어진 숫자가 252512 이면 아래와 같이 출력하는 문제.
public class IPGuess {
    static char[] nums;
    static PriorityQueue<String> pq;
    static void solution(int start, int cnt, String[] tmp) {
        if(start > nums.length) return;
        if(cnt == 4) {
            if(start < nums.length) return;
            boolean validate = true;
            StringBuilder sb = new StringBuilder();
            for(int k = 0; k < tmp.length; k++){
                int v = Integer.parseInt(tmp[k]);
                if(v < 0 || v > 255) {
                    validate = false;
                    break;
                } else {
                    if(k != tmp.length - 1){
                        sb.append(String.format("%d. ", v));
                    } else {
                        sb.append(String.format("%d", v));
                    }
                }
            }
            if(validate) {
                pq.offer(sb.toString());
            }
            return;
        }

        if(start + 1 <= nums.length) {
            tmp[cnt] = new String(Arrays.copyOfRange(nums, start, start + 1));
            solution(start + 1, cnt + 1, tmp);
            tmp[cnt] = "";
        }

        if(start + 2 <= nums.length) {
            tmp[cnt] = new String(Arrays.copyOfRange(nums, start, start + 2));
            solution(start + 2, cnt + 1, tmp);
            tmp[cnt] = "";
        }

        if(start + 3 <= nums.length) {
            tmp[cnt] = new String(Arrays.copyOfRange(nums, start, start + 3));
            solution(start + 3, cnt + 1, tmp);
            tmp[cnt] = "";
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();
        nums = text.toCharArray();
        pq = new PriorityQueue<>(Comparator.reverseOrder());

        if(text.length() >= 4) {
            solution(1, 1, new String[] { new String(Arrays.copyOfRange(nums, 0, 1)), "", "", "" });
            if(text.length() >= 5)
                solution(2, 1, new String[] { new String(Arrays.copyOfRange(nums, 0, 2)), "", "", "" });
            if(text.length() >= 6)
                solution(3, 1, new String[] { new String(Arrays.copyOfRange(nums, 0, 3)), "", "", "" });
        }

        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }
    }
}

/*
 * 252. 5. 1. 2
 * 25. 25. 1. 2
 * 25. 2. 51. 2
 * 25. 2. 5. 12
 * 2. 52. 51. 2
 * 2. 52. 5. 12
 * 2. 5. 251. 2
 * 2. 5. 25. 12
 */