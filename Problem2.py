#Time complexity is: O(n)
#Space complexity is: O(n)
#No issues faced while coding
#Code ran successfully on leetcode
class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        #Initializing stack and count value
        count=0
        st=[]
        #We will be looping through the entire string S
        for i in range(0,len(s)):
            #If s[i] value falls in one of 3 values in the below if condition
            #We will increase the count value by 1 and we will add that to the stack
            if(s[i]=='(' or s[i]=='[' or s[i]=='{'):
                count+=1
                st.append(s[i])
            #If s[i] value falls in one of 3 values in the below if condition
            if(s[i]==')' or s[i]==']' or s[i]=='}'):
                #First we will check, if there are any values in the stack or not
                if(len(st)==0):
                    return False
                #Then we will pop the stack
                m=st.pop()
                #We will start comparing the popped value to the s[i] value
                #If the condition in the if satements satisfies, we will reduce the count
                #By 1 which means it is valid
                if(s[i]==')' and m=='('):
                    count-=1
                elif(s[i]==']' and m=='['):
                    count-=1
                elif(s[i]=='}' and m=='{'):
                    count-=1
                #If the above consition doesn't satisfies, we will return False
                #as it is not valid
                else:
                    return False
            #If the count is less than 0, it is not valid so we will return false
            if(count<0):
                return False
        #If the count is greater than 0, we will return False as it is not valid
        if(count>0):
            return False
        #Finally we will return True, if everything is valid
        else:
            return True
