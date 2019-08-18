To compile, make sure you are in the Lab directory and then execute the following command :

	javac part1/*.java

To run, execute the following command:

	java part1.EchoServer

The following message should be displayed : 

	[Server]: Started. Waiting for connection on port 6013

Then, then open an other terminal window on the same directory and execute :

	java part1.EchoClient localhost
	Bonjour là!

Which should display on the client terminal:

	Server: Bonjour là!

And, on the server terminal:

	[Server]: Client connected
	[Server]: Message received: Bonjour là!

You can terminate the server process by executing the command ^C on the client terminal, which should display the following on the server terminal : 

	[Server]: Server process terminated by client.
