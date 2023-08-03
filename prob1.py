# Time Complexity :  O(len(logs))
# Space Complexity :O(len(logs))
# Passed on Leetcode: yes

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        result = [0] * n
        st = []

        curr = 0
        prev = 0

        for log in logs:
            strArr = log.split(":") 
            currId = int(strArr[0])
            curr = int(strArr[2])

            if strArr[1] == "start":
                if st:
                    result[st[-1]] += curr - prev
                st.append(currId)
                prev = curr
            else:
                result[st.pop()] += curr + 1 - prev
                prev = curr + 1

        return result