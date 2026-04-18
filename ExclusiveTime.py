# Time Complexity : O(m) where m is number of logs
# Space Complexity :O(m)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : We use a stack to track which function is running at any given time.
# If a function starts, we pause the previous one and calculate how much it ran.
# When a function ends, we pop it and add its exclusive duration, adjusting for time units.


class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        st = []
        result = [0] * n
        prev = 0

        for log in logs:
            splitArr = log.split(":")
            processId = int(splitArr[0])
            processType = splitArr[1]
            curr = int(splitArr[2])

            if processType == "start":
                if st:
                    result[st[-1]] += curr - prev
                st.append(processId)
            else:
                curr = curr + 1
                result[st.pop()] += curr - prev

            prev = curr

        return result
