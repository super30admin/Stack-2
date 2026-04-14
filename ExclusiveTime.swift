//
//  ExclusiveTime.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 3/4/26.
//

import Foundation

class ExclusiveTime {
    struct Stack<T> {
        var elements: [T] = []

        mutating func push(_ element: T) {
            elements.append(element)
        }

        mutating func pop() -> T? {
            elements.removeLast()
        }

        func peek() -> T? {
            return elements.last
        }

        var isEmpty: Bool {
            return elements.count == 0
        }
    }

    func exclusiveTime(_ n: Int, _ logs: [String]) -> [Int] {
        
        var stack = Stack<Int>()

        var result = Array(repeating: 0, count: n)
        var prev = 0
        
        for i in 0..<logs.count {
            let currParts = logs[i].components(separatedBy: ":")
            let currTime = Int(currParts[2])!
            let taskID = Int(currParts[0])!
            
            if (stack.isEmpty) {
                stack.push(taskID)
            } else {
                if (currParts[1] == "start") {
                    let taskId = stack.peek()!
                    result[taskId] += (currTime - prev)
                    stack.push(taskID)
                    prev = currTime
                } else if (currParts[1] == "end") {
                    result[stack.pop()!] += (currTime + 1 - prev)
                    prev = currTime + 1
                }
            }

        }
        return result
    }
}
