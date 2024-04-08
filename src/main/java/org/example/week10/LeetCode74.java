package org.example.week10;

import org.example.Main;

import java.util.Arrays;

public class LeetCode74 {
    public boolean searchMatrix(int[][] matrix, int target) {
//        int findCol = searchBinaryCol(matrix, target);
//        return binarySearch(matrix[findCol], target);
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, right = m * n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int mid_val = matrix[mid / n][mid % n];

            if (mid_val == target)
                return true;
            else if (mid_val < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return false;
    }

    private int searchBinaryCol(int[][] matrix, int target){
        int left =0; int right = matrix.length -1 ;
        int result = -1;
        int prevPivot = -1;
        while(left <= right) {
            int pivot = (left + right) / 2;
            if (matrix[pivot][0] == target) {
                return pivot;
            }
            if (matrix[pivot][0] > target) {
                right = pivot-1;
            } else {
                left = pivot+1;
            }
            if(prevPivot == pivot) return pivot;
            prevPivot = pivot;
        }
        return prevPivot;
    }
    private boolean binarySearch(int[] matrix, int target) {
        int left =0; int right = matrix.length -1 ;
        int result = -1;
        int prevPivot = -1;
        while(left <= right) {
            int pivot = (left + right) / 2;
            if (matrix[pivot] == target) {
                return true;
            }
            if (matrix[pivot] > target) {
                right = pivot-1;
            } else {
                left = pivot+1;
            }
            if(prevPivot == pivot) break;
            prevPivot = pivot;
        }
        return matrix[prevPivot] == target;
    }
}
