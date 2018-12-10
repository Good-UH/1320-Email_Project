# 1320-Email_Project
Reading entire file content and find out if there is email in the input file.

In this assignment, develop a program that 
i. reads an external input file,
ii. detect the emails in the input file, and
iii. create a list of desired email address in an output file.

In your program,
1. Connect to the external input file. The name of the input file will always be inputemails.txt, and
therefore please don’t ask the file name in your program.
2. Detect the email addresses in the file.
3. If an email does not have a sub-domain, please create Email object for that email.
4. If an email has a sub-domain, please create UniversityEmail object for that email.
5. Please store all emails in the same (one single) array list.
6. After you copy all emails from the file to the array list, please ask the user what type of emails to be
included in the output file. If the user enters 0, please write the emails that do not have sub-domain in
the array list. Please note that the output file must start with a number indicating the number of emails
in the file. If the user enters a number between 1-7, please write all emails from the specific department
in the output file. Please note that the output file must start with a number indicating the number of
emails in the file.
