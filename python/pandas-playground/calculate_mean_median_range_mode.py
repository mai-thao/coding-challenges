import pandas as pd

# Calculate statistics by hand of my product prices

df = pd.read_csv('csv-files/products.csv')

# Mean
def calculate_mean(column):
    return sum(column) / len(column)

# Median
def calculate_median(column):
    sorted_column = sorted(column)
    count = len(sorted_column)
    if count % 2 == 0:
        mid1 = sorted_column[count // 2 - 1]
        mid2 = sorted_column[count // 2]
        median = (mid1 + mid2) / 2
    else:
        median = sorted_column[count // 2]
    return median

def calculate_range(column):
    num_list = column.tolist()
    
    min_val = num_list[0]
    max_val = num_list[0]
    
    for num in num_list:
        if num < min_val:
            min_val = num
        if num > max_val:
            max_val = num
    
    return (min_val, max_val)

def calculate_mode(column):
    num_list = column.tolist()
    frequency = {}
    
    for num in num_list:
        frequency[num] = frequency.get(num, 0) + 1
    
    max_freq = max(frequency.values())
    modes = [num for num, freq in frequency.items() if freq == max_freq]
    
    return modes

mean = calculate_mean(df['price'])
median = calculate_median(df['price'])
range = calculate_range(df['price'])
mode = calculate_mode(df['price'])

print(f"Price average: {round(mean, 2)}")
print(f"Price medium: {round(median, 2)}")
print(f"Price range (min, max): {range}")
print(f"Price mode: {mode}")
