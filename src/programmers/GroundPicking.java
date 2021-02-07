package programmers;

public class GroundPicking {


    int solution(int[][] land) {
        int answer = 0;

        int columnCnt = land.length;

        int[][] dp = land.clone();

        for(int i = 1 ;i < columnCnt; i++){
            dp[i][0] += Math.max(dp[i-1][1], Math.max(dp[i-1][2], dp[i-1][3]));
            dp[i][1] += Math.max(dp[i-1][0], Math.max(dp[i-1][2], dp[i-1][3]));
            dp[i][2] += Math.max(dp[i-1][1], Math.max(dp[i-1][0], dp[i-1][3]));
            dp[i][3] += Math.max(dp[i-1][1], Math.max(dp[i-1][2], dp[i-1][0]));

        }
        for(int i = 0 ;i < 4; i++){
            answer = Math.max(dp[columnCnt-1][i],answer);
        }
        return answer;
    }

    public static void main(String[] args){
        int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};

        System.out.println(new GroundPicking().solution(land));
    }
}
