import re

# Returns key-value dictionary of a number and its corresponding sentence
def extract_sentences_with_numbers(text):
    sentences = re.split(r'[.!?]', text)
    sentences_with_numbers = {}
    for s in sentences:
        numbers = re.findall(r'\d+', s)
        for num in numbers:
            sentences_with_numbers[num] = s.strip()
    return sentences_with_numbers

text = "This is a sentence with numbers 123 and 456. Also, here's another one with 789!"
result = extract_sentences_with_numbers(text)
print(result)
