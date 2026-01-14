import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MultiServer {

	public static void main(String[] args) {
		MultiServer multiserver = new MultiServer();
		multiserver.start();
	}
	
	public void start() {
		ServerSocket sc = null;
		Socket s = null;
		try {
			sc = new ServerSocket(8000);
			while (true) {
				System.out.println("[클라이언트 연결 대기중]");
				s = sc.accept();  
				ReceiveThread receiveThread = new ReceiveThread(s);
				receiveThread.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	class ReceiveThread extends Thread {

		static List<PrintWriter> list =
				Collections.synchronizedList(new ArrayList<PrintWriter>());
		
		Socket s = null;
		BufferedReader in = null;
		PrintWriter out = null;
		String name = null; 

		public ReceiveThread(Socket s) {
			this.s = s;
			try {
				out = new PrintWriter(s.getOutputStream(), true); // ⛏️ auto flush
				in = new BufferedReader(new InputStreamReader(s.getInputStream()));
				list.add(out);

				
				out.println("이름을 입력하세요:");
				name = in.readLine();

				sendAll("[" + name + "]님이 입장하셨습니다.");

				String msg;
				while ((msg = in.readLine()) != null) {
					sendAll("[" + name + "]: " + msg);
				}

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				sendAll("[" + name + "]님이 나가셨습니다.");
				list.remove(out);
				try {
					if (s != null && !s.isClosed()) {
						s.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println("[" + name + " 연결 종료]");
			}
		}

		private void sendAll(String s) {
			for (PrintWriter out : list) {
				out.println(s);
				out.flush();
			}
		}
	}
}
