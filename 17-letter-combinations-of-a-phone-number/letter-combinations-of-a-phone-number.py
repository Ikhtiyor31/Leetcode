class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        phone_letters = {
            "2": "abc",
            "3": "def",
            "4": "ghi",
            "5": "jkl",
            "6": "mno",
            "7": "pqrs",
            "8": "tuv",
            "9": "wxyz",
        }

        letter_combination = []

        def backtrack(digits: str, curr: int, form: str) -> None:
            if curr >= len(digits):
                return
            digit = digits[curr]
            letters = phone_letters[digit]
            for letter in letters:
                form += letter

                if len(form) == len(digits):
                    letter_combination.append(form)
                backtrack(digits, curr + 1, form)
                form = form[: len(form) - 1]

        backtrack(digits, 0, "")
        return letter_combination
