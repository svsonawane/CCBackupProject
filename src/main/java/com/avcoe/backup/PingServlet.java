package com.avcoe.backup;

import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ping")
public class PingServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/plain");

        try (Connection conn = DBConnection.getConnection()) {
            conn.createStatement().executeQuery("SELECT 1");
            response.setStatus(200);
            response.getWriter().write("ok");
        } catch (Exception e) {
            response.setStatus(500);
            response.getWriter().write("error: " + e.getMessage());
        }
    }
}