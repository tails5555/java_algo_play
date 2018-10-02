package net.digital_past.tutorial;

import java.util.Scanner;

public class Example01 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String tmp = s.nextLine();
        System.out.println(tmp.replaceAll("\\s", ""));
    }
}
