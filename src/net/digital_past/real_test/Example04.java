package net.digital_past.real_test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Example04 {
    static List<int[]> threeValues;
    static boolean[] flag;

    public static void combination(List<Integer> nums, int value, int n, int r){
        if( n == r ){
            for(int i=0;i<n;i++){
                flag[i] = true;
            }
            int[] threeList = new int[3];
            int idx = 0;
            int sum = 0;
            for(int i=0;i<nums.size();i++){
                if(flag[i]) {
                    int val = nums.get(i);
                    threeList[idx++] = val;
                    sum += val;
                }
            }
            for(int i=0;i<n;i++){
                flag[i] = false;
            }
            if(sum == value){
                threeValues.add(threeList);
            }
            return;
        }
        if(r == 1){
            for(int i=0;i<n;i++){
                flag[i] = true;
                int[] threeList = new int[3];
                int idx = 0;
                int sum = 0;
                for(int j=0;j<nums.size();j++){
                    if(flag[j]) {
                        int val = nums.get(j);
                        threeList[idx++] = val;
                        sum += val;
                    }
                }
                if(sum == value){
                    threeValues.add(threeList);
                }
                flag[i] = false;
            }
            return;
        }
        flag[n-1] = true;
        combination(nums, value, n-1,r-1);
        flag[n-1] = false;
        combination(nums, value, n-1,r);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        List<Integer> numList = new ArrayList<Integer>();
        while(st.hasMoreTokens()){
            numList.add(Integer.parseInt(st.nextToken()));
        }
        flag = new boolean[numList.size()];
        int num = Integer.parseInt(br.readLine());
        threeValues = new ArrayList<>();
        Collections.sort(numList);
        combination(numList, num, numList.size(), 3);

        if(threeValues.size() > 0)
            for(int[] arr : threeValues){
                for(int k=0;k<arr.length;k++){
                    if(k != arr.length - 1)
                        System.out.printf("%d ", arr[k]);
                    else
                        System.out.printf("%d", arr[k]);
                }
                System.out.println();
            }
        else
            System.out.println("NO");
    }
}
