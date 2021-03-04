#Time Complexity :o(n) n- len of logs
#Space Complexity :o(n) n- len of logs
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this :no

class Solution(object):
    def exclusiveTime(self, n, logs):
        """
        :type n: int
        :type logs: List[str]
        :rtype: List[int]
        """
        #edge case
        if(logs==None or len(logs)==0):
            return []
        
        res=[0]*n
        prev=0
        stack=[]
        for log in logs:
            arrS=log.split(':')
            curr=int(arrS[2])
            if(arrS[1]=='start'):
                if(stack):
                    res[stack[len(stack)-1]]+=curr-prev
                    prev=curr
                stack.append(int(arrS[0]))
            else:
                res[stack.pop()]+=curr+1-prev
                prev=curr+1
                
        return res
                