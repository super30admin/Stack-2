// Time Complexity : O(s)
// Space Complexity : O(s)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
have a stack
loop over characters of string
if they are opening then add to stack
else if stack is empty return false else if its not the complementary value of popped element return false

after the loop if stack is not empty return false
return true
*/
package main

import "fmt"

func isValid(s string) bool {
	st := []byte{}
	for i := 0; i < len(s); i++ {
		c := s[i]
		if c == '(' || c == '{' || c == '[' {
			st = append(st, c)
		} else {
			if len(st) > 0 {
				co := st[len(st)-1]
				st = st[:len(st)-1]
				if c == ')' && co != '(' {
					return false
				}
				if c == ']' && co != '[' {
					return false
				}
				if c == '}' && co != '{' {
					return false
				}
			} else {
				return false
			}
		}
	}
	if len(st) > 0 {
		return false
	}
	return true
}

func MainValidParantheses() {
	fmt.Println(isValid("(]")) //expected false
}
