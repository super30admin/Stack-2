
# STACK + 2 variables (current, previous)
# time : O(N), N: no.of.logs
# space : O(N), worstcase of storing all the process in the stack
# run on leetcode : yes

                        # current = timestamp
                        # start -----> record elapsed time for previous process in the stack
                        #              push id to stack
                        #              previous = current
                        # end   -----> pop previous process 'id' from top of stack
                        #              record time, result[id] += current - previous + 1
                        #              previous = current + 1



class Solution:
    def isValid(self, n, logs):
        result = [0]*n
        st = []
        previous = 0
        for log in logs:
            arr = log.split(':')
            current = int(arr[2])
            if arr[1] == 'start':
                if st != []:                        # record time for previous process in the stack
                    result[st[-1]] += current - previous
                st.append(int(arr[0]))
                previous = current
            else:
                id = st.pop()
                result[id] += current - previous + 1
                previous = current + 1
        return result


obj = Solution()
print(obj.isValid(n =2 ,logs=["0:start:0","1:start:2","1:end:5","0:end:6"]))