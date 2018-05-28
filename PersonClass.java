import java.util.ArrayList;

public class PersonClass {
	private String personName;
	ArrayList<BorrowClass> _borrowList=new ArrayList<>();
	DateClass _dateObj = new DateClass();
	
	
	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public PersonClass() {

	}

	public PersonClass(String name) {
		personName = name;
	}

	BorrowClass borrow(DiscClass discObj, DateClass date) {
		BorrowClass _borrowObj = new BorrowClass();
		
		_borrowObj.setBorrowDate(date);
		_borrowObj.setDiskName(discObj.getDiscName());
		
		return _borrowObj;
	}

	BorrowClass deliver(DiscClass disc, DateClass date) {
		BorrowClass _borrowObj = new BorrowClass();
		
		_borrowObj.setBorrowDate(date);
		_borrowObj.setDiskName(disc.getDiscName());
		
		return _borrowObj;
	}

	int getLateDays(DateClass _borrowDate, DateClass _deliverDate) {

		DateClass date;

		int timeBorrow = 0;
		int late = 0;

		String _borrowDateConcat = _dateObj.ConcatDate(_borrowDate);
		String _deliverDateConcat = _dateObj.ConcatDate(_deliverDate);

		while (!_borrowDateConcat.equals(_deliverDateConcat)) {
			_dateObj = _borrowDate;
			date = _dateObj.InsertDay();
			_borrowDateConcat = _dateObj.ConcatDate(date);
			timeBorrow++;
		}
		if (timeBorrow > 7)
			late = timeBorrow - 7;
		else
			late = 0;
		return late;
	}
	
	int DeliverPayment(int _contDayDeliver,int payment)
	{
		int deliverPayment=_contDayDeliver*payment;
		return deliverPayment;
	}
}
