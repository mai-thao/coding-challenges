package main

import "fmt"

/*
 * Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.
 *
 * Time complexity: O(n*m) because iterating through each digit in num AND iterating again to reduce down to 1 digit
 * Space complexity: O(1) because no extra dataset or memory created
 */
func addDigits(num int) int {
    sum := 0
    for num > 0 {
        popped := num % 10
        sum += popped
        num /= 10
        if num == 0 && sum >= 10 {
            num = sum
            sum = 0
        }
    }
    return sum
}

func main() {
    fmt.Println(addDigits(38))          // 3+8=11 -> 1+1=2 -> 2
    fmt.Println(addDigits(0))           // 0
    fmt.Println(addDigits(999999999))   // 9+9+9+9+9+9+9+9+9=18 -> 1+8=9 -> 9
}
