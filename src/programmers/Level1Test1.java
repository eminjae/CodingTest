package programmers;

public class Level1Test1 {
    public static String solution(String s, int n) {

        String[] str = s.split("");
        String answer = "";
        for(int i = 0 ; i < str.length ; i++){
            int code = (int) str[i].charAt(0);
            int temp = 0;
            if(code >= 97 && code <= 122){
                temp = code + n;
                char ch = temp > 122 ? (char) ((char) 97 + (temp-122-1)) : (char) temp;
                answer += ch;
            } else if(code >=65 && code <=90){
                temp = code + n;
                char ch = temp > 90 ? (char) ((char) 65 + (temp-90-1)) : (char) temp;
                answer += ch;
            } else {
                answer += " ";
            }
        }

        return answer;
    }

    public static void main(String[] args){
        int a = (int) 'a';
        int A = (int) 'A';
        int z = (int) 'z';
        int Z = (int) 'Z';


        System.out.println(a); //97
        System.out.println(z); //122
        System.out.println(A);  //65
        System.out.println(Z); //90



        System.out.println(solution("a B z",4));

    }
}
