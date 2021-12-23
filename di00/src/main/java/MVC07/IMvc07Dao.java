package MVC07;

import java.util.ArrayList;

public interface IMvc07Dao {
	public Customer sltOne(int code);
	public ArrayList<Customer> sltMulti(int code);
	public int insertCst(Customer customer);
	public int updateCst(Customer customer);
	public int deleteCst(int code);
	public void dbConnect();
	public void conClose();
}
