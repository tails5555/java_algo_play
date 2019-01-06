package net.line_summer_intern_2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

// LINE 인턴 코딩 테스트 3번 문제 서버 관리
public class Ex03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String logInfo = br.readLine();
        String[] infoSplit = logInfo.split("\\|");

        int N = Integer.parseInt(infoSplit[0]);
        LocalTime pivotTime = LocalTime.parse(infoSplit[1]);

        Map<Integer, Set<String>> map = new TreeMap<>();
        for(int k=0;k<10;k++){
            map.put(k, new HashSet<>());
        }
        String eleInfo;
        String[] eleSplit;

        // Log 는 시간 순으로 작성 되었다고 명시되어 있습니다.
        for(int k=0;k<N;k++){
            eleInfo = br.readLine();
            eleSplit = eleInfo.split("\\|");

            LocalTime logTime = LocalTime.parse(eleSplit[0]);
            boolean completed = eleSplit[1].equals("O") ? true : false;
            String task = eleSplit[2];
            int client = Integer.parseInt(eleSplit[3]);

            if(logTime.compareTo(pivotTime) <= 0) {
                Set<String> tasks = map.get(client);
                if (!completed) {
                    tasks.add(task);
                } else {
                    tasks.remove(task);
                }
            }
        }

        for(int k=0;k<=9;k++){
            System.out.printf("%d %d\n", k, map.get(k).size());
        }
    }
}

/*

6|00:01:00
00:00:50|I|abcde01|9
00:00:55|I|cbcde02|1
00:00:59|O|cbcde02|1
00:00:59|I|c1cce03|3
00:01:05|O|abcde01|9
00:01:09|O|c1cce03|3

0 0
1 0
2 0
3 1
4 0
5 0
6 0
7 0
8 0
9 1

 */