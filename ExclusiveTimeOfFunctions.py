
#time Complexity: O(N)
#spaceComplexity = O(N)

def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
    if not logs:
        return []
    result = [0] * n
    st = []
    prev = 0

    for log in logs:
        currLog = log.split(":")
        curr = int(currLog[2])
        if currLog[1] == "start":
            jobNumber = int(currLog[0])
            if st:
                idx = st[-1]
                result[idx] += curr - prev
            st.append(jobNumber)
        else:
            idx = st.pop()
            curr += 1
            result[idx] += curr - prev
        prev = curr

    return result