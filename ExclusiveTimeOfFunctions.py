# Time complexity: O(n) and space is also O(n) for stack use.

# The intuition is to use a stack to determine the next log that comes in, because the prev log pauses as the next comes out. Then if there is an
# end function then the top of the stack will be the start of that end function.

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        stack = []
        result = [0] * n
        curr = 0
        prev = 0
        for i in range(len(logs)):
            splitArr = logs[i].split(":")
            taskId = int(splitArr[0])
            curr = int(splitArr[2])
            if splitArr[1] == "start":
                if stack:
                    result[stack[-1]] += curr - prev
                prev = curr
                stack.append(taskId)
            else:
                result[stack.pop()] += curr + 1 - prev
                prev = curr + 1
        return result