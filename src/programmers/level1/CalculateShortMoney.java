package programmers.level1;

public class CalculateShortMoney {
    public long solution(int price, int money, int count) {
        long answer = 0;

        for(int i = 1 ; i <= count; i++) {
            answer = answer + (price * i);
        }
        return money > answer ? 0 : Math.abs(answer-money);
    }
}
