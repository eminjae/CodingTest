package programmers.level1;

import java.util.Arrays;
import java.util.OptionalInt;

public class MutualEvaluation {
    public String solution(int[][] scores) {

        int[][] transScores = new int[scores[0].length][scores.length];

        for(int i = 0; i < scores.length; i++) {
            for(int j= 0 ; j < scores[i].length; j++) {
                transScores[j][i] = scores[i][j];
            }
        }
        String answer = "";

        for(int i = 0 ; i < transScores.length; i++) {
            int max = Arrays.stream(transScores[i]).max().getAsInt();
            int min = Arrays.stream(transScores[i]).min().getAsInt();

            int sameMaxCount = (int) Arrays.stream(transScores[i]).filter(score -> score == max).count();
            int sameMinCount = (int) Arrays.stream(transScores[i]).filter(score -> score == min).count();

            int cnt = 0;
            int totalScore = 0;
            for(int j = 0 ; j < transScores[i].length; j++) {
                int score = transScores[i][j];
                if(i==j) {
                    if(isMaxOrMinTarget(score, max, sameMaxCount)) continue;
                    if(isMaxOrMinTarget(score, min, sameMinCount)) continue;
                }
                cnt++;
                totalScore += score;
            }
            answer += getGrade(totalScore/cnt);

        }
        return answer;
    }
    public boolean isMaxOrMinTarget(int score, int value, int sameCount) {
        return (score == value) && (sameCount ==1);
    }

    public String getGrade(int score) {
        if(score >= 90) return "A";
        else if(score >= 80) return "B";
        else if(score >= 70) return "C";
        else if(score >= 50) return "D";
        else return "F";
    }

    public static void main(String[] args) {
        MutualEvaluation mutualEvaluation = new MutualEvaluation();


        int[][] scores = new int[][]{{70,49,90},{68,50,38},{73,31,100}};
        System.out.println(mutualEvaluation.solution(scores));

        int[][] scores2 = new int[][]{{50,90},{50,87}};
        System.out.println(mutualEvaluation.solution(scores2));

        int[][] scores3 = new int[][]{{100,90,98,88,65},{50,45,99,85,77},{47,88,95,80,67},{61,57,100,80,65},{24,90,94,75,65}};
        System.out.println(mutualEvaluation.solution(scores3));

    }
}
