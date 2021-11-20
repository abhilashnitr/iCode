31`P1
https://leetcode.com/problems/count-number-of-nice-subarrays/
https://leetcode.com/problems/binary-subarrays-with-sum/
https://leetcode.com/problems/subarrays-with-k-different-integers/



Diff:
https://leetcode.com/problems/minimum-window-substring/
https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
https://leetcode.com/problems/find-all-anagrams-in-a-string/
https://leetcode.com/problems/permutation-in-string/
https://leetcode.com/problems/replace-the-substring-for-balanced-string






Problems such as finding longest substring or shortest substring with some contraints are mostly based on sliding window.

https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
https://leetcode.com/problems/replace-the-substring-for-balanced-string/
https://leetcode.com/problems/max-consecutive-ones-iii/
https://leetcode.com/problems/fruit-into-baskets/
https://leetcode.com/problems/get-equal-substrings-within-budget/
https://leetcode.com/problems/longest-repeating-character-replacement/
https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/
https://leetcode.com/problems/minimum-size-subarray-sum/
https://leetcode.com/problems/sliding-window-maximum/
https://leetcode.com/problems/count-number-of-nice-subarrays/
https://leetcode.com/problems/binary-subarrays-with-sum/

Basic template of such problems is basically 3 steps.

Step1: Have a counter or hash-map to count specific array input and keep on increasing the window toward right using outer loop.
Step2: Have a while loop inside to reduce the window side by sliding toward right. Movement will be based on constraints of problem. Go through few examples below
Step3: Store the current maximum window size or minimum window size or number of windows based on problem requirement.



930 1248 3 992 438
76(skip) 567 1100 1208 1438
424 395(skip) 340 159 1004
1456 325 209 1358 1234
239 713 560 974 713

R- 992 438 930 1438 395(D) 

similarity : 567 438 (string based)
             930 3 1248  560 974 - 159 340 -1004
             1100 is alter version of 3 
             424 is a interesting trick
             
2nd revise:
3   - strugled a bit on while loop annd window reduce logic.
159,340 - confussed on  j - i + 1 or j-i , conclusionn if j++ is done in while loop before then do j-i else j-i+1 then 
          j++ , inn for loop use j-i+1 as j++ is done in declaration statement.
209 - one error on using if loop instread of while asked min length where sum is greater than or equal to target. (so 
      better to use while loop to reduce the window and calculated result inside while loop ) 
239 - sliding window max (standard question with using queue) maintain decreasing order inside queue.
325	- Maximum Size Subarray Sum Equals k - similar to twwo use problem (use of hashMap)
424 - Longest Repeating Character Replacement - 
      //length of the entire string - number of times of the maximum occurring character in the string
      //Given this, we can apply the at most k changes constraint and maintain a sliding window such that
      //(length of substring - number of times of the maximum occurring character in the substring) <= k    
438 - Find All Anagrams in a String - 
      actully i saw the solution but tried to work again.
560 - Subarray Sum Equals K - variation of 2 sum problem.
567 - Permutation in String (simillar to 438).
713 - Subarray Product Less Than K  . Atmost logic like 159 , 340 . used while in reduce window logic instread of if .
930 - Binary Subarrays With Sum - - variation of 2 sum problem.
974 - Subarray Sums Divisible by K - - variation of 2 sum problem.
992 - Subarrays with K Different Integers - Two atmost logic
1004- Max Consecutive Ones III -Atmost logic
1248- Count Number of Nice Subarrays- variation of 2 sum problem.
1358- Number of Substrings Containing All Three Characters
1208- Get Equal Substrings Within Budget--Simple SLidingWindow
1234. Replace the Substring for Balanced String
1100

2 Sum variation plus sliding window_____          
Count Number of Nice Subarrays
Binary Subarrays With Sum
560 Subarray Sum Equals K
Subarray Sums Divisible by K        
MinimumSizeSubarraySum
MaximumSizeSubarraySumEqualsk
          
FindK_LengthSubstringsWithNoRepeatedCharacters
LongestSubstringWithoutRepeatingCharacters

Simple
Get Equal Substrings Within Budget
MaximumNumberofVowelsinaSubstringofGivenLength

Diff
SubarrayswithKDifferentIntegers      
       
Queue Based 
1438 - LongestContinuousSubarrayWithAbsoluteDiffLessThanorEqualtoLimit
239 - Sliding Window Maximum