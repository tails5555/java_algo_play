package net.sw_expert.d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

// 삼성 SW Expert D1 날짜 유효성 검사 문제
public class Main2056 {
    public static String dateCheck(String date) {
        SimpleDateFormat sbt = new SimpleDateFormat("yyyyMMdd");
        sbt.setLenient(false);
        try {
            Date d = sbt.parse(date);
            SimpleDateFormat tmp = new SimpleDateFormat("yyyy/MM/dd");
            return tmp.format(d);
        } catch (Exception Ex) {
            return "-1";
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int k=0;k<T;k++){
            String tmp = br.readLine();
            System.out.println("#" + (k + 1) + " " + dateCheck(tmp));
        }
    }
}
