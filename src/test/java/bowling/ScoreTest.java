package bowling;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ScoreTest {
    @Test
    void first10() {
        Score score = Score.of(10);
        assertThat(score.hasNext()).isFalse();
    }

    @Test
    void first9() {
        Score score = Score.of(9);
        assertThat(score.hasNext()).isTrue();
    }

    @Test
    void isStrike() {
        Score score = Score.of(10);
        assertThat(score.isStrike()).isTrue();
    }

    @Test
    void maxPoint10() {
        assertThatIllegalArgumentException().isThrownBy(() -> Score.of(11));
    }

    @Test
    void isGutter() {
        Score score = Score.of(0);
        assertThat(score.isGutter()).isTrue();
    }

    @Test
    void printPointString() {
        Score score = Score.of(5);
        assertThat(score.printScore()).isEqualTo("5");
    }

    @Test
    void printGutterString() {
        Score score = Score.of(0);
        assertThat(score.printScore()).isEqualTo("-");
    }
}
