import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        task21();
        task22();
        task23_24_25_26();

    }

    private static void task21() {
        long startTime = System.nanoTime();
        MyToolsClass myToolsClass = new MyToolsClass();
        char[] abc = myToolsClass.getAbc();
        System.out.println(Arrays.toString(abc)+"\nВывод массива abc занял "+(System.nanoTime()-startTime)+" нс");

        startTime = System.nanoTime();
        char[] firstHalfOfAlphabet = Arrays.copyOf(abc, abc.length/2);
        System.out.println("Создание (копирование) массива firstHalfOfAlphabet заняло "+(System.nanoTime()-startTime)+ " нс");
        startTime = System.nanoTime();
        System.out.println(Arrays.toString(firstHalfOfAlphabet)+"\nВывод массива firstHalfOfAlphabet занял "+(System.nanoTime()-startTime)+" нс");

        startTime = System.nanoTime();
        char[] secondHalfOfAlphabet = Arrays.copyOfRange(abc, abc.length/2, abc.length);
        System.out.println("Создание (копирование) массива secondHalfOfAlphabet заняло "+(System.nanoTime()-startTime)+ " нс");
        startTime = System.nanoTime();
        System.out.println(Arrays.toString(secondHalfOfAlphabet)+"\nВывод массива secondHalfOfAlphabet занял "+(System.nanoTime()-startTime)+" нс");
    }

    private static void task22() {
        final int ARRAY_LENGTH = 100;
        final int MAX_VALUE = 10;
        final int SEARCHED_VALUE = 10;
        long startTime;

        MyToolsClass myToolsClass = new MyToolsClass();
        int[] intArray = myToolsClass.setNewRandomIntArray(ARRAY_LENGTH,MAX_VALUE);
        System.out.println("Начальный массив:\n"+ Arrays.toString(intArray));

        startTime = System.nanoTime();
        try {
            System.out.println("Первое появление " + SEARCHED_VALUE + " в массиве intArray на позиции " + myToolsClass.simpleSearch(intArray, SEARCHED_VALUE));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Простой поиск занял " + (System.nanoTime()-startTime) + " нс");

        startTime = System.nanoTime();
        Arrays.sort(intArray);
        System.out.println("Отсортированный массива:\n" + Arrays.toString(intArray));
        System.out.println("Сортировка массива заняла " + (System.nanoTime()-startTime) + " нс");

        startTime = System.nanoTime();
        System.out.println("Результат бинарного поиска: " + Arrays.binarySearch(intArray,SEARCHED_VALUE));
        System.out.println("Бинарный поиск в неотсортированном массиве занял " + (System.nanoTime()-startTime) + " нс");

    }

    private static void task23_24_25_26() {
        final int NUMBER_OF_ELEMENTS = 400;
        final int MAXIMUM_VALUE = 100;
        long startTime;

        MyArray myArray = new MyArray();
        int[] intArray = myArray.createIntArray(NUMBER_OF_ELEMENTS,MAXIMUM_VALUE);
        System.out.println("Исходный массив:\n" + Arrays.toString(intArray));
        int[] intArrayForQuickSorting = Arrays.copyOf(intArray,intArray.length);
        int[] intArrayForBubbleSorting = Arrays.copyOf(intArray,intArray.length);
        int[] intArrayForSelectionSorting = Arrays.copyOf(intArray,intArray.length);
        int[] intArrayForInsertionSorting = Arrays.copyOf(intArray,intArray.length);

        startTime = System.nanoTime();
        Arrays.sort(intArrayForQuickSorting);
        System.out.println("Сортировка методом sort() заняла " + (System.nanoTime()-startTime) + " нс");

        startTime = System.nanoTime();
        myArray.bubbleSort(intArrayForBubbleSorting);
        System.out.println("Сортировка пузырьком заняла " + (System.nanoTime()-startTime) + " нс");

        startTime = System.nanoTime();
        myArray.selectionSort(intArrayForSelectionSorting);
        System.out.println("Сортировка выбором заняла " + (System.nanoTime()-startTime) + " нс");

        startTime = System.nanoTime();
        myArray.insertionSort(intArrayForInsertionSorting);
        System.out.println("Сортировка вставками заняла " + (System.nanoTime()-startTime) + " нс");
    }
}
