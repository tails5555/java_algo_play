package net.baekjoon.implement;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main14405 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String msg = s.nextLine();

        msg = msg.replaceAll("pi|ka|chu", "");

        if(Pattern.matches("^[a-z]+", msg))
            System.out.println("NO");
        else
            System.out.println("YES");
    }
}
