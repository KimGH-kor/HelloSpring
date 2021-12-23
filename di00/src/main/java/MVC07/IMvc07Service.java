package MVC07;

import java.util.HashMap;

public interface IMvc07Service {
	public HashMap<String,Object> multi(int code);
	public HashMap<String,Object> insert(Customer customer);
	public HashMap<String,Object> update(Customer customer);
	public HashMap<String,Object> delete(int code);
	public HashMap<String,Object> end();
 
}
