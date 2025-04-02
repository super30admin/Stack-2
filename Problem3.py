#time complexity o(n)
#space complexity o(1)
class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        map = {}
        result = []
        for i in range(len(s)):
            c = ord(s[i]) - ord('a')
            map[c] = i

        start = 0
        end = 0
        for i in range(len(s)):
            c = ord(s[i]) - ord('a')
            end = max(end,map[c])
            if i == end:
                result.append(end-start+1)
                start = i + 1

        return result
        