package tutorials.sort;

import java.io.IOException;

public class QuickSort {
    static int[] arrs = {3, 1, 6, 9, 2, 5, 7};

    static int sort(int[] a, int left, int right) {
        int pivot = (left + right) / 2;
        while (left <= right) {
            while (a[left] < a[pivot]) {
                left++;
            }
            while (a[right] > a[pivot]) {
                right--;
            }

            if (left <= right) {
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
                left++;
                right--;
            }
        }
        return left;
    }

    static void quickSort(int[] a, int left, int right) {
        int k = sort(a, left, right);
        if (left < k - 1) {
            quickSort(a, left, right - 1);
        }
        if (right > k) {
            quickSort(a, k, right);
        }

    }

    public static void main(String[] args) throws IOException {
        quickSort(arrs, 0, arrs.length - 1);
        for (int i = 0; i < arrs.length; i++) {
            System.out.print(arrs[i] + " ");
        }
    }
}