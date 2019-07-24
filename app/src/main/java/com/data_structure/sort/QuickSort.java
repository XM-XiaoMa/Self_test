package com.data_structure.sort;

import java.util.Arrays;

/**
 * Created by mbc on 19-6-24
 * Description:
 */
public class QuickSort {


    private QuickSort() {

    }

    private static int partition(int[] arr, int l, int r) {
        int v = arr[l];
        int i;
        int j = l;
        for (i = l + 1; i <= r; i++) {
            // 找到小于基准值的，放在左边
            if (arr[i] < v) {
                j++;
                swap(arr, j, i);
            }
        }
        // 基准归位
        swap(arr, l, j);
        return j;
    }

    /* 双路快速排序 */
    private static int partition2(int[] arr, int l, int r) {
        int v = arr[l];
        int i = l + 1;
        int j = r;
        while (true) {
            while (i <= r && arr[i] < v) i++;
            while (j >= l + 1 && arr[j] > v) j--;
            if (i > j) break;
            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr, l, j);
        return j;
    }

    public static int partition3(int[] array, int start, int end) {
        int pivot = (int) (start + Math.random() * (end - start + 1));
        int smallIndex = start - 1;
        swap(array, pivot, end);
        for (int i = start; i <= end; i++)
            if (array[i] <= array[end]) {
                smallIndex++;
                if (i > smallIndex)
                    swap(array, i, smallIndex);
            }
        return smallIndex;
    }

    public static int partition5(int[] numbers, int low, int high) {
        int temp = numbers[low]; //数组的第一个作为中轴
        while (low < high) {
            while (low < high && numbers[high] > temp) {
                high--;
            }
            numbers[low] = numbers[high];//比中轴小的记录移到低端
            while (low < high && numbers[low] < temp) {
                low++;
            }
            numbers[high] = numbers[low]; //比中轴大的记录移到高端
        }
        numbers[low] = temp; //中轴记录到尾
        return low; // 返回中轴的位置
    }

    private static void sort(int[] arr, int l, int r) {
        if (l >= r)
            return;
        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    public static void sort(int[] arr) {

        int n = arr.length;
        sort(arr, 0, n - 1);

    }

    public static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 7, 8, 5, 6, 9, 7, 7, 10, 17, 11, 890, 8, 9490, 16, 898, 88, 77, 55};
        QuickSort.sort(arr);
        System.out.print(Arrays.toString(arr));
    }

}
