class Solution:
    def longestCommonSubsequence(self, s1: str, s2: str) -> int:
            def longest_common_subsequence(s1: str, s2: str, n: int, m: int, memo: {}) -> int:
                key = str(n) + "," + str(m)
                if n <= 0 or m <= 0:
                    return 0
                if key in memo:
                    return memo[key]

                if s1[n-1] == s2[m-1]:
                    memo[key] = longest_common_subsequence(s1, s2, n - 1, m - 1, memo) + 1
                    return memo[key]

                memo[key] = max(longest_common_subsequence(s1, s2, n - 1, m, memo), longest_common_subsequence(s1, s2, n, m - 1, memo))
                return memo[key]
            memo = {}
            return longest_common_subsequence(s1, s2, len(s1), len(s2), memo)