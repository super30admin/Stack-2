# // Time Complexity :O(n),len of logs
# // Space Complexity :O(n),height of stack
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        
        st=[]
        prev=0
        result=[0 for i in range(n)]
        for i in logs:
            li=i.split(':')
           
            if li[1]=='start':
                curr=int(li[2])
                
                if len(st)!=0:
                    print("x")
                    result[st[-1]]=result[st[-1]]+curr-prev
                prev=curr
                st.append(int(li[0]))
            else:
                curr=int(li[2])
                
                top=st.pop()
                result[top]=result[top]+curr+1-prev
                prev=curr+1
            print(result)
        return result