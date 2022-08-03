# Time-Complexity: O(n)
# Space Complexity: O(n)
# Leetcode status: Accepted
class Solution(object):
    def exclusiveTime(self, n, logs):
        """
        :type n: int
        :type logs: List[str]
        :rtype: List[int]
        """
        result = [0] * n
        st = []
        prev = 0
        for log in logs:
            arr = log.split(':')
            curr = int(arr[2])
            idx = int(arr[0])
            if arr[1] == 'start':
                if len(st) != 0:
                    result[st[-1]] += curr - prev
                st.append(idx)
                prev = curr
            else:
                result[st.pop()] += curr + 1 - prev
                prev = curr + 1
        return result
