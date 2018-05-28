import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		BankClass _bankObj = new BankClass();
		PersonClass _personObj = new PersonClass();
		BorrowClass _borrowObj = new BorrowClass();
		EventClass[] _eventList = new EventClass[6];

		int _deliverDate = 0;
		int perDayDeliverMoney = 500;
		int allPayment = 0;

		try {
			File _file = new File("D:/SoftwareBank.txt");
			String[] help = new String[5];
			Scanner _scanner = new Scanner(_file);
			int count = 0;

			while (_scanner.hasNextLine()) {
				_scanner.nextLine();
				count++;
			}

			File _fileAgain = new File("D:/SoftwareBank.txt");
			_scanner = new Scanner(_fileAgain);

			for (int i = 0; i < count-1; i++) {
				String line = _scanner.nextLine();
				help = _bankObj.Spliter(line);
				EventClass _eventObj = new EventClass();
				_eventObj._personName = help[0];
				_eventObj._disc.setDiscName(help[1]);
				_eventObj.date.set_year(Integer.parseInt(help[2]));
				_eventObj.date.set_month(Integer.parseInt(help[3]));
				_eventObj.date.set_day(Integer.parseInt(help[4]));
				_eventList[i] = _eventObj;
			} // end of while

			boolean flag = false;
			int m = 0;

			for (int j = 0; j < _eventList.length; j++) {
				flag=false;
				if (j == 0) {
					_personObj.setPersonName(_eventList[j]._personName);
					_borrowObj=_personObj.borrow(_eventList[j]._disc, _eventList[j].date);
					_personObj._borrowList.add(_borrowObj);
				
				/*	_manageObj = new Management();

					_manageObj.personName = _eventList[j]._personName;
					_manageObj.late = 0;
					_manageObj.discName = _eventList[j]._disc.getDiscName();
					_manageList.add(_manageObj);*/

				} else if (j == 1) {
					_personObj.setPersonName(_eventList[j]._personName);
					if (_eventList[j]._personName.equals(_eventList[j - 1]._personName)
							&& _eventList[j]._disc.getDiscName().equals(_eventList[j - 1]._disc.getDiscName())) {

						_borrowObj=_personObj.deliver(_eventList[j]._disc, _eventList[j].date);
						_deliverDate = _personObj.getLateDays(_eventList[j - 1].date, _eventList[j].date);
						_personObj._borrowList.add(_borrowObj);
						allPayment = _personObj.DeliverPayment(_deliverDate, perDayDeliverMoney);

						
					} else {
						_borrowObj=_personObj.borrow(_eventList[j]._disc, _eventList[j].date);
						_personObj._borrowList.add(_borrowObj);
					}

				} // end of j if
				else {
					outher:for (int i = j - 1; i >= 0; i--) {
						if (_eventList[j]._personName.equals(_eventList[i]._personName)
								&& _eventList[j]._disc.getDiscName().equals(_eventList[i]._disc.getDiscName())) {

							_personObj.setPersonName(_eventList[j]._personName);

							_borrowObj=_personObj.deliver(_eventList[j]._disc, _eventList[j].date);
							_personObj._borrowList.add(_borrowObj);
							_deliverDate = _personObj.getLateDays(_eventList[i].date, _eventList[j].date);
							allPayment = _personObj.DeliverPayment(_deliverDate, perDayDeliverMoney);
	
							flag = true;
							break outher;
						}
						m = i;
					}
					if (flag != true) {
						_personObj.setPersonName(_eventList[m]._personName);
						_borrowObj=_personObj.borrow(_eventList[m]._disc, _eventList[m].date);
						_personObj._borrowList.add(_borrowObj);

					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
