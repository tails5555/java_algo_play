package net.skhu.shakespeare;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Solution01 {
    static Map<String, Integer> wordCount = new HashMap<String, Integer>();
    static int result = 0;
    public static void counting(String line){
        String[] words = line.split("\\s");
        for(int k=0;k<words.length;k++){
            if(!words[k].equals("")) {
                if (!wordCount.containsKey(words[k].toLowerCase())) {
                    wordCount.put(words[k].toLowerCase(), 1);
                } else {
                    int current = wordCount.get(words[k].toLowerCase());
                    wordCount.put(words[k].toLowerCase(), current + 1);
                }
                result++;
            }
        }
    }
    public static Map<String, Integer> sortByValue(Map<String, Integer> unsortedMap){
        List<Entry<String, Integer>> list = new LinkedList<>(unsortedMap.entrySet());
        Collections.sort(list, (o1, o2) -> {
            return (!o1.getValue().equals(o2.getValue())) ? o1.getValue().compareTo(o2.getValue()) * (-1) : o1.getKey().compareTo(o2.getKey()) * (-1);
        });
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for(int k=0;k<10;k++){
            sortedMap.put(list.get(k).getKey(), list.get(k).getValue());
        }
        return sortedMap;
    }
    public static void main(String[] args){
        long startTime = System.currentTimeMillis();
        String path = Solution01.class.getResource("").getPath();
        File file = new File(path+"shakespeare.txt");
        try(FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);){
            String line = "";
            while((line = bufferedReader.readLine()) != null){
                String removeMultipleSpace = "\\s{2,}";
                line = line.replaceAll(removeMultipleSpace, " ");
                String removeCharacter = "[^a-zA-Z\\s]";
                line = line.replaceAll(removeCharacter, " ");
                counting(line);
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }

        System.out.println(wordCount);

        Map<String, Integer> sortMap = sortByValue(wordCount);
        System.out.println(result);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
    }
}
