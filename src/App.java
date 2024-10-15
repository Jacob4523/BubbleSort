import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public static int[] createRandomArray(int arrayLength){

}

public static void writeArrayToFile(int[] array, String filename){

}

public static int[] readFileToArray(String filename){
    
}

public static void bubbleSort(int[] array) {
    for (int i = 0; i < array.length - 1; i++) {
        boolean swapped = false;
        for (int j = 0; j < array.length - i - 1; j++) {
            if (array[j] > array[j + 1]) {
                int temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
            }
        }
    }
}

public static void main(String[] args){
    Scanner fileScan = new Scanner(System.in);
    
}