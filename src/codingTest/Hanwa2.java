package codingTest;

import java.util.*;

public class Hanwa2 {
    public String[] solution(String[] rooms, int target){

        List<String> newRoomList = new ArrayList<>();
        List<String> nameSeq = new ArrayList<>();
        //자리 있으면
        List<String> extractPerson = new ArrayList<>();

        for(int i = 0 ; i < rooms.length; i++){
           String room = rooms[i].substring(rooms[i].indexOf('[')+1,rooms[i].indexOf(']'));
            if (!room.equals(String.valueOf(target)))
            {
                newRoomList.add(rooms[i]);
            }else {
                String extractPeople = rooms[i].substring(rooms[i].indexOf(']')+1, rooms[i].length());
                String[] splitExtractPeople = extractPeople.split(",");
                for(int j = 0 ; j < splitExtractPeople.length; j++){
                    extractPerson.add(splitExtractPeople[j]);
                }
            }
        }
        for(int i =0 ; i < extractPerson.size(); i++){
            for(int j = 0 ; j <newRoomList.size(); j++){
                newRoomList.set(j,newRoomList.get(j).replaceAll(extractPerson.get(i)+",",""));
                newRoomList.set(j,newRoomList.get(j).replaceAll(extractPerson.get(i),""));

            }
        }
        HashMap<String, Integer> param = new HashMap<>();
        HashMap<String, Integer> absParam = new HashMap<>();
        List<String> result = new ArrayList<>();

        //자리가 제일 적은 우선순위 높다
        for(int i = 0 ; i < newRoomList.size(); i++){
            String roomNumber = newRoomList.get(i).substring(newRoomList.get(i).indexOf('[')+1,newRoomList.get(i).indexOf(']'));
            String people = newRoomList.get(i).substring(newRoomList.get(i).indexOf("["+roomNumber+"]")+roomNumber.length()+2);
            int abs = Math.abs(target-Integer.parseInt(roomNumber));

            if(people.contains(",")){
                String[] temp = people.split(",");
                for(String s : temp){
                    nameSeq.add(s);
                    if(!absParam.containsKey(s)) absParam.put(s,abs);
                    else absParam.put(s,Math.min(abs, absParam.get(s)));

                    if(!param.containsKey(s))
                        param.put(s,1);
                    else
                        param.put(s,param.get(s)+1);
                }
            }else {
                nameSeq.add(people);
                if(!absParam.containsKey(people)) absParam.put(people,abs);
                else absParam.put(people,Math.min(abs, absParam.get(people)));

                if(!param.containsKey(people))
                    param.put(people,1);
                else
                    param.put(people,param.get(people)+1);
            }
        }
        List<String> keySetList = new ArrayList<>(param.keySet());
        Collections.sort(keySetList, (o1, o2) -> (param.get(o1).compareTo(param.get(o2))));

        List<String> answer = new ArrayList<>();

        Collections.sort(nameSeq);
        for(int i = 0 ; i < keySetList.size()-1; i++){
            String currentKey = keySetList.get(i);
            String nextKey = keySetList.get(i+1);
            int currentValue = param.get(currentKey);
            int nextValue = param.get(nextKey);

            if(currentValue != nextValue){
                answer.add(currentKey);
            }else {
                List<String> tempKey = new ArrayList<>();
                tempKey.add(currentKey);
                tempKey.add(nextKey);
                int index = i;
                while(currentValue == nextValue){
                    index++;
                    currentKey = keySetList.get(index);
                    nextKey = keySetList.get(index+1);
                    tempKey.add(nextKey);
                }
                int currentAbs = absParam.get(currentKey);
                int nextAbs = absParam.get(nextKey);
                if(currentAbs > nextAbs) {
                    answer.add(nextKey);
                    answer.add(currentKey);
                }else if(currentAbs < nextAbs) {
                    answer.add(currentKey);
                    answer.add(nextKey);
                }else {
                    if(nameSeq.indexOf(currentKey) > nameSeq.indexOf(nextKey)){
                        answer.add(nextKey);
                        answer.add(currentKey);
                    }else {
                        answer.add(currentKey);
                        answer.add(nextKey);
                    }
                }
            }

        }
        answer.add(keySetList.get(keySetList.size()-1));

        return null;
    }
    public static void main(String[] args){
//        String temp = "[403]James";
//        String roomNumber = temp.substring(temp.indexOf('[')+1,temp.indexOf(']'));
//        String t = temp.substring(temp.indexOf("["+roomNumber+"]")+roomNumber.length()+2);
//
//
//        System.out.println(roomNumber);
//        System.out.println(t);


       System.out.println(new Hanwa2().solution(new String[]{"[403]James", "[404]Azad,Louis,Andy", "[101]Azad,Guard"},403));
       System.out.println(new Hanwa2().solution(new String[]{"[101]Azad,Guard", "[202]Guard", "[303]Guard,Dzaz"},202));
       System.out.println(new Hanwa2().solution(new String[]{"[1234]None,Of,People,Here","[5678]Wow"},1234));
    }
}
