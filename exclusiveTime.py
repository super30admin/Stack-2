class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
    '''
    1. If the incoming log is a start log:
            if stack is empty:
                push it into the stack
            elif stack is not empty:
                add the difference between the 
                curr func's start time and the func 
                at the top of the stack to the func 
                at the top of the stack.
        elif incoming func is end:
            then pop the top element from the stack
            get the differnce in the timing 
            add it to the func id  
            if there is stack, it mean sthere is a func that has been paused and will resume.
            So we need to update it's start val to the curr func's end val. 
            
     T = O(N)
     S = O(N)
    '''
     
        stack = [] 
        result = [0]*(n)
        curr_start , curr_end = 0 , 0 
        for log in logs:
            curr_log = log.split(':')
            if 'start' == curr_log[1]:
                if not stack:
                    stack.append( [ int(curr_log[0]) , int(curr_log[2]) ] )
                else:
                    result[stack[-1][0]] +=  int(curr_log[2]) - int(stack[-1][1]) 
                    stack.append( [ int(curr_log[0]) , int(curr_log[2]) ]  )
            elif 'end' == curr_log[1]:
                top_of_stack = stack.pop()
                result[ int(curr_log[0])  ] += int(curr_log[2]) - int( top_of_stack[1] ) +1
                if stack:
                    stack[-1][1] = int(curr_log[2])+1
        return result
                
                
