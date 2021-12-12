//Time complexity:- O(n);
//space complexity:-O(n+3).
//did it run on leetcode:- Yes.
//approach with the code:- as given sentence only contains [,],(,),{,} first a hashmap is constructed with keys as [,(,{
//and values as ],),}.next if given character is in key of hashmap simply pushed to stack, else if stack is not empty it checks
// with key of peek value if equal pops out else false;



class Solution {
    public boolean isValid(String s) {
        HashMap<Character,Character> map=new HashMap<>();
        Stack<Character> cache=new Stack<>();
        map.put('[',']');
        map.put('(',')');
        map.put('{','}');
        for(int i=0;i<s.length();i++){
           if(map.containsKey(s.charAt(i))){
               cache.push(s.charAt(i));
           }
           else if(!cache.isEmpty()){
                if(s.charAt(i)==map.get(cache.peek())){
                    cache.pop();
                }
                else{
                    return false;
                }
            }
            else{
                return false;
            }
        }
        if(cache.isEmpty()){
            return true;
        }
        return false;
    }
}