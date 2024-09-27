// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach:
In this problem we use a stack and if the function is start then we make previous pointer to curr pointer and then push it to the stack and if the function is end then we change prev to curr+1 and then pop it from the stack.


# Time complexity --> o(n)
# space complexity --> o(n)
class Solution(object):
    def exclusiveTime(self, n, logs):
        """
        :type n: int
        :type logs: List[str]
        :rtype: List[int]
        """
        prev=0
        curr=0
        stack=[]
        res=[0 for i in range(n)]
        for i in range(len(logs)):
            log=logs[i]
            val=log.split(':')
            functionid=int(val[0])
            curr=int(val[2])
            #when the function is start then we push it to the stack and we manage curr and prev.
            if val[1]=='start':
                if len(stack)>0:
                    res[stack[-1]]=res[stack[-1]]+curr-prev
                    prev=curr
                stack.append(functionid)
            #If the fucntion is end then we manage curr and prev and pop the element from the stack.
            else:
                res[functionid]=res[functionid]+curr-prev+1
                prev=curr+1
                stack.pop()
        return res
            