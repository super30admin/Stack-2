#Time complexity is O(n)
#Space omplexity is O(n)
#Code ran successfully on leetcode
#No issues faced while coding
class Solution(object):
    def exclusiveTime(self, n, logs):
        """
        :type n: int
        :type logs: List[str]
        :rtype: List[int]
        """
        #Base condition
        if(logs==None):
            return 0
        #Initializing all the required variables 
        result=[0 for i in range(n)]
        st=[]
        curr=0
        prev=0
        #iterating through the values in the logs array
        for log in logs:
            #Splitting the log value
            strArr=log.split(":")
            #CApturing currId and curr value from the strArr
            currId=int(strArr[0])
            curr=int(strArr[2])
            #If the strArr[1] is start
            if(strArr[1]=="start"):
                #We will check if there is any value in the stack
                if(len(st)):
                    #We will update the time of that index in the result
                    #with curr-prev value
                    result[st[-1]]+=curr-prev
                #Next we will append the new currId in thestack
                st.append(currId)
                #We will place the curr value into prev
                prev=curr
            else:
                #If the strArr[1]=="end", then we will pop the stack
                #And we will update result[st.pop()] with curr+1-prev value
                result[st.pop()]+=curr+1-prev
                #Updating prev values
                prev=curr+1
            #Finally we are returning result
        return result


