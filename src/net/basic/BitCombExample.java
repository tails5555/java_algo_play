package net.basic;

import java.util.Arrays;

// 카카오 2019 1차 블라인드 3번 문제에서 발견
// 비트 마스크를 이용한 조합 찾기(허나 int 는 31, long 은 63까지만 허용됨.)
public class BitCombExample {
    public static void main(String[] args){
        int N = 6; // N 의 범위는 int 기준으로 1부터 31까지 적용 가능합니다.
        int target = 1 << N;
        for(int k = 0; k < target; k++){
            int tmp = k;
            StringBuilder sb = new StringBuilder();
            boolean[] select = new boolean[N];
            int idx = select.length - 1;
            if(tmp == 0) {
                sb.append(0);
            } else {
                while (tmp > 0) {
                    sb.insert(0, tmp % 2);
                    select[idx--] = (tmp % 2 == 1) ? true : false;
                    tmp = tmp >> 1;
                }
            }
            System.out.println(k + " = " + sb.toString() + " = " + Arrays.toString(select));
        }
    }
}
