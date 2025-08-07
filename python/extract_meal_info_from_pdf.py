from PyPDF2 import PdfReader
import re

reader = PdfReader('input-docs/Meal_Schedule_Plan.pdf')
num_pages = len(reader.pages)

# Iterate through the pages and extract text from each page
text = ''
for page in range(num_pages):
    page_obj = reader.pages[page]
    text += page_obj.extract_text()

fruits = ['cherry', 'berries', 'apple', 'blueberry']
vegetables = ['kale', 'carrots', 'tomatoes', 'artichoke', 'green beans', 'avocado', 'squash']

# Remove puncutations and join text to handle vegetables with two words like 'green beans'
cleaned_text = re.sub(r'[^\w\s]', '', text)
joined_text = ' '.join(cleaned_text.split())

# Count the occurrences of each fruit and vegetable
fruit_count = 0
vegetable_count = 0
fruit_counts = {}
vegetable_counts = {}
for fruit in fruits:
    count = joined_text.lower().count(fruit)
    fruit_count += count
    fruit_counts[fruit] = count
for vegetable in vegetables:
    count = joined_text.lower().count(vegetable)
    vegetable_count += count
    vegetable_counts[vegetable] = count

difference = abs(fruit_count - vegetable_count)

print("Fruit Count:", fruit_count)
print("Vegetable Count:", vegetable_count)
print("Fruits:", fruit_counts)
print("Vegetables:", vegetable_counts)
print("Count Difference:", difference)