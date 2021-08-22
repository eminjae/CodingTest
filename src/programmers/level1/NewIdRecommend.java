package programmers.level1;


public class NewIdRecommend {
    public String solution(String new_id) {

        String oneStep = toLowerCase(new_id);
        String twoStep = removeOtherSpecialChar(oneStep);
        String threeStep = replaceContinueFullStop(twoStep);
        String fourStep = removeFullStopLocatingFirstOrEnd(threeStep);
        String fiveStep = changeInEmptyString(fourStep);
        String sixStep = checkMaxLength(fiveStep);
        String lastStep = checkMinLength(sixStep);

        return lastStep;
    }
    /*
    * 1단계
    * */
    public String toLowerCase(String id) {
        return id.toLowerCase();
    }
    /*
    * 2단계
    * */
    public String removeOtherSpecialChar(String id) {
        String regExp = "[^a-z0-9\\-_.]*";
        return id.replaceAll(regExp, "");
    }
    /*
    * 3단계
    * */
    public String replaceContinueFullStop(String id) {
        String regExp = "\\.{2,}";
        return id.replaceAll(regExp, ".");
    }
    /*
    * 4단계
    * */
    public String removeFullStopLocatingFirstOrEnd(String id) {
        String new_id = id;
        if(id.charAt(id.length()-1) == '.'){
            new_id = new_id.substring(0, id.length()-1);
        }
        if(id.charAt(0) == '.'){
            new_id = new_id.replaceFirst(".","");
        }
        return new_id;
    }
    /*
    * 5단계
    * */
    public String changeInEmptyString(String id) {
        return id.trim().equals("") ? "a" : id;
    }
    /*
    * 6단계
    * */
    public String checkMaxLength(String id) {
        String new_id = id;
        if(id.length() >= 16) {
            new_id = new_id.substring(0, 15);
        }
        return removeFullStopLocatingFirstOrEnd(new_id);
    }
    /*
    * 7단계
    * */
    public String checkMinLength(String id) {
        String new_id = id;
        if(new_id.length() <= 2) {
            char lastChar = new_id.charAt(new_id.length()-1);
            while(new_id.length() < 3) {
                new_id += lastChar;
            }
        }
        return new_id;
    }

    public static void main(String[] args) {
        System.out.println(new NewIdRecommend().solution(	"...!@BaT#*..y.abcdefghijklm"));
        System.out.println(new NewIdRecommend().solution(	"z-+.^."));
        System.out.println(new NewIdRecommend().solution(	"=.="));
        System.out.println(new NewIdRecommend().solution(	"123_.def"));
        System.out.println(new NewIdRecommend().solution(		"abcdefghijklmn.p"));
    }
}
