class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        
        
        f = [0]*(n)
        
        
        stack=[]
        
        
        for i in logs:
            
            ID,pos,time = i.split(':')
            
            ID= int(ID)
            time= int(time)
            if pos == 'start':
                
                stack.append([ID,time])
            else:
                
                prID, prtime = stack.pop()
                
                timespent = time-prtime+1
                f[ID]+= timespent
                
                #remove the overlapping time 
                
                if stack:
                    f[stack[-1][0]]-= timespent
                    
        return f

%TC:O(n)
%SC:O(n)