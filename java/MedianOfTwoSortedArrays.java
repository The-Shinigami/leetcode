/**
iven two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

 

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 

Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106
**/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
        int m = nums2.length;
        int[] result = new int[m+n];
        int n1i=0,n2i=0,ri=0;
        int limit = (n+m)/2;

        while(ri<=limit && n1i<n && n2i<m){
           if(nums1[n1i] < nums2[n2i]){
               result[ri++] = nums1[n1i++];
           }else{
               result[ri++] = nums2[n2i++];
           }
        }

        while(n1i<n && ri<=limit){
            result[ri++]=nums1[n1i++];
        }
        while(n2i<m && ri<=limit){
            result[ri++]=nums2[n2i++];
        }

        double med = 0d;
        if((n+m)%2 == 0){
            med = (double)(result[ri - 1] + result[ri-2]) / 2;
        }else{
            med = result[ri-1];
        }
        return med;
    }
}
