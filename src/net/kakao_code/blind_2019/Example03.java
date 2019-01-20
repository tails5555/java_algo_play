package net.kakao_code.blind_2019;

import java.util.HashSet;
import java.util.Set;

// Kakao 2019 블라인드 문제 3번
// 후보키. 드디어 100점 나왔당♥
public class Example03 {
    public static int solution(String[][] relation) {
        Set<Integer> unique = new HashSet<>();
        int search_cnt = 1 << relation[0].length;
        boolean[] visit;

        // 후보키를 참조하는 진 부분 집합과 완전 집합의 총 개수는 2^(열의 수) - 1 개입니다.
        for(int k = 1; k < search_cnt; k++){
            visit = new boolean[relation[0].length];
            int idx = relation[0].length - 1;

            // 참조할 데이터를 bool 이진수로 표현합니다.
            int var = k;
            while(idx >= 0){
                visit[idx] = (var % 2 == 1) ? true : false;
                var /= 2;
                idx -= 1;
            }

            // 그 행에 해당되는 문자열을 박아둡니다.
            Set<String> matchBox = new HashSet<>();
            for (int l = 0; l < relation.length; l++) {
                StringBuilder sb = new StringBuilder();
                for (int m = 0; m < visit.length; m++) {
                    if (visit[m]) {
                        sb.append(relation[l][m]+" ");
                    }
                }
                matchBox.add(sb.toString());
            }

            // 행의 개수와 유일성이 확인된 개수가 같으면 비트 마스크 칠을 합니다.
            // 왼쪽은 현재 집합 안에 있는 숫자들 중에 포함된 binary 가 있는 경우입니다.
            // (0, 0, 0, 1) & (0, 0, 1, 1) = 1
            // (0, 0, 1, 1) & (0, 1, 1, 1) = 3
            // 오른쪽은 현재 수치에 전부 포함 되는 경우입니다.
            // (0, 1, 1, 1) & (0, 0, 1, 1) = 3
            // 즉 좌측과 우측의 비트끼리 부분집합이 아닌지를 확인하는 것입니다.
            // 문제 풀 때 이런 방법을 고려 했는데 boolean 배열로 채킹하면 런타임 오류납니다. 참고 바랍니다.
            if(matchBox.size() == relation.length){
                boolean confirm = true;
                for(int tmp : unique){
                    if((tmp & k) == tmp || (tmp & k) == k) {
                        confirm = false;
                        break;
                    }
                }
                if(confirm) {
                    unique.add(k);
                }
            }
        }

        return unique.size();
    }

    public static void main(String[] args){
        System.out.println(solution(
            new String[][] {
                { "100", "ryan", "music", "2" },
                { "200", "apeach", "math", "2" },
                { "300", "tube", "computer", "3" },
                { "400", "con", "computer", "4" },
                { "500", "muzi", "music", "3" },
                { "600", "apeach", "music", "2" }
            }
        ));
    }
}
