package Maze;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.management.RuntimeErrorException;

import linkedList.dLinkedList;
import Maze.IMazeSolver;
import Queue.LinkedListQueue;
import Stack.stack;

public class maze implements IMazeSolver{
	functions use = new functions();
	@Override
	public int[][] solveBFS(File maze) {
		int check = 0;
		String[][] map = use.readFromFile(maze);
		if(map == null)
			return null;
		boolean[][] checker = new boolean[use.x][use.y];
		myPoint[][] road = new myPoint[use.x][use.y];
		myPoint node = new myPoint();
		myPoint endNode = new myPoint();
		LinkedListQueue queue = new LinkedListQueue();
		
		int startCounter = 0;
		int endCounter = 0;
		
		StringBuilder sajed = new StringBuilder();
		for (int i = 0 ; i < map.length ; i++) {
			for (int j = 0; j < map[0].length ;  j++) {
				sajed.append(map[i][j]);
			}
			sajed.append("\n");
		}
		
		for(int i = 0; i < use.x; i++)
		{
			for(int j = 0; j < use.y; j++)
			{
 				if(map[i][j].equals("S") )
				{
					checker[i][j] = true;
					startCounter++;
					node.x = i;
					node.y = j;
				}
				if(map[i][j].equals("E"))
				{
					endCounter++;
				}
			}
		}
		
		if(startCounter != 1 || endCounter != 1) {
			throw new RuntimeException(use.test.toString() + " " + startCounter + " " + endCounter + " " + sajed.toString() );
		}
		queue.enqueue(node);
		
		while(!queue.isEmpty())
		{
			node = (myPoint) queue.dequeue();
			checker[node.x][node.y] = true;
			
			if(map[node.x][node.y].equals("E"))
			{
				endNode = node ;
				endNode.counter = node.counter + 1;
				check++;
				break;
			}
			
			else
			{
				int x;
				int y;
				
				x = node.x;
				y = node.y+1;
				if(!(y >= use.y )&& !(map[x][y].equals("#")) && !(checker[x][y] == true))
				{
					myPoint newIndex = new myPoint();
					newIndex.counter = node.counter+ 1;
					road[x][y] = node;
					newIndex.x = x;
					newIndex.y = y;
					checker[x][y] = true;
					queue.enqueue(newIndex);
				}
				
				x = node.x;
				y = node.y-1;
				if(!(y < 0) && !(map[x][y].equals("#")) && !(checker[x][y] == true))
				{
					myPoint newIndex = new myPoint();
					newIndex.counter = node.counter + 1;
					road[x][y] = node;
					newIndex.x = x;
					newIndex.y = y;
					checker[x][y] = true;
					queue.enqueue(newIndex);
				}
				
				x = node.x-1;
				y = node.y;
				if(!(x < 0) && !(map[x][y].equals("#")) && !(checker[x][y] == true))
				{
					myPoint newIndex = new myPoint();
					newIndex.counter = node.counter + 1;
					road[x][y] = node;
					newIndex.x = x;
					newIndex.y = y;
					checker[x][y] = true;
					queue.enqueue(newIndex);
				}
				
				x = node.x+1;
				y = node.y;
				if(!(x >= use.x) && !(map[x][y].equals("#")) && !(checker[x][y] == true))
				{
					myPoint newIndex = new myPoint();
					newIndex.counter = node.counter + 1;
					road[x][y] = node;
					newIndex.x = x;
					newIndex.y = y ;
					checker[x][y] = true;
					queue.enqueue(newIndex);
				}
			}
		}
		if(check == 0)
			return null;
		
		int[][] result = new int[endNode.counter][2];
		result[endNode.counter - 1][0] = endNode.x;
		result[endNode.counter - 1][1] = endNode.y;
		for(int i = endNode.counter - 2; i >= 0 ; i--)
		{
			result[i][0] = road[endNode.x][endNode.y].x;
			result[i][1] = road[endNode.x][endNode.y].y;
			endNode.x = result[i][0];
			endNode.y = result[i][1];
		}
		
		return result;
	}

	@Override
	public int[][] solveDFS(File maze) {
		int check = 0;
		String[][] map = use.readFromFile(maze);
		boolean[][] checker = new boolean[use.x][use.y];
		myPoint[][] road = new myPoint[use.x][use.y];
		myPoint node = new myPoint();
		myPoint endNode = new myPoint();
		stack stack = new stack();
		
		
		int startCounter = 0;
		int endCounter = 0;
		for(int i = 0; i < use.x; i++)
		{
			for(int j = 0; j < use.y; j++)
			{
				if(map[i][j].equals("S"))
				{
					checker[i][j] = true;
					startCounter++;
					node.x = i;
					node.y = j;
				}
				if(map[i][j].equals("E"))
				{
					endCounter++;
				}
			}
		}
		if(startCounter != 1 || endCounter != 1)
			throw new RuntimeErrorException(null);
		
		stack.push(node);
		
		while(!stack.isEmpty())
		{
			myPoint newIndex = new myPoint();
			node = (myPoint) stack.pop();
			checker[node.x][node.y] = true;
			
			if(map[node.x][node.y].equals("E"))
			{
				endNode = node ;
				endNode.counter = node.counter + 1;
				check++;
				break;
			}
			
			else
			{
				int x;
				int y;
				
				x = node.x;
				y = node.y+1;
				if(!(y >= use.y )&& !(map[x][y].equals("#")) && !(checker[x][y] == true))
				{
					newIndex.counter = node.counter+ 1;
					road[x][y] = node;
					newIndex.x = x;
					newIndex.y = y;
					checker[x][y] = true;
					stack.push(newIndex);
				}
				
				x = node.x;
				y = node.y-1;
				if(!(y < 0) && !(map[x][y].equals("#")) && !(checker[x][y] == true))
				{
					newIndex.counter = node.counter + 1;
					road[x][y] = node;
					newIndex.x = x;
					newIndex.y = y;
					checker[x][y] = true;
					stack.push(newIndex);
				}
				
				x = node.x-1;
				y = node.y;
				if(!(x < 0) && !(map[x][y].equals("#")) && !(checker[x][y] == true))
				{
					newIndex.counter = node.counter + 1;
					road[x][y] = node;
					newIndex.x = x;
					newIndex.y = y;
					checker[x][y] = true;
					stack.push(newIndex);
				}
				
				x = node.x+1;
				y = node.y;
				if(!(x >= use.x) && !(map[x][y].equals("#")) && !(checker[x][y] == true))
				{
					newIndex.counter = node.counter + 1;
					road[x][y] = node;
					newIndex.x = x;
					newIndex.y = y;
					checker[x][y] = true;
					stack.push(newIndex);
				}
			}
		}
		if(check == 0)
			return null;
		int[][] result = new int[endNode.counter][2];
		result[endNode.counter - 1][0] = endNode.x;
		result[endNode.counter - 1][1] = endNode.y;
		for(int i = endNode.counter - 2; i >= 0 ; i--)
		{
			result[i][0] = road[endNode.x][endNode.y].x;
			result[i][1] = road[endNode.x][endNode.y].y;
			endNode.x = result[i][0];
			endNode.y = result[i][1];
		}
		
		return result;

	}

}
