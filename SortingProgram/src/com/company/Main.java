package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {




    public static void main(String[] args) {
        int rangeMin = 1;
        int rangeMax = 10000;
	System.out.println("Enter the Size of numbers ");
        Scanner scanner = new Scanner(System.in);
        int size = 0;
        size   =    scanner.nextInt();
        //generating random number
        Random rd = new Random();

        double[] arr = new double[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rangeMin + (rangeMax - rangeMin) * rd.nextDouble(); // storing random integers in an array
        }

        System.out.println("Select the Sorting Method below");
        System.out.println("(1) Insertion Sort");
        System.out.println("(2) Merge Sort");
        System.out.println("(3) Quick Sort");
        System.out.println("(4) Exit");

        int selection = scanner.nextInt();

        if(selection==1){
            InsertionSort(arr);
        }
        else if(selection==2){
            Mergesort(arr,0,size-1);
            System.out.println("After Merge Sort");
            for (int i = 0; i < size; i++) {
                System.out.println(arr[i]); // printing each array element
            }
        }
        else if (selection==3){
            quickSort(arr,0,size-1);
            System.out.println("After Quick Sort");
            for (int i = 0; i < size; i++) {
                System.out.println(arr[i]); // printing each array element
            }
        }
        else if (selection==4){
            return;
        }

    }

    static void InsertionSort(double arr[])
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            double key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        System.out.println("After Insertion Sort");
        int num = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.println(arr[i]);

        System.out.println();
    }
// merge SOrt starts
    static void merge(double arr[], int beg, int mid, int end)
    {

        int l = mid - beg + 1;
        int r = end - mid;

        double LeftArray[] = new double [l];
        double RightArray[] = new double [r];

        for (int i=0; i<l; ++i) {
            LeftArray[i] = arr[beg + i];
        }

        for (int j=0; j<r; ++j) {
            RightArray[j] = arr[mid + 1+ j];
        }


        int i = 0, j = 0;
        int k = beg;
        while (i<l&&j<r)
        {
            if (LeftArray[i] <= RightArray[j])
            {
                arr[k] = LeftArray[i];
                i++;
            }
            else
            {
                arr[k] = RightArray[j];
                j++;
            }
            k++;
        }
        while (i<l)
        {
            arr[k] = LeftArray[i];
            i++;
            k++;
        }

        while (j<r)
        {
            arr[k] = RightArray[j];
            j++;
            k++;
        }
    }
    static void Mergesort(double arr[], int beg, int end)
    {
        if (beg<end)
        {
            int mid = (beg+end)/2;
            Mergesort(arr, beg, mid);
            Mergesort(arr , mid+1, end);
            merge(arr, beg, mid, end);
        }
    }
//merger sort ends

//Quick Sort Starts
static int partition(double[] arr, int low, int high)
{

    // pivot
    double pivot = arr[high];

    // Index of smaller element and
    // indicates the right position
    // of pivot found so far
    int i = (low - 1);

    for(int j = low; j <= high - 1; j++)
    {

        // If current element is smaller
        // than the pivot
        if (arr[j] < pivot)
        {

            // Increment index of
            // smaller element
            i++;
            swap(arr, i, j);
        }
    }
    swap(arr, i + 1, high);
    return (i + 1);
}

    static void swap(double[] arr, int i, int j)
    {
        double temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void quickSort(double[] arr, int low, int high)
    {
        if (low < high)
        {

            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);

            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

// Quick Sort End
    //





}
