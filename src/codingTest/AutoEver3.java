package codingTest;

public class AutoEver3 {
    public String solution(int number) {
        String temp = Integer.toString(number);
        String answer =
                temp.replaceAll("0", "zero")
                        .replaceAll("1", "one")
                        .replaceAll("2", "two")
                        .replaceAll("3", "three")
                        .replaceAll("4", "four")
                        .replaceAll("5", "five")
                        .replaceAll("6", "six")
                        .replaceAll("7", "seven")
                        .replaceAll("8", "eight")
                        .replaceAll("9", "nine");
        return answer;
    }
    public static void main(String[] args) {

    }
}
