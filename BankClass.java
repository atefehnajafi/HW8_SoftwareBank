import java.util.ArrayList;

public class BankClass {
	ArrayList<EventClass> _eventList = new ArrayList<>();

	ArrayList<PersonClass> _personList=new ArrayList<>();
	
	String[] Spliter(String str) {
		String[] s = new String[5];

			s = str.split(" ");

		return s;
	}
}
