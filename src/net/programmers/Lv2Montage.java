package net.programmers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// 프로그래머스 위장 문제
// 경우의 수를 더욱 알아둬야 하는 좋은 문제
public class Lv2Montage {
    public static int solution(String[][] clothes) {
        Map<String, Set<String>> map = new HashMap<>();
        for(int k=0;k<clothes.length;k++){
            Set<String> tmp = map.getOrDefault(clothes[k][1], new HashSet<>());
            tmp.add(clothes[k][0]);
            map.put(clothes[k][1], tmp);
        }
        System.out.println(map);

        int res = 1;
        for(String str : map.keySet()) {
            res *= (map.get(str).size() + 1);
        }

        return res - 1;
    }

    public static void main(String[] args){
        System.out.println(solution(new String[][] {
            { "yellow_hat", "headgear" }, { "blue_sunglasses", "eyewear" }, { "green_turban", "headgear" }
        }));
        System.out.println(solution(new String[][] {
            { "crow_mask", "face" }, { "blue_sunglasses", "face" }, { "smoky_makeup", "face" }
        }));
    }
}

// 예를 들어 아래와 같은 경우를 살펴보자.
// [ 파란 후드티, 하얀 나시 ] 상의
// [ 초록 바지, 파란 스커트 ] 하의
// 상의를 고르는 경우의 수는 2개, 하의를 고르는 경우의 수는 2개이다.
// 그리고 상의와 하의를 같이 고르는 수는 4개이다. 총 8가지.
// 하지만 이를 간단하게 계산하는 방법은 안 고르는 옵션을 추가하는 것이다.
// [ 파란 후드티, 하얀 나시, 안 입는 거 ] 상의
// [ 초록 바지, 파란 스커트, 안 입는 거 ] 하의
// 그래서 3 * 3 의 결과 값은 9가지가 나오는데 전부 다 안 고르는 경우의 수인 1를 제외한 8이 나오게 된다.
// 이는 알고리즘 문제보다 경우의 수를 짚어야 하는 좋은 문제였다.