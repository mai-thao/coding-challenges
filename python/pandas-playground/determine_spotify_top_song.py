import pandas as pd

# Find the most popular song for a given year
# CSV file is stored in csv-files directory
df = pd.read_csv('csv-files/spotify_2000.csv')
print(df)
print(df.dtypes)

desired_year = None

# Prompt the user for a valid number, if not, then re-prompt
while desired_year is None:
    try:
        desired_year = int(input("Enter a year (e.g. 2024): "))
    except ValueError:
        print("Not an integer value... enter again.")

print("Your desired year is: " + str(desired_year))

df_filtered = df[df['Year'] == desired_year]
if df_filtered.empty:
    print(f"There is no data for year {desired_year}")
else:
    most_popular_song = df_filtered.loc[df_filtered['Popularity'].idxmax()]
    print(f"The most popular song in {desired_year} was \"{most_popular_song['Title']}\" by {most_popular_song['Artist']}")
