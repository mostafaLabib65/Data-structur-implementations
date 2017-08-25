package polynomialSolver;
import java.util.Scanner;

import polynomialSolver.IPolynomialSolver;
public class main {
	public static MyPolynomialSolver poly = new MyPolynomialSolver();
	
	public static void main(String[] args) {
		while(true)
		{
			printMain();
	//_________________________________________________________________________________________________________________________
			Scanner s = new Scanner(System.in);
			int choose = 0;
			do
			{
				do
				{	 
			
					try {
						
						choose = s.nextInt();
						break;
					}
					catch (Exception e )
					{
						s.next();
						System.out.println("Couldn't parse input, please try again");
					}
				}
				while (true);
			}
			while(choose >7 || choose <=0);
	//________________________________________________________________________________________________________________________________		
			if(choose == 1)
			{
				setPolyVariable();
			}
	//________________________________________________________________________________________________________________________________
			else if(choose == 2)
			{
				Scanner s1 = new Scanner(System.in);
				char variableName;
				String Line;
				do
				{
					System.out.println("Insert the variable name : A , B , C or R");
					Line = s1.next();
					variableName = Line.charAt(0);
					
				}
				while(variableName != 'A' && variableName != 'B' && variableName != 'C' && variableName != 'R');
				String Variable;
				Variable = poly.print(variableName);
				System.out.println(Variable);
			}
	//___________________________________________________________________________________________________________________________________-
			else if(choose == 3)
			{
				System.out.println("Insert first operand variable name : A , B or C");
				char variableName1 = getValid();
				System.out.println("Insert second operand variable name : A , B or C");
				char variableName2 = getValid();
				int[][] terms = poly.add(variableName1, variableName2);
				poly.setPolynomial('R', terms);
				System.out.print("Result set in R : ");
				print(terms);
			}
	//________________________________________________________________________________________________________________________________		
			else if(choose == 4)
			{
				System.out.println("Insert first operand variable name : A , B or C");
				char variableName1 = getValid();
				System.out.println("Insert second operand variable name : A , B or C");
				char variableName2 = getValid();
				int[][] terms = poly.subtract(variableName1, variableName2);
				poly.setPolynomial('R', terms);
				System.out.println("Result set in R : ");
				print(terms);
			}
	//________________________________________________________________________________________________________________________________
			else if(choose == 5)
			{
				System.out.println("Insert first operand variable name : A , B or C");
				char variableName1 = getValid();
				System.out.println("Insert second operand variable name : A , B or C");
				char variableName2 = getValid();
				int[][] terms = poly.multiply(variableName1,variableName2);
				poly.setPolynomial('R', terms);
				System.out.println("Result set in R : ");
				print(terms);
			}
	//________________________________________________________________________________________________________________________________	
			else if(choose == 6)
			{
				System.out.println("Insert operand variable name : A , B or C");
				char variableName1 = getValid();
				float number = validFloat();
				float ans = poly.evaluatePolynomial(variableName1, number);
				System.out.println(number);
			}
	//________________________________________________________________________________________________________________________________
			else if(choose == 7)
			{
				System.out.println("Insert operand variable name : A , B or C");
				char variableName1 = getChar();
				poly.clearPolynomial(variableName1);
			}
		}
	}
	//________________________________________________________________________________________________________________________________
	public static void printMain()
	{
		System.out.println("Please choose an action");
		System.out.println("-----------------------");
		System.out.println("1 - Set a polynomial variable");
		System.out.println("2 - Print the value of a polynomial variable");
		System.out.println("3 - Add two polynomials");
		System.out.println("4 - Subtract two polynomials");
		System.out.println("5 - Multiply two polynomials");
		System.out.println("6 - Evaluate a polynomial at some point");
		System.out.println("7 - Clear a polynomial variable");
	}
	//________________________________________________________________________________________________________________________________	
	public static void setPolyVariable()
	{
		int[][] terms;
		System.out.println("=============================================");
		System.out.println("Insert the variable name : A , B or C");
		char variableName = getChar();
		terms = ((MyPolynomialSolver) poly).getTerms();
		poly.setPolynomial(variableName, terms);
	}
	//________________________________________________________________________________________________________________________________	
	public static char getChar()
	{
		Scanner s = new Scanner(System.in);
		char variableName;
		String Line;
		int flage = 0;
		do
		{	
			if(flage != 0)
			{
				System.out.println("invaild variable");
			}
			flage++;
			Line = s.next();
			variableName = Line.charAt(0);
			
		}
		while(variableName != 'A' && variableName != 'B' && variableName != 'C');
		return variableName;
	}
	//________________________________________________________________________________________________________________________________	
	public static char getValid()
	{
		char variableName;
		int flage1;
		do{
			flage1 = 0;
			variableName = getChar();
			if((variableName == 'A' && poly.isEmpty('A') || variableName == 'B' && poly.isEmpty('B') || variableName == 'C' && poly.isEmpty('C')))
			{
				flage1++;
				System.out.println("Variable not set");
			}
		}while(flage1 != 0);
		return variableName;
	}
	//________________________________________________________________________________________________________________________________	
	public static float validFloat()
	{
		Scanner s = new Scanner(System.in);
		float choose = 0;
		System.out.println("Enter the point: ");
		do
		{	 
	
			try {
				
				choose = s.nextInt();
				break;
			}
			catch (Exception e )
			{
				s.next();
				System.out.println("Couldn't parse input, please try again");
			}
		}
		while (true);
		return choose;
	}
	public static void print(int[][] terms)
	{
		for(int i = 0; i < terms.length; i++)
		{
			for(int j = 0; j < 1; j++)
			{
				if(i != terms.length -1)
					System.out.print("("+terms[i][j]+","+terms[i][j+1]+")"+",");
				else
					System.out.println("("+terms[i][j]+","+terms[i][j+1]+")");
			}
		}
	}
}











