package implementations;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = {38, 27, 43, 10};
        System.out.println("Mảng ban đầu:");
        printArray(array);

        mergeSort(array);

        System.out.println("\nMảng sau khi sắp xếp:");
        printArray(array);
    }

    public static void mergeSort(int[] arr) {
        if (arr.length > 1) {
            int mid = arr.length / 2;

            // Chia mảng thành hai mảng con
            int[] leftArray = new int[mid];
            System.arraycopy(arr, 0, leftArray, 0, mid);

            int[] rightArray = new int[arr.length - mid];
            System.arraycopy(arr, mid, rightArray, 0, arr.length - mid);

            // Đệ quy sắp xếp hai mảng con
            mergeSort(leftArray);
            mergeSort(rightArray);

            // Gộp hai mảng con đã sắp xếp lại thành mảng ban đầu
            merge(arr, leftArray, rightArray);
        }
    }

    public static void merge(int[] arr, int[] leftArray, int[] rightArray) {
        int i = 0; // Chỉ số của mảng leftArray
        int j = 0; // Chỉ số của mảng rightArray
        int k = 0; // Chỉ số của mảng arr

        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] < rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Sao chép các phần tử còn lại của leftArray (nếu có)
        while (i < leftArray.length) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        // Sao chép các phần tử còn lại của rightArray (nếu có)
        while (j < rightArray.length) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
