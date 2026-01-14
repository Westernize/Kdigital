import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLTest {
	
	public static void main(String[] args) throws Exception {
		URL kbs = new URL("https://web.kangnam.ac.kr/menu/7a73adebe8fa9563c252fcaba05cc52c.do");
		/*
		System.out.println("프로토콜:" + kbs.getProtocol());
		System.out.println("포트:" + kbs.getPort());
		System.out.println("호스트:" + kbs.getHost());
		System.out.println("파일경로:" + kbs.getFile());
		*/
		URLConnection kbscon = kbs.openConnection();
		System.out.println("문서의 타입:" + kbscon.getContentType());
		double i =5000000;
		int c;
		InputStream input = kbscon.getInputStream();
		while((c = input.read()) != -1 && (--i) >0) { 
			System.out.print((char)c);
			
		}
	}

}
