package org.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/create")
public class CarCreateServlet extends HttpServlet {

    CarInterface service = new CarService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        String model = req.getParameter("model");
        String year = req.getParameter("year");
        int cost = Integer.parseInt(req.getParameter("cost"));

        Car car = new Car(id, model, year, cost);

        service.save(car);
//        List<Car> all = service.getAll();
//        req.setAttribute("cars", all);

//        req.getRequestDispatcher("/create.jsp").forward(req,resp);
        resp.sendRedirect("/");
    }
}
