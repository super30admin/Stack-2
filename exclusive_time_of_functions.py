# https://leetcode.com/problems/exclusive-time-of-functions/
# Time Complexity- O(m) Space Complexity- O(m)

class Solution:
    def exclusiveTime(self, n: int, logs: list[str]) -> list[int]:
        # initialise the stack
        st = []
        # intialise the result set
        result = [0] * n       
        # intialise the pointer
        prev = 0
        
        # iterate over the logs
        for log in logs:
            splitArr = log.split(':')
            # find the process id from the logs
            processId = int(splitArr[0])
            # find the type: start or end
            type = splitArr[1]
            # find the counter
            curr = int(splitArr[2]) 

            # handle the start logs
            if type == 'start':
                # pause currently running function
                if st:
                    result[st[-1]] = curr - prev + 1
                # start new function
                st.append(processId)
            # handle the end logs
            else:
                # end timestamps are inclusive so add 1
                curr += 1
                # pop the element as the log is ending by incrementing the curr
                result[st.pop()] = curr - prev + 1
            # move the timeline forward
            prev = curr

        return result
