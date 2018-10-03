package net.digital_past.real_test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Example02 {
    public static int toDecimal(int[] arr){
        int num = 0;
        for(int k=0;k<arr.length;k++){
            num += arr[k] * (int) Math.pow(10, arr.length - k - 1);
        }
        return num;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int size = Integer.parseInt(st.nextToken());
        int[] maximum = new int[size];
        int[] current = new int[size];
        st = new StringTokenizer(br.readLine(), " ");
        int idx = 0;
        while(st.hasMoreTokens()){
            maximum[idx++] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        idx = 0;
        while(st.hasMoreTokens()){
            current[idx++] = Integer.parseInt(st.nextToken());
        }
        int move = Integer.parseInt(br.readLine());
        boolean nonValidate = false;
        for(int k=0;k<size;k++){
            if(current[k] > maximum[k]) {
                nonValidate = true;
                break;
            }
        }
        if(!nonValidate) {
            for (int k = 0; k < move; k++) {
                int digit = 1;
                while (true) {
                    if (digit > size) break;
                    current[size - digit] = (current[size - digit] + 1) % (maximum[size - digit] + 1);
                    if (current[size - digit] == 0) {
                        digit = digit + 1;
                    } else {
                        break;
                    }
                }
            }
        }
        System.out.println(!nonValidate ? toDecimal(current) : -1);
    }
}
