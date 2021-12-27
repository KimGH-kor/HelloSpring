package aopExam;

import java.util.HashMap;

public class ProductServiceImpl implements ProductService {
	ProductDao productDao;
	
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public HashMap<String, Object> doProc(String str) {
		return productDao.getProduct(str);
	}

}
