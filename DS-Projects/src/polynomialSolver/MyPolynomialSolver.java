package polynomialSolver;

import java.util.Scanner;
import java.lang.RuntimeException;
import java.lang.NullPointerException;
import linkedList.sLinkedList;

import polynomialSolver.IPolynomialSolver;

public class MyPolynomialSolver implements IPolynomialSolver {
	public sLinkedList A = new sLinkedList() ;
	public sLinkedList B = new sLinkedList() ;
	public sLinkedList C = new sLinkedList() ;
	public sLinkedList R = new sLinkedList() ;
	int[][] Result ;
	
	/**
	* Set polynomial terms (coefficients & exponents)
	* @param poly name of the polynomial
	* @param terms array of [coefficients][exponents]
	*/
	public void setPolynomial(char poly, int[][] terms){
		if (poly != 'A' && poly != 'B' && poly != 'C' && poly != 'R')
		{
			throw new RuntimeException();
		}
		if (this.checkSort(terms, terms.length))
		{
			if (poly == 'A')
			{
				A = setLinkedList(terms) ;
			}
			else if (poly == 'B')
			{
				B = setLinkedList(terms) ;
			}
			else if (poly == 'C')
			{
				C = setLinkedList(terms) ;
			}
			else if (poly == 'R')
			{
				R = setLinkedList(terms) ;
			}
		}
		else 
		{
			throw new RuntimeException();
		}
	}
	/**
	* Print the polynomial in human readable representation
	* @param poly name of the polynomial
	* @return polynomial in the form like 27x^2+x-1
	*/
	public String print(char poly){
		if (poly == 'A')
		{
			if (A.isEmpty() == true)
			{
				return null ;
			}
			return expression(A) ;
		}
		else if (poly == 'B')
		{
			if (B.isEmpty() == true)
			{
				return null ;
			}
			return expression(B) ;
		}
		else if (poly == 'C')
		{
			if (C.isEmpty() == true)
			{
				return null ;
			}
			return expression(C) ;
		}
		else if (poly == 'R')
		{
			if (R.isEmpty() == true)
			{
				return null ;
			}
			return expression(R) ;
		}
		else 
		{
			return "Variable not Set" ;
		}
	}
	/**
	* Clear the polynomial
	* @param poly name of the polynomial
	*/
	public void clearPolynomial(char poly){
		if (poly == 'A')
		{
			if (A.isEmpty() == true )
			{
				throw new NullPointerException();

			}
			A.clear();
		}
		else if (poly == 'B')
		{
			if (B.isEmpty() == true )
			{
				throw new NullPointerException();

			}
			B.clear();
		}
		else if (poly == 'C')
		{
			if (C.isEmpty() == true )
			{
				throw new NullPointerException();

			}
			C.clear();
		}
		else if (poly == 'R')
		{
			if (R.isEmpty() == true )
			{
				throw new NullPointerException();

			}
			R.clear();
		}
	}
	/**
	* Evaluate the polynomial
	* @param poly name of the polynomial
	* @param the polynomial constant value
	* @return the value of the polynomial
	*/
	public float evaluatePolynomial(char poly, float value){
		float sum = 0 ;
		if (poly == 'A')
		{
			if (A.isEmpty() == true )
			{
				throw null ;
			}
			int size = A.size() ;
			int[] b = new int[2] ;
			
			for (int i = 0 ; i < size ; i ++)
			{
				b = (int[])A.get(i) ;
				sum += b[0] * Math.pow(value, b[1]) ;
			}
			return sum ;
		}
		else if (poly == 'B')
		{
			if (B.isEmpty() == true )
			{
				throw null ;
			}
			int size = B.size() ;
			int[] b = new int[2] ;
			
			for (int i = 0 ; i < size ; i ++)
			{
				b = (int[])B.get(i) ;
				sum += b[0] * Math.pow(value, b[1]) ;
			}
			return sum ;
		}
		else if (poly == 'C')
		{
			if (C.isEmpty() == true )
			{
				throw null ;
			}
			int size = C.size() ;
			int[] c = new int[2] ;
			
			for (int i = 0 ; i < size ; i ++)
			{
				c = (int[])C.get(i) ;
				sum += c[0] * Math.pow(value, c[1]) ;
			}
			return sum ;
		}
		else if (poly == 'R')
		{
			if (R.isEmpty() == true )
			{
				throw null ;
			}
			int size = R.size() ;
			int[] r = new int[2] ;
			
			for (int i = 0 ; i < size ; i ++)
			{
				r = (int[])R.get(i) ;
				sum += r[0] * Math.pow(value, r[1]) ;
			}
			return sum ;
		}
		return 0 ;
	}
	/**
	* Add two polynomials
	* @param poly1 first polynomial
	* @param poly2 second polynomial
	* @return the result polynomial
	*/
	public int[][] add(char poly1, char poly2){
		
		if ((poly1 == 'A' || poly2 == 'A') && (poly1 == 'B' || poly2 == 'B') )
		{
				if ((A.isEmpty() == true) || (B.isEmpty() == true) || A.size() == 0 || B.size() == 0)
				{
					throw new RuntimeException() ;
				}
				return addPoly(A , B) ;
		}
		else if ((poly1 == 'A' || poly2 == 'A') && (poly1 == 'C' || poly2 == 'C') )
		{
				if ((A.isEmpty() == true) || (C.isEmpty() == true) || A.size() == 0 || C.size() == 0)
				{
					throw new RuntimeException() ;
				}
				return addPoly(A , C) ;
		}
		else if ((poly1 == 'C' || poly2 == 'C') && (poly1 == 'B' || poly2 == 'B') )
		{
				if ((C.isEmpty() == true) || (B.isEmpty() == true) || C.size() == 0 || B.size() == 0)
				{
					throw new RuntimeException() ;
				}
				return addPoly(C , B) ;
		}
		else if (poly1 == 'A' && poly2 == 'A')
		{
				if ((A.isEmpty() == true))
				{
					throw new RuntimeException() ;
				}
				return addPoly(A , A) ;
		}
		else if (poly1 == 'B' && poly2 == 'B')
		{
				if ((B.isEmpty() == true))
				{
					throw new RuntimeException() ;
				}
				return addPoly(B , B) ;
		}
		else if (poly1 == 'C' && poly2 == 'C')
		{
				if ((C.isEmpty() == true))
				{
					throw new RuntimeException() ;
				}
				return addPoly(C , C) ;
		}
		
			throw new RuntimeException() ;
	}
	/**
	* Subtract two polynomials
	* @param poly1 first polynomial
	* @param poly2 second polynomial
	* @return the result polynomial
	*/
	public int[][] subtract(char poly1, char poly2){
		if (poly1 == 'A' && poly2 == 'B')
		{
			if ((A.isEmpty() == true) || (B.isEmpty() == true))
			{
				return null ;
			}
			return this.SubPoly(A, B) ;
		}else if (poly1 == 'A' && poly2 == 'C')
		{
			if ((A.isEmpty() == true) || (C.isEmpty() == true))
			{
				return null ;
			}
			return this.SubPoly(A, C) ;
		}else if (poly1 == 'B' && poly2 == 'A')
		{
			if ((A.isEmpty() == true) || (B.isEmpty() == true))
			{
				return null ;
			}
			return this.SubPoly(B, A) ;
		}else if (poly1 == 'B' && poly2 == 'C')
		{
			if ((C.isEmpty() == true) || (B.isEmpty() == true))
			{
				return null ;
			}
			return this.SubPoly(B, C) ;
		}else if (poly1 == 'C' && poly2 == 'A')
		{
			if ((A.isEmpty() == true) || (C.isEmpty() == true))
			{
				return null ;
			}
			return this.SubPoly(C, A) ;
		}else if (poly1 == 'C' && poly2 == 'B')
		{
			if ((C.isEmpty() == true) || (B.isEmpty() == true))
			{
				return null ;
			}
			return this.SubPoly(C, B) ;
		}
		else if (poly1 == 'A' && poly2 == 'A')
		{
				if ((A.isEmpty() == true))
				{
					throw new RuntimeException() ;
				}
				return SubPoly(A , A) ;
		}
		else if (poly1 == 'B' && poly2 == 'B')
		{
				if ((B.isEmpty() == true))
				{
					throw new RuntimeException() ;
				}
				return SubPoly(B , B) ;
		}
		else if (poly1 == 'C' && poly2 == 'C')
		{
				if ((C.isEmpty() == true))
				{
					throw new RuntimeException() ;
				}
				return SubPoly(C , C) ;
		}
		
		else {
			throw new RuntimeException() ;
		}
	}
	/**
	* Multiply two polynomials
	* @param poly1 first polynomial
	* @param poly2 second polynomial
	* @return the result polynomial
	*/
	public int[][] multiply(char poly1, char poly2){
		if ( (poly1 == 'A' || poly2 == 'A') && (poly1 == 'B' || poly2 == 'B') )
		{ 
				if ((A.isEmpty() == true) || (B.isEmpty() == true))
				{
					return null ;
				}
				return multiplyPoly(A , B) ;
		}
		else if ( (poly1 == 'A' || poly2 == 'A') && (poly1 == 'C' || poly2 == 'C') )
		{
				if ((A.isEmpty() == true) || (C.isEmpty() == true))
				{
					return null ;
				}
				return multiplyPoly(A , C) ;
		}
		else if ( (poly1 == 'C' || poly2 == 'C') && (poly1 == 'B' || poly2 == 'B') )
		{
				if ((C.isEmpty() == true) || (B.isEmpty() == true))
				{
					return null ;
				}
				return multiplyPoly(C , B) ;
		}
		else if (poly1 == 'A' && poly2 == 'A')
		{
				if (A.isEmpty() == true)
				{
					return null ;
				}
				return multiplyPoly(A , A) ;
		}
		else if (poly1 == 'B' && poly2 == 'B')
		{
				if ((B.isEmpty() == true))
				{
					return null ;
				}
				return multiplyPoly(B , B) ;
		}
		else if (poly1 == 'C' && poly2 == 'C')
		{
				if (C.isEmpty() == true )
				{
					return null ;
				}
				return multiplyPoly(C , C) ;
		}
		
		
		return null ;
		
	}
	
