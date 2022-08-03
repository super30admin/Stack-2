#Time complexity: O(n^2)
#Space complexity: O(n)
class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        res = []
        
        people.sort(key = lambda x:(-x[0], x[1]))
        for ppl in people:
            res.insert(ppl[1], ppl)
        
        return res
