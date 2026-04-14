//
//  ValidParenthesis.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 3/3/26.
//


class ValidParentheses {
    
    class Stack<T> {
        var elements: [T] = []

        func push(_ element: T) {
            elements.append(element)
        }

        func pop() -> T? {
            return elements.removeLast()
        }

        func peek() -> T? {
            return elements.last
        }

        var isEmpty: Bool {
            return elements.count == 0
        }
    }

    //O(n), O(n)
    func isValid(_ s: String) -> Bool {
        let sArray = Array(s)
        var stack = Stack<Character>()
        for i in 0..<sArray.count {
            if (sArray[i] == "(") {
                stack.push(")")
            } else if (sArray[i] == "[") {
                stack.push("]")
            } else if (sArray[i] == "{") {
                stack.push("}")
            } else if (stack.isEmpty || stack.pop()! != sArray[i]) {
                return false
            }
        }
        if (stack.isEmpty) {
            return true
        }
        return false
    }
}
