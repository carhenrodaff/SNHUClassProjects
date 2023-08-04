Briefly summarize your client, Artemis Financial, and their software requirements. Who was the client? What issue did they want you to address?
	Artemis Financial is a company who needed my help in encrypting their data.
What did you do very well when you found your client’s software security vulnerabilities? Why is it important to code securely? What value does software security add to a company’s overall wellbeing?
	I implemented a standard AES cipher with a SHA-256 hash key. Making sure that information stays safe is the best way for an institution to keep
	a user's trust.
What part of the vulnerability assessment was challenging or helpful to you?
	Generating certificates was pretty difficult, and especially when it came to obtaining trust. Handling anything to do with the spring framework was also challenging.
How did you increase layers of security? In the future, what would you use to assess vulnerabilities and decide which mitigation techniques to use?
	For this particular project, I migrated the JRE to java 17, and I updated the framework to its latest release. That in itself took care of most of the vulnerabilities, and what was left were false positives.
How did you make certain the code and software application were functional and secure? After refactoring the code, how did you check to see whether you introduced new vulnerabilities?
	I made sure to rerun owasp, and see if anything had changed from the original run. I did not refactor that much, so naturally no new vulnerabilities came.
What resources, tools, or coding practices did you use that might be helpful in future assignments or tasks?
	Through this class, I became very familiar with navigating maven, which will be very useful moving forward with java. 
Employers sometimes ask for examples of work that you have successfully completed to show your skills, knowledge, and experience. What might you show future employers from this assignment?
	In the future, I'd like to choose this project as a starting point for developing spring apps. I can use this as an example of where I started to contrast where I will eventually be.
