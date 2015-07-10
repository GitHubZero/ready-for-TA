/*
 *find kth largest number in two sorted array
 *
 */
import java.util.*;



public class FindKthSorted {
    //Method 1: time complexity O(k), no extra space

    public int findKth (int[] a, int[] b, int k) {
        int lenA = a.length;
        int lenB = b.length;
        if (k > lenA + lenB) {
            throw new RuntimeException("Cannot find");
        }
        int indexA = lenA - 1;
        int indexB = lenB - 1;
        int count = 0;
        if (k == 1) {
            return Math.max(a[indexA], b[indexB]);
        }

        while (indexA >= 0 && indexB >= 0) {
            if (a[indexA] < b[indexB]) {
                count++;
                if (count == k) {
                    return b[indexB];
                }
                indexB--;
            }else{
                count++;
                if (count == k) {
                    return a[indexA];
                }
                indexA--;
            }
        }
        if (indexA < 0) {
            return b[indexB - (k - count) + 1];
        }else{
            return a[indexA - (k - count) + 1];
        }
    }
    
    //Method 2: time complexity (logn + logm)
    public int findKth2 (int[] a, int[] b, int k) {
        return helper(a, 0, b, 0, a.length + b.length - k + 1);
    }
    
    private int helper(int A[], int startA, int B[], int startB, int k) {
        //base case:
        //1. if startA is out of A
        if (startA >= A.length) {
            return B[startB - 1 + k];
        }
        //2. if startB greater than length
        if (startB >= B.length) {
            return A[startA - 1 + k];
        }
        //3. if k == 1
        if (k == 1) {
            return Math.min(A[startA], B[startB]);
        }
        //BUG: pay attention for "-1" for index from 0;
        int keyA = ((startA + (k / 2) - 1) < A.length) ? A[startA + k / 2 - 1] : Integer.MAX_VALUE;
        int keyB = ((startB + (k / 2) - 1) < B.length) ? B[startB + k / 2 - 1] : Integer.MAX_VALUE;
        
        if (keyA > keyB) {
            return helper(A, startA, B, startB + k / 2, k - k / 2);
        }else{
            return helper(A, startA + k / 2, B, startB, k - k / 2);
        }
    }
    
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[] b = {4,5};
        FindKthSorted test = new FindKthSorted();
        int res = test.findKth2(b, a, 3);
        System.out.println(res);
    }
}