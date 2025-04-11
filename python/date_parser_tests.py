import pytest
from date_parser import date_parser

def test_date_parser_ymd():
  assert date_parser("2023-04-15") == "15/04/2023"
  assert date_parser("2023/4/15") == "15/04/2023"
  assert date_parser("2023.04.15") == "15/04/2023"

def test_date_parser_dmy():
  assert date_parser("15-04-2023", day_first=True) == "15/04/2023"
  assert date_parser("15/4/2023", day_first=True) == "15/04/2023"
  assert date_parser("15.04.2023", day_first=True) == "15/04/2023"

def test_date_parser_ambiguous():
  assert date_parser("01-02-2021", day_first=True) == "01/02/2021"
  assert date_parser("01-02-2021", day_first=False) == "02/01/2021"

def test_date_parser_invalid():
  with pytest.raises(ValueError):
    date_parser("invalid date")

  with pytest.raises(ValueError):
    date_parser("20230-01-05")

  with pytest.raises(ValueError):
    date_parser("2023-015-05")
