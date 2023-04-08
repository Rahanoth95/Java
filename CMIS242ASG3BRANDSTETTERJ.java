//Johnathan Brandstetter CMIS242
//Assignment 3 GuiConverter

import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 

public class CMIS242ASG3BRANDSTETTERJ{
//Converter Class
public class Converter{
	private double input; //Private attribute for input of data type double

	//Default constructor with no parameter which sets input to Double.NaN
	Converter()
	{
		this.input=Double.NaN;
		}
	//Overloaded constructor with input for parameter
	Converter(double input)
	{
		this.input = input;
		}
	//Get and set methods for input attribute
	double getInput()
	{
		return this.input;
		}
	void setInput(double input)
	{
		this.input = input;
	}

	//Method convert() which returns input value
	double convert()
	{
		return this.input;
	}
	}

//TemperatureConverter Class

	public class TemperatureConverter extends Converter
	{

		//Constructors which call parent constructors
		TemperatureConverter()
		{
			super();
		}

		TemperatureConverter(double input)
		{
			super(input);
		}

		//Overridden convert() method to convert input (Fahrenheit temperature) to Celsius and returns the value. If the instance has no input value, it should return Double.NaN
		double convert()
		{
			//We use getter method of super class to get input value and check if it has default value. If yes, we return same as result, otherwise we calculate temperature in Celsius
			if(super.getInput() == Double.NaN)

			{
				return Double.NaN;
			}
			else
			{
				return ((super.getInput()-32.0)*5.0)/9.0;
			}
		}
	}
//DistanceConverter Class
	public class DistanceConverter extends Converter
	{
		//Constructors which call parent constructors
		DistanceConverter()
		{
			super();
		}
		DistanceConverter(double input)
		{
			super(input);
		}
		//Overridden convert() method to convert input (distance in miles) to distance in kilometers and returns the value. If the instance has no input value, it should return Double.NaN
		double convert()
		{
			//We use getter method of super class to get input value and check if it has default value. If yes, we return same as result, otherwise we calculate distance in KM
			if(super.getInput() == Double.NaN)
			{
				return Double.NaN;
			}
			else
			{
				return super.getInput() * 1.609;
			}
		}
	}
	
	//GUIConverter Class
	public class GUIConverter{
		GUIConverter(){
			//Implement GUIConverter class using JFrame and JPanel
			JFrame j= new JFrame("Converter");
			j.setLayout (new FlowLayout ());
			JPanel panel=new JPanel();

			//GUI will have 3 buttons: "Distance Converter", "Temperature Converter", and "Exit".
			JButton but1=new JButton("Distance Converter");
			JButton but2=new JButton("Temperature Converter");
			JButton but3=new JButton("Exit");

			//We add them to the Panel, add panel to frame and set size and layout of frame.
			panel.add(but1);
			panel.add(but2);
			panel.add(but3);
			j.add(panel);
			j.setLayout(new FlowLayout ());
			j.setSize(470,90);
			j.setVisible(true);
			j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

			//Adding ActionListener to buttons

			//When user clicks Distance Converter, an input dialog will pop up where user can type value and click OK. Once user clicks OK, message dialog will pop up with converted result.
			but1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String str = JOptionPane.showInputDialog("Enter Distance In Miles:"); //str will store input string from JOptionPane.showInputDialog()
					Double miles = Double.parseDouble(str);//Conversion to Double and storing in miles variable
					DistanceConverter object = new DistanceConverter(miles);//Creation of new DistanceConverter obj using miles
					JOptionPane.showMessageDialog(j,"Distance in KM is "+object.convert());//Calling convert() of obj and displaying result in JOptionPane.showMessageDialog
				}
			});

			//When user clicks on Temperature button, an input dialog will pop up to input value and then when clicks OK, the message dialog with pop up with converted result
			but2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String str = JOptionPane.showInputDialog("Enter Temperature In Fahrenheit :"); //str will store input string from JOptionPane.showInputDialog()
					Double far = Double.parseDouble(str);//Conversion to Double and storing in far variable
					TemperatureConverter object = new TemperatureConverter(far);//Creation of new TemperatureConverter obj using far
					JOptionPane.showMessageDialog(j,"Temperature in Celsius is "+object.convert());
				}
			});

			//When user clicks Exit, the program will terminate
			but3.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					j.dispose();//We dispose the frame f
				}
			});
		}
		public static void main(String[] args)
		{
			GUIConverter converter = new GUIConverter();//We call the constructor to create the GUI
		}
	}
	}