
public class BorrowClass {
	private String discName;
	private DateClass borrowDate; 


	public String getDiskName() {
		return discName;
	}
	public void setDiskName(String discName) {
		this.discName = discName;
	}
	public DateClass getBorrowDate() {
		return borrowDate;
	}
	public void setBorrowDate(DateClass borrowDate) {
		this.borrowDate = borrowDate;
	}
	
	public BorrowClass() {
		
	}
	public BorrowClass(String disc,DateClass date) {
		discName=disc;
		borrowDate=date;
	}
	
}
