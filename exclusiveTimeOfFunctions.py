'''
Time Complexity: 0(n)
Space Complexity: 0(n) -- call stack
Run on leetCode: Yes
'''

class Solution:
    
    def __init__(self):
        self.__callStack = []
        self.__resultList = None
        
        # time
        self.cT = 0
        self.pT = 0
        
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        
        # intilize the resultList
        self.__resultList = [0]*n
        
        # Iterate the logs
        for i in range(0,len(logs)):
            log = logs[i]
            # convert log to the list
            log = log.split(":")

            # initialize the vars
            funcId = int(log[0])      
            event = log[1]    
            timeStamp = int(log[2])    

            # chk is cT == timeStamp
            self.cT = timeStamp

            if event == "start" and len(self.__callStack) == 0:
                self.__callStack.append(funcId)

            elif event == "start" and len(self.__callStack) != 0:
                self.__resultList[self.__callStack[-1]] += self.cT - self.pT
                self.__callStack.append(funcId)
                self.pT = self.cT

            elif event == "end":
                self.__resultList[funcId] += (self.cT+1) - self.pT
                self.__callStack.pop()
                self.pT = self.cT+1
            
            # print
            # print(self.__resultList)
        '''end of for loop'''
        
        return self.__resultList