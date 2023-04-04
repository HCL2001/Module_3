package com.example.genshin_food.Controllers;

import com.example.genshin_food.Models.Cart;
import com.example.genshin_food.Models.Food;
import com.example.genshin_food.Models.Item;
import com.example.genshin_food.Models.Order;
import com.example.genshin_food.Services.FoodDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@WebServlet(name = "AddToCartServlet", value = "/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {

    public FoodDAO foodDAO;

    @Override
    public void init() throws ServletException {
        foodDAO = new FoodDAO();
    }

    Cart cart = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int quantity = 1;
        int id;
        if (request.getParameter("idFood") != null) {
            id = Integer.parseInt(request.getParameter("idFood"));
            Food food = null;
            try {
                food = foodDAO.selectFoodById(id);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            if (food != null) {
                HttpSession session = request.getSession();
                if (session.getAttribute("cart") == null) {
                    cart = new Cart();
                    List<Item> listItem = new ArrayList<Item>();
                    Item item = new Item();
                    item.setQuantity(quantity);
                    item.setFood(food);
                    item.setPrice(food.getPriceFood());
                    item.setTotal(food.getPriceFood());
                    listItem.add(item);
                    cart.setItems(listItem);
                    cart.setTotal(item.getTotal());
                    session.setAttribute("cart", cart);

                } else {
                    cart = (Cart) session.getAttribute("cart");
                    List<Item> listItem = cart.getItems();
                    boolean check = false;
                    for (Item item : listItem
                    ) {
                        if (item.getFood().getIdFood() == food.getIdFood()) {
                            cart.setTotal(item.getTotal());
                            item.setQuantity(item.getQuantity() + quantity);
                            check = true;
                        }
                    }
                    if (!check) {
                        Item item = new Item();
                        item.setQuantity(quantity);
                        item.setFood(food);
                        item.setPrice(food.getPriceFood());
                        item.setTotal(food.getPriceFood());
                        listItem.add(item);
                        cart.setItems(listItem);
                        cart.setTotal(item.getPrice());
                    }
                    cart.setQuantity(cart.getQuantity() + 1);
                    session.setAttribute("cart", cart);

                }
                RequestDispatcher dispatcher = request.getRequestDispatcher("html/cart.jsp");
                try {
                    dispatcher.forward(request, response);
                } catch (IOException | ServletException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("finish");
        if (Objects.equals(action, "Submit")) {
            int idOrder = Integer.parseInt(request.getParameter("idOrder"));
            String addressOrder = request.getParameter("addressOrder");
            String dateOrder = request.getParameter("dateOrder");
            String phoneOrder = request.getParameter("phoneOrder");

            Order order = new Order(idOrder, dateOrder, addressOrder, cart.getTotal(), phoneOrder);

            try {
                foodDAO.addNewOrder(order);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            List<Item> list = cart.getItems();
            for (Item i : list
            ) {
                try {
                    foodDAO.addOrderDetail(idOrder, i.getFood().getIdFood(), i.getQuantity());
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

            cart.setQuantity(0);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/foods");
            requestDispatcher.forward(request, response);
        }
    }
}
