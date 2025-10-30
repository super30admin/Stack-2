#  Time Complexity : O(N)   
#  Space Complexity : O(N)  
#  Did this code successfully run on Leetcode : Yes
#  Three line explanation of solution in plain english: This code calculates the exclusive execution time of functions using a stack to track active processes. When a function starts, it adds the time since the previous event to the currently running function (if any) and pushes the new function onto the stack; when it ends, it adds its total running time (including the end time) and pops it. The prev variable helps maintain the last processed timestamp to correctly compute time differences between consecutive logs.

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        # TC: O(n)  SC: O(n)
        st = []
        result = [0] * n
        prev = 0

        for log in logs:
            splitArr = log.split(":")
            processId = int(splitArr[0])
            processName = splitArr[1]
            curr = int(splitArr[2])

            if processName == "start":
                if st:
                    result[st[-1]] += curr - prev
                st.append(processId)
            else:
                curr = curr + 1
                result[st.pop()] += curr - prev

            prev = curr

        return result