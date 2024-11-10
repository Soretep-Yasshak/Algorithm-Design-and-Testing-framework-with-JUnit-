package Algos.recursive;

public class B_SearchAlgos {


    public static int R_binarySearch(int[] data, int target, int min, int max) {

        int result            = -1;

        if (min <= max) {

            int mid           = min + (max - min) / 2;

            if (data[mid] == target) {

                result        = mid;

            }

            else if (data[mid] < target) {

                result        = R_binarySearch(data, target, mid + 1, max);

            }

            else {

                result        = R_binarySearch(data, target, min, mid - 1);

            }

        }

        return result;

    }

}
