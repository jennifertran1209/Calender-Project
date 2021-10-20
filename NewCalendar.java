import java.util.*;
import java.util.Scanner;

/**
	Name: Jennifer Tran
	Professor: Ken Nguyen
	Class: CSCI 1301
	Description: Code that prints out a calendar that is based
		     on the month and the year. The calendar is shown
		     when the user inputs a month and year using numbers.
*/

public class NewCalendar{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		
		// Intro to the coding program
		System.out.println("Welcome to my Calendar program!\n");
		System.out.println("Input a month and the year for" +
				   " the calendar. Input both as numbers.");
		System.out.println("Remember the inputs for months is from " + 
				    "1 - 12.");
		
		// Gathers user's input for month
		System.out.println("Input for month: ");
		int month = scan.nextInt();

		/*
			Condition will keep running if the user keeps inputting
			an invalid input for month. It will activate if month
			is less than 1 and greater than 12.
		*/
		while(month < 1 || month > 12){
			System.out.println("Invalid input. Please input again: ");
			month = scan.nextInt();
		}

		// Gathers user's input for year
		System.out.println("Input for year: ");
		int year = scan.nextInt();
		
		
		/*
			Prints out the month from the user's numerical input.
			Numerical input spans from January(1) through December(12).
		*/
		switch(month){
			case 1:
				System.out.println("January");
				break;
			case 2:
				System.out.println("February");
				break;
			case 3:
				System.out.println("March");
				break;
			case 4:
				System.out.println("April");
				 break;
			case 5:
				System.out.println("May");
				break;
			case 6:
				System.out.println("June");
				break;
			case 7:
				System.out.println("July");
				break;
			case 8:
				System.out.println("August");
				break;
			case 9:
				System.out.println("September");
				break;
			case 10:
				System.out.println("October");
				break;
			case 11:
				System.out.println("November");
				break;
			case 12:
				System.out.println("December");
				break;
		}
		// Prints out the year the user chose.
		System.out.println(year);
		
		// Total days in the year to be added with the rest of the code
		int totalDay = 0;
		
		/* 
			January 1, 1 starts on a Saturday. Code that gathers
			the total days of the year. Counts for leap year too
			so on leap year it is 366 days and a normal year is 
			365.
		*/
		if(year < 1900){
		    totalDay += 2;
		    for(int i = 0; i <= year; i++){
		        if ((i % 4 == 0) && (i % 100 != 0) || (i % 400 == 0)) {
                    totalDay += 366;
		        } else {
                    totalDay += 365;
		        }
		    }
		}
		
		/*
			January 1, 1900 starts on a Monday. Code that gathers the
			total days of the year. Leap year is 366 days and
			normal year is 365 days.
		*/
		if(year >= 1900){
		    for(int i = 1900; i < year; i++){
		        if ((i % 4 == 0) && (i % 100 != 0) || (i % 400 == 0)) {
                    totalDay += 366;
                } else {
                    totalDay += 365;
                }
		    }
		}
		
		/*
			Code that calculates the total amount of days from the month
			as the code iterates. 
		*/
		for(int jan = 1; jan < month; jan++){
		    if(jan == 4 || jan == 6 || jan == 9 || jan == 11){
		        totalDay += 30;
		    } else if(jan == 2){
		        if ((year % 4 == 0) && (year % 100 != 0) || 
			(year % 400 == 0)){
		            totalDay += 29;
		        } else {
		            totalDay += 28;
		        }
		    } else {
		        totalDay += 31;
		    }
	    }
		
		// Prints the day header of the calendar.
		System.out.println();
		System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat");
		
		/*
			Code that adds the total days of the month. Helps 
			determine the last day of the month.
		*/
		int lastDay = 0;
		if(month == 1 || month == 3 || month == 5 || month == 7 || 
		   month == 8 || month == 10 || month == 12){
			lastDay += 31;
		} else if(month == 4 || month == 6 || month == 9 || month == 11){
			lastDay += 30;
		} else {
			if(((year % 4 == 0) && (year % 100 != 0)) ||
			(year % 400 == 0)){
				lastDay += 29;
			} else {
				lastDay += 28;
			}
		}
		
		// Used to calculate the first day of the first month.
	    	int firstDay = (totalDay + 1) % 7;
		// Creates space before the 1st day of each month.
		for(int space = 0; space < firstDay; space++){ 
		    System.out.print("\t");
		}
		
		/*
			Creates the month with the total amount of days, last day,
			and adds lines to make it neat.
		*/
		int day1 = totalDay + 1;
		for(int num = 1; num <= lastDay; num++){
			if(day1 % 7 == 6){
				System.out.print(num);
				System.out.println();
			} else {
				System.out.print(num + "\t");
			}
			day1++;
		}
	}
}