class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        st = []
        result = [0 for i in range(n)]
        prev = 0
        curr = 0
        if n is None:
            return result

        for i in range(len(logs)):
            l = logs[i].split(":")
            curr = int(l[-1])
            # if i == 0 and l[1] == "start":
            #     prev = 0
            #     st.append(int(l[0]))
            if l[1] == "start":
                if st:
                    temp = st[-1]
                    result[temp] += curr - prev
                prev = curr
                st.append(int(l[0]))
            elif l[1] == "end":
                if st:
                    temp = st.pop()
                    result[temp] += (curr + 1) - prev
                prev = curr + 1
        return result

# Time Complexity: O(n)
# Space Complexity: (n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

