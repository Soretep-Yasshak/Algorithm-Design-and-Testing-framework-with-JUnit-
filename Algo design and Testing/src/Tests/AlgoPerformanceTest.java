package Tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.Random;

import static Algos.iterative.B_SearchAlgos.contains;
import static Algos.iterative.B_SearchAlgos.indexOf;
import static Algos.iterative.B_SearchAlgos.binarySearch;
import static Algos.iterative.SortAlgos.bubbleSort;
import static Algos.iterative.SortAlgos.insertionSort;
import static Algos.iterative.SortAlgos.selectionSort;
import static Algos.recursive.SortAlgos.mergeSort;
import static Algos.recursive.SortAlgos.quickSort;
import static Algos.recursive.B_SearchAlgos.R_binarySearch;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlgoPerformanceTest {

    int[] smallArray;
    int[] mediumArray;
    int[] largeArray;


    @BeforeEach
    void setUp() {

        smallArray             = generateRandomArray();
        mediumArray            = generateRandomArray();
        largeArray             = generateRandomArray();

    }


    static int[] generateRandomArray() {

        Random random        = new Random();
        int bound            = 1000;
        int[] list           = new int[bound / 2];
        int num;

        for(int i = 0; i < list.length; i++) {

            num              = random.nextInt(bound);

            if (!(contains(list, num))) {

                list[i]      = num;

            }

            else {

                i--;

            }

        }

        return list;

    }

    boolean isSorted(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {

            if (array[i] > array[i + 1]) {

                return false;

            }

        }

        return true;

    }

    @Test
    void testSequentialSearch() {

        System.out.println("\n\n=======================================================");
        System.out.println(" S E Q U E N T I A L   S E A R C H   T E S T S ");
        System.out.println("=======================================================\n");

        String[] sizes         = new String[3];
        sizes[0]               = "Small";
        sizes[1]               = "Medium";
        sizes[2]               = "Large";

        for (int i = 0; i < sizes.length; i++) {

            int[] array;

            if (sizes[i].equals("Small")) {

                array          = smallArray.clone();

            }

            else if (sizes[i].equals("Medium")) {

                array          = mediumArray.clone();

            }

            else {

                array          = largeArray.clone();

            }

            System.out.println("\n" + sizes[i] + " Array Test");
            System.out.println("----------------------------------------");

            System.out.println("\n----------- indexOf ------------");
            System.out.println("location of 3: " + indexOf(array, 3));
            System.out.println("location of 7: " + indexOf(array, 7));
            System.out.println("location of 8: " + indexOf(array, 8));

            System.out.println("\n----------- contains ------------");
            System.out.println("contains 3: " + contains(array, 3));
            System.out.println("contains 7: " + contains(array, 7));
            System.out.println("contains 8: " + contains(array, 8));

            System.out.println("\n=======================================================\n");
        }

    }


    @Test
    void testBinarySearchComparison() {

        System.out.println("\n\n=======================================================");
        System.out.println(" B I N A R Y   S E A R C H   C O M P A R I S O N ");
        System.out.println("=======================================================\n");

        String[] sizes          = new String[3];
        sizes[0]                = "Small";
        sizes[1]                = "Medium";
        sizes[2]                = "Large";

        for (int i = 0; i < sizes.length; i++) {

            int[] array;

            if (sizes[i].equals("Small")) {

                array           = smallArray.clone();

            }

            else if (sizes[i].equals("Medium")) {

                array           = mediumArray.clone();

            }

            else {

                array           = largeArray.clone();

            }

            quickSort(array);  // Sort array first

            int targetIndex     = array.length / 2;
            int target          = array[targetIndex];

            System.out.println("\n" + sizes[i] + " Array Test");
            System.out.println("----------------------------------------");
            System.out.println("Searching for value: " + target);

            // Test iterative binary search
            long startTime      = System.nanoTime();
            int iterativeResult = binarySearch(array, target);
            long iterativeTime  = (System.nanoTime() - startTime) / 1_000_000;

            // Test recursive binary search
            startTime           = System.nanoTime();
            int recursiveResult = R_binarySearch(array, target, 0, array.length - 1);
            long recursiveTime  = (System.nanoTime() - startTime) / 1_000_000;

            assertEquals(iterativeResult, recursiveResult);
            assertEquals(targetIndex, iterativeResult);

            System.out.println("\nIterative Binary Search:");
            System.out.println("\tFound at index: " + iterativeResult);
            System.out.println("\tExecution Time: " + iterativeTime + " ms");

            System.out.println("\nRecursive Binary Search:");
            System.out.println("\tFound at index: " + recursiveResult);
            System.out.println("\tExecution Time: " + recursiveTime + " ms");

        }

        System.out.println("\n=======================================================\n");

    }


    @Test
    void testSortingAlgorithms() {

        System.out.println("\n\n=======================================================");
        System.out.println(" A L G O R I T H M   P E R F O R M A N C E   T E S T S ");
        System.out.println("=======================================================\n");

        String[] sizes        = new String[3];
        sizes[0]              = "Small";
        sizes[1]              = "Medium";
        sizes[2]              = "Large";

        for (int i = 0; i < sizes.length; i++) {

            int[] array;

            if (sizes[i].equals("Small")) {

                array          = smallArray.clone();

            }

            else if (sizes[i].equals("Medium")) {

                array          = mediumArray.clone();

            }

            else {

                array          = largeArray.clone();

            }

            System.out.println("\n" + sizes[i] + " Array Sample (First 10 elements):");
            System.out.println("----------------------------------------");

            for (int j = 0; j < 10; j++) {

                System.out.print(array[j] + " ");

            }

            System.out.println("\n");

            testAlgorithm("B U B B L E   S O R T", array.clone());
            testAlgorithm("I N S E R T I O N   S O R T", array.clone());
            testAlgorithm("S E L E C T I O N   S O R T", array.clone());
            testAlgorithm("M E R G E   S O R T", array.clone());
            testAlgorithm("Q U I C K   S O R T", array.clone());

            System.out.println("\n=======================================================\n");

        }

    }


    void testAlgorithm(String name, int[] array) {

        System.out.println("\n\t\t" + name);
        System.out.println("\t\t" + "-".repeat(name.length()));

        long startTime        = System.nanoTime();

        if (name.contains("BUBBLE")) {

            bubbleSort(array);

        }

        else if (name.contains("INSERTION")) {

            insertionSort(array);

        }

        else if (name.contains("SELECTION")) {

            selectionSort(array);

        }

        else if (name.contains("MERGE")) {

            mergeSort(array);

        }

        else {

            quickSort(array);

        }

        long timeInMs        = (System.nanoTime() - startTime) / 1_000_000;

        assertTrue(isSorted(array));

        System.out.println("\tSorted Sample (First 10 elements):");

        for (int i = 0; i < 10; i++) {

            System.out.print(array[i] + " ");

        }

        System.out.println("\n\tExecution Time: " + timeInMs + " ms");

    }

}