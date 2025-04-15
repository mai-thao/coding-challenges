# Assume that there is ONLY ever one odd occurrence in the list
def find_odd_occurrences(num_list):
    if not num_list:
        return None
    
    result = num_list[0]

    for num in num_list[1:]:
        result ^= num # Bitwise XOR

    return result

# Only one odd occurrence
list = [1,2,3,1,2,3,1]
result = find_odd_occurrences(list)
print(result)

# Empty list
list = []
result = find_odd_occurrences(list)
print(result)

# No odd occurrences
list = [1,2,3,1,2,3,1,1]
result = find_odd_occurrences(list)
print(result)
