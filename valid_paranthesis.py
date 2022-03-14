# sc and tc : O(n)
class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        for e in s:
            if e=="(":
                stack.append(")")
            elif e=="{":
                stack.append("}")
            elif e=="[":
                stack.append("]")
            else:
                if stack:
                        ele = stack.pop()
                        if e == ele:
                            continue 
                        else:
                            return False
                else:
                    return False
        if stack:
            return False
        return True
