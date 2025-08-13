from collections import Counter

# Sort the characters in order of most to least frequency
def frequency_sort(s):
    char_counts = Counter(s)
    sorted_chars = sorted(char_counts.items(), reverse=True, key=lambda item: item[1])
    return ''.join(char * count for char, count in sorted_chars)

# Test cases
print(frequency_sort("tree"))   # Output: "eert"
print(frequency_sort("cccaaa"))  # Output: "aaaccc" (or "cccaaa")
print(frequency_sort("f"))  # Output: "f"
print(frequency_sort("zeeeaaazzzzllab"))  # Output: "zzzzzaaaaeeellb"
