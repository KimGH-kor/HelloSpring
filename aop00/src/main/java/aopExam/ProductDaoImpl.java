package aopExam;

import java.util.HashMap;

public class ProductDaoImpl implements ProductDao{
	HashMap<String, Object> product;
	
	public ProductDaoImpl() {
		product = new HashMap<String, Object>();
		product.put("price", 100);
	}

	@Override
	public HashMap<String, Object> getProduct(String str) {
		if("에러".equals(str)) {
			System.out.println(0/0);
		}
		product.put("name", str);
		return product;
	}
}
