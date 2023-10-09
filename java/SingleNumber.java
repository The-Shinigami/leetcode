/*
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.

 

Example 1:

Input: nums = [2,2,1]
Output: 1
Example 2:

Input: nums = [4,1,2,1,2]
Output: 4
Example 3:

Input: nums = [1]
Output: 1
 

Constraints:

1 <= nums.length <= 3 * 104
-3 * 104 <= nums[i] <= 3 * 104
Each element in the array appears twice except for one element which appears only once.
*/

class Solution {
    public int singleNumber(int[] nums) {

    // Solution 1
        /*HashMap<Integer,Integer> countNum = new HashMap<Integer,Integer>();

        Arrays.stream(nums).forEach(
            n -> {
                if(countNum.containsKey(n)){
                    countNum.put(n,countNum.get(n)+1);
                }else{
                    countNum.put(n,1);
                }

            }
        );

        for (Map.Entry<Integer, Integer> entry : countNum.entrySet()) {
            if (1 == entry.getValue()) {
                return entry.getKey();
            }
        }

        return 0;*/

    // Solution 2    
    int result = 0;

    for (int num : nums) {
        result ^= num;
    }

    return result;
        
    }
}
