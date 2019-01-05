package net.line_intern_coding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

// LINE 인턴 코딩 테스트 1번 문제 컬링
public class Ex01 {
    static class Curling {
        int x;
        int y;

        public Curling(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public double getDistance() {
            return Math.sqrt(Math.pow(this.x - 0.0, 2.0) + Math.pow(this.y - 0.0, 2.0));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int cony = 0;
        int brown = 0;

        for(int k=0;k<T;k++){
            int N = Integer.parseInt(br.readLine());

            Map<String, List<Curling>> map = new HashMap<>();
            map.put("Brown", new ArrayList<>());
            map.put("Cony", new ArrayList<>());

            double brownMin = Double.MAX_VALUE;
            double conyMin = Double.MAX_VALUE;

            StringTokenizer st;
            for(int l=0;l<N;l++){
                st = new StringTokenizer(br.readLine(), " ");

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                String team = st.nextToken();

                Curling curling = new Curling(x, y);
                double distance = curling.getDistance();

                switch(team) {
                    case "Brown" :
                        if(distance < brownMin) {
                            brownMin = distance;
                        }
                        break;
                    case "Cony" :
                        if(distance < conyMin) {
                            conyMin = distance;
                        }
                        break;
                }

                List<Curling> tmp = map.get(team);
                tmp.add(curling);
                map.put(team, tmp);
            }

            double min = brownMin < conyMin ? conyMin : brownMin;
            List<Curling> winCur = map.get(brownMin < conyMin ? "Brown" : "Cony");

            int cnt = 0;
            for(Curling c : winCur) {
                if(c.getDistance() < min) cnt += 1;
            }

            if(brownMin < conyMin) {
                brown += cnt;
            } else {
                cony += cnt;
            }
        }

        System.out.printf("%s %d\n", "Cony", cony);
        System.out.printf("%s %d", "Brown", brown);
    }
}
