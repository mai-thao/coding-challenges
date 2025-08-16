import matplotlib.pyplot as plt
import numpy as np

# x values from 0 to 2 with increments of 0.1
x = np.arange(0, 2.1, 0.1)

# y values using the square function
y = x**2

# Create and show the plot
plt.figure(figsize=(6, 6))
plt.plot(x, y)
plt.title('Plot of the Square Function')
plt.xlabel('x')
plt.ylabel('y = x^2')
plt.grid(True)
plt.show()
