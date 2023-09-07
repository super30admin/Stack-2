# Time Complexity: O(n)
# Space Complexity: O(n)
# Did this problem run on Leetcode: Yes
# Any issues faced doing this problem: No

class Solution(object):
    def exclusiveTime(self, n, logs):
        """
        :type n: int
        :type logs: List[str]
        :rtype: List[int]
        """
        tm = ([0] * n)
        st = []
        latestTime = 0
        for i in logs:
            ar = i.split(":")
            if ar[1] == "start":
                if len(st) != 0:
                    tm[int(st[-1][0])] += (int(ar[2]) - latestTime)
                st.append((ar[0], ar[2]))
                latestTime = int(ar[2])
            else:
                tm[int(ar[0])] += (int(ar[2]) - latestTime + 1)
                st.pop()
                latestTime = (int(ar[2]) + 1)
        return tm