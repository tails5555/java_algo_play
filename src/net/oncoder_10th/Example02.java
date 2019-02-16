package net.oncoder_10th;

import java.util.Map;
import java.util.TreeMap;

// 온코더 10회 공식테스트 2번
public class Example02 {
    public static int solution(int[] type){
        Map<Integer, Integer> map = new TreeMap<>();
        int max = Integer.MIN_VALUE;
        for(int k = 0; k < type.length; k++){
            int tmp = map.getOrDefault(type[k], 0);
            map.put(type[k], tmp + 1);
            max = Math.max(max, type[k]);
        }

        int res = 0;
        for(int k = 1; k <= max; k++){
            int tmp = 1;
            boolean checked = true;
            for(int l = 1; l <= k; l++){
                if(map.containsKey(l))
                    tmp *= map.get(l);
                else {
                    checked = false;
                }
            }
            if(checked) res += tmp;
            else break;
        }

        return res;
    }

    public static void main(String[] args){
        System.out.println(solution(new int[] { 3, 2, 1 }));
        System.out.println(solution(new int[] { 1, 1, 2 }));
        System.out.println(solution(new int[] { 1, 2, 2, 3, 3 }));
        System.out.println(solution(new int[] { 1, 3, 4 }));
    }
}
