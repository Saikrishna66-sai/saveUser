package getConnection;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBUtill {

	@SuppressWarnings("deprecation")
	public static SessionFactory getsf() {
		Configuration configure = new Configuration().configure();
		SessionFactory sf = configure.buildSessionFactory();
		return sf;
	}
}
