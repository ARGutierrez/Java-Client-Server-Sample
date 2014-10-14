import java.util.Scanner;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * This program tests the square root server.
 */
public class NumberClient {
	public static void main(String[] args) throws IOException
	{
		final int PORT = 8899;
		Socket s;

		while (true) {
		
			Scanner console = new Scanner(System.in);
			int n;
			System.out.print("\nPlease enter a number: ");
			n = console.nextInt();
			s = new Socket("localhost", PORT);
			
			InputStream inStream = s.getInputStream();
			OutputStream outStream = s.getOutputStream();
			Scanner in = new Scanner(inStream);
			PrintWriter out = new PrintWriter(outStream);
			
			out.println(n);
			out.flush();

			double response = in.nextDouble();
			System.out.println("The square root of " + n + " is: " + response);
		}
	}
}