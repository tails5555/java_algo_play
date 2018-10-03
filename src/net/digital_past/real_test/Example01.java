package net.digital_past.real_test;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Example01 {

    static String getStringInDate(String message){
        Matcher matcher;
        if (message.isEmpty()) {
            matcher = null;
            return null;
        } else {
            String patternStr = "(\\d{2,4})[-/년]*([1-9]|0[1-9]|1[012])[-/월]*(\\d{1,2})[일]*";

            int flags = Pattern.MULTILINE | Pattern.CASE_INSENSITIVE;
            Pattern pattern = Pattern.compile(patternStr, flags);
            matcher = pattern.matcher(message);
            System.out.println(matcher.group(1));
            while (matcher.find()) {
                return matcher.group();
            }
        }
        return null;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> articles = new ArrayList<String>();
        while(true) {
            String tmpStr = br.readLine();
            if(tmpStr.equals("END")) break;
            else articles.add(tmpStr);
        }

        System.out.println(articles);
        for(int k=0;k<articles.size();k++){
            String date = getStringInDate(articles.get(k));
            System.out.println(date);
        }
    }
}
