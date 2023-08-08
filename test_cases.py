from bowling_game import BowlingGame
import unittest

class TestBowlingGame(unittest.TestCase):
    def test_normal_game(self):
        # Test case for a normal game
        game = BowlingGame()
        game.roll(4)
        game.roll(5)
        self.assertEqual(game.score(), 9)

    def test_spare(self):
        # Test case for a spare
        game = BowlingGame()
        game.roll(5)
        game.roll(5)
        game.roll(3)
        self.assertEqual(game.score(), 16)

    def test_strike(self):
        # Test case for a strike
        game = BowlingGame()
        game.roll(10)
        game.roll(3)
        game.roll(4)
        self.assertEqual(game.score(), 24)

    def test_perfect_game(self):
        # Test case for a perfect game
        game = BowlingGame()
        for _ in range(12):
            game.roll(10)
        self.assertEqual(game.score(), 300)

if __name__ == '__main__':
    unittest.main()