import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class readFile {

	private String path;
	
	//Passing the name of the file
	public readFile(String file_path) {
		path = file_path;
		//Handling the file name over to the path field
	}
	//Open file method
	public String[] OpenFile() throws IOException {
		//Creating two new objects
		FileReader fr = new FileReader (path);
		BufferedReader textReader = new BufferedReader(fr);
		//Array to hold the number of the number of lines in the text
		int numberOfLines = readLines();
		String[] textData = new String[numberOfLines];
		//Loop to get each line 
		int i;
		
		for(i=0; i<numberOfLines; i++) {
			//Accesses the lines of text and stores them in the array
			textData[i] = textReader.readLine(); //Store memory in textData[i]
		}
		
		textReader.close();
		return textData;
	}
	
int readLines() throws IOException{
		//Reading how many lines
		FileReader file_to_read = new FileReader(path);
		BufferedReader bf = new BufferedReader(file_to_read);
		
		@SuppressWarnings("unused")
		String aLine;
		int numberOfLines = 0;
		
		while ((aLine = bf.readLine()) != null){
			numberOfLines++;
		}
		bf.close();
		
		return numberOfLines;
	}
}
