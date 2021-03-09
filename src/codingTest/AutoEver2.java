package codingTest;

public class AutoEver2 {

    public String solution(String s) {

        StringBuffer result = new StringBuffer();
        buttonRecursion(1, s.length(),String.valueOf(s.charAt(0)), String.valueOf(s.charAt(1)), 0, s, result );
        return result.toString();

    }
    public void buttonRecursion(int dept, int endPoint, String previousStr, String currentStr,
                                int selectedCnt, String input, StringBuffer result){
        if(dept == endPoint-1){
            if(currentStr.equals(previousStr)){
                result.append(mappingNumber(currentStr, selectedCnt+1));
            } else {
                result.append(mappingNumber(previousStr, selectedCnt));
                result.append(mappingNumber(currentStr, 0));
            }
            return;
        }


        if(currentStr.equals(previousStr)){
            buttonRecursion(dept+1, endPoint, String.valueOf(input.charAt(dept)),
                    String.valueOf(input.charAt(dept+1)), selectedCnt+1, input, result);
        }else {
            result.append(mappingNumber(previousStr, selectedCnt));
            buttonRecursion(dept+1, endPoint, String.valueOf(input.charAt(dept)),
                    String.valueOf(input.charAt(dept+1)), 0, input, result);
        }

    }
    public String mappingNumber(String number, int index){

        String[] one = {".", "Q", "Z"};
        String[] two = {"A", "B", "C"};
        String[] three = {"D", "E", "F"};
        String[] four = {"G" , "H", "I"};
        String[] five = {"J", "K", "L"};
        String[] six = {"M", "N", "O"};
        String[] seven = {"P", "R", "S"};
        String[] eight = {"T", "U", "V"};
        String[] nine = {"W", "X", "Y"};
        StringBuffer sb = new StringBuffer();

        switch (number){
            case "1":
                sb.append(one[index]);
                break;
            case "2":
                sb.append(two[index]);
                break;
            case "3":
                sb.append(three[index]);
                break;
            case "4":
                sb.append(four[index]);
                break;
            case "5":
                sb.append(five[index]);
                break;
            case "6":
                sb.append(six[index]);
                break;
            case "7":
                sb.append(seven[index]);
                break;
            case "8":
                sb.append(eight[index]);
                break;
            case "9":
                sb.append(nine[index]);
                break;
            default:
                break;
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        AutoEver2 autoEver2 = new AutoEver2();

        System.out.println(autoEver2.solution("44335550555666"));
        System.out.println(autoEver2.solution("9666775553"));
        System.out.println(autoEver2.solution("2220281"));
        System.out.println(autoEver2.solution("99909"));
    }
}
