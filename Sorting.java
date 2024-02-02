import java.util.Arrays;
import java.util.Scanner;

public class Sorting {

    

    public static void sort(int[] arr, String order) {
        if (order.equalsIgnoreCase("ascending")) {
            ascending(arr, 0, arr.length - 1);
        } else if (order.equalsIgnoreCase("descending")) {
            descending(arr, 0, arr.length - 1);
        } else {
            System.out.println("Invalid sorting order.");
        }
    }

    private static void ascending(int[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partitionAscending(arr, low, high);
            ascending(arr, low, partitionIndex - 1);
            ascending(arr, partitionIndex + 1, high);
        }
    }

    private static int partitionAscending(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    private static void descending(int[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partitionDescending(arr, low, high);
            descending(arr, low, partitionIndex - 1);
            descending(arr, partitionIndex + 1, high);
        }
    }

    private static int partitionDescending(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] >= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
    
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the integers separated by spaces: ");
        String input = scanner.nextLine();
        String[] inputNumbers = input.split(" ");
        int[] numbers = new int[inputNumbers.length];

        for (int i = 0; i < inputNumbers.length; i++) {
            try {
                numbers[i] = Integer.parseInt(inputNumbers[i]);
            } catch (NumberFormatException e) {
                System.err.println("Invalid input: " + inputNumbers[i]);
                System.exit(1);
            }
        }

        Sorting.sort(numbers, "ascending");
        System.out.println("Ascending Order: " + Arrays.toString(numbers));

        Sorting.sort(numbers, "descending");
        System.out.println("Descending Order: " + Arrays.toString(numbers));

        scanner.close();
    }
}