package main

import (
    "fmt"
    "strconv"
)

/*
 * Given a string of operations, return the sum of all the records after applying each operation.
 *
 * An operation can be:
 * - integer "x" -> records a new score of x
 * - "+" -> records a new score that is the sum of the previous two scores
 * - "D" -> records a new score that is the double of the previous score
 * - "C" -> invalidates the previous score, removing it from the record
 *
 * Each element will only be 1 of these 4 operation.
 * For operation "+", there will always be at least two previous scores on the record.
 * For operations "C" and "D", there will always be at least one previous score on the record.
 *
 * Time complexity: O(n) since traversing each string (aka each operation) in the array
 * Space complexity: O(n) since created a stack "slice" to hold the score integers
 */
func calculatePoints(operations []string) int {
    scoreStack := []int{}
    for _, operation := range operations {
        stackLen := len(scoreStack)
        if operation == "+" {
            firstPrev := scoreStack[stackLen - 1]
            secondPrev := scoreStack[stackLen - 2]
            scoreStack = append(scoreStack, firstPrev + secondPrev)
        } else if operation == "D" {
            prev := scoreStack[stackLen - 1]
            scoreStack = append(scoreStack, prev * 2)
        } else if operation == "C" {
            scoreStack = scoreStack[:stackLen - 1]
        } else {
            intVal, _ := strconv.Atoi(operation)
            scoreStack = append(scoreStack, intVal)
        }
    }
    var sum int
    for _, score := range scoreStack {
        sum += score
    }
    return sum
}

func main() {
    fmt.Println(calculatePoints([]string{"5", "2", "C", "D", "+"}))                 // 30
    fmt.Println(calculatePoints([]string{"5", "-2", "4", "C", "D", "9", "+", "+"})) // 27
    fmt.Println(calculatePoints([]string{"1", "C"}))                                // 0
    fmt.Println(calculatePoints([]string{"5", "D"}))                                // 15
    fmt.Println(calculatePoints([]string{"1"}))                                     // 1
    fmt.Println(calculatePoints([]string{"5", "10", "15", "20"}))                   // 50
}
