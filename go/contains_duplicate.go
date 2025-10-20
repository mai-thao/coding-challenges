package main

import "fmt"

func containsDuplicate(nums []int) bool {
    for i := 0; i < len(nums)-1; i++ {
        for j := i+1; j < len(nums); j++ {
            if nums[i] == nums[j] {
                return true
            }
        }
    }
    return false
}

func main() {
    fmt.Println(containsDuplicate([]int{1,2,3,1}))  // true
    fmt.Println(containsDuplicate([]int{1,2,3,4}))    // false
    fmt.Println(containsDuplicate([]int{1,1,1,3,3,4,3,2,4,2}))   // true
}