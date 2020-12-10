import java.util.Arrays;

import static java.util.Arrays.*;

public class WorkWithArrays {

    int [] newArr;

    public int [] findElementsAfterLast4AndMakeNewArr(int [] arr) {
        if (arr.length <= 4){
            throw new RuntimeException();
        }
        System.out.println("Остаток по модулю: " + arr.length % 4);
        newArr = copyOfRange(arr, arr.length - arr.length % 4, arr.length);
        return newArr;
    }

    public boolean checkForPresence1or4 (int [] arr){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != 1 && arr[i] != 4) return false;
        }
        return true;
    }
    }


