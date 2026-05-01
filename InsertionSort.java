import java.util.*;

public class InsertionSort {
    static void insertion(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int k = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > k) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = k;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int arr[] = new int[n];

        Random r = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = r.nextInt(10000) + 1;
        }

        long s = System.nanoTime();
        insertion(arr);
        long e = System.nanoTime();

        System.out.println("Execution time: " + (e - s));
        sc.close();
    }
}