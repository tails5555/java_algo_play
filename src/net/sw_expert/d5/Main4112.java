package net.sw_expert.d5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

// SW Expert D5 Yee상한 피라미드 탐험 문제 풀이
public class Main4112 {
    public static void main(String[] args) throws IOException {
        int sum = 0;
        int[] dist = new int[151];
        for(int k = 1; k <= 150; k++){
            sum += k;
            dist[k] = sum;
        }
        System.out.println(Arrays.toString(dist));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int k = 0; k < T; k++){
            st = new StringTokenizer(br.readLine(), " ");

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if(start == end) {
                System.out.printf("#%d %d\n", k+1, 0);
            } else {
                int sIdx = 0;
                while (start > dist[sIdx]) {
                    sIdx += 1;
                }

                int eIdx = 1;
                while (end > dist[eIdx]) {
                    eIdx += 1;
                }

                if(sIdx == eIdx){
                    System.out.printf("#%d %d\n", k+1, Math.abs(start - end));
                } else {
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[] { start, sIdx, 0 });

                    Set<Integer> set = new HashSet<>();
                    set.add(start);

                    int res = Integer.MAX_VALUE;
                    while(!queue.isEmpty()) {
                        int[] tmp = queue.poll();
                        if(tmp[0] == end) {
                            res = Math.min(res, tmp[2]);
                        }

                        int side_left = tmp[0] - 1;
                        if(side_left > dist[tmp[1] - 1] && side_left <= dist[tmp[1]] && !set.contains(side_left)) {
                            queue.offer(new int[] { side_left, tmp[1], tmp[2] + 1 });
                            set.add(side_left);
                        }

                        int side_right = tmp[0] + 1;
                        if(side_right > dist[tmp[1] - 1] && side_right <= dist[tmp[1]] && !set.contains(side_right)) {
                            queue.offer(new int[] { side_right, tmp[1], tmp[2] + 1 });
                            set.add(side_right);
                        }

                        if(tmp[1] > 1) {
                            int cross_top_left = tmp[0] - tmp[1];
                            if (cross_top_left > dist[tmp[1] - 2] && cross_top_left <= dist[tmp[1] - 1] && !set.contains(cross_top_left)) {
                                queue.offer(new int[]{cross_top_left, tmp[1] - 1, tmp[2] + 1});
                                set.add(cross_top_left);
                            }

                            int cross_top_right = tmp[0] - tmp[1] + 1;
                            if (cross_top_right > dist[tmp[1] - 2] && cross_top_right <= dist[tmp[1] - 1] && !set.contains(cross_top_right)) {
                                queue.offer(new int[]{cross_top_right, tmp[1] - 1, tmp[2] + 1});
                                set.add(cross_top_right);
                            }
                        }

                        if(tmp[1] < 148) {
                            int cross_bottom_left = tmp[0] + tmp[1];
                            if (cross_bottom_left > dist[tmp[1]] && cross_bottom_left <= dist[tmp[1] + 1] && !set.contains(cross_bottom_left)) {
                                queue.offer(new int[]{ cross_bottom_left, tmp[1] + 1, tmp[2] + 1 });
                                set.add(cross_bottom_left);
                            }
                            int cross_bottom_right = tmp[0] + tmp[1] + 1;
                            if (cross_bottom_right > dist[tmp[1]] && cross_bottom_right <= dist[tmp[1] + 1] && !set.contains(cross_bottom_right)) {
                                queue.offer(new int[]{ cross_bottom_right, tmp[1] + 1, tmp[2] + 1 });
                                set.add(cross_bottom_right);
                            }
                        }
                    }

                    System.out.printf("#%d %d\n", k + 1, res);
                }
            }
        }
    }
}
