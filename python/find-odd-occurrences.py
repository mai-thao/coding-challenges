# This 1st solution assumes there is ONLY one odd occurrence in the list
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

print("--------------------Using Dictionary--------------------")

def find_odd_occurrences_using_dict(num_list):
    num_count_dict = {}
    result = []
    
    for num in num_list:
        num_count_dict[num] = num_count_dict.get(num, 0) + 1

    for num, count in num_count_dict.items():
        if count % 2 == 1:
            result.append(num)

    return result

# 1 odd occurrences
list = [1,2,3,1,2,3,1]
result = find_odd_occurrences_using_dict(list)
print(result)

# 2 odd occurrences
list = [1,2,3,1,2,3,1,2]
result = find_odd_occurrences_using_dict(list)
print(result)

# Empty list
list = []
result = find_odd_occurrences_using_dict(list)
print(result)

# No odd occurrences
list = [1,2,3,1,2,3,1,1]
result = find_odd_occurrences_using_dict(list)
print(result)
