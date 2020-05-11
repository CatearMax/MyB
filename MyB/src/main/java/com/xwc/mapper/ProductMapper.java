package com.xwc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.xwc.entity.OrderDetails;
import com.xwc.entity.Product;

public interface ProductMapper {
	
	@Select("select *from product")
	@Results({
		@Result(id = true,column="pro_id",property="proId"),
		@Result(column="pro_name", property="proName"),
		@Result(column="pro_desc", property="proDesc")
	})
	//查询所有商品
	public List<Product> findAllProduct();
	
	
	
	@Delete("delete from product where pro_id = #{value}")
	//删除商品
	public int deleteProduct(Integer proId);
	
	@Update("update product set pro_name = #{proName},pro_desc = #{proDesc} "
			+ "where pro_id = #{proId} ")
	//更新商品
	public int updateProduct(Product product);
	
	@Insert("insert into product (pro_name,pro_desc) "
			+ "values (#{proName},#{proDesc})")
	public int addProduct(Product product);
	
	@Select("select *from product where pro_id = #{value}")
	@Results({
		@Result(id = true,column="pro_id",property="proId"),
		@Result(column="pro_name", property="proName"),
		@Result(column="pro_desc", property="proDesc"),
		@Result(column = "pro_id",property = "orderDetails",
				many = @Many(select = "com.xwc.mapper.ProductMapper.findOrderDetailsById"))
	})
	//根商品一对多查询订单详情
	public Product findProductsById(Integer pro_id);
	
	@Select("select *from order_details where pro_id = #{value}")
	@Results({
		@Result(id = true, column="od_id",property="odId"),
		@Result(column="od_num",property="odNum")
	})
	public OrderDetails findOrderDetailsById(Integer pro_id);
	
	@Select("select *from order_details where pro_id = #{value} ")
	@Results({
		@Result(id = true, column="od_id",property="odId"),
		@Result(column="od_num",property="odNum"),
		@Result(column = "pro_id",property = "products",
				one = @One(select = "com.xwc.mapper.ProductMapper.findProduct"))
	})
	//订单详情一对一查询商品
	public OrderDetails findOrdertails(Integer pro_id);
	
	@Select("select * from product where pro_id = #{value}")
	@Results({
		@Result(id = true,column="pro_id",property="proId"),
		@Result(column="pro_name", property="proName"),
		@Result(column="pro_desc", property="proDesc")
	})
	public Product findProduct(Integer pro_id);
	
	//批量添加
	int batchInsert(List<Product> list);
	
	//批量更新
	int batchUpdate(List<Product> list);
	
	//批量删除
	int batchDelete(List<Integer> ids);

}
