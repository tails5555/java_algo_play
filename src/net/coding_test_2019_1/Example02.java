package net.coding_test_2019_1;

import java.util.Arrays;

// 프로그래머스 2019 상반기 모의고사 문제 No.2
// 서울시 가로등 문제(100점)
public class Example02 {
    public static int solution(int l, int[] v) {
        Arrays.sort(v);

        int[] temp;

        boolean startContains = false;
        boolean endContains = false;

        if(v[0] != 0 && v[v.length - 1] != l){
            temp = new int[v.length + 2];
            temp[0] = 0;
            temp[v.length + 1] = l;
            System.arraycopy(v, 0, temp, 1, v.length);
        } else if(v[0] != 0) {
            temp = new int[v.length + 1];
            temp[0] = 0;
            System.arraycopy(v, 0, temp, 1, v.length);
            endContains = true;
        } else if(v[v.length - 1] != l){
            temp = new int[v.length + 1];
            temp[v.length] = l;
            System.arraycopy(v, 0, temp, 0, v.length);
            startContains = true;
        } else {
            temp = new int[v.length];
            System.arraycopy(v, 0, temp, 0, v.length);
            startContains = true;
            endContains = true;
        }

        int max = Integer.MIN_VALUE;
        for(int k = 0; k < temp.length; k++){
            if(k == 0) {
                if(!startContains) {
                    max = Math.max(max, temp[k + 1]);
                }
            } else if(k == temp.length - 1) {
                if(!endContains) {
                    max = Math.max(max, l - temp[k - 1]);
                }
            }

            if(k < temp.length - 1)
                max = Math.max(max, (int) Math.ceil(Math.abs(temp[k] - temp[k + 1]) / 2.0));
        }

        return max;
    }

    public static void main(String[] args){
        System.out.println(solution(15, new int[] { 15,5,3,7,9,14,0 }));
        System.out.println(solution(5, new int[] { 2,5 }));
        System.out.println(solution(10, new int[] { 2,8 }));
        System.out.println(solution(11, new int[] { 4,6 }));
    }
}
