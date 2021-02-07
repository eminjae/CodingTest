package programmers;
import java.util.*;

public class ColoringBook {


    public int[] solution(int m, int n, int[][] picture) {

        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        int[][] visited = new int[m][n];
        int max = 0;
        int total = 0;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ;j < n; j++){
                if(picture[i][j] == 0 || visited[i][j] !=0)
                    continue;
                total++;
                Queue<Integer> qx = new LinkedList<>();
                Queue<Integer> qy = new LinkedList<>();
                int cnt = 1;
                qx.add(i);
                qy.add(j);

                visited[i][j] = 1;
                while(!qx.isEmpty() && !qy.isEmpty()){
                    int x = qx.poll();
                    int y = qy.poll();

                    for(int k = 0 ;k < 4; k++){
                        int tempX = x + dx[k];
                        int tempY = y + dy[k];
                        if(tempX < 0 || tempX >= m) continue;
                        if(tempY < 0 || tempY >= n) continue;
                        if(picture[tempX][tempY] == 0 || visited[tempX][tempY] !=0) continue;

                        if(picture[x][y] == picture[tempX][tempY]){
                            visited[tempX][tempY] = 1;
                            qx.add(tempX);
                            qy.add(tempY);
                            cnt++;
                        }
                    }
                }
                max = Math.max(max,cnt);
            }
        }

        int[] answer = new int[2];
        answer[0] = total;
        answer[1] = max;
        return answer;
    }

    public static void main(String[] args){
        int m = 6;
        int n = 4;
        int[][] array = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
//
//        int[] result = new Test().solution(m,n,array);
//        System.out.println(result[0]);
//        System.out.println(result[1]);

        int[][] array2 = {{1, 1, 1, 0}, {1, 1, 1, 0}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}};
        int[] result2 = new Test().solution(13, 16,
               new int[][] {{0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                        {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0}, {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
        {0, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 0}, {0, 1, 1, 1, 2, 1, 2, 1, 1, 2, 1, 2, 1, 1, 1, 0},
    {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0}, {0, 1, 3, 3, 3, 1, 1, 1, 1, 1, 1, 3, 3, 3, 1, 0},
        {0, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 0}, {0, 0, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 0, 0},
        {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0}});
        System.out.println(result2[0]);
        System.out.println(result2[1]);

//        (2, 2, { { 1, 1 }, { 0, 1 } }) => 1, 3
//
//        (6, 4, { { 1, 1, 1, 0 }, { 1, 2, 2, 0 }, { 1, 0, 0, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 3 }, { 0, 0, 0, 3 } }) => 4, 5
//
//        (6, 4, { { 1, 0, 0, 1 }, { 1, 0, 0, 1 }, { 1, 0, 0, 1 }, { 1, 0, 0, 1 }, { 1, 0, 0, 1 }, { 1, 1, 1, 1 } }) => 1, 14
//
//        (1, 1, { { 0 } }) => 0, 0
//
//        (4, 4, { { 1, 1, 1, 1 }, { 1, 4, 1, 1 }, { 1, 3, 2, 1 }, { 1, 1, 1, 1 } }) => 12, 120
    }
}
