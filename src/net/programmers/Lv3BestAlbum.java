package net.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

// 프로그래머스 베스트 앨범 문제
public class Lv3BestAlbum {
    public static int[] solution(String[] genres, int[] plays) {
        Map<String, PriorityQueue<int[]>> map = new TreeMap<>();
        for(int k = 0; k < genres.length; k++){
            PriorityQueue<int[]> queue = map.getOrDefault(genres[k], new PriorityQueue<>((o1, o2) -> {
                if(o1[0] == o2[0]) return o1[1] - o2[1];
                else return o2[0] - o1[0];
            }));
            queue.offer(new int[] { plays[k], k });
            map.put(genres[k], queue);
        }

        String[] keys = map.keySet().stream().toArray(String[]::new);
        Arrays.sort(keys, (o1, o2) -> {
            PriorityQueue<int[]> q1 = map.get(o1);
            PriorityQueue<int[]> q2 = map.get(o2);

            Integer sum1 = q1.stream().map(arr -> arr[0]).reduce((v1, v2) -> v1 + v2).get();
            Integer sum2 = q2.stream().map(arr -> arr[0]).reduce((v1, v2) -> v1 + v2).get();

            return sum2 - sum1;
        });

        List<Integer> answer = new ArrayList<>();
        for(String key : keys){
            PriorityQueue<int[]> tmp = map.get(key);
            int idx = 0;
            while(!tmp.isEmpty()) {
                if(idx >= 2) break;
                int[] arr = tmp.poll();
                answer.add(arr[1]);
                idx += 1;
            }
        }
        return answer.stream().mapToInt(m -> m).toArray();
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(
            solution(new String[] { "classic", "pop", "classic", "classic", "pop" }, new int[] { 500, 600, 150, 800, 2500 })
        ));
        System.out.println(Arrays.toString(
            solution(new String[] { "hiphop", "pop", "hiphop", "trot", "trot" }, new int[] { 1000, 20, 2000, 20, 10 })
        ));
    }
}
