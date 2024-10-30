package Appointment;

import java.util.ArrayList;
import java.util.Date;

public interface IScheludable {
    ArrayList<Date> appoinmentsAvailable(Date date);
    boolean schelude(Date date, String time);
}
