# Problem 2: Exclusive Time of Functions
class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        st = []
        result = [0 for _ in range(n)]
        curr = 0
        prev = 0
        for log in logs:
            splitArr = log.split(":")
            Id = int(splitArr[0])
            label = splitArr[1]
            time = int(splitArr[2])
            curr = time

            if label == "start":
                if st:
                    result[st[-1]] += curr - prev
                st.append(Id)
            elif label == "end":
                curr = curr + 1
                result[st.pop()] += curr - prev

            prev = curr

        return result

        