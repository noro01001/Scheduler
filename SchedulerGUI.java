/**
 * This is a GUI form for use with Scheduler.java.
 * The user inputs times for days of the week and details for appointments, then can submit, clear, or open the appointments.
 *
 * SchedulerGUI.java extends the Application object.
 *
 * @author  Norik Movsesyan
 * @version 1.0
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.event.*;
import javafx.scene.text.*;
import javafx.event.ActionEvent;
import javax.swing.JOptionPane;

import java.util.ArrayList;

public class SchedulerGUI extends Application
{
	// Creates all labels used throughout the program.
	private Label mondayLabel = new Label("Monday");
	private Label tuesdayLabel = new Label("Tuesday");
	private Label wednesdayLabel = new Label("Wednesday");
	private Label thursdayLabel = new Label("Thursday");
	private Label fridayLabel = new Label("Friday");

	// Creates all TextFields used throughout the program.
	private TextField mondayTextField1 = new TextField();
	private TextField tuesdayTextField1 = new TextField();
	private TextField wednesdayTextField1 = new TextField();
	private TextField thursdayTextField1 = new TextField();
	private TextField fridayTextField1 = new TextField();

	private TextField mondayTextField2 = new TextField();
	private TextField tuesdayTextField2 = new TextField();
	private TextField wednesdayTextField2 = new TextField();
	private TextField thursdayTextField2 = new TextField();
	private TextField fridayTextField2 = new TextField();

	// Creates all Buttons used throughout the program.
	private Button submitButton = new Button("Submit");
	private Button clearButton = new Button("Clear");
	private Button openButton = new Button("Open");

	// Creates ArrayList.
	ArrayList<String> appointmentList = new ArrayList<>();

	@Override
	public void start(Stage primaryStage) {

		// Creates BorderPane
		BorderPane pane = new BorderPane();

		// Sets HBox to the top.
		pane.setTop(getHBox());

		// Creates scene.
		Scene scene = new Scene(pane);

		// Sets title for stage and shows primary stage.
		primaryStage.setTitle("Scheduler");
		primaryStage.setScene(scene);
		primaryStage.show();

		// Adds prompt text to all textFields.
		mondayTextField1.setPromptText("Time");
		tuesdayTextField1.setPromptText("Time");
		wednesdayTextField1.setPromptText("Time");
		thursdayTextField1.setPromptText("Time");
		fridayTextField1.setPromptText("Time");

		mondayTextField2.setPromptText("Details");
		tuesdayTextField2.setPromptText("Details");
		wednesdayTextField2.setPromptText("Details");
		thursdayTextField2.setPromptText("Details");
		fridayTextField2.setPromptText("Details");


		// When Submit Button is pressed...
		submitButton.setOnAction (e -> {

			// Scheduler object is created.
			Scheduler scheduler1 = new Scheduler();

			// Checks if Time text fields are empty.
			if (mondayTextField1.getText().isEmpty()
			&& tuesdayTextField1.getText().isEmpty()
			&& wednesdayTextField1.getText().isEmpty()
			&& thursdayTextField1.getText().isEmpty()
			&& fridayTextField1.getText().isEmpty())
			{
				// If they all are, the user gets an error message.
				JOptionPane.showMessageDialog(null,
				"Please make sure you've entered an appointment time for at least one day.");
				return;
			}

			// Runs data validation on all Time text fields.
			String time = mondayTextField1.getText();
			Appointment(time);
			time = tuesdayTextField1.getText();
			Appointment(time);
			time = wednesdayTextField1.getText();
			Appointment(time);
			time = thursdayTextField1.getText();
			Appointment(time);
			time = fridayTextField1.getText();
			Appointment(time);

			// AppointmentList adds 10 indexes.
			appointmentList.add("");
			appointmentList.add("");
			appointmentList.add("");
			appointmentList.add("");
			appointmentList.add("");
			appointmentList.add("");
			appointmentList.add("");
			appointmentList.add("");
			appointmentList.add("");
			appointmentList.add("");

			// Sets appointmentList indexes to all textFields.
			appointmentList.set(0, mondayTextField1.getText());
			appointmentList.set(1, tuesdayTextField1.getText());
			appointmentList.set(2, wednesdayTextField1.getText());
			appointmentList.set(3, thursdayTextField1.getText());
			appointmentList.set(4, fridayTextField1.getText());

			appointmentList.set(5, mondayTextField2.getText());
			appointmentList.set(6, tuesdayTextField2.getText());
			appointmentList.set(7, wednesdayTextField2.getText());
			appointmentList.set(8, thursdayTextField2.getText());
			appointmentList.set(9, fridayTextField2.getText());
		});

		// When Clear button is pressed...
		clearButton.setOnAction (e -> {

			// The text in the textFields are erased.
			mondayTextField1.setText("");
			tuesdayTextField1.setText("");
			wednesdayTextField1.setText("");
			thursdayTextField1.setText("");
			fridayTextField1.setText("");

			mondayTextField2.setText("");
			tuesdayTextField2.setText("");
			wednesdayTextField2.setText("");
			thursdayTextField2.setText("");
			fridayTextField2.setText("");
		});

		// When open button is pressed...
		openButton.setOnAction (e -> {

			//Tries to set the Textfield text to what was stored in appointmentList.
			try
			{
				mondayTextField1.setText(appointmentList.get(0));
				tuesdayTextField1.setText(appointmentList.get(1));
				wednesdayTextField1.setText(appointmentList.get(2));
				thursdayTextField1.setText(appointmentList.get(3));
				fridayTextField1.setText(appointmentList.get(4));

				mondayTextField2.setText(appointmentList.get(5));
				tuesdayTextField2.setText(appointmentList.get(6));
				wednesdayTextField2.setText(appointmentList.get(7));
				thursdayTextField2.setText(appointmentList.get(8));
				fridayTextField2.setText(appointmentList.get(9));
			}
			// Catches error if User has not submitted at least one appointment time.
			catch(IndexOutOfBoundsException error)
			{
				JOptionPane.showMessageDialog(null,
				"Please submit at least one appointment time before pressing 'Open'.");
				return;
			}
		});


	}// end start

	// Sets up hboxes and vboxes.
	private HBox getHBox() {
		HBox hBox = new HBox(100);
		hBox.setPadding(new Insets(15, 15, 15, 15));

		VBox vBox1 = new VBox(30);
		vBox1.setPadding(new Insets(5, 5, 5, 5));
		vBox1.getChildren().addAll(mondayLabel, mondayTextField1, mondayTextField2, submitButton);

		VBox vBox2 = new VBox(30);
		vBox2.setPadding(new Insets(5, 5, 5, 5));
		vBox2.getChildren().addAll(tuesdayLabel, tuesdayTextField1, tuesdayTextField2);

		VBox vBox3 = new VBox(30);
		vBox3.setPadding(new Insets(5, 5, 5, 5));
		vBox3.getChildren().addAll(wednesdayLabel, wednesdayTextField1, wednesdayTextField2, clearButton);

		VBox vBox4 = new VBox(30);
		vBox4.setPadding(new Insets(5, 5, 5, 5));
		vBox4.getChildren().addAll(thursdayLabel, thursdayTextField1, thursdayTextField2);

		VBox vBox5 = new VBox(30);
		vBox5.setPadding(new Insets(5, 5, 5, 5));
		vBox5.getChildren().addAll(fridayLabel, fridayTextField1, fridayTextField2, openButton);

		hBox.getChildren().addAll(vBox1, vBox2, vBox3, vBox4, vBox5);
		return hBox;
	}

	/** Appointment method is created.
	*
	* @param   time        Datatype: String. This value is pulled from the time textfields.
	*                      (Example: 1230p)
	**/
	public static void Appointment(String time)
	{
		// For loop for data validation.
		for(int i = 0; i < time.length(); i++) {

			// Creates boolean that determines if a char is or isn't a digit.
			Boolean flag = Character.isDigit(time.charAt(i));

			// If the time length is one...
			if (time.length() == 1)
			{
				//... The user gets an error message and the validation ends.
				JOptionPane.showMessageDialog(null, "Invalid entry.\nTime must be formatted with 1-4 numbers and one letter, a or p, AM and PM respectively.\n Example: 12:30 PM would be 1230p.");
				return;
			}

			// If the time length is over 5...
			if (time.length() > 5)
			{
				//... The user gets an error message and the validation ends.
				JOptionPane.showMessageDialog(null, "Invalid entry.\nTime must be formatted with 1-4 numbers and one letter, a or p, AM and PM respectively.\n Example: 12:30 PM would be 1230p.");
				return;
			}

			// If i is less than one less than the length of time...
			if (i < time.length() - 1)
			{
				// If the first 1-5 chars are digits...
				if(flag) {

				}
				else {
					// If they're not, the user gets an error message and the validation ends.
					JOptionPane.showMessageDialog(null, "Invalid entry.\nTime must be formatted with 1-4 numbers and one letter, a or p, AM and PM respectively.\n Example: 12:30 PM would be 1230p.");
					return;
				}
			}

			// If i is 1 less than the length of time...
			if (i == time.length() - 1)
			{
				// And the last digit is a digit...
				if(flag) {
					// The user gets an error message and validation ends.
					JOptionPane.showMessageDialog(null, "Invalid entry.\nTime must be formatted with 1-4 numbers and one letter, a or p, AM and PM respectively.\n Example: 12:30 PM would be 1230p.");
					return;
				}
			}
		}
	}


}// end SchedulerGUI
