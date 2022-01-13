# Time: O(n)
# Space: O(n)
class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        ls = []
        dic = {}
        dic['}'] = "{"
        dic[']'] = "["
        dic[')'] = "("
        for i in s:
            if i == "(" or i == "{" or i == "[":
                ls.append(i)
            else:
                if len(ls)>0:
                    tp = ls.pop()
                    if tp != dic[i]:
                        return False
                else:
                    return False
        if len(ls) != 0:
            return False
        return True
                
        
