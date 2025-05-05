import matplotlib.pyplot as plt
import numpy as np

# Create sample dataset
data = [1, 2, -59, 5, 7, 231, 3, 5, 12, 100]
print("Data:", data)

# Create boxplot of dataset
plt.figure(figsize=(10, 7))  
plt.boxplot(data, vert=False) # Make it horizontal
plt.title('Boxplot of Data')
plt.xlabel('Values')
plt.show()

# Remove outliers using the Interquartile Range (IQR) method
Q1 = np.percentile(data, 25)
Q3 = np.percentile(data, 75)
IQR = Q3 - Q1
lower_bound = Q1 - 1.5 * IQR
upper_bound = Q3 + 1.5 * IQR

filtered_data = [x for x in data if lower_bound <= x <= upper_bound]
print("Data after removing outliers:", filtered_data)

# Create a boxplot to show the filtered dataset
plt.figure(figsize=(10, 7))  
plt.boxplot(filtered_data, vert=False) 
plt.title('Boxplot of Data')
plt.xlabel('Values')
plt.show()
