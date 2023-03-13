package by.academy.controller;

import by.academy.util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/home")
public class Controller extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(final HttpServletRequest req,
                                final HttpServletResponse resp)
            throws ServletException, IOException {
        String commandStr = req.getParameter("command");
        Command command = CommandInvoker.define(commandStr);
        String page = Objects.requireNonNull(command).execute(req);
        getServletContext().getRequestDispatcher(page).forward(req, resp);
    }

    @Override
    public void destroy() {
        HibernateUtil.close();
    }
}
