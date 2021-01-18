package programmers;

import java.util.Arrays;

public class PhoneNumberList {

    public boolean solution(String[] phone_book) {

        boolean answer = true;


        Arrays.sort(phone_book);

        Loop1 :
        for(int i = 0 ; i < phone_book.length; i++){
            String standPhoneNumber = phone_book[i];

            for(int j = i+1 ; j < phone_book.length; j++){
                if(standPhoneNumber.length() > phone_book[j].length()){
                    continue;
                }
                String splitPhoneNumber = phone_book[j].substring(0, standPhoneNumber.length());

                if(standPhoneNumber.equals(splitPhoneNumber)){
                    answer = false;
                    break Loop1;
                }


            }
        }

        return answer;
    }
    public static void main(String[] args){
        PhoneNumberList phoneNumberList = new PhoneNumberList();

        System.out.println(phoneNumberList.solution(new String[] {"1235","12","123"}));
    }

}
