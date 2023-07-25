import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> hash_list = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (hash_list.containsKey(complement)) {
                int[] indexes = {hash_list.get(complement),i};
                return indexes;
            }
            hash_list.put(nums[i], i);
        }


        return null;
    }
}
