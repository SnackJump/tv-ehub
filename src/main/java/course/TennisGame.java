package course;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: TennisGame<br>
 * Description: 網球記分版需求<br>
 * Company: Tradevan Co.<br>
 *  1. 單局<br>
 *  2. 規則<br>
 *    得分：0；用語：love<br>
 *    得分：1；用語：fifteen<br>
 *    得分：2；用語：thirty<br>
 *    得分：3；用語：forth<br>
 *    得分：4；用語：win<br>
 *    得分：超過3分且平手；用語：deuce<br>
 *    得分：超過3分且領先1分；用語：advantage<br>
 *    得分：獲勝；用語：win<br>
 * 3. output: <br>
 *    3:1 —> [forty fifteen]<br>
 *    if after deuce, first player win —> [first player win]<br>
 *    if after deuce, second player win —> [second player win]<br>
 *    if after deuce, second player win —> [second player win]<br>
 *
 * @author 2920
 * @version 修訂記錄:<br>
 * @since 2022/5/6
 */
public class TennisGame {

    private final String FORTY = "forty";
    private final String THIRTY = "thirty";
    private final String LOVE = "love";
    private final String FIFTEEN = "fifteen";
    private final String FIRST_PLAYER = "first player";
    private final String WIN = "win";
    private final String BLANK = " ";
    private final String SECOND_PLAYER = "second player";
    private final String DEUCE = "deuce";
    private final String ADVANTAGE = "advantage";

    private int firstPlayerTotalScore;
    private int secondPlayerTotalScore;

    private Map<Integer, String> scoreMapping;

    /**
     * 初始化
     */
    public TennisGame() {
        /* 初始化得分對應顯示方式 */
        scoreMapping = new HashMap<>();
        scoreMapping.put(0, LOVE);
        scoreMapping.put(1, FIFTEEN);
        scoreMapping.put(2, THIRTY);
        scoreMapping.put(3, FORTY);
    }

    /**
     * 顯示目前得分
     * @return 目前得分
     */
    public String score() {
        if (firstPlayerTotalScore >= 3 && secondPlayerTotalScore >= 3) {
            /* 特殊情況，有 DEUCE、ADVANTAGE、WIN */
            if (firstPlayerTotalScore == secondPlayerTotalScore) {
                return DEUCE;
            }else {
                String player = (firstPlayerTotalScore > secondPlayerTotalScore) ? FIRST_PLAYER : SECOND_PLAYER;
                int diff = Math.abs(firstPlayerTotalScore-secondPlayerTotalScore);
                String show = "";
                switch (diff) {
                    case 1:
                        show = ADVANTAGE;
                        break;
                    case 2:
                        show = WIN;
                        break;
                }
                return player + BLANK + show;
            }
        } else {
            /* 一般情況 */
            if (firstPlayerTotalScore == 4) {
                return FIRST_PLAYER + BLANK + WIN;
            } else if (secondPlayerTotalScore == 4) {
                return SECOND_PLAYER + BLANK + WIN;
            } else {
                String firstScore = scoreMapping.get(firstPlayerTotalScore);
                String secondScore = scoreMapping.get(secondPlayerTotalScore);

                return firstScore + BLANK + secondScore;
            }
        }
    }

    /**
     * first player 得分
     */
    public void firstPlayerScore() {
        firstPlayerTotalScore++;
    }

    /**
     * second player 得分
     */
    public void secondPlayerScore() {
        secondPlayerTotalScore++;
    }
}
