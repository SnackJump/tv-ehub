package course;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Title: TennisGameTest<br>
 * Description:網球記分版需求的 junit<br>
 * Company: Tradevan Co.<br>
 *
 * @author 2920
 * @version 修訂記錄:<br>
 * @since 2022/5/6
 */
public class TennisGameTest {

    private final String BLANK = " ";
    private final String LOVE = "love";
    private final String FORTY = "forty";
    private final String FIFTEEN = "fifteen";
    private final String THIRTY = "thirty";
    private final String FIRST_PLAYER = "first player";
    private final String WIN = "win";
    private final String SECOND_PLAYER = "second player";
    private final String DEUCE = "deuce";
    private final String ADVANTAGE = "advantage";

    TennisGame game = new TennisGame();

    @Test
    public void test_0_0_love_love(){
        Assertions.assertEquals(LOVE + BLANK + LOVE, game.score());
    }

    @Test
    public void test_3_1_forty_fifteen(){
        firstPlayerScore(3);
        secondPlayerScore(1);
        Assertions.assertEquals(FORTY + BLANK + FIFTEEN, game.score());
    }

    @Test
    public void test_3_2_forty_thirty(){
        firstPlayerScore(3);
        secondPlayerScore(2);
        Assertions.assertEquals(FORTY + BLANK + THIRTY, game.score());
    }

    @Test
    public void test_2_3_thirty_forty(){
        firstPlayerScore(2);
        secondPlayerScore(3);
        Assertions.assertEquals(THIRTY + BLANK + FORTY, game.score());
    }

    @Test
    public void test_0_1_love_fifteen(){
        secondPlayerScore(1);
        Assertions.assertEquals(LOVE + BLANK + FIFTEEN, game.score());
    }

    @Test
    public void test_4_1_first_win(){
        firstPlayerScore(4);
        secondPlayerScore(1);
        Assertions.assertEquals(FIRST_PLAYER + BLANK + WIN, game.score());
    }

    @Test
    public void test_2_4_second_win(){
        firstPlayerScore(2);
        secondPlayerScore(4);
        Assertions.assertEquals(SECOND_PLAYER + BLANK + WIN, game.score());
    }

    @Test
    public void test_3_3_deuce(){
        firstPlayerScore(3);
        secondPlayerScore(3);
        Assertions.assertEquals(DEUCE, game.score());
    }

    @Test
    public void test_4_4_deuce(){
        firstPlayerScore(4);
        secondPlayerScore(4);
        Assertions.assertEquals(DEUCE, game.score());
    }

    @Test
    public void test_4_3_advantage(){
        firstPlayerScore(4);
        secondPlayerScore(3);
        Assertions.assertEquals(FIRST_PLAYER + BLANK + ADVANTAGE, game.score());
    }

    @Test
    public void test_3_4_advantage(){
        firstPlayerScore(3);
        secondPlayerScore(4);
        Assertions.assertEquals(SECOND_PLAYER + BLANK + ADVANTAGE, game.score());
    }

    @Test
    public void test_6_4_first_win(){
        firstPlayerScore(6);
        secondPlayerScore(4);
        Assertions.assertEquals(FIRST_PLAYER + BLANK + WIN, game.score());
    }

    @Test
    public void test_3_5_second_win(){
        firstPlayerScore(3);
        secondPlayerScore(5);
        Assertions.assertEquals(SECOND_PLAYER + BLANK + WIN, game.score());
    }

    @Test
    public void test_5_3_first_win(){
        firstPlayerScore(5);
        secondPlayerScore(3);
        Assertions.assertEquals(FIRST_PLAYER + BLANK + WIN, game.score());
    }

    private void secondPlayerScore(int time) {
        for (int i = 0; i < time; i++) {
            game.secondPlayerScore();
        }
    }

    private void firstPlayerScore(int time) {
        for (int i = 0; i < time; i++) {
            game.firstPlayerScore();
        }
    }
}
