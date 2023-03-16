import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.tournament.Game;
import ru.netology.tournament.NotRegisteredException;
import ru.netology.tournament.Player;

public class GameTest {
    Game game = new Game();
    Player alex = new Player(10, "Alex", 100);
    Player ken = new Player(20, "Ken", 200);

    @BeforeEach
    public void setup() {
        game.register(alex);
        game.register(ken);
    }

    @Test
    public void firstPlayerWins() {

        int expected = 1;
        int actual = game.round("Ken", "Alex");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void secondPlayerWins() {

        int expected = 2;
        int actual = game.round("Alex", "Ken");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void strengthPlayerEqual() {
        Game game = new Game();
        Player alex = new Player(1, "Alex", 300);
        Player ken = new Player(2, "Ken", 300);

        game.register(alex);
        game.register(ken);

        int expected = 0;
        int actual = game.round("Alex", "Ken");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void firstPlayerNotFound() {

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Ted", "Ken"));
    }

    @Test
    public void secondPlayerNotFound() {

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Alex", "Jon"));
    }

    @Test
    public void allPlayersNotFound() {

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Ted", "Jon"));
    }
}
