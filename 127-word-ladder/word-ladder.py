class Solution:
    def ladderLength(self, start: str, end: str, wordList: List[str]) -> int:
        if len(wordList) == 0:
            return 0

        letters = "abcdefghijklmnopqrstuvwxyz"
        my_set = set()
        for word in wordList:
            my_set.add(word)
        visited = set()
        queue = []
        queue.append((start, 1))
        visited.add(start)
        while queue:
            word, transformation = queue.pop(0)
            if word == end:
                return transformation
            for i in range(len(word)):
                copy_word = list(word)
                for c in letters:
                    if c == copy_word[i]:
                        continue
                    new_word = word[:i] + c + word[i + 1:]
                    if new_word in my_set and new_word not in visited:
                        queue.append((new_word, transformation + 1))
                        visited.add(new_word)
        return 0