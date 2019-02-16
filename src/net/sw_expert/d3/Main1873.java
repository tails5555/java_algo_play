package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SW Expert D3 인성이의 배틀필드 문제 풀이
public class Main1873 {
    static boolean hasInside(int[] where, int H, int W) {
        return (where[0] >= 0 && where[0] <= H - 1) && (where[1] >= 0 && where[1] <= W - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int k = 0; k < T; k++){
            st = new StringTokenizer(br.readLine(), " ");
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            char[][] map = new char[H][W];
            int[] where = new int[2];
            for(int l = 0; l < H; l++){
                map[l] = br.readLine().toCharArray();
                for(int m = 0; m < map[l].length; m++){
                    if(map[l][m] == '^' || map[l][m] == 'v' || map[l][m] == '<' || map[l][m] == '>') {
                        where = new int[] { l, m };
                    }
                }
            }

            int N = Integer.parseInt(br.readLine());
            String command = br.readLine();
            for(char c : command.toCharArray()) {
                int[] tmp = null;
                int[] attack = null;
                char tank = '0';
                switch(c) {
                    case 'U' :
                        tmp = new int[] { where[0] - 1, where[1] };
                        tank = '^';
                        break;
                    case 'D' :
                        tmp = new int[] { where[0] + 1, where[1] };
                        tank = 'v';
                        break;
                    case 'L' :
                        tmp = new int[] { where[0], where[1] - 1 };
                        tank = '<';
                        break;
                    case 'R' :
                        tmp = new int[] { where[0], where[1] + 1 };
                        tank = '>';
                        break;
                    case 'S' :
                        if(map[where[0]][where[1]] == '^') {
                            for(int l = where[0]; l >= 0; l--) {
                                if(map[l][where[1]] == '#'){
                                    break;
                                }
                                if(map[l][where[1]] == '*') {
                                    attack = new int[] { l, where[1] };
                                    break;
                                }
                            }
                        } else if(map[where[0]][where[1]] == 'v') {
                            for(int l = where[0]; l < H; l++) {
                                if(map[l][where[1]] == '#'){
                                    break;
                                }
                                if(map[l][where[1]] == '*') {
                                    attack = new int[] { l, where[1] };
                                    break;
                                }
                            }
                        } else if(map[where[0]][where[1]] == '<') {
                            for(int l = where[1]; l >= 0; l--) {
                                if(map[where[0]][l] == '#'){
                                    break;
                                }
                                if(map[where[0]][l] == '*') {
                                    attack = new int[] { where[0], l };
                                    break;
                                }
                            }
                        } else if(map[where[0]][where[1]] == '>') {
                            for(int l = where[1]; l < W; l++) {
                                if(map[where[0]][l] == '#'){
                                    break;
                                }
                                if(map[where[0]][l] == '*') {
                                    attack = new int[] { where[0], l };
                                    break;
                                }
                            }
                        }
                        break;
                }

                if(tmp != null && tank != '0') {
                    if (hasInside(tmp, H, W)) {
                        if (map[tmp[0]][tmp[1]] == '.') {
                            map[where[0]][where[1]] = '.';
                            where = tmp;
                        }
                    }
                    map[where[0]][where[1]] = tank;
                }

                if(attack != null) {
                    map[attack[0]][attack[1]] = '.';
                }
            }

            System.out.printf("#%d ", k+1);
            for(char[] c : map){
                System.out.println(new String(c));
            }
        }
    }
}
