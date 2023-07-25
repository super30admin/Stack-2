#Time Complexity:O(n)
#Space Complexity:O(n)

class Solution(object):
    def exclusiveTime(self, n, logs):
        """
        :type n: int
        :type logs: List[str]
        :rtype: List[int]
        """
        result=[0]*n
        stack=[]
        time=0
        for log in logs:
            stamp=log.split(":")
            if stamp[1]=="start":
                if len(stack)!=0:
                    result[int(stack[-1][0])]+=int(stamp[2])-time
                stack.append((stamp[0],stamp[2]))
                time=int(stamp[2])
            else:
                result[int(stamp[0])]+=int(stamp[2])-time+1
                stack.pop()
                time=int(stamp[2])+1
        return result
