class Solution:
    # TC : O(n)
    # SC : O(n)
    def isValid(self, s: str) -> bool:
        st = []
        hashmap = {']':'[','}':'{',')':'('}
        for ch in s:
            if ch not in hashmap:
                st.append(ch)
            else:
                if not st: return False
                lastelem = st.pop()
                if lastelem != hashmap[ch]:
                    return False
        if not st: return True
        else: return False