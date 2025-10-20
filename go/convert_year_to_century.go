package main

import "fmt"

func yearToCentury(year int) int {
	if year <= 0 {
		return -1
	}
	century := (year - 1) / 100 + 1
	return century
}

func main() {
	years := []int{-1000, 1, 101, 300, 1700, 1701, 1900, 1935, 2000, 2010, 2500, 2990, 2999}

	for _, y := range years {
		fmt.Printf("Year: %d → Century: %d\n", y, yearToCentury(y))
	}

    // -1, 1, 2, 3, 17, 18, 19, 20, 20, 21, 25, 30, 30
}
