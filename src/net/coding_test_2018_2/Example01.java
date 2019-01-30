package net.coding_test_2018_2;

// 프로그래머스 2018 하반기 모의고사 1번
// 정수 회문 문제 - 시뮬레이션 문제
public class Example01 {
    static int solution(int start, int end) {
        int cnt = 0;
        for(int k=start;k<=end;k++){
            String tmp = Integer.toString(k);
            String rev = new StringBuilder(tmp).reverse().toString();
            if(tmp.equals(rev)) cnt += 1;
        }
        return cnt;
    }

    public static void main(String[] args){
        System.out.println(solution(1, 100)); // 1~9, 11, 22, 33, 44, ... , 99
        System.out.println(solution(10, 100)); // 11~99
    }
}
