# Parses a date string into the format "DD/MM/YYYY"
# date_str is the date to parse
# day_first is a boolean whether to parse the day first or not, defaults to False
def date_parser(date_str: str, day_first: bool = False) -> str:
    parts = date_str.replace("-", "/").replace(".", "/").split("/")
    if len(parts) != 3:
        raise ValueError(f"Invalid date format: {date_str}")

    # Identify the year part based on length
    year = next((p for p in parts if len(p) == 4), None)
    if year is None or not year.isdigit():
        raise ValueError(f"Invalid year format in date: {date_str}")
    
    parts.remove(year)

    # Check remaining parts are digits and of correct length
    if not all(part.isdigit() and 1 <= len(part) <= 2 for part in parts):
        raise ValueError(f"Invalid date format: {date_str}")

    # Handle ambiguous dates based on day_first flag
    if 1 <= int(parts[0]) <= 12 and 1 <= int(parts[1]) <= 12:
        if day_first:
            day, month = parts
        else:
            month, day = parts
    else:
        month = next((p for p in parts if 1 <= int(p) <= 12), None)
        day = next((p for p in parts if p != month), None)
        if month is None or day is None or not (1 <= int(day) <= 31):
            raise ValueError(f"Invalid date components in: {date_str}")

    # Ensure day and month are within valid ranges
    day, month = int(day), int(month)
    if not (1 <= day <= 31 and 1 <= month <= 12):
        raise ValueError(f"Day or month out of range in: {date_str}")

    return f"{day:02}/{month:02}/{year}"
