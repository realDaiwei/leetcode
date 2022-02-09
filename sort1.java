import java.util.Arrays;
import java.util.Random;

import javafx.util.converter.NumberStringConverter;

class Sort {

    public static void main(String[] args) {
        int[] arr = createRandomArr(100);
        //bubbleSort(arr);
        // selectSort(arr);
        // insertSort(arr);
        // shellSort(arr);
        // mergeSort(arr);
        quickSort(arr);
        printlnArr(arr);
        boolean sortRes = checkSort(arr, true);
        System.out.println("排序结果：" + sortRes);
    }

    /**
     * 冒泡排序
     * @param arr
     * @return
     */
    private static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }


    /**
     * 选择排序
     * @param arr
     * @return
     */
    private static int[] selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) min = j;
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        return arr;
    }

    /**
     * 插入排序
     * @param arr 
     * @return 
     */
    private static int[] insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int cur = arr[i], curIdx = i;
            while (curIdx > 0 && cur < arr[curIdx - 1]) {
                arr[curIdx] = arr[curIdx - 1];
                curIdx--;
            }
            arr[curIdx] = cur;
        }
        return arr;
    }    


    /**
     * 希尔排序
     * @param arr
     * @return
     */
    private static int[] shellSort(int[] arr) {
        for (int step = arr.length / 2; step > 0; step /= 2) {
            for (int i = step; i < arr.length; i++) {
                int j = i - step, temp = arr[i];
                while (j >= 0 && arr[j] > arr[i]) {
                    arr[j + step] = arr[j];
                    j -= step;
                }
                arr[j + step] = temp;
            }
        }
        return arr;
    }

    /**
     * 归并排序
     * @param arr
     * @return
     */
    private static int[] mergeSort(int[] arr) {
        if (arr.length == 0) return arr;
        merge(arr, 0, arr.length - 1);
        return arr;
    }

    /**
     * merge
     * @param arr
     * @param start
     * @param end
     */
    private static void merge(int[] arr, int start, int end) {
        if (start >= end) return;
        int mid = (start + end) >> 1;
        merge(arr, start, mid);
        merge(arr, mid + 1, end);
        int c = 0, l = start, r = mid + 1;
        int[] temp = new int[end - start + 1];
        while (l <= mid && r <= end) {
            temp[c++] = arr[l] < arr[r] ? arr[l++] : arr[r++];
        }
        while (l <= mid) temp[c++] = arr[l++];
        while (r <= end) temp[c++] = arr[r++];
        System.arraycopy(temp, 0, arr, start, end - start + 1);
    }

    /**
     * 快速排序
     * @param arr
     * @return
     */
    public static int[] quickSort(int[] arr) {
        if (arr.length <= 1) return arr; 
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    /**
     * 快速排序
     * @param arr目标数组
     * @param l 左边界
     * @param r 右边界
     */
    private static void quickSort(int[] arr, int l, int r) {
        // terminate
        if (l >= r) return;
        // partition
        int cur = arr[l], j = l;
        for (int i = l + 1; i <= r; i++) {
            if (cur > arr[i]) {
                j++;
                int num = arr[i];
                arr[i] = arr[j];
                arr[j] = num;
            }
        }
        int num = arr[l];
        arr[l] = arr[j];
        arr[j] = num;
        // drill down
        quickSort(arr, l, j - 1); 
        quickSort(arr, j + 1, r);
    }

    /**
     * 打印输出
     * @param arr
     */
    private static void printlnArr(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 随机创建数组
     * @param n
     * @return
     */
    private static int[] createRandomArr(int n) {
        Random rnd = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rnd.nextInt(n);
        }
        return arr;
    }

    /**
     * 校验排序结果
     * @param arr 目标数组
     * @param asc 升序
     * @return
     */
    private static boolean checkSort(int[] arr, boolean asc) {
        for (int i = 0, j = 1; j < arr.length; i++, j++) {
            if (asc ? arr[i] > arr[j] : arr[i] < arr[j]) {
                return false;
            }
        }
        return true;
    }
    
}
