/*
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 

Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 

Constraints:

1 <= n <= 45
*/

class Solution {

  // Solution 1
    /*int calc(int n,memo<Integer,Integer> memo){
            if (n == 0)
            {return 1;}
            if (n < 0)
            {return 0;}

    if(memo.containsKey(n))
    {return memo.get(n);}
    else{
    int result = calc(n - 1,memo) + calc( n - 2,memo);
    memo.put(n,result);
    return  result;

    }


    }*/

    public int climbStairs(int n) {
   
    /*memo<Integer, Integer> memo = new memo<>();
    return calc(n,memo);*/

    // Solution 2
      if (n <= 2) {
            return n;
        }
        
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        return dp[n];
    

    }
}
