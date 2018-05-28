
public class DateClass {
	private int _day;
	private int _month;
	private int _year;

	public int get_day() {
		return _day;
	}

	public void set_day(int _day) {

		if (_day < 1 || _day > 31)
			System.out.println("öDay Input value is incorrect");
		else
			this._day = _day;
	}

	public int get_month() {
		return _month;
	}

	public void set_month(int _month) {
		if (_month < 1 || _month > 12)
			System.out.println("Month Input Value is incorrect");
		else if (_month > 0 || _month < 13) {
			if (_month > 0 || _month <= 6) {
				if (_day > 30)
					System.out
							.println("this day not exist,Because Between Farvardin and Shahrivar, months are 30 days");
				else
					this._month = _month;
			} else if (_month == 12) {
				if (_day > 29)
					System.out.println("this day not exist,Because Esfand is 29 days");
			} else
				this._month = _month;
		}
	}

	public int get_year() {
		return _year;
	}

	public void set_year(int _year) {
		this._year = _year;
	}

	DateClass InsertDay() {
		if (_month >= 1 && _month < 7) {
			if (_day < 31)
				_day++;
			else {
				_day = 1;
				_month++;
			}
		} else if (_month >= 7 && _month < 12) {
			if (_day < 30)
				_day++;
			else {
				_day = 1;
				_month++;
			}
		} else if (_month == 12) {
			if (_day < 29)
				_day++;
			else {
				_day = 1;
				_month = 1;
				_year++;
			}
		}
		DateClass _newDate = new DateClass();
		_newDate._day = _day;
		_newDate._month = _month;
		_newDate._year = _year;

		return _newDate;
	}
	
	String ConcatDate(DateClass date)
	{
		String year=String.valueOf(date._year);
		String month=String.valueOf(date._month);
		String day=String.valueOf(date._day);
		if(day.length()==1)
			day="0".concat(day);
		if(month.length()==1)
			month="0".concat(month);
		
		String _dateConcat=year.concat(month).concat(day);
		return _dateConcat;
	}

}
