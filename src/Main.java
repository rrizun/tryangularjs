
import org.mortbay.jetty.*;
import org.mortbay.jetty.webapp.*;

public class Main {
	public static void main(String[] args) throws Exception {
		Server server = new Server(8001);
		server.setHandler(new WebAppContext("war", "/tryangularjs"));
		server.start();
	}
}
