myString = input("Enter a phrase: ")
if not myString:
    myString = "I am actively seeking full-time opportunities and eager to connect with like-minded professionals to explore Collaborations, Bringing not only my Technical Expertise but also a Spirit of Curiosity and Innovation!"
    print("No input so using default phrase: \"I am actively seeking full-time opportunities and eager to connect with like-minded professionals to explore Collaborations, Bringing not only my Technical Expertise but also a Spirit of Curiosity and Innovation!\"")
else:
    print("Your phrase is: " + myString)

print("--------------------RESULT--------------------")

# Approach 1 using generator expression:
print("[1] Uppercase letter counts:", sum(1 for c in myString if c.isupper())) # Should be 8

# Approach 2 using regex:
import re
count = len(re.findall(r'[A-Z]',myString))
print(f"[2] Uppercase letter counts: {count}") # Should be 8

# Approach 3 using for-loop:
count = 0
for c in myString:
    if c.isupper():
        count += 1
print(f"[3] Uppercase letter counts: {count}") # Should be 8
