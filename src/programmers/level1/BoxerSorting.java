package programmers.level1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BoxerSorting {

    public int[] solution(int[] weights, String[] head2head) {
        int[] answer = {};

        List<Boxer> boxerList = IntStream.range(0, weights.length).mapToObj(operand -> {
            String[] head2 = head2head[operand].split("");

            int moreWeightWinCount = 0;
            for(int i = 0 ; i < head2.length; i++) {
                if("W".equals(head2[i]) && (weights[operand] < weights[i]))
                    moreWeightWinCount++;
            }
            double winCount = Arrays.stream(head2).filter(s -> "W".equals(s)).count();
            double loseCount = Arrays.stream(head2).filter(s -> "L".equals(s)).count();

            return new Boxer(operand, (winCount/(winCount+loseCount)) * 100, moreWeightWinCount, weights[operand]);

        }).sorted().collect(Collectors.toList());


        return boxerList.stream().mapToInt(boxer -> boxer.getSeq()).toArray();
    }

    public static class Boxer implements Comparable<Boxer> {
        int seq;
        double winRate;
        int moreWeightWinCount;
        int weight;


        public int getSeq() {
            return this.seq;
        }
        public Boxer(int seq, double winRate, int moreWeightWinCount, int weight) {
            this.seq = seq+1;
            this.winRate = winRate;
            this.moreWeightWinCount = moreWeightWinCount;
            this.weight = weight;
        }

        @Override
        public int compareTo(Boxer o) {
            if(this.winRate < o.winRate) {
                return 1;
            } else if(this.winRate > o.winRate) {
                return -1;
            } else {
                if(this.moreWeightWinCount < o.moreWeightWinCount)
                    return 1;
                else if(this.moreWeightWinCount > o.moreWeightWinCount)
                    return -1;
                else {
                    if(this.weight < o.weight)
                        return 1;
                    else if(this.weight > o.weight)
                        return -1;
                    else {
                        if(this.seq > o.seq)
                            return 1;
                        else if(this.seq < o.seq)
                            return -1;
                    }
                }
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        BoxerSorting boxerSorting = new BoxerSorting();
        int[] weights = new int[]{50,82,75,120};
        String[] head2head = new String[]{"NLWL","WNLL","LWNW","WWLN"};

        System.out.println(boxerSorting.solution(weights, head2head));

    }
}
