package com.example.genshin_food.Controllers;

import com.example.genshin_food.Models.Food;
import com.example.genshin_food.Models.Order;
import com.example.genshin_food.Services.FoodDAO;
import com.sun.org.apache.xpath.internal.operations.Or;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "FoodServlet", urlPatterns = "/foods")
public class FoodServlet extends HttpServlet {

    private FoodDAO foodDAO;

    public void init() {
        foodDAO = new FoodDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null)
            action = "";
        switch (action) {
            case "admin":
                try {
                    showAdminPage(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "edit":
                try {
                    showEditPage(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "create":
                showCreatePage(request, response);
                break;
            case "delete":
                try {
                    showDelete(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "showOrder":
                try {
                    showOrderPage(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "detail":
                try {
                    showDetailPage(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "orderDetail":
                try {
                    showDetailOrder(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "show":
                showCart(request, response);
                break;
            default:
                try {
                    listFood(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }

    private void showCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("html/cart.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showDetailOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("idOrder"));
        Order order = FoodDAO.getFoodDAO().orderDetail(id);
        request.setAttribute("order", order);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("html/order_detail.jsp");
        requestDispatcher.forward(request, response);
    }

    private void listFood(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Food> foodList = foodDAO.selectAllFood();
        request.setAttribute("listFood", foodList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("html/index.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showDetailPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("idFood"));
        Food food = foodDAO.selectFoodById(id);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("html/food_detail.jsp");
        request.setAttribute("food", food);
        requestDispatcher.forward(request, response);
    }

    private void showOrderPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Order> list = foodDAO.selectAllOrder();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("html/orderList.jsp");
        request.setAttribute("listOrder", list);
        requestDispatcher.forward(request, response);
    }

    private void showDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("idFood"));
        foodDAO.deleteFoodById(id);
        List<Food> foodList = foodDAO.selectAllFood();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("html/admin.jsp");
        request.setAttribute("listFood", foodList);
        requestDispatcher.forward(request, response);
    }

    private void showCreatePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("html/create.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showEditPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("idFood"));
        Food food = foodDAO.selectFoodById(id);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("html/edit.jsp");
        request.setAttribute("food", food);
        requestDispatcher.forward(request, response);
    }

    private void showAdminPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Food> lists = foodDAO.selectAllFood();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("html/admin.jsp");
        request.setAttribute("listFood", lists);
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null)
            action = "";
        switch (action) {
            case "create":
                try {
                    addNewFoodServlet(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "edit":
                try {
                    updatedFoodById(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                try {
                    listFood(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }

    private void updatedFoodById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("idFood"));
        String name = request.getParameter("foodName");
        String des = request.getParameter("descriptionFood");
        int price = Integer.parseInt(request.getParameter("priceFood"));
        String country = request.getParameter("countryFood");
        String img = request.getParameter("imgFood");
        Food food = new Food(id, name, des, price, country, img);
        foodDAO.updateFood(food);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("html/edit.jsp");
        requestDispatcher.forward(request, response);
    }

    private void addNewFoodServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int idFood = Integer.parseInt(request.getParameter("idFood"));
        String nameFood = request.getParameter("foodName");
        String description = request.getParameter("descriptionFood");
        int priceFood = Integer.parseInt(request.getParameter("priceFood"));
        String country = request.getParameter("countryFood");
        String img = request.getParameter("imgFood");
        Food food = new Food(idFood, nameFood, description, priceFood, country, img);
        foodDAO.addNewFood(food);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("html/create.jsp");
        request.setAttribute("message", "abc");
        requestDispatcher.forward(request, response);
    }
}
