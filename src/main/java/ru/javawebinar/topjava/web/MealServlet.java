package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet {
    private static final Logger log = getLogger(MealServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        log.debug("redirect to meals");
//
////        resp.sendRedirect("meals.jsp");
//        final LocalTime startTime = LocalTime.MIN;
//        final LocalTime endTime = LocalTime.MAX;
//
//        List<MealTo> mealsTo = filteredByStreams(meals, startTime, endTime, 2000);
//        req.setAttribute("listToMeal",mealsTo);
//
//        req.getRequestDispatcher("/meals.jsp").forward(req, resp);


               log.info("getAll");
              req.setAttribute("meals", MealsUtil.getTos(MealsUtil.MEALS, MealsUtil.DEFAULT_CALORIES_PER_DAY));
              req.getRequestDispatcher("/meals.jsp").forward(req, resp);
    }

}
