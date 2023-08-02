package implementations;

public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {15, 30, 25, 10, 35, 20, 45, 40};
        System.out.println("Mảng ban đầu:");
        printArray(array);

        selectionSort(array);

        System.out.println("\nMảng sau khi sắp xếp:");
        printArray(array);
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // Tìm phần tử nhỏ nhất trong mảng chưa được sắp xếp
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Hoán đổi phần tử nhỏ nhất tìm được với phần tử đầu tiên của mảng chưa được sắp xếp
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
