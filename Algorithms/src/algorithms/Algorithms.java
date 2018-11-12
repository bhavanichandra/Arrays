package algorithms;

import java.util.Scanner;

public class Algorithms {

    int[] array = new int[50];
    Scanner scan = new Scanner(System.in);
    int arraySize = scan.nextInt();

    public static void main(String[] args) {

        Algorithms algos = new Algorithms();
        algos.fillArray();
        algos.shellSort();
        algos.printArray();
    }

    public void fillArray() {
        for (int i = 0; i < arraySize; i++) {
            array[i] = (int) (Math.random() * 30) + 5;
        }
    }

    public void printArray() {
        for (int i = 0; i < arraySize; i++) {
            //System.out.print(" | " + i + " | ");
            System.out.print(array[i] + " ");

        }
        System.out.println();
    }

    public void deleteArray(int index) {
        if (index < arraySize) {
            for (int i = index; i < arraySize - 1; i++) {
                array[i] = array[i + 1];
            }
            arraySize--;
        }
    }

    public int deleteArrayByValue(int value) {
        for (int i = 0; i < arraySize - 1; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return 0;
    }

    public void insertValue(int value) {
        if (arraySize < 50) {
            array[arraySize] = value;
            arraySize++;
        }

    }

    public String linearSearch(int value) {
        boolean valueInArray = false;
        String indexesWithValue = "";
        for (int i = 0; i < arraySize; i++) {
            if (array[i] == value) {
                valueInArray = true;
                indexesWithValue += i + " ";
            }
        }
        if (!valueInArray) {
            indexesWithValue = "None";
        }
        return indexesWithValue;
    }

    public void bubbleSort() {
        for (int i = arraySize - 1; i > 1; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    swapValues(j, j + 1);
                }
            }
        }
    }

    public void swapValues(int a, int b) {
        int temp;
        temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public void binarySearchValue(int value) {
        int lowIndex = 0;
        int maxIndex = arraySize - 1;
        boolean valueFound = false;
        while (lowIndex <= maxIndex) {
            int midIndex = (lowIndex + maxIndex) / 2;
            if (array[midIndex] < value) {
                lowIndex++;
            } else if (array[midIndex] > value) {
                maxIndex++;
            } else {
                System.out.println("The value is found at " + midIndex + " containig " + value);
                lowIndex = maxIndex + 1;
                valueFound = true;

            }
        }
        if (!valueFound) {
            System.out.println("Value not found");
        }

    }

    public void selectionSort() {
        for (int i = 0; i < arraySize; i++) {
            int min = i;
            for (int j = i; j < arraySize; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }
            swapValues(i, min);
        }
    }

    public void insertionSort() {
        for (int i = 1; i < arraySize; i++) {
            int j = i;
            int toInsert = array[i];
            while ((j > 0) && array[j - 1] > toInsert) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = toInsert;
            System.out.println();
            printArray();
        }
    }

    public void shellSort() {
        int inner, outer, temp;
        int interval = 1;
        while (interval <= arraySize / 3) {
            interval = interval * 3 + 1;
        }
        while (interval > 0) {
            for (outer = interval; outer < arraySize; outer++) {
                temp = array[outer];
                inner = outer;
                while (inner > interval - 1 && array[inner - interval] >= temp) {
                    array[inner] = array[inner - interval];
                    inner -= interval;
                }
                array[inner] = temp;
            }
            interval = (interval - 1) / 3;
        }
    }
}
