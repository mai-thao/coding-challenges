package main

import "fmt"

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
 * Time complexity: O(n) since traversing each String in the array
 * Space complexity: O(n) since created a Stack to hold the score integers
 */
func calculatePoints(operations []string) int {
    // TODO: Implement my own Stack type? Can it be if-else or case statements?
    return 0
}

func main() {
    fmt.Println(calculatePoints([]string{"5", "2", "C", "D", "+"}))                 // 30
    fmt.Println(calculatePoints([]string{"5", "-2", "4", "C", "D", "9", "+", "+"})) // 27
    fmt.Println(calculatePoints([]string{"1", "C"}))                                // 0
    fmt.Println(calculatePoints([]string{"5", "D"}))                                // 15
    fmt.Println(calculatePoints([]string{"1"}))                                     // 1
    fmt.Println(calculatePoints([]string{"5", "10", "15", "20"}))                   // 50
}
