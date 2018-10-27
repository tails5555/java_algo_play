package net.winter_coding_2018;

// 100점 나왔음. 그런데 배열 4개를 쓰는 경우에 대해서는 좀...
public class Example02 {
    public static boolean hasInside(int x, int y){
        return (x >= -5 && x <= 5) && (y >= -5 && y <= 5);
    }
    public static int solution(String dirs){
        boolean[][][][] visited = new boolean[11][11][11][11];
        char[] visitArrow = dirs.toCharArray();
        int curX = 0;
        int curY = 0;
        int cnt = 0;
        for(int k=0;k<visitArrow.length;k++){
            int tmpX = curX;
            int tmpY = curY;
            boolean checking = false;
            switch(visitArrow[k]) {
                case 'U' :
                    if(hasInside(tmpX, tmpY + 1)) {
                        curY += 1;
                        checking = true;
                    }
                    break;
                case 'D' :
                    if(hasInside(tmpX, tmpY - 1)) {
                        curY -= 1;
                        checking = true;
                    }
                    break;
                case 'L' :
                    if(hasInside(tmpX - 1, tmpY)) {
                        curX -= 1;
                        checking = true;
                    }
                    break;
                case 'R' :
                    if(hasInside(tmpX + 1, tmpY)) {
                        curX += 1;
                        checking = true;
                    }
                    break;
            }

            if(checking && !visited[curX + 5][curY + 5][tmpX + 5][tmpY + 5] && !visited[tmpX + 5][tmpY + 5][curX + 5][curY + 5]) {
                cnt += 1;
                visited[curX + 5][curY + 5][tmpX + 5][tmpY + 5] = true;
                visited[tmpX + 5][tmpY + 5][curX + 5][curY + 5] = true;
            }
        }
        return cnt;
    }
    public static void main(String[] args){
        System.out.println(solution("ULURRDLLU"));
        System.out.println(solution("LULLLLLLU"));
    }
}
