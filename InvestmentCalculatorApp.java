/****************************************************************************************** 
Name: Zhenyu Jiang 
Course: CS170-01 
Lab #: Lab Assignment Two 
Submission Date: 10pm, Thu(11/10)
Description:  This class is a driver class to create the InvestmentCalculator object and call the
necessary methods to run the program.
*********************************************************************************************/ 
public class InvestmentCalculatorApp
{
	public static void main(String[] args)
	{
		InvestmentCalculator Calculator_one = new InvestmentCalculator(); //creating a new calculator object
		Calculator_one.ask_for_data(); //calling the function to ask for user inputs
		Calculator_one.calculate(); //calling the function to do the calculation
		Calculator_one.modify_and_dispaly(); //calling the function to modify data and display message
	}
}