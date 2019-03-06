package net.leetcode_interview;

public class Solution021 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        else if(l2 == null) return l1;
        else {
            ListNode tmp1 = l1;
            ListNode tmp2 = l2;
            int min = Math.min(tmp1.val, tmp2.val);
            if(tmp1.val == min) {
                tmp1 = tmp1.next;
            } else {
                tmp2 = tmp2.next;
            }

            ListNode list = new ListNode(min);
            ListNode tmp = list;
            while(tmp1 != null && tmp2 != null){
                if(tmp1.val < tmp2.val){
                    tmp.next = new ListNode(tmp1.val);
                    tmp = tmp.next;
                    tmp1 = tmp1.next;
                } else {
                    tmp.next = new ListNode(tmp2.val);
                    tmp = tmp.next;
                    tmp2 = tmp2.next;
                }
            }

            while(tmp1 != null){
                tmp.next = new ListNode(tmp1.val);
                tmp = tmp.next;
                tmp1 = tmp1.next;
            }

            while(tmp2 != null){
                tmp.next = new ListNode(tmp2.val);
                tmp = tmp.next;
                tmp2 = tmp2.next;
            }

            return list;
        }
    }

    public static void main(String[] args){
        ListNode tmp1_0 = new ListNode(1);
        ListNode tmp1_1 = new ListNode(2);
        ListNode tmp1_2 = new ListNode(4);

        tmp1_0.next = tmp1_1;
        tmp1_1.next = tmp1_2;

        ListNode tmp2_0 = new ListNode(1);
        ListNode tmp2_1 = new ListNode(3);
        ListNode tmp2_2 = new ListNode(4);

        tmp2_0.next = tmp2_1;
        tmp2_1.next = tmp2_2;

        ListNode result = mergeTwoLists(tmp1_0, tmp2_0);
        while(result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}
