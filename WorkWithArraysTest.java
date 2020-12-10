import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import java.util.stream.Stream;

public class WorkWithArraysTest {
    WorkWithArrays w1 = new WorkWithArrays();

    @ParameterizedTest
    @MethodSource ("actualAndExpectedResults")

    void shouldFindElementsAfterLast4AndMakeNewArrSuccessfully(int [] parameters, int [] expected){
            Assertions.assertArrayEquals(expected, w1.findElementsAfterLast4AndMakeNewArr(parameters));
    }

    private static Stream<Arguments> actualAndExpectedResults(){
        return Stream.of(
                Arguments.arguments(new int[] {1, 2, 4, 5, 4}, new int[] {4}),
                Arguments.arguments(new int[] {1, 2, 4, 5, 4, 7, 8, 8, 9, 5}, new int[] {9, 5})
        );
    }

    @ParameterizedTest
    @NullAndEmptySource
    @MethodSource({"wrongParameters"})
    void shouldFrowRuntimeExeption(int[] parameters){
        RuntimeException runtimeException = Assertions.assertThrows(
                RuntimeException.class, () -> w1.findElementsAfterLast4AndMakeNewArr(parameters)
        );
        Assertions.assertNotNull(runtimeException);
    }
    private static Stream<int[]> wrongParameters(){
        return Stream.of(new int[] {1, 2, 4, 5});
            }

    @ParameterizedTest
    @MethodSource ("actualAndExpectedResultsforSecondTest")

    void shouldCheckForPresence1or4Successfully(int[] parameters, boolean exp){
          Assertions.assertEquals(exp, w1.checkForPresence1or4(parameters));
    }
    private static Stream<Arguments> actualAndExpectedResultsforSecondTest(){
        return Stream.of(
                Arguments.arguments(new int[] {1, 1, 4, 4, 4}, true),
                Arguments.arguments(new int[] {1, 1, 1, 1}, true),
                Arguments.arguments(new int[] {2, 5, 7, 8, 8, 9, 5}, false)
        );
    }
}