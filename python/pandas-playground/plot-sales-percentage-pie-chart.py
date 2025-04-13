import pandas as pd
import matplotlib.pyplot as plt

# Create a pie chart showcasing the percentage of sales by each customer (dummy data)
# Learning pandas: dataframe and data manipulation/aggregation functions
file_name = 'csv-files\Sales-Printing-Office-2023.csv'

df = pd.read_csv(file_name)

print(df.head(10))

relevant_df = df.filter(items=['Customer', 'Final Price'])
print(relevant_df.head(10))

# Remove bad data
relevant_df.dropna(subset=['Customer'], inplace=True)
relevant_df.dropna(subset=['Final Price'], inplace=True)
print(relevant_df)

# Need in float so remove $ and commas characters
relevant_df['Final Price'] = relevant_df['Final Price'].str.replace('$', '').str.replace(',', '').astype(float)

relevant_df = relevant_df.groupby(['Customer'], as_index=False).sum()
print(relevant_df)

total_money = relevant_df['Final Price'].sum()

# The autopct='%1.1f%%' format string displays the percentage rounded to one decimal place.
plt.pie(relevant_df['Final Price'], labels=relevant_df['Customer'], autopct='%1.1f%%')
plt.title('Sales Percentage Per Customer')
plt.show()
