package net.kakao_code.blind_2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

// Kakao 2019 블라인드 문제 2번
// 실패율
public class Example02 {
    static class Stage implements Comparable<Stage> {
        int stage;
        double percent;
        public Stage(int stage, double percent){
            this.stage = stage;
            this.percent = percent;
        }

        @Override
        public int compareTo(Stage another){
            if(this.percent > another.percent)
                return -1;
            else if(this.percent < another.percent)
                return 1;
            else return stage - another.stage;
        }
    }

    static int[] solution(int N, int[] stages){
        Arrays.sort(stages);
        int firstIdx = 0;
        int tmp = 0;
        List<Stage> result = new ArrayList<Stage>();
        for(int i=1;i<=N;i++){
            tmp = firstIdx;
            while(true){
                if(tmp >= stages.length) break;
                if(i == stages[tmp]) tmp++;
                else break;
            }
            result.add(new Stage(i, ((double)(tmp - firstIdx) / (double)(stages.length - firstIdx))));
            firstIdx = tmp;
        }
        Collections.sort(result);
        List<Integer> ids = result.stream().map(s -> s.stage).collect(Collectors.toList());
        return ids.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(solution(5, new int[] {2, 1, 2, 6, 2, 4, 3, 3})));
        System.out.println(Arrays.toString(solution(4, new int[] {4, 4, 4, 4, 4})));
    }
}
