package main

import (
    "fmt"
    "strconv"
)

func fizzBuzz(n int) []string {
    result := []string{}

    for idx := 1; idx <= n; idx++ {
        var str string
        if idx % 3 == 0 && idx % 5 == 0 {
            str = "FizzBuzz"
        } else if idx % 3 == 0 {
            str = "Fizz"
        } else if idx % 5 == 0 {
            str = "Buzz"
        } else {
            str = strconv.Itoa(idx)
        }
        result = append(result, str)
    }

    return result
}

func main() {
	nums := []int{3,5,15}

	for _, n := range nums {
		fmt.Printf("Number: %d → Result: %v\n", n, fizzBuzz(n))
	}

    // [1 2 Fizz], [1 2 Fizz 4 Buzz], [1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz]
}