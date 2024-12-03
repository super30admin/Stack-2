class Solution(object):
    def exclusiveTime(self, n, logs): #T.C-> O(N) , S.C -> O(N/2)
        """
        :type n: int
        :type logs: List[str]
        :rtype: List[int]
        """
        result = [0] * n
        st = []
        prev = 0

        for log in logs:
            splitArr = log.split(':')
            processId = int(splitArr[0])
            typeOf = splitArr[1]
            curr = int(splitArr[2])

            if typeOf == 'start':
                if len(st) !=0:
                    result[st[-1]] += curr - prev
                st.append(processId)
            else:
                curr = curr + 1
                result[st.pop()] += curr - prev
            prev = curr
        return result
