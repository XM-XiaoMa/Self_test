package com.data_structure.sort;

import java.util.Arrays;

/**
 * Created by mbc on 19-6-24
 * Description:
 */
public class SortOpt {

    public static void main(String[] args) {
        int[] array = {2, 4, 7, 8, 5, 6, 9, 7, 7, 10, 17, 11, 45, 576, 233424, 65, 342, 65, 45, 45, 565, 7};

//        SortUtil.getInstance().bubble_sort(array);
//        SortUtil.getInstance().quick_sort(array);
//        SortUtil.getInstance().heap_sort(array);
        SortUtil.getInstance().merge_sort(array);
        System.out.print(Arrays.toString(array));
    }

}
