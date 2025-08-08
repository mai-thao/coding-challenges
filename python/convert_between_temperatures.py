class TemperatureConverter:
    def convert(self, temperature, unit):
        if not isinstance(temperature, (int, float)):
            raise ValueError("Temperature must be a number")
        if unit == 'C':
            return self.celsius_to_fahrenheit(temperature)
        elif unit == 'F':
            return self.fahrenheit_to_celsius(temperature)
        else:
            raise ValueError("Invalid unit")

    def celsius_to_fahrenheit(self, temperature):
        return round((temperature * 9/5) + 32, 2)

    def fahrenheit_to_celsius(self, temperature):
        return round((temperature - 32) * 5/9, 2)

converter = TemperatureConverter()

# Celsius -> Fahrenheit
print(converter.convert(-273.15, 'C'))  # -459.67
assert converter.convert(-273.15, 'C') == -459.67

print(converter.convert(100, 'C'))      # 212.0
assert converter.convert(100, 'C') == 212.0

print(converter.convert(0, 'C'))        # 32.0
assert converter.convert(-0, 'C') == 32.0

print(converter.convert(1000, 'C'))     # 1832.0
assert converter.convert(1000, 'C') == 1832.0

# Fahrenheit -> Celsius
print(converter.convert(32, 'F'))       # 0.0
assert converter.convert(32, 'F') == 0.0

print(converter.convert(212, 'F'))      # 100.0
assert converter.convert(212, 'F') == 100.0

print(converter.convert(-459.67, 'F'))  # -273.15
assert converter.convert(-459.67, 'F') == -273.15

print(converter.convert(-40, 'C'))      # -40.0
assert converter.convert(-40, 'F') == -40

# Invalid test cases
try:
    converter.convert(0, 'K')
except ValueError as e:
    print(e)                            # "Invalid unit"
    assert str(e) == "Invalid unit"

try:
    converter.convert('K', 'C')
except ValueError as e:
    print(e)                            # "Invalid temperature"
    assert str(e) == "Temperature must be a number"
