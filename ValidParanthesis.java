Time: O(n) : n is length of String
Space: O(n)
LeetCode: Yes
Issue: No

class Solution {
    public boolean isValid(String S) {
     // write your code in Java SE 8
     //Base case:
     if(S==null || S.length()==0) return true;
     
     //Logic:
     //Stack<Character> stack = new Stack<>(); 
     int size=0;
     List<Character> list = new ArrayList<>();
     for(int i=0; i<S.length(); i++){ 
         char ch=S.charAt(i);
            if(ch=='{' || ch=='(' || ch=='['){
                list.add(ch);
                size++;
            }
            else if(ch=='}'){
                if(list.isEmpty() || list.get(size-1) !='{'){
                    return false;
                }
                list.remove(size-1);
                size--;
            }
            else if(ch==')'){
                if(list.isEmpty() || list.get(size-1) !='('){
                    return false;
                }
                list.remove(size-1);
                size--;
            }
            else if(ch==']'){
                if(list.isEmpty() || list.get(size-1) !='['){
                    return false;
                }
                list.remove(size-1);
                size--;
            }
        }
        
        return list.isEmpty(); 
    }
}
