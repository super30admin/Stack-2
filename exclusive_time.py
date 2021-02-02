class Solution(object):
    def exclusiveTime(self, n, logs):
        """
        :type n: int
        :type logs: List[str]
        :rtype: List[int]
        """
        #O(no. of logs)
        #O(no. of functions)
        stack=[]
        #stack will have indices to be accessed
        prev=0
        res=[0]*(n)
        for log in logs:
            splitted=log.split(":")
            cur=int(splitted[2])
            if splitted[1]=="start":
                if stack:
                    res[stack[-1]]+=cur-prev
                    prev=cur
                stack.append(int(splitted[0]))
            else:
                res[stack.pop()]+=cur-prev+1
                prev=cur+1
        return res
            
            
            