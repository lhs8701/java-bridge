package bridge.view;

import bridge.InputView;
import camp.nextstep.edu.missionutils.Console;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ViewTest {

    public static InputStream generateUserInput(String input){
        return new ByteArrayInputStream(input.getBytes());
    }

    @Test
    @DisplayName("다리의 길이를 입력받는다.")
    void 다리의_길이를_입력받는다(){
        //given
        InputView inputView = new InputView();

        //when
        InputStream in = generateUserInput("3");
        System.setIn(in);
        int bridgeLength = inputView.readBridgeSize();

        //then
        assertThat(bridgeLength).isEqualTo(3);
    }

    @Test
    @DisplayName("다리의 길이가 범위를 벗어날 경우 예외가 발생한다.")
    void 다리의_길이가_범위를_벗어날_경우_예외가_발생한다() {
        // given
        InputView inputView = new InputView();

        // when
        InputStream in = generateUserInput("22");
        System.setIn(in);

        // then
        assertThatThrownBy(inputView::readBridgeSize)
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("입력받은 값이 숫자가 아닌경우 예외가 발생한다.")
    void test() {
        // given
        InputView inputView = new InputView();

        // when
        InputStream in = generateUserInput("15j");
        System.setIn(in);

        // then
        assertThatThrownBy(inputView::readBridgeSize)
                .isInstanceOf(IllegalArgumentException.class);
    }
}
