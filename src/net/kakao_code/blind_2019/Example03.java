package net.kakao_code.blind_2019;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Kakao 2019 블라인드 문제 3번
// 후보키
public class Example03 {
    static String[][] database;
    static boolean[] visited;
    static List<List<Integer>> unique;
    static int targetCnt;

    public static void confirm_unique_constraint(boolean[] visited){
        Set<String> matchBox = new HashSet<>();
        for (int k = 0; k < database.length; k++) {
            List<String> tmpTuples = new ArrayList<>();
            for (int l = 0; l < visited.length; l++) {
                if (visited[l]) {
                    tmpTuples.add(database[k][l]);
                }
            }

            String tmpText = tmpTuples.toString();
            if (matchBox.contains(tmpText)) {
                return;
            } else {
                matchBox.add(tmpText);
            }
        }

        if(matchBox.size() == database.length){
            List<Integer> tmpList = new ArrayList<>();
            for(int k=0;k<visited.length;k++){
                if(visited[k]) tmpList.add(k);
            }
            unique.add(tmpList);
        }
    }

    public static void combination(int idx, int cnt){
        if(cnt == targetCnt) {
            confirm_unique_constraint(visited);
            return;
        }
        for(int k=idx;k<database[k].length;k++){
            if(!visited[k]){
                visited[k] = true;
                combination(k, cnt + 1);
                visited[k] = false;
            }
        }
    }

    public static int solution(String[][] relation) {
        database = relation;
        unique = new ArrayList<>();
        for(int k=0;k<database[0].length;k++){
            targetCnt = k + 1;
            visited = new boolean[database[0].length];
            combination(0, 0);
        }

        Set<List<Integer>> res = new HashSet<>();
        for(List<Integer> list : unique){
            if(!res.contains(list)){
                boolean contain = true;
                for(List<Integer> small : res){
                    if(list.containsAll(small)) {
                        contain = false;
                        break;
                    }
                }
                if(contain){
                    res.add(list);
                }
            }
        }
        return res.size();
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
