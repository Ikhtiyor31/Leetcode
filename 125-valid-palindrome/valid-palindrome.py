class Solution:
    def is_digit(s: str) -> bool:
        return len(s) == 1 and '0' <= s <= '9'
    def is_character(s: str) -> bool:
        return len(s) == 1 and 'a' <= s <= 'z'

    def isPalindrome(self, s: str) -> bool:   
        n = len(s)
        l = 0
        r = n - 1
        s = s.lower()
        while l < r:
            
            if not Solution.is_character(s[l]) and not Solution.is_digit(s[l]):
                l += 1
            elif not Solution.is_character(s[r]) and not Solution.is_digit(s[r]):
                r -= 1
            elif s[l] != s[r]:
                return False
            else:
                r -= 1
                l += 1
        return True
