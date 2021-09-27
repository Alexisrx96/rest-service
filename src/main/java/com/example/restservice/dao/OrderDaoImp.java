package com.example.restservice.dao;

import com.example.restservice.models.Order;
import com.example.restservice.models.OrderProduct;
import com.example.restservice.models.OrderProductId;
import com.example.restservice.models.OrderWrapper;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Repository
@Transactional
public class OrderDaoImp implements OrderDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Order> getOrders() {
        String query = "FROM Order";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Order getOrder(int id) {
        String query = String.format("FROM Order O WHERE O.id = %d", id);
        return (Order) entityManager.createQuery(query).getSingleResult();
    }

    @Override
    public void updateOrder(Order order) {
        entityManager.merge(order);
    }

    @Override
    public void deleteOrder(int id) {
        Order order = entityManager.find(Order.class, id);
        entityManager.remove(order);
    }

    @Override
    public void createOrder(Order order) {
        entityManager.persist(order);
    }

    @Override
    public void submitOrder(OrderWrapper orderWrapper) {
        entityManager.getTransaction().begin();
        Order order = new Order();
        order.setOrdersDate(orderWrapper.getOrdersDate());
        order.setOrdersStatus(orderWrapper.getOrdersStatus());
        order.setOrdersDelivaddress(orderWrapper.getOrdersDelivaddress());
        order.setIdPayment(orderWrapper.getIdPayment());
        order.setIdUser(orderWrapper.getIdUser());
        entityManager.persist(order);
        int idOrder = order.getId();
        for (var productWrapper: orderWrapper.getProductWrappers()) {
            OrderProductId id = new OrderProductId();
            id.setIdOrder(idOrder);
            id.setIdProduct(productWrapper.getIdProduct());
            OrderProduct orderProduct = new OrderProduct();
            orderProduct.setId(id);
            orderProduct.setProductPrice(productWrapper.getProductPrice());
            orderProduct.setProductQuantity(productWrapper.getProductQuantity());
            entityManager.persist(orderProduct);
        }
        entityManager.getTransaction().commit();
    }

    /*
    @Override
    public ByteArrayInputStream exportOrders() throws IOException {
        String[] columns = {"id_order","fecha","estado"};

        Workbook workbook = new HSSFWorkbook();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        Sheet sheet = workbook.createSheet("Orders");
        Row row = sheet.createRow(0);

        for(int i = 0; i < columns.length; i++ ){
            Cell cell = row.createCell(i);
            cell.setCellValue(i);
        }

        List<Order> orders = this.getOrders();

        int initRow = 1;
        for (Order order:orders){
            row = sheet.createRow(initRow);
            row.createCell(0).setCellValue(order.getId());
            row.createCell(1).setCellValue(order.getOrdersDate());
            row.createCell(2).setCellValue(order.getOrdersStatus());

            initRow++;
        }

        workbook.write(stream);
        workbook.close();

        return new ByteArrayInputStream(stream.toByteArray());
    }
*/

}
