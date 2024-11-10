package Algos.iterative;

public class SortAlgos {


    public static void bubbleSort(int[] data) {


        for (int i = 0; i < data.length - 1; i++) {

            for (int j = 0; j < data.length - i - 1; j++) {

                if (data[j] > data[j + 1]) {

                    int temp        = data[j];
                    data[j]         = data[j + 1];
                    data[j + 1]     = temp;

                }

            }

        }

    }


    public static void insertionSort(int[] data) {

        for (int i = 1; i < data.length; i++) {

            int current        = data[i];
            int j              = i;

            while (j > 0 && current < data[j - 1]) {

                data[j]        = data[j - 1];
                j--;

            }

            data[j]            = current;

        }

    }


    public static void selectionSort(int[] data) {

        for (int i = 0; i < data.length - 1; i++) {

            int minIndex       = i;

            for (int j = i + 1; j < data.length; j++) {

                if (data[j] < data[minIndex]) {

                    minIndex   = j;

                }

            }

            if (minIndex != i) {

                swap(data, minIndex, i);

            }

        }

    }


    public static void swap(int[] data, int a, int b) {

        int temp              = data[a];
        data[a]               = data[b];
        data[b]               = temp;

    }

}
