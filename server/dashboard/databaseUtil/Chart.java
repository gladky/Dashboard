package dashboard.databaseUtil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Chart {
	private int values[];
	private Date args[];
	
	public Chart(){
		values = new int[2];
		args = new Date[2];
		initTestChart();
		
		
	}

	
	private void initTestChart(){
		values[0] = 10;
		values[1] = 10;
		/*values[2] = 10;
		values[3] = 10;
		values[4] = 10;
		values[5] = 10;
		values[6] = 10;
		values[7] = 10;
		values[8] = 10;
		values[9] = 10;*/
		args[0] = new Date();
		args[0] = addDays(args[0],-1);
		args[1] = new Date();
	}
	
	public static Date addDays(Date date, int days)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }
}
