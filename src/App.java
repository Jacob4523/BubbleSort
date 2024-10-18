import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class App {
    public static int[] createRandomArray(int arrayLength){
        Random random = new Random();
        int[] randomArray = new int[arrayLength];
        
        for (int i = 0; i < arrayLength; i++) {
            randomArray[i] = random.nextInt(101);
        }
        
        return randomArray;
    }

    public static void writeArrayToFile(int[] array, String filename){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (int number : array) {
                writer.write(Integer.toString(number));
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage()); 
        }
    }

    public static int[] readFileToArray(String filename) throws FileNotFoundException{
        ArrayList<Integer> integers = new ArrayList<>();
        File file = new File(filename);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            integers.add(Integer.parseInt(scanner.nextLine()));
        }
        scanner.close();

        int[] result = new int[integers.size()];
        for (int i = 0; i < integers.size(); i++) {
            result[i] = integers.get(i);
        }
        return result;
    }

    public static int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }
        return array;
    }

    public static void main(String[] args) throws IOException{
        Scanner fileScan = new Scanner(System.in);
        int[] array = {};
        int number;
        System.out.println("Welcome to the Bubble Sort App!");
        System.out.println("- Input a file name that you want to be sorted");
        System.out.println("- Input an integer to create an array with the number of elements you specified");
        System.out.println("  that contain random integers from 0-100 that will then be sorted.");
        System.out.print("\nPlease input a file/integer: ");
        String userInput = fileScan.nextLine();
        if(isInteger(userInput)) {
            number = Integer.parseInt(userInput);
            array = createRandomArray(number);
            writeArrayToFile(array, "arrayRandom.txt");
            System.out.println("Array has been written to arrayRandom.txt"); 
        } else {
            array = readFileToArray(userInput);
        }
        fileScan.close();
        array = bubbleSort(array);
        writeArrayToFile(array, "arraySorted.txt");
        System.out.println("Array has been sorted and written to arraySorted.txt"); 
    }

    public static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}