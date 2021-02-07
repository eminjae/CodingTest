package codingTest;

public class Kakaobank3 {

    static int maxinum = 0;
    int solution(int[][] board) {

        recursion(board, 0,1);

        int answer = maxinum;
        return answer;
    }

    public int recursion(int[][] board, int max, int count){
        int tempMax = 0;
        for(int i =0; i < 4 ; i++){
            for(int j = 0 ; j < 4 ; j++){
                if(board[i][j] != 0)
                    tempMax = Math.max(board[i][j], tempMax);
            }
        }
        if(count > 2048) return tempMax;

//
//        maxinum = Math.max(recursion(move(board, "LEFT"),tempMax), maxinum, count++);
//        maxinum = Math.max(recursion(move(board, "RIGHT"),tempMax), maxinum, count++);
//        maxinum = Math.max(recursion(move(board, "UP"),tempMax), maxinum, count++);
//        maxinum = Math.max(recursion(move(board, "DOWN"),tempMax), maxinum, count++);

        return maxinum;
    }
    public int[][] move(int[][] board, String direction){

        int[][] newMap = new int[4][4];

        if(direction.equals("LEFT")){
            for(int i =0; i < 4 ; i++){
                StringBuffer sb = new StringBuffer();
                for(int j = 0 ; j < 4 ; j++){

                    if(board[i][j] != 0) sb.append(board[i][j]);
                }
                int index = -1;
                for(int j = 0 ; j < sb.length(); j++){
                    if(j >= sb.length()) break;

                    index++;

                    if(j == sb.length()-1){
                        newMap[i][index] =Integer.parseInt(String.valueOf(sb.charAt(j)));
                        break;
                    }

                    if(sb.charAt(j) == sb.charAt(j+1)){
                        newMap[i][index] = Integer.parseInt(String.valueOf(sb.charAt(j))) + Integer.parseInt(String.valueOf(sb.charAt(j+1)));
                        j++;
                    }else {
                        newMap[i][index] = Integer.parseInt(String.valueOf(sb.charAt(j)));
                    }
                }
            }
        }else if(direction.equals("RIGHT")){
            for(int i =3; i >= 0 ; i--){
                StringBuffer sb = new StringBuffer();
                for(int j = 0 ; j < 4 ; j++){

                    if(board[i][j] != 0) sb.append(board[i][j]);
                }
                int index = -1;
                for(int j = 0 ; j < sb.length(); j++){
                    if(j >= sb.length()) break;

                    index++;

                    if(j == sb.length()-1){
                        newMap[i][index] =Integer.parseInt(String.valueOf(sb.charAt(j)));
                        break;
                    }

                    if(sb.charAt(j) == sb.charAt(j+1)){

                        newMap[i][index] = Integer.parseInt(String.valueOf(sb.charAt(j))) + Integer.parseInt(String.valueOf(sb.charAt(j+1)));
                        j++;
                    }else {
                        newMap[i][index] = Integer.parseInt(String.valueOf(sb.charAt(j)));
                    }
                }
            }
        }else if(direction.equals("DOWN")){
            for(int j =3; j >=0 ; j--){
                StringBuffer sb = new StringBuffer();
                for(int i = 0 ; i < 4 ; i++){

                    if(board[i][j] != 0) sb.append(board[i][j]);
                }
                int index = -1;
                for(int k = 0 ; k < sb.length(); k++){
                    if(k >= sb.length()) break;

                    index++;

                    if(k == sb.length()-1){
                        newMap[index][k] =Integer.parseInt(String.valueOf(sb.charAt(k)));
                        break;
                    }

                    if(sb.charAt(k) == sb.charAt(k+1)){


                        newMap[index][k] = Integer.parseInt(String.valueOf(sb.charAt(k))) + Integer.parseInt(String.valueOf(sb.charAt(k+1)));
                        k++;
                    }
                    else {
                        newMap[index][k] = Integer.parseInt(String.valueOf(sb.charAt(k)));
                    }
                }
            }
        }else if(direction.equals("UP")){
            for(int j =0; j < 4 ; j++){
                StringBuffer sb = new StringBuffer();
                for(int i = 0 ; i < 4 ; i++){

                    if(board[i][j] != 0) sb.append(board[i][j]);
                }
                int index = -1;
                for(int k = 0 ; k < sb.length(); k++){
                    if(k >= sb.length()) break;

                    index++;

                    if(k== sb.length()-1){
                        newMap[index][k] =Integer.parseInt(String.valueOf(sb.charAt(k)));
                        break;
                    }

                    if(sb.charAt(k) == sb.charAt(k+1)){


                        newMap[index][k] = Integer.parseInt(String.valueOf(sb.charAt(k))) + Integer.parseInt(String.valueOf(sb.charAt(k+1)));
                        k++;
                    } else {
                        newMap[index][k] = Integer.parseInt(String.valueOf(sb.charAt(k)));
                    }
                }
            }
        }

        return newMap;
    }


    public static void main(String[] args){
        System.out.println(new Kakaobank3().solution(new int[][]{{2, 4, 8, 2}, {2, 2, 2, 2}, {0, 4, 2, 4}, {2, 2, 2, 4}}));
    }
}
