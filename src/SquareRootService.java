import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Computes the square root of a number from a socket.
 */
public class SquareRootService {
	/**
	 * Constructs a service object that computes the square root of a number.
	 * 
	 * @param aSocket
	 *            the socket
	 */
	public SquareRootService(Socket aSocket) {
		s = aSocket;
	}

	/**
	 * Computes the square root of a number from a socket.
	 */
	public void doService() throws IOException {
		InputStream instream = s.getInputStream();
		Scanner in = new Scanner(instream);
		OutputStream outstream = s.getOutputStream();
		PrintWriter out = new PrintWriter(outstream);
		double response = Math.sqrt(in.nextDouble());
		System.out.println("Sending: " + response);
		out.print(response);
		out.flush();
	}

	private Socket s;
}