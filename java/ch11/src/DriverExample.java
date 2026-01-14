
public class DriverExample {

	public static void main(String[] args) {
		Driver d = new Driver();
		Bus bus = new Bus();
		Taxi taxi = new Taxi();
		d.driver(taxi);
		d.driver(bus);
	

	}

}
