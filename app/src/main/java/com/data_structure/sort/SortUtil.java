package com.data_structure.sort;

/**
 * Created by mbc on 19-6-21
 * Description: 排序算法
 */
public class SortUtil implements ISort {

    private static SortUtil sort;

    private SortUtil() {
    }

    public synchronized static SortUtil getInstance() {
        if (sort == null) {
            synchronized (SortUtil.class) {
                if (sort == null) {
                    sort = new SortUtil();
                }
            }
        }
        return sort;
    }


    @Override
    public void bubble_sort(int[] array) {
        // 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
        // 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
        // 针对所有的元素重复以上的步骤，除了最后一个。
        // 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。

        if (array == null || array.length <= 0) return;
        int i, j, temp;
        int size = array.length;
        for (i = 0; i < size - 1; i++) {
            for (j = 0; j < size - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /*============================================================================================*/

    @Override
    public void quick_sort(int[] array) {
        // 快速排序采用分治的思想
        // 1. 从数列中挑出一个元素，称为"基准"（pivot）,这里是以数组第一个数为“基准”
        // 2. 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区结束之后，该基准就处于数列的中间位置。这个称为分区（partition）操作。
        // 3. 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
        int n = array.length;
        sort(array, 0, n - 1);
    }

    private void sort(int[] arr, int l, int r) {
        if (l >= r)
            return;
        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }


    private int partition(int[] arr, int l, int r) {
        int v = arr[l];
        int i;
        int j = l;
        for (i = l + 1; i <= r; i++) {
            // 找到小于基准值的，从左边依次往右边放
            if (arr[i] < v) {
                if (i == j)
                    continue;
                j++;
                swap(arr, j, i);
            }
        }
        // 基准归位
        swap(arr, l, j);
        return j;
    }

    /*============================================================================================*/

    @Override
    public void insert_sort(int[] array) {

    }

    @Override
    public void shell_sort(int[] array) {

    }

    @Override
    public void selection_sort(int[] array) {
        //首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。实际适用的场合非常罕见。
        int i, j, min, temp;
        int size = array.length;
        for (i = 0; i < size - 1; i++) {
            min = i;
            // 找出最小
            for (j = i + 1; j < size; j++) {
                if (array[min] > array[j])
                    min = j;
            }
            // 需要更换
            if (min != i)
                swap(array, i, min);
        }
    }

    @Override
    public void heap_sort(int[] array) {
        // 堆排序利用了大根堆（或小根堆）堆顶记录的关键字最大（或最小）这一特征，使得在当前无序区中选取最大（或最小）关键字的记录变得简单。
        // 1. 将数组分为有序区和无序区，在无序区中建立最大堆
        // 2. 将堆顶的数据与无序区末尾的数据交换
        // 3. 从后往前，直到所有数据排序完成
        for (int i = array.length - 1; i >= 0; i--) {
            maxHeap(array, 0, i);
            swap(array, 0, i);
        }
    }


    public void maxHeap(int[] heap, int start, int end) {
        if (start == end) {
            return;
        }

        int parent = start;
        int childLeft = start * 2 + 1;
        int childRight = childLeft + 1;

        if (childLeft <= end) {
            maxHeap(heap, childLeft, end);

            if (heap[childLeft] > heap[parent]) {
                swap(heap, parent, childLeft);
            }
        }

        if (childRight <= end) {
            maxHeap(heap, childRight, end);

            if (heap[childRight] > heap[parent]) {
                swap(heap, parent, childRight);
            }
        }
    }

    @Override
    public void merge_sort(int[] array) {
        // 归并排序采用分治的思想,含义就是将两个或两个以上的有序表合并成一个新的有序表
        mergeSort(array, 0, array.length - 1, new int[array.length]);
    }

    private static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) { // 如果起始下标跟结束下标差值小于1，则不进行操作
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, temp); // 将左边分为一组，内部递归地进行排序
            mergeSort(arr, mid + 1, right, temp); // 将右边分为一组，内部递归地进行排序
            merge(arr, left, mid, right, temp); //将左右分组合并
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left; // 定义左指针
        int j = mid + 1; // 定义右指针
        int t = 0; // 给temp临时数组用的指针
        while (i <= mid && j <= right) { // 设置左右指针的移动边界
            if (arr[i] <= arr[j]) { // 此处是升序，故谁小谁先赋给临时数组
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        while (i <= mid) { // 如果左边有剩余，则放在temp中
            temp[t++] = arr[i++];
        }
        while (j <= right) { // 如果右边有剩余，依次放入temp中
            temp[t++] = arr[j++];
        }
        t = 0;
        // 此时temp中已经是arr数组中下标从left到right之间排好序的数据了，因为temp每次都是从0开始赋值，所以需将排好序的数放回arr的对应位置
        while (left <= right) {
            // 将left到right之间排好序的数据放回arr中，此时left到right之间的数就是最终排好序的数
            arr[left++] = temp[t++];
        }
    }

    @Override
    public void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
