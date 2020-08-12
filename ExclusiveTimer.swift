// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes. Forget to add the previousUnit count + 1 for end


// Your code here along with comments explaining your approach
//idea is to store function id in stack and it's corresponding time in result array.
//if function is "start" then time is curr - prev  and prev is set to curr. function start at begining of timestamp.
// calculate the current completed unit based on current index minus previous start index. 
//if funtion is "end" then time is curr - prev +1 and prev is set to curr +1 because function is ending at the end of timestamp so other process cant start at same curr time.

//Stack-2
class Solution {
    func exclusiveTime(_ n: Int, _ logs: [String]) -> [Int] {
        var stack: [Int] = [Int]()
        var result: [Int] = [Int](repeating:0, count: n)
        
        var previousUnit = 0
        for systemLog in logs {
            let log = systemLog.split(separator: ":")
            let index = Int(log[0])!
            let unit = Int(log[2])!
            if log[1] == "start" {
                if !stack.isEmpty {
                    result[stack.last!] += (unit - previousUnit)
                }
                previousUnit = unit
                stack.append(index)
            } else {
                result[stack.last!] += (unit - previousUnit) + 1
                stack.popLast()
                previousUnit = unit + 1

            }
        }
        return result
    }
}