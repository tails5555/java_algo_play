package net.hackerrank.array;

// Hacker Rank Array 문제
// 3번. New Year Chaos 문제
// 줄 서는 순서를 Bubble Sort 처럼 순서를 바꾸는 문제. 그러나 정확한 의미를 몰라 풀이 참조...ㅜ
public class Example03 {
    static void minimumBribes(int[] q) {
        boolean chaotic = false;
        int bribe = 0;
        for(int k=0;k<q.length;k++){
            if(q[k] - (k + 1) > 2) {
                chaotic = true;
                break;
            }
            for(int l = Math.max(0, q[k] - 2); l < k ; l++){
                if(q[l] > q[k]) bribe += 1;
            }
        }

        if(chaotic) {
            System.out.println("Too chaotic");
        } else {
            System.out.println(bribe);
        }
    }

    public static void main(String[] args){
        minimumBribes(new int[] { 2, 1, 5, 3, 4 });
        minimumBribes(new int[] { 2, 5, 1, 3, 4 });
    }
}

// [) <- 2 1 5 3 4 - 복잡도 변화 = 0
// [2) <- 1 5 3 4 - 비교 데이터 = 1, 복잡도 변화 = 1 (2, 1 발견)
// 2 1 5 -> [) 3 4 - 복잡도 변화 = 0
// 2 [1 5) <- 3 4 - 비교 데이터 = 3, 복잡도 변화 = 1 (5, 3 발견)
// 2 1 [5 3) <- 4 - 비교 데이터 = 4, 복잡도 변화 = 1 (5, 4 발견)
// 규칙이 약간 어렵다. 한 번 더 살펴보자.