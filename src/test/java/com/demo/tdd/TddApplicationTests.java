package com.demo.tdd;

import com.demo.tdd.game.Game;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


@SpringBootApplication
 public class TddApplicationTests {

    Game game ;

    @Before
  public  void setGameObject(){
        game = new Game();
    }

    @Test
   public void test() {
        assertNotEquals(1,2);
    }

    @Test
   public void rollZeroScoreIsZero(){
        game.roll(0);
        assertEquals(0 , game.score());
    }


    @Test
   public void openFrameAddPins() {
        game.roll(2);
        game.roll(4);
        assertEquals(6, game.score());
    }

    @Test
    public void spareAddNextBall() {
        game.roll(4);
        game.roll(6);
        game.roll(3);
        game.roll(0);
        assertEquals(16 , game.score());
    }

    @Test
    public void aTenInTwoFramesIsNotSpare() {
        game.roll(3);
        game.roll(6);
        game.roll(4);
        game.roll(2);
        assertEquals(15 , game.score());
    }

    @Test
    public void aStrikeAddsTwoNextBalls() {
        game.roll(10);
        game.roll(3);
        game.roll(2);
        assertEquals(20 , game.score());
    }

    @Test
    public void perfectGameScore() {
        for (int i = 0; i < 12 ; i++) {
            game.roll(10);
        }
        assertEquals(300 , game.score());
    }

    }
