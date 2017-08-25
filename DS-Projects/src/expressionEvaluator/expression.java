package expressionEvaluator;

import javax.management.RuntimeErrorException;

import Stack.stack;
import expressionEvaluator.IExpressionEvaluator;

public class expression implements IExpressionEvaluator{
	/**
	* Takes a symbolic/numeric infix expression as input and converts it to
	* postfix notation. There is no assumption on spaces between terms or the
	* length of the term (e.g., two digits symbolic or numeric term)
	* @param expression infix expr
	 */
	@Override
	public String infixToPostfix(String expression) {
		if(expression == null || expression.isEmpty())
		{
			throw null;
		}
		else
		{
			String[] splited = expression.split("\\s+");
			for(int i = 1; i < expression.length(); i++)
			{
				char currentMember = expression.charAt(i);
				char prevMember = expression.charAt(i-1);
				if((currentMember == '/' || currentMember  == '*' || currentMember == '-' || currentMember == '+') &&
						(prevMember == '/' || prevMember == '*' || prevMember == '-' || prevMember  == '+'))
				{
					throw new RuntimeErrorException(null);
				}
			}
			stack signs = new stack();
			stack operands = new stack();
			for(int i = 0; i < expression.length(); i++)
			{
				char chars = expression.charAt(i);
				if(chars == ' ')
				{
					continue;
				}
				if(chars != '/' && chars != '*' && chars != '-' && chars != '+')
				{
					if(chars == '(')
						signs.push(chars);
					else if(chars == ')')
					{
						while(!signs.peek().equals('('))
						{
							operands.push(signs.pop());
						}
						signs.pop();
					}
					else
						operands.push(chars);
				}
				else
				{

					if((signs.isEmpty() ) || signs.peek().equals('('))
					{
						if(!(signs.isEmpty()) && signs.peek().equals(chars))
						{
							throw null;
						}
						signs.push(chars);
					}
					else
					{
						char sign = (char) signs.peek();
						if(chars == ' ')
						{
							continue;
						}
						else
						{
							if((chars == '/' || chars == '*') && (sign == '-' || sign == '+'))
							{
								
								signs.push(chars);
							}
							else if((chars == '-' || chars == '+' ) && (sign == '/' || sign == '*' || sign == '-' || sign == '+') )
							{
								int flag=0;
								do{
									operands.push(signs.pop());
									if(!signs.isEmpty())
									{
										sign = (char) signs.peek();
									}
									else
										flag++;
									
								}while((chars == '-' || chars == '+' ) && (sign == '/' || sign == '*' || sign == '-' || sign == '+') && flag == 0);
								
								signs.push(chars);
								flag = 0;
							}
							else if((chars == '/' || chars == '*') && (sign == '/' || sign == '*'))
							{
								int flag=0;
								do{
									operands.push(signs.pop());
									if(!signs.isEmpty())
									{
										sign = (char) signs.peek();
									}
									else
										flag++;
									
								}while((chars == '/' || chars == '*') && (sign == '/' || sign == '*') && flag == 0);
								
								signs.push(chars);
								flag = 0;
							}
							else if(chars == ')')
							{
								while(sign != '(')
								{
									operands.push(signs.pop());
									sign = (char) signs.peek();
								}
							}
						}
					
					}
				}
			}
			int counter = signs.size();
			for(int i = 1; i < counter+1; i++)
			{
				if(signs.peek().equals('(') || signs.peek().equals(')'))
					throw null;
				operands.push(signs.pop());
			}
			char[] result = new char[expression.length()];
					int l = operands.size()-1;
			for(int i = l; i >= 0; i--)
			{
				result[i] = (char) operands.pop();
			}
			String s = String.valueOf(result).trim();
			StringBuilder out = new StringBuilder();
			for (int i = 0; i < s.length(); i++) {
			   if (i > 0) {
			      out.append(" ");
			    }

			   out.append(s.charAt(i));
			}
			return out.toString();
		}
}

	/**
	* Evaluate a postfix numeric expression, with a single space separator
	* @param expression postfix expression
	* @return the expression evaluated value
	*/
	@Override
	public int evaluate(String expression) {
			if(expression == null || expression.isEmpty())
			{
				throw null;
			}
			else
			{
				for(int i = 1; i < expression.length(); i++)
				{
					char currentMember = expression.charAt(i);
					char prevMember = expression.charAt(i-1);
					if((currentMember == '/' || currentMember  == '*' || currentMember == '-' || currentMember == '+') &&
							(prevMember == '/' || prevMember == '*' || prevMember == '-' || prevMember  == '+'))
					{
						throw new RuntimeErrorException(null);
					}
				}
				stack operands = new stack();
				String[] splited = expression.split("\\s+");
				for(int i  = 0; i < splited.length; i++)
				{
					
					String chars = splited[i];
					if(chars == " ")
					{
						continue;
					}
					else
					{
						if(!chars.equals("/")  && !chars.equals("*") && !chars.equals("-") && !chars.equals("+"))
						{
							operands.push(chars);
						}
						else
						{
							if(operands.size() == 1)
							{
								throw null;
							}
							else
							{
								int x =   Integer.parseInt(operands.pop().toString());
								int y =  Integer.parseInt(operands.pop().toString());
								
								int result;
								if(chars.equals("/"))
								{
									if(x == 0)
										throw new RuntimeErrorException(null);
									result = (int) (((float) y)/x);
								}
								else if(chars.equals("*"))
								{
									result = x*y;
								}
								else if(chars.equals("+"))
								{
									result = x+y;
								}
								else
								{
									result = y-x;
								}
								operands.push(result);
							}
						}
					}
				}
				
				return Integer.parseInt(operands.pop().toString());
			}
		}
	 
   }

