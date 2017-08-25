package Maze;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import linkedList.dLinkedList;

public class functions {
	int x;
	int y;
	StringBuilder test = new StringBuilder();
	public String[][] readFromFile(File maze)
	{
		if(maze == null)
			return null;
		BufferedReader br = null;
		FileReader fr = null;
		 String[][] map;
		try {

		

			String sCurrentLine;
			br = new BufferedReader(new FileReader(maze));
			sCurrentLine = br.readLine();
			
			String[] splited = sCurrentLine.split(" ");
			x = Integer.parseInt(splited[0]);
			y = Integer.parseInt(splited[1]);
			if(x == 0 && y == 0)
				return null;
			map = new String[x][y];
			int j = 0;
			while ((sCurrentLine = br.readLine()) != null) {
			
				test.append("(");
				test.append(sCurrentLine);
				test.append(")");
				for(int i = 0; i < y; i++)
				{
					StringBuilder s = new StringBuilder();
					s.append(sCurrentLine.charAt(i));
					map[j][i] = s.toString();
				}
				j++;
			}
			
			
		} catch (IOException e) {
			throw new RuntimeException();
		}
		finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}
		return map;
	}
	
}
