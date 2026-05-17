# problem 1 

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        st = []
        result = [0] * n

        for log in logs:
            splitArr = log.split(":")
            processId = int(splitArr[0])
            processType = splitArr[1]
            curr_time = int(splitArr[2])

            if processType == "start":
                if st:
                    result[st[-1][0]] += curr_time - st[-1][1]
                st.append([processId, curr_time])
            else:
                top = st.pop()
                result[top[0]] += curr_time - top[1] + 1
                if st:
                    st[-1][1] = curr_time + 1

        return result
