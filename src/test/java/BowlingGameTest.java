import org.junit.Test;
import static org.junit.Assert.*;

public class BowlingGameTest {

    @Test
    public void testNormalPlay() {
        BowlingGame game = new BowlingGame();
        game.roll(5);
        game.roll(4);
        assertEquals(9, game.score());
    }

    @Test
    public void testSpare() {
        BowlingGame game = new BowlingGame();
        game.roll(7);
        game.roll(3); // spare
        game.roll(6);
        assertEquals(16, game.score());
    }

    @Test
    public void testStrike() {
        BowlingGame game = new BowlingGame();
        game.roll(10); // strike
        game.roll(3);
        game.roll(6);
        assertEquals(19, game.score());
    }

    @Test
    public void testPerfectGame() {
        BowlingGame game = new BowlingGame();
        for (int i = 0; i < 12; i++) {
            game.roll(10); // strike
        }
        assertEquals(300, game.score());
    }
}