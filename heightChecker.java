/*

https://leetcode.com/problems/height-checker/

1051. Height Checker
Easy

A school is trying to take an annual photo of all the students. The students are asked to stand in a single file line in non-decreasing order by height. Let this ordering be represented by the integer array expected where expected[i] is the expected height of the ith student in line.

You are given an integer array heights representing the current order that the students are standing in. Each heights[i] is the height of the ith student in line (0-indexed).

Return the number of indices where heights[i] != expected[i].

*/
import java.util.Arrays;
public class heightChecker {
    public static void main(String[] args)
    {
        int[] heights = {1,1,4,2,1,3};
        System.out.println(Arrays.toString(heights));
        int outputIndices = solution1(heights);
        System.out.println(outputIndices);

    }

    public static int solution1(int[] heights)
    {
        int unmatchedIndices = 0;

        //Getting a copy of array to compare
        int[] expectedOrder = new int[heights.length];
        int i = 0;
        for(int val : heights)
        {
            expectedOrder[i++] = val;
        }

        //Sorting via bubble sort
        int e = expectedOrder.length;
        boolean isSwapDone = true;
        while(isSwapDone) {
            isSwapDone = false;
            for (int j = 0; j < e-1; j++) {
                if (expectedOrder[j] > expectedOrder[j+1]) {
                    int temp = expectedOrder[j];
                    expectedOrder[j] = expectedOrder[j+1];
                    expectedOrder[j+1] = temp;
                    isSwapDone = true;
                }
            }
        }

        // Compare both the arrays for invalid orders
        for(int j=0; j<e; j++)
        {
            if(heights[j] != expectedOrder[j])
            {
                unmatchedIndices++;
            }
        }

        return unmatchedIndices;
    }
}
