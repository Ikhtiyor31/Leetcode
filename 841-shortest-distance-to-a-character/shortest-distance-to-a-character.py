class Solution:
    def shortestToChar(self, s: str, c: str) -> List[int]:
        res = [0] * len(s)
        c_idx = []

        for i in range(len(s)):
            if s[i] == c:
                c_idx.append(i)

        for i in range(len(s)):
            if len(c_idx) >= 2:
                res[i] = min(abs(c_idx[0] - i), abs(c_idx[1] - i))
                if abs(c_idx[0] - i) > abs(c_idx[1] - i):
                    c_idx = c_idx[1:]
            else:
                res[i] = abs(c_idx[0] - i)
   
        return res