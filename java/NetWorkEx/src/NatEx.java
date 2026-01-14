import java.net.InetAddress;
import java.net.UnknownHostException;

public class NatEx {
    public static void main(String[] args) throws Exception {
        InetAddress address = InetAddress.getLocalHost();
        System.out.println("내 컴퓨터 이름:" + address.getHostName());
        System.out.println("내 컴퓨터 IP:" + address.getHostAddress());
        InetAddress naver [] = InetAddress.getAllByName("www.snu.ac.kr");
        for(int i=0; i<naver.length; i++) {
        	System.out.println(naver[i]);
        }
    }
}
