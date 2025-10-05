package main

import "fmt"

/*
 * Given an array `a`, return a new array `b` of the same length by applying the following transformations:
 * - For each i from 0 to a.length - 1 inclusive, b[i] = a[i-1] + a[i] + a[i+1]
 * - If an element in the sum a[i-1] + a[i] + a[i+1] does not exist, use 0 in its place
 * - For instance, b[0] = 0 + a[0] + a[1]
 *
 * Time complexity: O(n) because traversing each element in the array at least once
 * Space complexity: O(n) because created a new int slice the same size as input slice
 */
func applyTransformation(a []int) []int {
    aLength := len(a)
    b := make([]int, aLength)
    for i, _ := range a {
        b[i] = a[i]
        if i > 0 {
            b[i] += a[i-1]
        }
        if i < aLength - 1 {
            b[i] += a[i+1]
        }
    }
    return b
}

func main() {
    fmt.Println(applyTransformation([]int{4,0,1,-2,3}))     // [4 5 -1 2 1]
    fmt.Println(applyTransformation([]int{5}))              // [5]
    fmt.Println(applyTransformation([]int{}))               // []
    fmt.Println(applyTransformation([]int{9,9,9,9}))        // [18 27 27 18]
    fmt.Println(applyTransformation([]int{-9,-9,-9,-9}))    // [-18 -27 -27 -18]
}
