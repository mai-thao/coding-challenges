import requests
import json

'''
This script calls the Weather API to check today's temperature and chance of rain. 
You will need to sign up with a free account to receive a unique API key.
See set up details and API contract at: https://www.weatherapi.com/docs/
'''

api_key = "PASTE_API_KEY_HERE"
base_url = "http://api.weatherapi.com/v1/"

city_name = input("Enter the city name: ")

def get_curr_temp_and_rain_forecast(city):
    url = f"{base_url}forecast.json?key={api_key}&q={city}"
    
    try:
        response = requests.get(url)
        response.raise_for_status()
    except requests.exceptions.RequestException:
        return None, None, None
   
    data = json.loads(response.text)
    
    curr_temp_c = data['current']['temp_c']
    curr_temp_f = data['current']['temp_f']
    
    curr_day = data['forecast']['forecastday'][0]
    will_it_rain = curr_day['day']['daily_will_it_rain']
    chance_of_rain = curr_day['day']['daily_chance_of_rain']
 
    # daily_will_it_rain returns `1` = Yes or `0`` = No
    if will_it_rain == 1:
        return curr_temp_c, curr_temp_f, chance_of_rain
    else:
        return curr_temp_c, curr_temp_f, None

temp_c, temp_f, chance_of_rain = get_curr_temp_and_rain_forecast(city_name) 

if temp_c and temp_f:
    print(f"The current temperature in {city_name} is {temp_c} degrees Celsius or {temp_f} degrees Fahrenheit.") 
    if chance_of_rain:
        print(f"It will rain today with a {chance_of_rain}% chance of rain.")
    else:
        print("It will not rain today.")
else:
    print(f"Error occured: city not found or there was an unexpected API error!") 
