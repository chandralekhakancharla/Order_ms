package com.infosys.infytel.order.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.infosys.infytel.order.dto.OrdersDTO;
import com.infosys.infytel.order.service.OrderService;
import com.infosys.infytel.order.dto.ProductsorderdDTO;

@RestController
@CrossOrigin
public class OrderController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	OrderService orderService;
//	list of products ordered by particular buyer
	@RequestMapping(value = "/api/buyer/productsordered/{buyerId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProductsorderdDTO> getAllOrder(@PathVariable String buyerId) {
		logger.info("Fetching all past Orders");
		return orderService.getAllOrder(buyerId);
	}
//	cart address vlidation
	@RequestMapping(value = "/api/buyer/address/{buyerId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getOrderAddress(@PathVariable String buyerId) throws Exception{
		logger.info("Fetching buyer order address {}", buyerId);
		return orderService.getOrderAddress(buyerId);
	}
// reordering product if it is there in products order table
	@RequestMapping(value="api/buyer/reorder/{buyerID}/{prodId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String reorder(@PathVariable String buyerId, String prodId){
		return orderService.reOrder(buyerId,prodId);
	}
	
// view	orders based on particular sellerId
	@RequestMapping(value = "api/seller/product/oreders/{sellerId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<OrdersDTO> viewAllOrders(@PathVariable String sellerId) {
		logger.info("Fetching all past Orders");
		return orderService.viewAllOrders(sellerId);
	}

//	change order state
	@RequestMapping(value = "api/seller/oreder/{orderId}/{status}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public void changeStatus(@PathVariable String orderId, String status) throws Exception {
		orderService.changeStatus(orderId,status);
	}
	
// new order placed by seller
	@RequestMapping(value = "api/seller/oreder", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addOrder(@RequestBody OrdersDTO ordersDTO) throws Exception {
		orderService.addOrder(ordersDTO);
	}
	
//// new order placed by buyer
//	@RequestMapping(value = "api/buyer/oreder", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
//	public Integer addOrder2(@RequestBody OrdersDTO ordersDTO) throws Exception {
//		return orderService.addOrder2(ordersDTO);
//	}
}
