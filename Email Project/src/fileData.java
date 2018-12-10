import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class fileData {

	public static void main(String[] args) throws IOException{
		
		String file_name = "inputemails.txt";
		ArrayList<Email> emails = new ArrayList<Email>();
		
		try {
			
			readFile file = new readFile(file_name);
			String[] aryLines = file.OpenFile();
			
			for (int i=0; i< aryLines.length; i++) {				
				// Initialize scanner that parses a line by spaces
				Scanner line_scan = new Scanner(aryLines[i]);
				line_scan.useDelimiter("[\\s,]");
				// Parse through each word until there is nothing
				while(line_scan.hasNext()) {
					// Get the next word
					String word = line_scan.next();
					
					// If the word has "@", we have an email so lets create the Email object
					if (word.indexOf("@") != -1) {
						// Initialize an email object
						Email email = null;

						// Make a list to place email content in
						ArrayList<String> email_split = new ArrayList<String>();
						// Initialize a scanner to parse the word
						Scanner word_scan = new Scanner(word);
						// Make this scanner use "@" and "." as delimiters
						word_scan.useDelimiter("[@.]");
						// While scanner has something add it to the list
						while(word_scan.hasNext())
							email_split.add(word_scan.next());
						word_scan.close();

						// If the list has three items in it, the email we found is username@domain.extension (make basic email)
						// username will be in index 0 of list
						// domain will be in index 1 of list
						// extension will be in index 2 of list
						if(email_split.size() == 3)
							email = new Email(email_split.get(0), email_split.get(1), email_split.get(2));
						// If the list has four items in it, the email we found is username@subdomain.domain.extension (make univiersity email)
						// username will be in index 0 of list
						// subdomain will be in index 1 of list
						// domain will be in index 2 of list
						// extension will be in index 3 of list
						else if (email_split.size() == 4)
							email = new universityEmail(email_split.get(0), email_split.get(2), email_split.get(3), email_split.get(1));
						
						// Add email object if it is not null
						if(email != null)
							emails.add(email);
					}
				}
				line_scan.close();
			}
			
			// Initialize scanner to get user input
			Scanner user_input = new Scanner(System.in);
			System.out.print("What type of emails would you like to see? ");
			System.out.print("\n1 for art, 2 for chee, 3 for chem, 4 for coe");
			System.out.print("\n5 for cs, 6 for egr, 7 for polsci, and 0 for all other emails.\n");
			int input = Integer.parseInt(user_input.nextLine());
			user_input.close();
			
			// Initialize list to place what will be printed
			ArrayList<Email> emails_to_print = new ArrayList<Email>();
			
			if(input == 0) {
				System.out.print("\nPlease check the output file to check for emails without a subdomain.");
				// If input is 0, then loop through each email object and get
				// the email objects that are not UniversityEmail instances
				for(Email e: emails)
					if(!(e instanceof universityEmail))
						emails_to_print.add(e);
			}
			else if(input>0 && input<8) {
				System.out.print("\nPlease check the output file to check for emails with the selected subdomain.");
				// Else loop through each email object and grab the email
				// objects that are UniversityEmail instances and who's codes are
				// the same as the requested
				for(Email e: emails) {
					if(e instanceof universityEmail) {
						universityEmail university_email = (universityEmail)e;
						if(university_email.get_code() == input)
							emails_to_print.add(e);
					}
				}
			}
			else {
				System.out.print("Only Options 0-7 are available! Try again! \nProgram has ended no output file created!");
				System.exit(0);
			}
			
			// Write the size of the list to the file
			PrintWriter file_writer = new PrintWriter(new File("output.txt"));
			file_writer.println(emails_to_print.size());
			// Loop through the found emails and write them to the file
			for(Email e: emails_to_print)
				file_writer.println(e);
			file_writer.close();
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
}
