/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaexample2;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Bhavani_Chandra
 */
public class JavaExample2 {

    /**
     * @param args the command line arguments
     */
    static Scanner stdin = new Scanner(System.in);

    public static void main(String[] args) {

        int[] a = new int[8];
        for (int i = 0; i < a.length; i++) {
            System.out.print("enter for element " + i + " ");
            a[i] = stdin.nextInt();
        }

        // mergeSort(a); 
        binarySearch(a);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array 
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }
            // Swap the found minimum element with the first element 
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void search(int arr[], int search) {

        int count = 0;
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == search) {
                count++;
                index = i;
                break;
            }
        }
        if (count > 0) {
            System.out.println("The value is present at index " + index + " and value is " + arr[index]);
        } else {
            System.out.println("The value is not present");
        }
    }

    public static void bubbleSort(int arr[]) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
                System.out.println(Arrays.toString(arr));
            }

        } while (swapped == true);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr) {

        merge(arr, new int[arr.length], 0, arr.length - 1);

    }

    public static void merge(int[] arr, int[] temp, int leftStart, int rightEnd) {
        if (leftStart >= rightEnd) {
            return;
        }
        int mid = (leftStart + rightEnd) / 2;
        merge(arr, temp, leftStart, mid);
        merge(arr, temp, mid + 1, rightEnd);
        mergeHalves(arr, temp, leftStart, rightEnd);
        //System.out.println("After merging two havles " + Arrays.toString(arr));

    }

    public static void mergeHalves(int[] arr, int[] temp, int leftStart, int rightEnd) {

        int leftEnd = (leftStart + rightEnd) / 2;
        int rightStart = leftEnd + 1;
        int size = rightEnd - leftStart + 1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;
        while (left <= leftEnd && right <= rightEnd) {
            if (arr[left] <= arr[right]) {
                temp[index++] = arr[left++];
            } else {
                temp[index++] = arr[right++];
            }
        }
        System.arraycopy(arr, left, temp, index, leftEnd - left + 1);
        System.arraycopy(arr, right, temp, index, rightEnd - right + 1);
        System.arraycopy(temp, leftStart, arr, leftStart, size);

    }

    public static void binarySearch(int[] arr) {
        mergeSort(arr);
        System.out.print("enter value to search: ");
        int searchValue = stdin.nextInt();
        binarySearch(arr, 0, arr.length - 1, searchValue);

    }

    public static void binarySearch(int[] arr, int low, int high, int search) {
        if (low > high) {
            System.out.println("Value cannot be found");
            return;
        }
        int mid = (low + high) / 2;
        if (search == arr[mid]) {
            System.out.println("value found at " + mid);
        } else if (search < arr[mid]) {
            binarySearch(arr, low, mid, search); // recursion algorithms
        } else {
            binarySearch(arr, mid + 1, high, search);
        }
    }
    
   
}
