# time complexity is o(n), where n is the size of the input
# space complexity is o(n), where n is the size of the input
class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        prev = 0
        curr = 0
        stack = list()
        res = [0 for i in range(n)]
        for l in logs:
            curr = l.split(":")
            if(curr[1] == "start"):
                if(len(stack) != 0):
                    k = stack[-1]
                    res[k] += int(curr[2]) - prev
                stack.append(int(curr[0]))
                prev = int(curr[2])
            else:
                res[stack.pop()] += int(curr[2]) + 1 - prev
                prev = int(curr[2]) + 1
                # stack.append(int(curr[0]))
        return res
                    
        