	public int[][] getTerms(){
		Scanner input = new Scanner(System.in);
		System.out.println("Insert the polynomial terms in the form :") ;
		System.out.println("(coeff1 , exponent1 ), (coeff2 , exponent2 ), ..");
		System.out.println("Ending with (coeff , 0 )") ;
		int[][] terms = new int[50][2] ;
		int i,j ;
		int termsCounter = 1 ;
		for (i = 0 ; i < 50 ; i ++)
		{
			for (j = 0 ; j < 2 ; j++)
			{
				terms[i][j] = input.nextInt() ;
				if (terms[i][j] < 0 && j == 1)
				{
					throw new RuntimeException() ; 
				}
			}
			if (j == 2 && terms[i][j - 1 ] == 0 )
			{
				break ;
			}
			termsCounter ++ ;
		}
		int[][] sortedTerms = sort(terms , termsCounter) ;
		return sortedTerms ;
	}
	public int[][] sort(int[][] terms , int counter)
	{
		for (int i = 0 ; i < counter  ; i++)
		{
			for (int j = 0 ; j < counter - 1 ; j++)
			{
				if (terms[j][1] < terms[j+1][1])
				{
					int tempCoeff = terms[j][0] ;
					int tempExponent = terms[j][1] ;
					terms[j][0] = terms[j+1][0] ;
					terms[j][1] = terms[j+1][1] ;
					terms[j+1][0] = tempCoeff ;
					terms[j+1][1] = tempExponent ;
				}
			}
		}
		int[][] sortedTerms = new int[counter][2] ;
		for (int i = 0 ; i < counter ; i++)
		{
			for (int j = 0 ; j < 2 ; j++)
			{
				sortedTerms[i][j] = terms[i][j] ;
			}
		}
		return sortedTerms ;
	}
	public sLinkedList setLinkedList(int[][] terms)
	{
		sLinkedList Poly = new sLinkedList() ;
		for (int i = 0 ; i < terms.length ; i ++)
		{
			Poly.add(i, terms[i]);
		}
		int size = Poly.size() ;
		for (int i = 0 ; i < size ; i ++)
		{
			int[] x = new int[2] ;
			x = (int[])Poly.get(i) ;
			if (x[0] == 0)
			{
				Poly.remove(i);
				i-- ;
				size -- ;
			}
		}
		return Poly ;
}
	public int[][] addPoly(sLinkedList poly1 , sLinkedList poly2){
		int[][] PolyResult = new int[poly1.size() + poly2.size()][2] ;
		int index = 0 ;
		for (int i = 0 ; i < poly1.size() ; i ++)
		{
			int flag = 0 ;
			int[] x = new int[2] ;
			x = (int[])poly1.get(i) ;
			for (int j = 0 ; j < poly2.size() ; j ++)
			{
				int[] y = new int[2] ;
				y = (int[])poly2.get(j) ;
				if (x[1] == y[1])
				{
					flag = 1 ;
					int[] temp = new int[2] ;
					temp[0] = x[0] + y[0] ;
					temp[1] = x[1] ;
					PolyResult[index] = temp ;
					index ++ ;
					break ;
				}
			}
			if (flag == 0 )
			{
				PolyResult[index] = x ;
				index ++ ;
			}
		}
		for (int i = 0 ; i < poly2.size() ; i++)
		{
			int[] x = new int[2] ;
			x = (int[])poly2.get(i) ;
			int flag = 0 ;
			for (int j = 0 ; j < poly1.size() ; j ++)
			{
				int[] y = new int[2] ;
				y = (int[])poly1.get(j) ;
				if (x[1] == y[1])
				{
					flag = 1 ;
				}
			}
			if (flag == 0 )
			{
				PolyResult[index] = x ;
				index ++ ;
			}
		}
		int[][] sortedResult = new int[index -1][2] ;
		sortedResult = sort(PolyResult, index) ;
		this.setPolynomial('R', sortedResult);
		
		return sortedResult ;
	   }
	public String expression(sLinkedList poly){
		String a = new String() ;
		int[] x = new int[2] ;
		int size = poly.size() ;
		for (int i = 0 ; i < size ; i ++)
		{
			x = (int[])poly.get(i) ;
			if (i != 0 )
			{
				if (x[0] > 0 )
				{
					a += " + " ;
				}
				if ( x[0] == -1)
				{
					a += " - " ;
				}
			}else if (i == 0 && x[0] == -1)
			{
				a += '-' ;
			}
			if (x[0] != 1 && x[0] != -1)
			{
				if (x[0] < 0 && i != 0)
				{
					a += ' ' ;
				}
				a +=x[0] ;
			}
			if ((x[0] == 1 || x[0] == -1) && x[1] == 0)
			{
				if (x[0] < 0 && i != 0)
				{
					a += ' ' ;
				}
				a += x[0] ;
			}
			if (x[1] != 0 && x[1] != 1 )
			{
				a += "x^" ;
				a += x[1] ;
			}else if (x[1] == 1 )
			{
				a +='x' ;
			}
		}
		return a ;
	}
	public int[][] SubPoly(sLinkedList poly1 , sLinkedList poly2){
		int[][] PolyResult = new int[poly1.size() + poly2.size()][2] ;
		int index = 0 ;
		if (poly1 == poly2)
		{
			int[][] result = new int[1][2] ;
			result[0][0] = 0 ;
			result[0][1] = 0 ;
			return result ;
		}
		for (int i = 0 ; i < poly1.size() ; i ++)
		{
			int flag = 0 ;
			int[] x = new int[2] ;
			x = (int[])poly1.get(i) ;
			for (int j = 0 ; j < poly2.size() ; j ++)
			{
				int[] y = new int[2] ;
				y = (int[])poly2.get(j) ;
				if (x[1] == y[1])
				{
					flag = 1 ;
					int[] temp = new int[2] ;
					temp[0] = x[0] - y[0] ;
					temp[1] = x[1] ;
					PolyResult[index] = temp ;
					index ++ ;
					break ;
				}
			}
			if (flag == 0 )
			{
				PolyResult[index] = x ;
				index ++ ;
			}
		}
		for (int i = 0 ; i < poly2.size() ; i++)
		{
			int[] x = new int[2] ;
			x = (int[])poly2.get(i) ;
			int flag = 0 ;
			for (int j = 0 ; j < poly1.size() ; j ++)
			{
				int[] y = new int[2] ;
				y = (int[])poly1.get(j) ;
				if (x[1] == y[1])
				{
					flag = 1 ;
				}
			}
			if (flag == 0 )
			{
				x[0] = -x[0] ;
				PolyResult[index] = x ;
				index ++ ;
			}
		}
		int[][] sortedResult = new int[index -1][2] ;
		sortedResult = sort(PolyResult, index) ;
		this.setPolynomial('R', sortedResult);
		return sortedResult ;
		}
	public int[][] multiplyPoly(sLinkedList poly1 , sLinkedList poly2)
	{
		int index = 0 ;
		int[][] polyMultiply = new int[poly1.size() * poly2.size()][2] ;
		for (int i = 0 ; i < poly1.size() ; i++)
		{
			int[] x = new int[2] ;
			x = (int[])poly1.get(i) ;
			
			for (int j = 0 ; j < poly2.size() ; j++ )
			{
				int[] y = new int[2] ;
				y = (int[])poly2.get(j) ;
				
				int[] temp = new int[2] ;
				temp[0] = x[0] * y[0] ;
				temp[1] = x[1] + y[1] ;
				polyMultiply[index] = temp ;
				index ++ ;
			}
		}
		int[][] sortedResult = new int[index -1][2] ;
		sortedResult = sort(polyMultiply, index) ;
		sortedResult = checkRepeatition(sortedResult) ;
		this.setPolynomial('R', sortedResult);
		
		return sortedResult ;
	}
	public int[][] checkRepeatition(int[][] array){
		int[][] temp = new int[array.length][2] ;
		int index = 0 ;
		for (int i = 0 ; i < array.length ; i ++)
		{
			for (int j = i+1 ; j < array.length ; j ++)
			{
					if (array[i][1] == array[j][1])
					{
						array[i][0] += array[j][0] ;
					}
			}
			int flag = 0 ;
			for (int k = 0 ; k < index ; k++ )
			{
				flag = 0 ;
				if (array[i][1] == temp[k][1])
				{
					flag = 1 ;
				}
			}
			if (flag == 0)
			{
				temp[index] = array[i] ;
				index ++ ;
			}
		}
		temp = this.sort(temp, index) ;
		return temp ;
	}
	public boolean checkSort(int[][] terms , int counter){
		
		for (int i = 0 ; i < counter  ; i++)
		{
			for (int j = 0 ; j < counter - 1 ; j++)
			{
				if (terms[j][1] < terms[j+1][1] || terms[j][1] < 0)
				{
					return false ;
				}
			}
		}
		if (terms[counter - 1][1] < 0)
		{
			return false ;
		}
		
		return true ;
	}
	public boolean isEmpty(char c)
	{
		if(c == 'A')
		{
			return A.isEmpty();
		}
		else if(c == 'B')
		{
			return B.isEmpty();
		}
		else if(c == 'C')
		{
			return C.isEmpty();
		}
		else if(c == 'R')
		{
			return R.isEmpty();
		}
		else
		{
			throw null;
		}
	}
}
	