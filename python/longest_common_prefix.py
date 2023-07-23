'''
Longest Common Prefix

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 

Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters.

'''
class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        
        count = 0
        output = ""
        s1 = strs[0]

        for i,l in enumerate(s1):

            for s in strs:
                if len(s)-1 >= i and s[i] == l:
                    count = count + 1
                else:
                    return output

            if count == len(strs) :
                output += l    
                count = 0 
            
        return output
