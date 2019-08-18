package part1;

import java.io.*;
import java.net.*;
import java.util.*;

public class EchoClient {
  
	private static int port = 6013;
	private static String hostname;
 
	public static void main (String [] args) {
  
	   	if(args.length != 1){
	     		System.out.println("Usage: EchoClient hostname");
			System.out.println("Example: EchoClient localhost");
	     		System.exit(1);
	   	} else {
	     		hostname = args[0];
	   	}

	   	Scanner sc = new Scanner(System.in);
	  
	  	try {
	   		//making connection to server socket
	   		Socket connection = new Socket(hostname, port);
	   
			//creating data streams
			DataOutputStream out = new DataOutputStream(connection.getOutputStream());
			InputStream in = connection.getInputStream();
			ByteArrayOutputStream buffer = new ByteArrayOutputStream();
	   
		    	while(true){
		      		//getting user input
			      	String m = sc.nextLine();

			      	byte[] byteMsg = m.getBytes();
			      	String message = new String(byteMsg, "UTF-8"); // for UTF-8 encoding
			      
			      	//checking if the escape character is used
			      	if(message.equals(".")){
					connection.close();
					break;
			      	} else if(message.equals("")) {
					System.out.println("Please enter something!");
			      	} else {
					//outputting message to the output stream
					out.write(byteMsg);
		
					//reading the response from the server
					int nRead;
					byte[] data = new byte[16384];

					if ((nRead = in.read(data, 0, data.length)) != -1){
						buffer.write(data,0,nRead);
					}

					buffer.flush();

					String res = new String(buffer.toByteArray(), "UTF-8"); // for UTF-8 encoding

					System.out.println("Server: " + res);
					buffer.reset();
				}

			}

	  	} catch (IOException e) {
			System.out.println("Server Connection Failed: Server not available.");
			System.exit(1);
		}
  
	}

}
