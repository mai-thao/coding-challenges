package main

import "fmt"

// Given two integers num1 and num2, return the sum of the two integers.
func sum(num1 int, num2 int) int {
    return num1 + num2
}

func main() {
    fmt.Println(sum(12, 5))     // 17
    fmt.Println(sum(-10, 4))    // -6
    fmt.Println(sum(-456, 77))  // -379
    fmt.Println(sum(0, 0))      // 0
}
