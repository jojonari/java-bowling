package bowling;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class FraemeTest {
    @Test
    void strike() {
        Frame frame = Frame.firstPitch(Score.of(10));
        assertThat(frame.hasNext()).isFalse();
    }

    @Test
    void spare() {
        Frame frame = Frame.firstPitch(Score.of(9));
        assertThat(frame.hasNext()).isTrue();
    }

    @Test
    void isStrike() {
        Frame frame = Frame.firstPitch(Score.of(10));
        assertThat(frame.isStrike()).isTrue();
    }

    @Test
    void isSpare() {
        Frame frame = Frame.firstPitch(Score.of(1));
        frame.scoundPitch(Score.of(9));
        assertThat(frame.isSpare()).isTrue();
    }

    @Test
    void miss() {
        Frame frame = Frame.firstPitch(Score.of(5));
        frame.scoundPitch(Score.of(4));
        assertThat(frame.isSpare()).isFalse();
    }

    @Test
    void maxPoint10() {
        Frame frame = Frame.firstPitch(Score.of(5));
        assertThatIllegalArgumentException().isThrownBy(()->frame.scoundPitch(Score.of(6)));
    }

    @Test
    void printStrike() {
        Frame frame = Frame.firstPitch(Score.of(10));
        assertThat(frame.getPrint()).isEqualTo("X");
    }
    @Test
    void printSpare() {
        Frame frame = Frame.firstPitch(Score.of(5));
        frame.scoundPitch(Score.of(5));
        assertThat(frame.getPrint()).isEqualTo("5|/");
    } @Test
    void printGurtter() {
        Frame frame = Frame.firstPitch(Score.of(0));
        frame.scoundPitch(Score.of(0));
        assertThat(frame.getPrint()).isEqualTo("-|-");
    }
}
