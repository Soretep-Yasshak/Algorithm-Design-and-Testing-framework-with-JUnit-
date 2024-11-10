package Algos.recursive;

public class SortAlgos {


    public static int[] getFirstHalf(int[] data) {

        if (data.length <= 1) {

            return data;

        }

        int midPoint          = (data.length + 1) / 2;
        int[] firstHalf       = new int[midPoint];

        copyArray(data, firstHalf, 0, 0, midPoint);

        return firstHalf;

    }


    public static int[] getSecondHalf(int[] data) {

        if (data.length <= 1) {

            return data;

        }

        int midPoint          = (data.length + 1) / 2;
        int[] secondHalf      = new int[data.length - midPoint];

        copyArray(data, secondHalf, midPoint, 0, data.length - midPoint);

        return secondHalf;

    }


    private static void copyArray(int[] src, int[] dest, int srcPos, int destPos, int length) {

        if (length > 0) {

            dest[destPos]     = src[srcPos];

            copyArray(src, dest, srcPos + 1, destPos + 1, length - 1);

        }

    }


    public static void merge(int[] data, int[] left, int[] right) {

        int[] firstHalf;
        int[] secondHalf;

        if (left == null || right == null) {

            firstHalf          = getFirstHalf(data);
            secondHalf         = getSecondHalf(data);

        }

        else {

            firstHalf          = left;
            secondHalf         = right;

        }

        mergeArrays(data, firstHalf, secondHalf, 0, 0, 0);

    }


    private static void mergeArrays(int[] data, int[] left, int[] right, int i, int j, int k) {

        if (i < left.length && j < right.length) {

            if (left[i] <= right[j]) {

                data[k]        = left[i];

                mergeArrays(data, left, right, i + 1, j, k + 1);

            }

            else {

                data[k]        = right[j];

                mergeArrays(data, left, right, i, j + 1, k + 1);

            }

        }

        else if (i < left.length) {

            data[k]            = left[i];

            mergeArrays(data, left, right, i + 1, j, k + 1);

        }

        else if (j < right.length) {

            data[k]            = right[j];

            mergeArrays(data, left, right, i, j + 1, k + 1);

        }

    }


    public static void mergeSort(int[] data) {

        if (data.length > 1) {

            int[] firstHalf    = getFirstHalf(data);
            int[] secondHalf   = getSecondHalf(data);

            mergeSort(firstHalf);
            mergeSort(secondHalf);

            merge(data, firstHalf, secondHalf);

        }

    }


    public static void quickSort(int[] data) {

        quickSort(data, 0, data.length - 1);

    }


    public static void quickSort(int[] data, int low, int high) {

        if (low < high) {

            int partitionIndex = partition(data, low, high, low, low - 1);

            quickSort(data, low, partitionIndex - 1);
            quickSort(data, partitionIndex + 1, high);

        }

    }


    public static int partition(int[] data, int low, int high, int j, int i) {

        if (j >= high) {

            Algos.iterative.SortAlgos.swap(data, i + 1, high);
            return i + 1;

        }

        if (data[j] <= data[high]) {

            i++;
            Algos.iterative.SortAlgos.swap(data, i, j);

        }

        return partition(data, low, high, j + 1, i);

    }


    public static void selectionSort(int[] data) {

        selectionSort(data, 0);

    }


    public static void selectionSort(int[] data, int start) {

        if (start < data.length - 1) {

            int minIndex       = findMin(data, start + 1, start);

            if (minIndex != start) {

                swap(data, start, minIndex);

            }

            selectionSort(data, start + 1);

        }

    }


    private static int findMin(int[] data, int current, int minIndex) {

        if (current >= data.length) {

            return minIndex;

        }

        if (data[current] < data[minIndex]) {

            minIndex          = current;

        }

        return findMin(data, current + 1, minIndex);

    }


    public static void swap(int[] data, int a, int b) {

        Algos.iterative.SortAlgos.swap(data, a, b);

    }

}