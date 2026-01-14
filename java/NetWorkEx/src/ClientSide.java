import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSide {
    public static void main(String[] args) throws UnknownHostException, IOException {
    	
    	try {
    	Socket c = new Socket("172.16.17.211", 9000);
    	System.out.println("서버연결 성공");
        InputStream is = c.getInputStream(); 
        DataInputStream dis = new DataInputStream(is);
        for (int i = 1; i <= 10; i++) {
            int j = dis.readInt();
            System.out.println("서버로 부터 받은 데이터: " + j);
        }
      c.close();
    }catch(Exception e) {
    	System.out.println("서버연결 실패");
    	e.printStackTrace();
    }
 
}
}
