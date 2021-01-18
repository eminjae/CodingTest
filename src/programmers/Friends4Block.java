package programmers;

import java.util.*;

public class Friends4Block {

    public int solution(int m, int n, String[] board) {
        int answer = 0;

        int[] dx = {1, 0, 1};
        int[] dy = {0, 1, 1};
        String[][] map = new String[m][n];
        int[][] blankMap = new int[m][n];


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = String.valueOf(board[i].charAt(j));
            }
        }

        boolean checkBumb = true;
        while (checkBumb) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if(map[i][j].equals("#"))
                        blankMap[i][j] = 0;
                    else blankMap[i][j] = 1;
                }
            }

            checkBumb = false;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int cntBumb = 0;
                    String temp = map[i][j];
                    for (int k = 0; k < 3; k++) {
                        if ((i + dx[k]) >= m || (j + dy[k]) >= n) break;
                        if (!temp.equals("#") && temp.equals(map[i + dx[k]][j + dy[k]])) {
                            cntBumb++;
                        }
                    }
                    if (cntBumb == 3) {
                        checkBumb = true;
                        blankMap[i][j] = 2;
                        for (int k = 0; k < 3; k++) {
                            blankMap[i + dx[k]][j + dy[k]] = 2;
                        }
                    }

                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (blankMap[i][j] == 2) {
                        map[i][j] = "#";
                    }

                }
            }
            for (int j = 0; j < n; j++) {
                for (int i = m-1; i >= 0; i--) {
                    if(map[i][j].equals("#")){
                        int temp = 1;
                        while(i-temp>=0){
                            if(!map[i-temp][j].equals("#")){
                                map[i][j] = map[i-temp][j];
                                map[i-temp][j] = "#";
                                break;
                            }
                            temp++;
                        }
                    }
                }
            }

        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (map[i][j].equals("#"))
                    answer++;
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        Friends4Block friends4Block = new Friends4Block();

        String[] str = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
        System.out.println(friends4Block.solution(6, 6, str));
    }

}
