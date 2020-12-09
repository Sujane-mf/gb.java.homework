import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class WorkWithArraysTest {
    WorkWithArrays w1 = new WorkWithArrays();
    int [] arr1 = {1, 2, 4, 5, 4};
    int [] exp1 = {4};
    int [] arr2 = {1, 2, 4, 5, 4, 7, 8, 8, 9, 5};
    int [] exp2 = {9, 5};
    int [] arr3 = {1, 2, 4};
    int [] exp3 = null;
    int [] arr4 = {1, 1, 4, 4, 4};
    int [] arr5 = {1, 1, 1, 1};
    int [] arr6 = {2, 5, 7, 8, 8, 9, 5};
    boolean exp4 = true;
    boolean exp5 = true;
    boolean exp6 = false;

    @Test
//    @CsvSource({
//            "{4}, {1, 2, 4, 5, 4}",
//            "{9, 5}, {1, 2, 4, 5, 4, 7, 8, 8, 9, 5}",
//            "NULL, {1, 2, 4}"
//    })

    void shouldFindElementsAfterLast4AndMakeNewArrSuccessfully(){

            Assertions.assertArrayEquals(exp1, w1.findElementsAfterLast4AndMakeNewArr(arr1));
            Assertions.assertArrayEquals(exp2, w1.findElementsAfterLast4AndMakeNewArr(arr2));
            Assertions.assertArrayEquals(exp3, w1.findElementsAfterLast4AndMakeNewArr(arr3));
    }
    @Test
    void shouldCheckForPresence1or4Successfully(){
          Assertions.assertEquals(exp4, w1.checkForPresence1or4(arr4));
            Assertions.assertEquals(exp5, w1.checkForPresence1or4(arr5));
            Assertions.assertEquals(exp6, w1.checkForPresence1or4(arr6));
    }

}
