import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SeverSide {

	public static void main(String[] args) throws IOException {
		int port = 9000;
		int times = 5;
	
		ServerSocket ss = new  ServerSocket(9000);
		int i = 1;
		while(i <= times) {
			Socket s = ss.accept();
			OutputStream os = s.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			for(int j = 1; j<=10; j++) {
				dos.writeInt(j);
			}
			s.close();
			++i;
		}
		ss.close();
	 

	}

}
