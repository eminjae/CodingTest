package programmers;

import java.util.*;
import java.util.StringTokenizer;

public class JustSong {
    public String solution(String m, String[] musicinfos) {

        String answer = "(None)";

        List<String> result = new ArrayList<>();
        HashMap<String, Integer> timeMap = new HashMap<>();

        String convertM = m.replaceAll("C#","c").replaceAll("D#","d").replaceAll("F#","f")
                .replaceAll("G#","g").replaceAll("A#","a");

        for (int i = 0; i < musicinfos.length; i++) {
            String[] music = musicinfos[i].split(",");

            String startTime = music[0];
            String endTime = music[1];
            String title = music[2];
            String info = music[3].replaceAll("C#","c").replaceAll("D#","d").replaceAll("F#","f")
                    .replaceAll("G#","g").replaceAll("A#","a");

            String startMinute = startTime.split(":")[1];
            String endMinute = endTime.split(":")[1];
            String startHour = startTime.split(":")[0];
            String endHour = endTime.split(":")[0];

            int hearingTime = (Integer.parseInt(endMinute) - Integer.parseInt(startMinute)) >= 0 ?
                    Integer.parseInt(endMinute) - Integer.parseInt(startMinute) + (Integer.parseInt(endHour) - Integer.parseInt(startHour))*60
                    : (Integer.parseInt(endHour) - Integer.parseInt(startHour) -1)*60 + 60 + Integer.parseInt(endMinute) - Integer.parseInt(startMinute) ;

            timeMap.put(title, hearingTime);
            StringBuffer totalHearingMusic = new StringBuffer();

            for (int j = 0; j < hearingTime; j++) {
                int index = j % info.length();

                totalHearingMusic.append(info.charAt(index));
            }

            if(totalHearingMusic.toString().contains(convertM)){
                result.add(title);
            }


        }
        if(result.size() == 0)
            return answer;
        else {
            int max = 0;
            for(int i = 0; i < result.size(); i++){

                max = Math.max(max, timeMap.get(result.get(i)));
            }
            int check = 0;
            List<String> temp = new ArrayList<>();

            for(String key : timeMap.keySet()){
                if(timeMap.get(key).equals(max)){
                    check++;
                    temp.add(key);
                }
            }
            if(check > 1){
                for(int i = 0 ; i < result.size(); i++){
                    if(temp.contains(result.get(i))){
                        answer = result.get(i);
                        break;
                    }
                }
            }
            else answer = temp.get(0);
            return answer;
        }

    }

    public static void main(String[] args) {
        JustSong justSong = new JustSong();

        String m = "ABCDEFG";
        String m1 = "C#BCC#BCC#BCC#B";
        String m2 = "ABC";
        String[] array = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        String[] array1 = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
        String[] array2 = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};


        System.out.println(justSong.solution(m, array));
        System.out.println(justSong.solution(m1, array1));
        System.out.println(justSong.solution(m2, array2));


    }
}
