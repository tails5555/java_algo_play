package net.hackerrank.string;

import java.util.ArrayList;
import java.util.List;

// Hacker Rank String 문제
// Special Palindrome Again 문제
// 글자 안에서 부분 회문 개수를 찾는 좀 고난이도 문제
public class Example04 {
    static class Point {
        char alp;
        long cnt;
        public Point(char alp, long cnt) {
            this.alp = alp;
            this.cnt = cnt;
        }
    }

    static long substrCount(int n, String s) {
        char[] arr = s.toCharArray();
        List<Point> points = new ArrayList<>();

        long palindromeCnt = 0L;
        long equalCnt = 1L;
        for(int k = 1; k < n; k++){
            if(arr[k] == arr[k - 1]) equalCnt++;
            else {
                points.add(new Point(arr[k - 1], equalCnt));
                equalCnt = 1L;
            }
        }
        points.add(new Point(arr[n - 1], equalCnt));

        for(Point point : points) {
            palindromeCnt += point.cnt * (point.cnt + 1) / 2;
        }

        for(int k = 1; k < points.size() - 1; k++) {
            Point before = points.get(k - 1);
            Point cur = points.get(k);
            Point after = points.get(k + 1);

            if(cur.cnt == 1L && before.alp == after.alp)
                palindromeCnt += Math.min(before.cnt, after.cnt);
        }

        return palindromeCnt;
    }

    public static void main(String[] args){
        System.out.println(substrCount(8, "mnonopoo"));
        System.out.println(substrCount(5, "asasd"));
        System.out.println(substrCount(7, "abcbaba"));
        System.out.println(substrCount(4, "aaaa"));
        System.out.println(substrCount(9, "abaabaaba"));
    }
}

// 풀이 전략
/*
 * 회문 중에서 다음과 같은 경우만 허용합니다.
 * aaaaa (같은 알파벳만 여러 개 있으면)
 * aabaa (중앙에 있는 알파벳을 기준으로 회문이 형성될 때. 단 중앙에 있는 알파벳은 양쪽에서 못 쓴다.)
 * baab, abbba, babab 같은 경우는 해당 되지 않습니다.
 *
 * 현재 단어에 있는 같은 알파벳 별 회문 개수를 찾아냅니다.
 *
 * 같은 알파벳의 회문 개수는 1 부터 N 까지 더하는 방법을 이용하면 편합니다. N * (N + 1) / 2
 *
 * a b a a b a a b a
 * { a : 1 }, { b : 1 }, { a : 2 }, { b : 1 }, { a : 2 }, { b : 1 }, { a : 1 }
 *
 * 1 + 1 + (2 * 3) / 2 + 1 + (2 * 3) / 2 + 1 + 1 = 2 + 3 + 1 + 3 + 2 = 11
 *
 * 위 단위를 3개씩 묶어서 가운데의 횟수가 1이고, 양 끝의 알파벳이 같을 때 최소 회문의 개수를 판별합니다.
 * 0, 1, 2 => 1
 * 2, 3, 4 => 2
 * 4, 5, 6 => 1
 *
 * 그래서 최종 값으로 11 + 4 = 15 가 나오게 됩니다.
 *
 * a, b, a, a, b, a, a, b, a, aa, aa, aba, aabaa, aba, aba
 */
