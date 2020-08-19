//Time Complexity : O(n)
//Space Complexity :O(n)
class Solution {
    public boolean isValid(String s) {
        
      char[] tempArray =  s.toCharArray();
       Stack<Character> stack =new Stack<>();
       HashMap<Character,Character> hashMap = new HashMap<>();
        hashMap.put(')','(');
        hashMap.put('}','{');
        hashMap.put(']','[');
        
        for(int i=0;i<tempArray.length;i++){
            if(tempArray[i]=='('||tempArray[i]=='{'|| tempArray[i]=='['){            
                stack.push(tempArray[i]);
            }
            else{
            if(stack.isEmpty())
                return false;
              else if(tempArray[i]=='}' || tempArray[i]==')'|| tempArray[i]==']')
            {
                
                 if(hashMap.get(tempArray[i])!=stack.pop() )
                     return false;
               
              }
            }
        }
        
        
        if(!stack.isEmpty())
            return false;
        
        
        return true;
        
    }
}
