package net.digital_past.tutorial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Example02 {
    static int[] range = { 500, 100, 50, 10 };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int change = 1000 - Integer.parseInt(input);
        for(int k=0;k<range.length;k++){
            System.out.printf("%d ", change/range[k]);
            change = change % range[k];
        }
    }
}
