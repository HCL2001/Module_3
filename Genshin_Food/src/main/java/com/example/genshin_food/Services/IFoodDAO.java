package com.example.genshin_food.Services;

import com.example.genshin_food.Models.Food;
import com.example.genshin_food.Models.Item;
import com.example.genshin_food.Models.Order;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.sql.SQLException;
import java.util.List;

public interface IFoodDAO {
    List<Food> selectAllFood() throws SQLException;

    void addNewFood(Food food) throws SQLException;

    Food selectFoodById(int id) throws SQLException;

    boolean updateFood(Food food) throws SQLException;

    boolean deleteFoodById(int id) throws SQLException;

    void addNewOrder(Order order) throws SQLException;

    void addOrderDetail(int idOrder, int idFood, int quantity) throws SQLException;

    List<Order> selectAllOrder() throws SQLException;

    Order getOrderById(int id) throws SQLException;

    Order orderDetail(int idOrder) throws SQLException;
}
