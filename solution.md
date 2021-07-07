# Problem 1 - Exclusive Time of Functions
## Time Complexity :
O(n)

## Space Complexity :
O(n)

## Did this code successfully run on Leetcode :
Yes.

## Any problem you faced while coding this :
No. 

## Your code here along with comments explaining your approach
### Solution:
      class Solution:
          def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
              stack=[]
              result=[0]*n
              priorTimestamp,currentTimestamp=0,0
              for log in logs:
                  token=log.split(":")
                  functionId = int(token[0])
                  currentTimestamp = int(token[2])
                  if token[1]=='start':
                      if stack:
                          result[stack[-1]]+=currentTimestamp-priorTimestamp
                      stack.append(functionId)
                      priorTimestamp = currentTimestamp
                  else:
                      result[functionId]+=currentTimestamp-priorTimestamp+1
                      stack.pop()
                      priorTimestamp=currentTimestamp+1
              return result

# Problem 2 - Valid Parentheses
## Time Complexity :
O(n)

## Space Complexity :
O(n)

## Did this code successfully run on Leetcode :
Yes.

## Any problem you faced while coding this :
No. 

## Your code here along with comments explaining your approach
### Solution:
      class Solution:
          def isValid(self, s: str) -> bool:
              if not s or len(s)==0:
                  return True
              stack=[]
              for i in s:
                  if i=='(':
                      stack.append(')')
                  if i=='[':
                      stack.append(']')
                  if i=='{':
                      stack.append('}')
                  if i==')' or i==']' or i=='}' :
                      if not stack:
                          return False
                      if i!=stack.pop():
                          return False
              return not stack
