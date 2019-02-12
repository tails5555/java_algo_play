package net.sw_expert.d3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// SW Expert D3 암호문 쿼리 문제 풀이. 1228, 1229 번 문제는 그냥 제출만 하겠음.
public class Main1230 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        for(int k=0;k<10;k++){
            List<String> list = new ArrayList<>();
            int N = s.nextInt();
            int idx = 0;
            while(idx < N) {
                list.add(s.next());
                idx += 1;
            }

            int M = s.nextInt();
            for(int l = 0; l < M; l++){
                String com = s.next();
                if(com.equals("I")){
                    int insertIdx = s.nextInt();
                    List<String> tmp = new ArrayList<>();
                    int insertCnt = s.nextInt();
                    for(int m = 0; m < insertCnt; m++){
                        tmp.add(s.next());
                    }
                    list.addAll(insertIdx, tmp);
                }
                else if(com.equals("D")) {
                    int remIdx = s.nextInt();
                    int remCnt = s.nextInt();
                    for(int m = 0; m < remCnt; m++){
                        list.remove(remIdx);
                    }
                }
                else if(com.equals("A")) {
                    int addCnt = s.nextInt();
                    for(int m = 0; m < addCnt; m++){
                        list.add(s.next());
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            for(int l = 0; l < 10; l++){
                sb.append(String.format("%s ", list.get(l)));
            }

            System.out.printf("#%d %s\n", k+1, sb.toString());
        }
    }
}
