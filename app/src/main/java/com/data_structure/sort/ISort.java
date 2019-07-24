package com.data_structure.sort;

/**
 * Created by mbc on 19-6-24
 * Description: 排序算法
 */
public interface ISort {
    /* 交换排序 - TODO 冒泡排序 */
    void bubble_sort(int[] array);

    /* 交换排序 - TODO 快速排序 */
    void quick_sort(int[] array);

    /* 插入排序 - TODO 直接插入排序 */
    void insert_sort(int[] array);

    /* 插入排序 - TODO 希尔排序 */
    void shell_sort(int[] array);

    /* 选择排序 - TODO 直接选择排序 */
    void selection_sort(int[] array);

    /* 选择排序 - TODO 堆排序 */
    void heap_sort(int[] array);

    /* TODO 归并排序 */
    void merge_sort(int[] array);

    /* 数据交换 */
    void swap(int[] arr, int a, int b);
}
