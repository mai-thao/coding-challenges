class TemperatureConverter:
    def convert(self, temperature, unit):
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
print(converter.convert(100, 'C'))      # 212.0
print(converter.convert(0, 'C'))        # 32.0
print(converter.convert(1000, 'C'))     # 1832.0

# Fahrenheit -> Celsius
print(converter.convert(32, 'F'))       # 0.0
print(converter.convert(212, 'F'))      # 100.0
print(converter.convert(-459.67, 'F'))  # -273.15
print(converter.convert(-40, 'C'))      # -40.0

# Invalid test case
try:
    converter.convert(0, 'K')
except ValueError as e:
    print(e)                            # "Invalid unit"
    assert str(e) == "Invalid unit"
