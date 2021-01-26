package programmers;

public class Snail {
    public int[] solution(int n) {

        int[][] map = new int[n][n];
        int[] dx = {1, 0, -1};
        int[] dy = {0, 1, -1};

        int total = n * (n+1) / 2;
        int cnt = 1;
        int x = 0;
        int y = 0;
        map[0][0] = cnt;
        int direction = 0;
        while(true){
            if(cnt>=total) break;
            direction = direction == 3 ? 0 : direction;

            x += dx[direction];
            y += dy[direction];
            if( x >= n || y >= n || map[x][y] != 0) {
                x -= dx[direction];
                y -= dy[direction];
                direction++;
                continue;
            }
            cnt++;
            map[x][y] = cnt;

        }
        int[] answer = new int[total];
        int index = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ;j++){
                if(map[i][j]!=0){
                    answer[index] = map[i][j];
                    index++;
                }
            }
        }

        return answer;
    }
}
