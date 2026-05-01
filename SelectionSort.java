import java.util.*;

public class SelectionSort {
    static void selection(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no of Elements: ");
        int n = sc.nextInt();
        int arr[] = new int[n];

        System.out.println("Enter Elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        long start = System.nanoTime();
        selection(arr);
        long end = System.nanoTime();

        System.out.println("Sorted array:");
        for (int x : arr) {
            System.out.print(x + " ");
        }

        System.out.println("\nExecution time: " + (end - start) + " nanoseconds");
        sc.close();
    }
}