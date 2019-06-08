package xmu.cs.lgp.algorithm.sort;

/**
 * @Des 堆排序算法
 * @Author gplee@sina.cn
 * @Date 2019/6/8 11:30
 **/
public class HeapSort {

    public static void main(String[] args) {
        int[] arrayTobeSort = new int[] {3,7,4,9,1,8,2,5,6};

        // 创建一个大顶堆
        createMaxHeap(arrayTobeSort);

        // 基于大顶堆排序
        heapSort(arrayTobeSort, arrayTobeSort.length);

        for (int i=0; i<arrayTobeSort.length; i++) {
            System.out.print(" " + arrayTobeSort[i]);
        }

    }

    public static void heapSort(int[] array, int arraySize) {
        for (int i = arraySize - 1; i > 0; i-- ) {
            // 每次用堆顶与最后一个元素交换
            swap(array, 0, i);

            // 重新从堆顶元素调整成大顶堆
            adjust2MaxHeap(array, i, 0);
        }
    }

    public static void createMaxHeap(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        int arraySize = array.length;
        for (int i = arraySize/2 ; i>=0; i--) {
            adjust2MaxHeap(array, arraySize, i);
        }
    }

    /**
     *  调整成大顶堆
     *
     * @param array
     * @param arraySize
     * @param startIndex
     */
    public static void adjust2MaxHeap(int[] array, int arraySize, int startIndex) {
        int left = startIndex * 2 + 1;
        int right = startIndex * 2 + 2;
        int maxIndex = startIndex;

        if (left <= arraySize - 1 && array[maxIndex] < array[left]) {
            maxIndex = left;
        }

        if (right <= arraySize - 1 && array[maxIndex] < array[right]) {
            maxIndex = right;
        }

        if (maxIndex != startIndex) {
            swap(array, maxIndex, startIndex);
            adjust2MaxHeap(array, arraySize, maxIndex);
        }
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }




}
