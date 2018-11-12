package algorithms;

import java.util.Scanner;

public class Algorithms {

    int[] array = new int[50];
    Scanner scan = new Scanner(System.in);
    int arraySize = scan.nextInt();

    public static void main(String[] args) {

        Algorithms algos = new Algorithms();
        algos.fillArray();
        algos.printArray();
        System.out.println("-------------");
        algos.quickSort(0,algos.arraySize-1);
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
                System.out.println("Copy " + array[outer] + " into temp" );
                inner = outer;
                System.out.println("Checking if " + array[inner-interval] + " in index " + (inner - interval) + " is bigger than " + temp );
                while (inner > interval - 1 && array[inner - interval] >= temp) {
                    System.out.println("In While Checking if " + array[inner-interval] + " in index " + (inner - interval) + " is bigger than " + temp );
                    printArray();
                    System.out.println();

                    array[inner] = array[inner - interval];
                    System.out.println(array[inner - interval] + " moved to index " +inner);
                    inner -= interval;
                    System.out.println("Interval is " + interval);
                    System.out.println("outer = " + outer);
                    System.out.println("temp = " + temp);
                    System.out.println("inner = " + inner);
                }
                array[inner] = temp;
                System.out.println(temp + " moved to index " +inner);
                printArray();
                System.out.println();
                System.out.println("------------");
            }
            interval = (interval - 1) / 3;
            System.out.println("New Interval is " + interval);
        }
    }
    public void partitioning(int pivot){
        int leftPointer = -1;
        int rightPointer = arraySize;

        while (true){
            while (leftPointer<arraySize-1 && array[++leftPointer]<pivot);
            printArray();
            System.out.println();
            System.out.println(array[leftPointer] + " in index " + leftPointer + " is bigger then pivot vlaue "+pivot);
            while (rightPointer > 0 && array[--rightPointer] > pivot);
            printArray();
            System.out.println();
            System.out.println(array[rightPointer] + " in index " + rightPointer + " is smaller then pivot vlaue "+pivot);
            printArray();
            System.out.println();
            if(leftPointer>=rightPointer){
                break;
            }else {
                swapValues(leftPointer,rightPointer);
                System.out.println(array[leftPointer] + " was swapped for " + array[rightPointer]);
            }
        }
    }

    public void quickSort(int left, int right){
        if(right-left<=0){
            return;
        }
        else {
            int pivot = array[right];
            System.out.println("value in right " + array[right] + " is made the pivot");
            System.out.println("left = "+left + " right = " + right + " pivot = "+pivot+ " was sent to partitioned");
            int pivotLocation = partitionArray(left,right,pivot);
            System.out.println("value in right " + array[left] + " is made the pivot");
            quickSort(left,pivotLocation-1);
            quickSort(pivotLocation+1,right);
        }
    }
    public int partitionArray(int left, int right, int pivot){

        int leftPointer= left-1;
        int rightPointer = right;
        while (true){
            while (array[++leftPointer]<pivot);
            printArray();
            System.out.println();
            System.out.println(array[leftPointer] + " in index " + leftPointer + " is bigger then pivot vlaue "+pivot);
            while (rightPointer > 0 && array[--rightPointer] > pivot);
            printArray();
            System.out.println();
            System.out.println(array[rightPointer] + " in index " + rightPointer + " is smaller then pivot vlaue "+pivot);
            printArray();
            System.out.println();
            if(leftPointer>=rightPointer){
                System.out.println("left is >= right so start again");
                break;
            }else {
                swapValues(leftPointer,rightPointer);
                System.out.println(array[leftPointer] + " was swapped for " + array[rightPointer]);
            }
        }
        swapValues(leftPointer, right);
        return  leftPointer;
    }
}
