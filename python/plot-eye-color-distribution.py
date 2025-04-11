import pandas as pd
import matplotlib.pyplot as plt

# matplotlib must be installed with command `pip install matplotlib`

data = {
    'eye_color': ['Brown', 'Blue', 'Hazel', 'Green', 'Brown', 'Blue', 'Hazel', 'Green'],
    'gender': ['Male', 'Male', 'Male', 'Male', 'Female', 'Female', 'Female', 'Female'],
    'percentage': [31.56, 39.06, 17.41, 11.97, 31.80, 33.42, 16.89, 17.89],
}
df = pd.DataFrame(data)
print(df)

pivot_df = df.pivot(index= 'eye_color', columns= 'gender', values= 'percentage')
pivot_df.plot(kind='bar')
plt.title('Eye Color Distribution by Gender')
plt.xticks(rotation=45)
plt.xlabel('Eye Color')
plt.ylabel('Percentage')
plt.legend(title='Gender')
# Force the bar graph to fit in the figure window area
plt.tight_layout()
# Opens the bar graph in a new window
plt.show()
