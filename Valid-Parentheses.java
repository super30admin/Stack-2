// time complexity: o(n)
// space complexity: o(n)
// idea:
// a) The implementation is with string but internally it uses the stack implementation with popping only the last char from the string
// b) whenever I find an open bracket ('(', '{' or '[', i push it into string(stack)
// c) if i find close bracket (')', '}' or ']', I peek the last element of stack and check if it matches it's corresponding open bracket
// d) if it matches, I pop the last element in the stack, else I append it to the stack
// e) once I come out of the loop, if the stack is empty, it is a valid parentheses, else it is not.

// Did it run on leetcode: yes

class Solution {
    public boolean isValid(String s) {
       boolean b = false;
		if(s.length()%2!=0) {
			b = false;
		}
		else b = true;
		String v = "";
		if(b==true) {
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='(') {
				v = v + "(";
			}
			if(s.charAt(i)==')') {
				if(v.length()>0 && v.charAt(v.length()-1)=='(') {
					v = v.substring(0, v.length()-1);
				}
				else v = v+')';
			}
			
			if(s.charAt(i)=='{') {
				v = v + "{";
			}
			if(s.charAt(i)=='}') {
				if(v.length()>0 && v.charAt(v.length()-1)=='{') {
					v = v.substring(0, v.length()-1);
				}
				else v = v+ '}';
			}
			
			if(s.charAt(i)=='[') {
				v = v + "[";
			}
			if(s.charAt(i)==']') {
				if(v.length()>0 && v.charAt(v.length()-1)=='[') {
					v = v.substring(0, v.length()-1);
				}
				else v = v+ ']';
			}
		
		}
		System.out.println(v);
		if(v.length()==0) b = true;
		else b = false;
		}
        return b;
}
}