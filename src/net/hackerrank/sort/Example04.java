package net.hackerrank.sort;

// Hacker Rank Sorting 문제
// Fraudulent Activity Notifications 문제
// 중앙 값 찾는 시간 복잡도를 줄이는 방법을 물었던 좋은 문제.
// 이 문제를 통해 우선 순위 큐를 이용해서 중앙 값을 찾는 방법을 더욱 고려할 필요가 있음.
public class Example04 {
    static int activityNotifications(int[] expenditure, int d) {
        int[] count = new int[201];
        for(int k = 0; k < d; k++){
            count[expenditure[k]] += 1;
        }

        int notification = 0;
        for(int k = d; k < expenditure.length; k++){
            int lower = 0;
            int leftNum = 0;
            while ((leftNum + count[lower]) * 2 <= d) {
                leftNum += count[lower];
                lower++;
            }

            int upper = count.length - 1;
            int rightNum = 0;
            while ((rightNum + count[upper]) * 2 <= d) {
                rightNum += count[upper];
                upper--;
            }

            if (expenditure[k] >= lower + upper) {
                notification++;
            }

            count[expenditure[k - d]]--;
            count[expenditure[k]]++;
        }

        return notification;
    }

    public static void main(String[] args){
        System.out.println(activityNotifications(new int[] { 2, 3, 4, 2, 3, 6, 8, 4, 5 }, 5));
        System.out.println(activityNotifications(new int[] { 1, 2, 3, 4, 4 }, 4));
        System.out.println(activityNotifications(new int[] { 10, 20, 30, 40, 50 }, 3));
    }
}
