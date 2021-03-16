package programmers;

import java.util.regex.Pattern;
import java.util.*;
import java.util.stream.Collectors;

public class FileSort {
    public String[] solution(String[] files) {


        List<FileNm> fileNms = new ArrayList<>();

        for(int i = 0 ; i < files.length; i++){
            String fileName = files[i];
            StringBuffer header = new StringBuffer();
            StringBuffer number = new StringBuffer();
            StringBuffer tail = new StringBuffer();
            boolean numberCheck = false;
            for(int j = 0 ; j  < fileName.length(); j++){
                String temp = String.valueOf(fileName.charAt(j));

                if(Pattern.matches("^[0-9]*$",temp)){
                    number.append(temp);
                    numberCheck = true;
                }else {
                    if(numberCheck == true){
                        tail.append(fileName.substring(j));
                        break;
                    }
                    header.append(temp);
                }

            }
            fileNms.add(new FileNm(header.toString(), number.toString(), tail.toString()));

        }
        String[] answer = new String[files.length];
        List<FileNm> result = new ArrayList<>();

        result = fileNms.stream().sorted(Comparator.comparing((FileNm f)->f.head.toLowerCase())
                .thenComparing((FileNm f)-> Integer.parseInt(f.number))).collect(Collectors.toList());

        for(int i = 0 ;i < answer.length; i++){
            answer[i] = result.get(i).head + result.get(i).number + result.get(i).tail;
        }
        return answer;
    }
    public static void main(String[] args){
        FileSort fileSort = new FileSort();
        String[] array = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        String[] array1 = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
        System.out.println(Arrays.toString(fileSort.solution(array)));
        System.out.println(Arrays.toString(fileSort.solution(array1)));
    }
}
class FileNm{
    String head;
    String number;
    String tail;

    FileNm(String head, String number, String tail){
        this.head = head;
        this.number = number;
        this.tail = tail;
    }
}
