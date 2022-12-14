/****************************************************************************************** 
Name: Zhenyu Jiang 
Course: CS170-01 
Lab #: Lab Assignment Two 
Submission Date: 10pm, Thu(11/10)
Description:  This class is used to calculate the amount of investment that the user can get after
a certain amount of time. It will ask the user for yearly rate, how much they invest monthly, and 
years they will invest to calculate the future value. This class has input validation function to 
make sure the user is entering legal numbers. In the end, the modified data will be shown through
the JOptionPane windows.
*********************************************************************************************/ 
import java.text.NumberFormat;
import java.util.Scanner;
import javax.swing.JOptionPane;
public class InvestmentCalculator
{
	private double yearlyRate, futureValue, monthlyInvest; //declaring some variables
	private int years;
	
	public class OutofRangeException extends Exception // a customize exception class to handle out of range numbers
	{
		public OutofRangeException() {
		super("The number is not in the range!");}
	}
		
	public boolean check_money(double input) // It will return true if the value between $1 to a million
	{
		return  input >= 1 && input <= 1000000 ? true : false; //it will return false if the input is not in range
	}
	
	public boolean check_rate(double rate)//It will return true if the rate is between 0.1 to 3.5
	{
		return rate >= 0.1 && rate <= 3.5 ? true : false; //it will return false if the input is not in range
	}
	
	public boolean check_year(int year) //It will return true if the year is between 1 to 100 years
	{
		return year >= 1 && year <= 100 ? true : false;
		
	}
	
	public void ask_for_data()
	{
		String input,input2,input3; //variables for storing user inputs
		Boolean vaild = false; //user's input will not meet the requirement before they enter anything
		String title = "Welcome to the InvestmentCalculator, please enter the following info to calcualte:";
		//simple description about the program
		JOptionPane.showMessageDialog(null, title); //show description
		input = JOptionPane.showInputDialog("Monthly investment(between $1 to $1,000,000): "); //asking for the first input
		while(!vaild) //when the input is not meet the requirements
		{
			try 
			{	
				monthlyInvest = Double.parseDouble(input); //turning the input to a double
				if(!check_money(monthlyInvest)) //checking the number is in range or not
				{
					throw new OutofRangeException();
				}
					vaild = true; //input meets the requirements and quit the loop
				}
			
			catch(OutofRangeException e)
			{
				JOptionPane.showMessageDialog(null,e.getMessage()); //showing the error message
				input = JOptionPane.showInputDialog("Please reenter your Montly investment");
				//telling the user to do the input again
			}
			catch(NumberFormatException e) //if the user input something other than numbers
			{
				JOptionPane.showMessageDialog(null,"Not a number!"); //showing the error message
				input = JOptionPane.showInputDialog("Please reenter your Montly investment");
				//telling the user to do the input again
			}
		}
		
		vaild = false; //reset the default condition so that the loop can run
		input2 = JOptionPane.showInputDialog("Yearly rate(between 0.1% to 3.5%): ");
		//asking for the second input
		while(!vaild)  //when the input is not meet the requirements
		{
			try 
			{	
				yearlyRate = Double.parseDouble(input2); //turning the input to a double
				if(!check_rate(yearlyRate))  //checking the number is in range or not
				{
					throw new OutofRangeException(); //throw exception if not in range
				}
					vaild = true; //input meets the requirements and quit the loop
				}
			
			catch(OutofRangeException r)
			{
				JOptionPane.showMessageDialog(null,r.getMessage()); //showing the error message
				input2 = JOptionPane.showInputDialog("Please reenter your year return rate");
				//telling the user to do the input again
			}
			catch(NumberFormatException r)
			{
				JOptionPane.showMessageDialog(null,"Not a number!"); //showing the error message
				input2 = JOptionPane.showInputDialog("Please reenter your year return rate");
				//telling the user to do the input again
			}
		}
		yearlyRate = yearlyRate/100; // turning the rate to a percentage
		
		vaild = false; //reset to default
		input3 = JOptionPane.showInputDialog("Years of investment (between 1 to 100): ");
		
		while(!vaild)  //when the input is not meet the requirements
		{
			try 
			{	
				years = Integer.parseInt(input3); //turning the input to an int
				if(!check_year(years))  //checking the number is in range or not
				{
					throw new OutofRangeException();
				}
					vaild = true;
				}
			
			catch(OutofRangeException y)
			{
				JOptionPane.showMessageDialog(null,y.getMessage());
				input3 = JOptionPane.showInputDialog("Please reenter your years of investment");
			}
			catch(NumberFormatException y) //if the user input something other than numbers
			{
				JOptionPane.showMessageDialog(null,"Not a number!");
				input3 = JOptionPane.showInputDialog("Please reenter your years of investment");
			}
		}
	}
	
	public void calculate() //a function to calculate the future value
	{
		double monthlyRate = yearlyRate/12/100;
		int months = years * 12;	//convert to months
		int i = 1;					//loop control variable
		while(i <= months) 
		{
			futureValue = (futureValue + monthlyInvest) *
					(1 + monthlyRate);
			i++;   				//month increased by 1
		}						//end of while
	}	//end of method futureValueComputing
	
	public void modify_and_dispaly() // the function will modified data and display them
	{
		String output1, output2, output3,output4; //variables to store output messages
		NumberFormat currency = NumberFormat.getCurrencyInstance(); //using BigDecimal class to modify currency
		NumberFormat total = NumberFormat.getCurrencyInstance(); 
		NumberFormat percent = NumberFormat.getPercentInstance(); //using BigDecimal class to modify percentage
		NumberFormat year = NumberFormat.getNumberInstance(); //using BigDecimal class to modify regular numbers
		currency.setMaximumFractionDigits(3);
		percent.setMaximumFractionDigits(3); //setting them to the 3 decimal places
		total.setMaximumFractionDigits(3);
		output1 = currency.format(monthlyInvest); //formating our data
		output2 = percent.format(yearlyRate);
		output3 = year.format(years);	
		output4 = total.format(futureValue);
		JOptionPane.showMessageDialog(null, "Your monthly investment will be: "+output1); //output them through the JOptionPane
		JOptionPane.showMessageDialog(null, "Your year return rate will be: "+output2);
		JOptionPane.showMessageDialog(null, "Your year of investment will be: "+output3);
		JOptionPane.showMessageDialog(null, "Your future value will be: "+output4);
	}
}