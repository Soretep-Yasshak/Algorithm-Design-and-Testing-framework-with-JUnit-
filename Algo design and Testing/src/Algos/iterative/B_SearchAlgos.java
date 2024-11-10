package Algos.iterative;

public class B_SearchAlgos {


    public static int binarySearch(int[] data, int target) {

        int min                  = 0;
        int max                  = data.length - 1;
        int result               = -1;

        while (min <= max) {

            int mid              = (min + max) / 2;

            if (data[mid] == target) {

                return mid;

            }

            else if (data[mid] < target) {

                min             = mid + 1;

            }

            else {

                max             = mid - 1;

            }

        }

        return result;

    }


    public static boolean contains(int[] data, int target) {

        boolean found         = false;

        for (int i = 0; i < data.length; i++) {

            if (data[i] == target) {

                found         = true;

            }

        }

        return found;

    }


    public static int indexOf(int[] data, int target) {

        int result            = -1;

        for (int i = 0; i < data.length; i++) {

            if (data[i] == target) {

                result        = i;

            }

        }

        return result;

    }

}
