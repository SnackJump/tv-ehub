package my;

import java.util.Scanner;

/**
 * Title: TennisGame<br>
 * Description:<br>
 * Company: Tradevan Co.<br>
 *
 * 參考：course/TennisGame 作法
 *
 * @author 2920
 * @version 修訂記錄:<br>
 * @since 2022/5/6
 */
public class TennisGame {
    // player1:player2
    public static String score;

    public static int play1 = 0;
    public static int play2 = 0;

    public static void main(String[] args) {
        System.out.print("Who win: ");
        Scanner scanner = new Scanner(System.in);
        while (true){
            switch (scanner.nextInt()){
                case 1:
                    firstPlayerScore();
                    break;
                case 2:
                    secondPlayerScore();
                    break;
            }
        }
    }

    public static void firstPlayerScore(){
        String playerName = "first player";
        play1++;
        if(!moreThenThree(playerName)){
            if(!checkWin(play1, playerName)){
                System.out.print(" ");
                checkWin(play2, "");
            }
        }
    }


    public static void secondPlayerScore(){
        String playerName = "second player";
        play2++;
        if(!moreThenThree(playerName)){
            if(!checkWin(play2, playerName)){
                System.out.print(" ");
                checkWin(play1, "");
            }
        }
    }

    /**
     * 特殊情況，有 DEUCE、ADVANTAGE、WIN
     * @param playerName
     * @return
     */
    public static boolean moreThenThree(String playerName){
        if(play1 >= 3 && play2 >= 3){
            int diff = java.lang.Math.abs(play1-play2);
            if(diff == 0){
                System.out.println(" deuce (平手)");
            }else if(diff == 1){
                System.out.println(playerName + " advantage(多一分)");
            }else if(diff == 2){
                System.out.println(playerName + " win");
                System.exit(0);
            }
            return true;
        }else{
            return false;
        }
    }

    /**
     * 一般情況
     * @param scroe
     * @param playerName
     * @return
     */
    public static boolean checkWin(int scroe, String playerName){
        switch (scroe){
            case 0:
                System.out.print("love (0)");
                break;
            case 1:
                System.out.print("fifteen (1)");
                break;
            case 2:
                System.out.print("thirty (2)");
                break;
            case 3:
                System.out.print("forty (3)");
                break;
            case 4:
                System.out.print(playerName + " win");
                System.exit(0);
                return true;
        }

        return false;
    }
}
