package net.line_summer_intern_2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

// LINE 인턴 코딩 테스트 5번 문제 숫자 프린팅
public class Ex05 {
    static class Request {
        int number;
        int width;
        public Request(int number, int width){
            this.number = number;
            this.width = width;
        }
    }

    static boolean[][][] drawMethod = {
        { { true, true, true }, { true, false, true }, { true, false, true }, { true, false, true }, { true, true, true } }, // 0
        { { false, false, true }, { false, false, true }, { false, false, true }, { false, false, true }, { false, false, true } }, // 1
        { { true, true, true }, { false, false, true }, { true, true, true }, { true, false, false }, { true, true, true } }, // 2
        { { true, true, true }, { false, false, true }, { true, true, true }, { false, false, true }, { true, true, true } }, // 3
        { { true, false, true }, { true, false, true }, { true, true, true }, { false, false, true }, { false, false, true } }, // 4
        { { true, true, true }, { true, false, false }, { true, true, true }, { false, false, true }, { true, true, true } }, // 5
        { { true, false, false }, { true, false, false }, { true, true, true }, { true, false, true }, { true, true, true } }, // 6
        { { true, true, true }, { false, false, true }, { false, false, true }, { false, false, true }, { false, false, true } }, // 7
        { { true, true, true }, { true, false, true }, { true, true, true }, { true, false, true }, { true, true, true } }, // 8
        { { true, true, true }, { true, false, true }, { true, true, true }, { false, false, true }, { false, false, true } }, // 9
    };

    public static String drawingRow(int width, boolean left, boolean mid, boolean right) {
        StringBuilder sb = new StringBuilder();
        if(left) {
            sb.append("#");
        } else {
            sb.append(".");
        }

        for(int k=1;k<width-1;k++){
            if(mid){
                sb.append("#");
            } else {
                sb.append(".");
            }
        }

        if(right) {
            sb.append("#");
        } else {
            sb.append(".");
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        String vAlign = st.nextToken();

        List<Request> requests = new ArrayList<>();
        Set<Integer> widths = new HashSet<>();
        int maxWidth = Integer.MIN_VALUE;
        for(int k=0;k<N;k++){
            st = new StringTokenizer(br.readLine(), " ");
            int width = Integer.parseInt(st.nextToken());
            String number = st.nextToken();
            for(char c : number.toCharArray()) {
                requests.add(new Request(c - '0', width));
            }
            maxWidth = Math.max(maxWidth, width);
            widths.add(width);
        }

        Map<Integer, int[]> drawingPivot = new HashMap<>();
        Integer[] tmp = widths.toArray(new Integer[0]);
        for(int k=0;k<tmp.length;k++){
            if(tmp[k] == maxWidth) {
                drawingPivot.put(tmp[k], new int[] { 0, (maxWidth - 1) * 2 });
            } else {
                int mid = maxWidth - 1;
                if(vAlign.equals("TOP")) {
                    drawingPivot.put(tmp[k], new int[] { 0, (tmp[k] - 1) * 2 });
                } else if(vAlign.equals("BOTTOM")) {
                    drawingPivot.put(tmp[k], new int[] { (maxWidth - tmp[k]) * 2, (maxWidth - 1) * 2 });
                } else {
                    drawingPivot.put(tmp[k], new int[] { mid - tmp[k] + 1, mid + tmp[k] - 1 });
                }
            }
        }

        String[] print = new String[maxWidth * 2 - 1];
        for(int k=0;k<print.length;k++){
            print[k] = "";
        }

        for(int k=0;k<print.length;k++){
            Iterator<Request> iter = requests.iterator();
            while(iter.hasNext()) {
                Request req = iter.next();
                int tmpMethod;
                int[] pivot = drawingPivot.get(req.width);
                if(k == pivot[0]) {
                    tmpMethod = 0;
                } else if(k > pivot[0] && k < (pivot[0] + pivot[1]) / 2) {
                    tmpMethod = 1;
                } else if(k == (pivot[0] + pivot[1]) / 2) {
                    tmpMethod = 2;
                } else if(k > (pivot[0] + pivot[1]) / 2 && k < pivot[1]) {
                    tmpMethod = 3;
                } else if(k == pivot[1]){
                    tmpMethod = 4;
                } else {
                    tmpMethod = -1;
                }

                if(tmpMethod != -1) {
                    boolean[] drawer = drawMethod[req.number][tmpMethod];
                    print[k] = print[k] + drawingRow(req.width, drawer[0], drawer[1], drawer[2]) + ((iter.hasNext()) ? " " : "");
                } else {
                    print[k] = print[k] + drawingRow(req.width, false, false, false) + ((iter.hasNext()) ? " " : "");
                }
            }
        }

        for(int k=0;k<print.length;k++){
            System.out.println(print[k]);
        }
    }
}

/*

Case 01.

4 TOP
5 123
3 45
5 7890
3 6

....# ##### ##### #.# ### ##### ##### ##### ##### #..
....# ....# ....# #.# #.. ....# #...# #...# #...# #..
....# ....# ....# ### ### ....# #...# #...# #...# ###
....# ....# ....# ..# ..# ....# #...# #...# #...# #.#
....# ##### ##### ..# ### ....# ##### ##### #...# ###
....# #.... ....# ... ... ....# #...# ....# #...# ...
....# #.... ....# ... ... ....# #...# ....# #...# ...
....# #.... ....# ... ... ....# #...# ....# #...# ...
....# ##### ##### ... ... ....# ##### ....# ##### ...

Case 02.

4 MIDDLE
5 123
3 45
5 7890
3 6

....# ##### ##### ... ... ##### ##### ##### ##### ...
....# ....# ....# ... ... ....# #...# #...# #...# ...
....# ....# ....# #.# ### ....# #...# #...# #...# #..
....# ....# ....# #.# #.. ....# #...# #...# #...# #..
....# ##### ##### ### ### ....# ##### ##### #...# ###
....# #.... ....# ..# ..# ....# #...# ....# #...# #.#
....# #.... ....# ..# ### ....# #...# ....# #...# ###
....# #.... ....# ... ... ....# #...# ....# #...# ...
....# ##### ##### ... ... ....# ##### ....# ##### ...

Case 03.

4 BOTTOM
5 123
3 45
5 7890
3 6

....# ##### ##### ... ... ##### ##### ##### ##### ...
....# ....# ....# ... ... ....# #...# #...# #...# ...
....# ....# ....# ... ... ....# #...# #...# #...# ...
....# ....# ....# ... ... ....# #...# #...# #...# ...
....# ##### ##### #.# ### ....# ##### ##### #...# #..
....# #.... ....# #.# #.. ....# #...# ....# #...# #..
....# #.... ....# ### ### ....# #...# ....# #...# ###
....# #.... ....# ..# ..# ....# #...# ....# #...# #.#
....# ##### ##### ..# ### ....# ##### ....# ##### ###

 */