package programmers;

public class StringCompression {

    public int solution(String s) {

        int size = s.length();
        int splitSize = 0;
        int min = 1000;

        while(splitSize < size/2){
            StringBuilder sb = new StringBuilder();
            splitSize++;

            for(int i = 0 ; i < s.length(); i++){
                if(i+splitSize >= s.length()) break;
                String current = s.substring(i, i+splitSize);

                int cnt = 1;
                boolean checkIfEqual = false;
                for(int j = i+splitSize; j < s.length();){
                    if(j+splitSize >= s.length()) break;
                    String later = s.substring(j,j+splitSize);
                    if(current.equals(later)){
                        cnt++;
                        checkIfEqual = true;
                    }else {
                        break;
                    }
                    j = j + splitSize;
                }
                if(checkIfEqual == true){
                    sb.append(Integer.toString(cnt) + current);
                    i = i + splitSize;
                }else {
                    sb.append(current);
                }

            }
            min = Math.min(min, sb.length());

        }
        int answer = min;
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(new StringCompression().solution("aabbaccc"));
        System.out.println(new StringCompression().solution("ababcdcdababcdcd"));
        System.out.println(new StringCompression().solution("abcabcdede"));
        System.out.println(new StringCompression().solution("abcabcabcabcdededededede"));
        System.out.println(new StringCompression().solution("xababcdcdababcdcd"));
    }
}
