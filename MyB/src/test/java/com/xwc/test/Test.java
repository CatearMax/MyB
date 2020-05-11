package com.xwc.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Before;

import com.xwc.entity.OrderDetails;
import com.xwc.entity.Product;
import com.xwc.mapper.ProductMapper;


public class Test {
	
static Logger logger = Logger.getLogger(Test.class);
	
	private SqlSessionFactory factory;
	
	@Before
	public void before() {
		try {
			factory = new SqlSessionFactoryBuilder().
					build(Resources.getResourceAsStream("mybatis.xml"));
		} catch (IOException e) {
			logger.error("读取mybatis xml文件失败"+e.getMessage());
		}
	}
	
	@org.junit.Test
	/**
	 * 查询所有商品
	 */
	public void findAllProduct() {
		SqlSession session = factory.openSession();
		ProductMapper productMapper = session.getMapper(ProductMapper.class);
		System.out.println(productMapper.findAllProduct());
		session.close();
	}
	
	@org.junit.Test
	/**
	 * 删除商品
	 */
	public void DeleteProduct() {
		SqlSession session = factory.openSession();
		ProductMapper productMapper = session.getMapper(ProductMapper.class);
		System.out.println(productMapper.deleteProduct(5));
		session.commit();
		session.close();
	}
	
	@org.junit.Test
	/**
	 * 更新商品
	 */
	public void UpdateProduct() {
		SqlSession session = factory.openSession();
		ProductMapper productMapper = session.getMapper(ProductMapper.class);
		Product product = new Product();
		product.setProId(1);
		product.setProName("裤裤裤子");
		product.setProDesc("秋秋秋裤");
		System.out.println(productMapper.updateProduct(product));
		session.commit();
		session.close();
	}
	
	@org.junit.Test
	/**
	 * 添加商品
	 */
	public void addProduct() {
		SqlSession session = factory.openSession();
		ProductMapper productMapper = session.getMapper(ProductMapper.class);
		Product product = new Product();
		product.setProName("眼镜");
		product.setProDesc("太阳镜");
		System.out.println(productMapper.addProduct(product));
		session.commit();
		session.close();
	}
	
	@org.junit.Test
	/**
	 * 一对多查询
	 */
	public void findProducts() {
		SqlSession session = factory.openSession();
		ProductMapper productMapper = session.getMapper(ProductMapper.class);
		Product product = productMapper.findProductsById(1);
			System.out.println(product.getOrderDetails());
		session.close();
	}
	
	@org.junit.Test
	/**
	 * 一对一查询
	 */
	public void findDetails() {
		SqlSession session = factory.openSession();
		ProductMapper productMapper = session.getMapper(ProductMapper.class);
		OrderDetails od = productMapper.findOrdertails(4);
			System.out.println(od.getProducts());
		session.close();
	}
	
	@org.junit.Test
	/**
	 * 批量删除
	 */
	public void batchDelete() {
		SqlSession session = factory.openSession();
		ProductMapper productMapper = session.getMapper(ProductMapper.class);
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);  list.add(2);  list.add(3);
		System.out.println(productMapper.batchDelete(list));
		session.commit();
		session.close();
	}
	
	@org.junit.Test
	/**
	 * 批量更新
	 */
	public void batchAdd() {
		SqlSession session = factory.openSession();
		ProductMapper productMapper = session.getMapper(ProductMapper.class);
		List<Product> list = new ArrayList<Product>();
		Product productA = new Product();
		productA.setProName("跑鞋");
		productA.setProDesc("ub");
		Product productB = new Product();
		productB.setProName("眼镜");
		productB.setProDesc("太阳镜");
		list.add(productA);list.add(productB);
		System.out.println(productMapper.batchInsert(list));
		session.commit();
		session.close();
	}
	
	@org.junit.Test
	/**
	 * 批量更新
	 */
	public void batchUpdate() {
		SqlSession session = factory.openSession();
		ProductMapper productMapper = session.getMapper(ProductMapper.class);
		List<Product> list = new ArrayList<Product>();
		Product productA = new Product();
		productA.setProName("跑鞋");
		productA.setProDesc("ub");
		productA.setProId(1);
		Product productB = new Product();
		productB.setProName("眼镜");
		productB.setProDesc("太阳镜");
		productB.setProId(2);
		list.add(productA);list.add(productB);
		System.out.println(productMapper.batchUpdate(list));
		session.commit();
		session.close();
	}


}
