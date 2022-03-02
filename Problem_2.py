# Time Complexity : O(n) going through the times given only once
# Space Complexity : O(1) we are using a stack which can be of size n/2
# runs on leetcode : Yes 
# any problems faced : NO

class Solution:
    def isValid(self, s: str) -> bool:
        arr=[]
        for i in range(len(s)):
	        if len(arr)==0:
		        arr.append(s[i])
	        elif (arr[-1]=="(" and s[i]==")") or (arr[-1]=="{" and s[i]=="}") or (arr[-1]=="[" and s[i]=="]"):
		        arr.pop()
	        else:
		        arr.append(s[i])
        return len(arr)==0