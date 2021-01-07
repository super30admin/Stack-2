// Time Complexity : O(len(logs))
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
have a res array, stack, prev=0
loop over each log and split by :
curr=timestamp of current log
if its a start then if stack is not empty then set res of top element of stack(preious element) += curr-prev so we recorded the gap already
after that push the fid into stack and set prev to curr

if its an end then pop element from stack set res[popped] += curr-prev+1
set prev=curr+1

return res
*/
package main

import (
	"fmt"
	"strconv"
	"strings"
)

//O(len(logs)), space O(n)
func exclusiveTime(n int, logs []string) []int {
	if len(logs) == 0 {
		return []int{}
	}
	res := make([]int, n)
	prev := 0 // end time of previous so we can subtract
	st := []int{}
	for _, str := range logs {
		strArr := strings.Split(str, ":") //[0:start:0][1:end:6] etc
		curr, _ := strconv.Atoi(strArr[2])
		if strArr[1] == "start" {
			if len(st) > 0 {
				res[st[len(st)-1]] += curr - prev //when we encounter start we store duration of that period in the beginning itself for the previous log
				prev = curr
			}
			fid, _ := strconv.Atoi(strArr[0])
			st = append(st, fid) //push functionid
		} else {
			popped := st[len(st)-1]
			st = st[:len(st)-1]
			res[popped] += curr - prev + 1
			prev = curr + 1
		}
	}
	return res
}

func MainExclusiveTime() {
	fmt.Println(exclusiveTime(2, []string{"0:start:0", "0:start:2", "0:end:5", "1:start:7", "1:end:7", "0:end:8"}))
	//expected [8,1]
}
