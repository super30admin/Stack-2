#time complexity o(m)
#space complexity o(n+m)

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        st = []
        result = [0] * n
        curr = 0
        prev = 0
        for log in logs:
            strArr = log.split(":")
            taskId = int(strArr[0])
            curr = int(strArr[2])
            if strArr[1] == "start":
                if st:
                    result[st[-1]] += curr - prev
                st.append(taskId)
                prev = curr
            else:
                popped = st.pop()
                result[popped] += curr + 1- prev
                prev = curr+1
        return result
