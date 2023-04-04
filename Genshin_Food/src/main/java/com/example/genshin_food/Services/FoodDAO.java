package com.example.genshin_food.Services;

import com.example.genshin_food.Models.Food;
import com.example.genshin_food.Models.Item;
import com.example.genshin_food.Models.Order;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FoodDAO implements IFoodDAO {

    private String jdbcURL = "jdbc:mysql://localhost:3306/genshin_food?useSSL=false";

    private String jdbcUserName = "root";

    private String jdbcPassWord = "Long@Hoang123";

    private static FoodDAO FoodDAO = new FoodDAO();

    public static FoodDAO getFoodDAO() {
        return FoodDAO;
    }

    public FoodDAO() {
    }

    private Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUserName, jdbcPassWord);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public List<Food> selectAllFood() throws SQLException {
        List<Food> foodList = new ArrayList<>();
        String query = "{CALL selectAllFood}";
        Connection connection = getConnection();
        try (CallableStatement callableStatement = connection.prepareCall(query)) {
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("idFood");
                String nameFood = resultSet.getString("nameFood");
                String descriptionFood = resultSet.getString("decriptionFood");
                int priceFood = resultSet.getInt("priceFood");
                String countryFood = resultSet.getString("countryFood");
                String imgFood = resultSet.getString("imgFood");
                foodList.add(new Food(id, nameFood, descriptionFood, priceFood, countryFood, imgFood));
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }finally {
            if (connection != null) {
                connection.close();
            }

        }
        return foodList;
    }

    @Override
    public void addNewFood(Food food) throws SQLException {
        String query = "{CALL addNewFood(?, ?, ?, ?, ?, ?)}";
        Connection connection = getConnection();
        try (CallableStatement callableStatement = connection.prepareCall(query)) {
            callableStatement.setInt(1, food.getIdFood());
            callableStatement.setString(2, food.getNameFood());
            callableStatement.setString(3, food.getDescriptionFood());
            callableStatement.setInt(4, food.getPriceFood());
            callableStatement.setString(5, food.getCountryFood());
            callableStatement.setString(6, food.getImgFood());
            callableStatement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        finally {
            if (connection != null){
                connection.close();
            }
        }
    }

    @Override
    public Food selectFoodById(int id) throws SQLException {
        Food food = null;
        String query = "{CALL selectById(?)}";
        Connection connection = getConnection();
        try (CallableStatement callableStatement = connection.prepareCall(query)) {
            callableStatement.setInt(1, id);
            ResultSet resultSet = callableStatement.executeQuery();

            while (resultSet.next()) {
                String namefood = resultSet.getString("nameFood");
                String description = resultSet.getString("decriptionFood");
                int priceFood = resultSet.getInt("priceFood");
                String country = resultSet.getString("countryFood");
                String img = resultSet.getString("imgFood");

                food = new Food(id, namefood, description, priceFood, country, img);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (connection != null){
                connection.close();
            }
        }
        return food;
    }

    @Override
    public boolean updateFood(Food food) throws SQLException {
        String query = "{CALL updateFood(?, ?, ?, ?, ?, ?)}";
        boolean updatedRow = false;
        Connection connection = getConnection();
        try (CallableStatement callableStatement = connection.prepareCall(query)) {
            callableStatement.setInt(1, food.getIdFood());
            callableStatement.setString(2, food.getNameFood());
            callableStatement.setString(3, food.getDescriptionFood());
            callableStatement.setInt(4, food.getPriceFood());
            callableStatement.setString(5, food.getCountryFood());
            callableStatement.setString(6, food.getImgFood());

            updatedRow = callableStatement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (connection != null){
                connection.close();
            }
        }
        return updatedRow;
    }

    @Override
    public boolean deleteFoodById(int id) throws SQLException {
        String query = "{CALL deleteFood(?)}";
        boolean rowDeleted = false;
        Connection connection = getConnection();
        try (CallableStatement callableStatement = connection.prepareCall(query)) {
            callableStatement.setInt(1, id);
            rowDeleted = callableStatement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (connection != null){
                connection.close();
            }
        }
        return rowDeleted;
    }

    @Override
    public void addNewOrder(Order order) throws SQLException {
        String query = "{CALL addNewOrder(?, ?, ?, ?, ?, ?)}";
        Connection connection = getConnection();
        try (CallableStatement callableStatement = connection.prepareCall(query)) {
            callableStatement.setInt(1, order.getIdOrder());
            callableStatement.setString(2, order.getDateOrder());
            callableStatement.setString(3, order.getAddressOrder());
            callableStatement.setString(4, order.getPhoneNumber());
            callableStatement.setInt(5, order.getTotal());
            callableStatement.setInt(6, order.getStatus());

            callableStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (connection != null){
                connection.close();
            }
        }
    }

    @Override
    public void addOrderDetail(int idOrder, int idFood, int quantity) throws SQLException {
        String query = "{CALL addOrderDetail(?, ?, ?)}";
        Connection connection = getConnection();
        try (CallableStatement callableStatement = connection.prepareCall(query)) {
            callableStatement.setInt(1, idOrder);
            callableStatement.setInt(2, idFood);
            callableStatement.setInt(3, quantity);

            callableStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (connection != null){
                connection.close();
            }
        }
    }

    @Override
    public List<Order> selectAllOrder() throws SQLException {
        List<Order> list = new ArrayList<>();
        String query = "{CALL getAllOrder}";
        Connection connection = getConnection();
        try (CallableStatement callableStatement = connection.prepareCall(query)) {
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                int idOrder = resultSet.getInt("idOrder");
                String dateOrder = resultSet.getString("dateOrder");
                String addressOrder = resultSet.getString("addressOrder");
                String phoneOrder = resultSet.getString("phoneOrder");
                int totalOrder = resultSet.getInt("total");
                int statusOrder = resultSet.getInt("statusOrder");
                list.add(new Order(idOrder, dateOrder, addressOrder, phoneOrder, totalOrder, statusOrder));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (connection != null){
                connection.close();
            }
        }
        return list;
    }

    @Override
    public Order getOrderById(int id) throws SQLException {
        Order order = null;
        String query = "CALL getOrderById(?)";
        Connection connection = getConnection();
        try (CallableStatement callableStatement = connection.prepareCall(query)) {
            callableStatement.setInt(1, id);

            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                String dateOrder = resultSet.getString("dateOrder");
                String addressOrder = resultSet.getString("addressOrder");
                String phoneOrder = resultSet.getString("phoneOrder");
                int totalOrder = resultSet.getInt("total");
                int statusOrder = resultSet.getInt("statusOrder");

                order = new Order(id, dateOrder, addressOrder, phoneOrder, totalOrder, statusOrder);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (connection != null){
                connection.close();
            }
        }
        return order;
    }

    @Override
    public Order orderDetail(int idOrder) throws SQLException {
        String query = "{CALL getOrderDetail(?)}";
        Order order = FoodDAO.getOrderById(idOrder);
        List<Item> itemList = new ArrayList<>();
        Connection connection = getConnection();
        try (CallableStatement callableStatement = connection.prepareCall(query)) {
            callableStatement.setInt(1, idOrder);
            ResultSet resultSet = callableStatement.executeQuery();

            while (resultSet.next()) {
                String tenSp = resultSet.getString("TenSP");
                int giaSp = resultSet.getInt("GiaSP");
                int quantity = resultSet.getInt("SoLuong");
                int idFood = resultSet.getInt("idFood");
                Food food = FoodDAO.selectFoodById(idFood);

                Item item = new Item();
                item.setFood(food);
                item.setQuantity(quantity);
                item.setPrice(giaSp);
                item.getFood().setNameFood(tenSp);
                itemList.add(item);
                order.setItemList(itemList);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if (connection != null){
                connection.close();
            }
        }
        return order;
    }


//    @Override
//    public List<Enum> selectAllCartItem() {
//
//    }
}
