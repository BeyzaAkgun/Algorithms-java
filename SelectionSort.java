import java.util.Scanner;

public class SelectionSort {
	public static void selectionSort(int[] arr) {
		//find the min element in given array
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap the found minimum element with the first element
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
    	//Test code.
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println("Original Array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        selectionSort(arr);

        System.out.println("\nSorted Array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        scanner.close();
    }
}

