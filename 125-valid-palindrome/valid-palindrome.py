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
            if s[l] == s[r]:
                l += 1
                r -= 1
            else:
                if (Solution.is_character(s[l]) or Solution.is_digit(s[l])) and (Solution.is_character(s[r]) or Solution.is_digit(s[r])):
                    return False
                if Solution.is_character(s[l]) or Solution.is_digit(s[l]):
                    r -= 1
                elif Solution.is_character(s[r]) or Solution.is_digit(s[r]):
                    l += 1
                else:
                    l += 1
                    r -= 1
        return True
