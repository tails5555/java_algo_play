package net.sds_academy.type_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution04 {
    static int mininum;
    static short[][] segment;
    static final short[][] SEGMENT_NUMBERS = {
            { 1, 1, 1, 1, 1, 1, 0 },
            { 0, 0, 0, 0, 1, 1, 0 },
            { 1, 0, 1, 1, 0, 1, 1 },
            { 1, 0, 0, 1, 1, 1, 1 },
            { 0, 1, 0, 0, 1, 1, 1 },
            { 1, 1, 0, 1, 1, 0, 1 },
            { 1, 1, 1, 1, 1, 0, 1 },
            { 1, 0, 0, 0, 1, 1, 0 },
            { 1, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 0, 1, 1, 1, 1 },
    };

    public static void dfs(short[][] segment, short[] timeSelect, short index, short broken){
        if(broken < 0) return;
        if(index == -1){
            if(possibleTime(timeSelect)) {
                mininum = Math.min(mininum, timeResult(timeSelect));
                return;
            }
            else return;
        }
        for(short k=0; k<=9; k++){
            short b = difference(segment[index], SEGMENT_NUMBERS[k]);
            if(b <= 2){
                timeSelect[index] = k;
                dfs(segment, timeSelect, (short)(index - 1), (short)(broken-b));
            }
        }
    }

    public static short difference(short[] segment1, short[] segment2){
        short count = 0;
        for(int k=0;k<7;k++){
            if(segment1[k] != segment2[k]) count += 1;
        }
        return count;
    }

    public static boolean possibleTime(short[] timeSelect){
        if(timeSelect[0] >= 3) return false;
        else if(timeSelect[0] == 2){
            if(timeSelect[1] >= 4) return false;
        }
        if(timeSelect[2] >= 6) return false;
        return true;
    }

    public static int timeResult(short[] timeSelect){
        return timeSelect[0]*1000 + timeSelect[1]*100 + timeSelect[2]*10 + timeSelect[3];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        short T = Short.parseShort(br.readLine());
        short[] hourResult = new short[T+1];
        short[] minResult = new short[T+1];
        short[] selector;
        for(short k=1;k<=T;k++) {
            segment = new short[4][7];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(short l=0;l<4;l++){
                for(short m=0;m<7;m++){
                    segment[l][m] = Short.parseShort(st.nextToken());
                }
            }
            selector = new short[4];
            mininum = Integer.MAX_VALUE;
            dfs(segment, selector, (short)3, (short)2);
            hourResult[k] = (short)(mininum / 100);
            minResult[k] = (short)(mininum % 100);
        }

        for(short k=1;k<=T;k++){
            System.out.printf("#%d %d %d\n", k, hourResult[k], minResult[k]);
        }
    }
}
