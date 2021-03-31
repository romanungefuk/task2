import java.util.Random;

public class MyArray {
    public int[] createIntArray (int numberOfElements, int maxValue) {
        int[] intArray = new int[numberOfElements];
        for (int i = 0; i < numberOfElements; i++) {
            intArray[i] = new Random().nextInt(maxValue) + 1;
        }
        return intArray;
    }

    public void bubbleSort(int [] array) {

        for (int i = array.length-1; i > 1; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j+1]) {
                    swapElements(array,j,j+1);
                }
            }
        }
    }

    public void selectionSort(int[] array) {
        int lowestNumberIndex;
        for (int i = 0; i < array.length-1; i++) {
            lowestNumberIndex = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[j] < array[lowestNumberIndex]) {
                    lowestNumberIndex = j;
                }
            }
            swapElements(array,lowestNumberIndex,i);
        }
    }

    public void insertionSort(int[] array) {
        int index;
        int buffer;
        for (int i = 1; i < array.length; i++) {
            index = i;
            buffer = array[i];
            while (index>0 && array[index-1]>=buffer) {
                array[index] = array[index-1];
                index--;
            }
            array[index] = buffer;
        }
    }

    private void swapElements (int[] array, int index1, int index2) {
        int buffer;
        buffer = array[index1];
        array[index1] = array[index2];
        array[index2] = buffer;
    }

}
