package net.digital_past.tutorial;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Example03 {
    public static int binarySearch(int[] arr, int value){
        int start = 0;
        int end = arr.length - 1;
        int mid;
        while(start <= end){
            mid = (start + end) / 2;
            if(value == arr[mid]) return mid;
            else if(value > arr[mid]) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int[] arr = new int[Integer.parseInt(input)];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int k=0;k<Integer.parseInt(input);k++){
            arr[k] = Integer.parseInt(st.nextToken());
        }
        String found = br.readLine();
        int result = binarySearch(arr, Integer.parseInt(found));
        System.out.println(result == -1 ? "X" : result + 1);
    }
}
