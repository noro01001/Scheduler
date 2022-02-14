/**
 * This is a Scheduler class for use with SchedulerGUI.java.
 * A Scheduler object is created with 3 parameters, the day, time, and appointment.
 *
 *
 * @author  Norik Movsesyan
 * @version 1.0
 */
import javax.swing.JOptionPane;

public class Scheduler
{
	// Creates DayOfWeek enum.
	protected enum DayOfWeek {
		MONDAY,
		TUESDAY,
		WEDNESDAY,
		THURSDAY,
		FRIDAY
	}// end DayOfWeek

	// Creates variables for use throughout program.
	protected DayOfWeek day;
	protected String time;
	protected String appointment;

	// No-arg Constructor for scheduler.
	public Scheduler() {
		this.day = DayOfWeek.MONDAY;
		this.time = "1200p";
		this.appointment = "";
	}
	/** Scheduler constructor with 3 parameters is created.
	*
	* @param   day         Datatype: DayOfWeek. This value is the day an appointment is made.
	*                      (Example: MONDAY)
	*
	* @param   time        Datatype: String. This value is the time an appointment is made.
	*                      (Example: 1230p)
	*
	* @param   appointment Datatype: String. This value contains the details of an appointment.
	*                      (Example: Doctor's Appointment)
	**/
	public Scheduler(DayOfWeek day, String time, String appointment) {
		this.day = day;
		this.time = time;
		this.appointment = appointment;
	}

	// Setters for each Scheduler parameter.
	public void setDay(DayOfWeek day) {
		this.day = day;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public void setAppointment(String appointment) {
		this.appointment = appointment;
	}

	public DayOfWeek getDay() {
		return this.day;
	}

	public String getTime() {
		return this.time;
	}

	// Getters for each Scheduler parameter.
	public String getAppointment() {
		return this.appointment;
	}
}// end Scheduler