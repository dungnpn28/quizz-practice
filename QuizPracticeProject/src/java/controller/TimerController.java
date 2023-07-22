/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Acer
 */
public class TimerController extends HttpServlet{

    private int timerValue = 0;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print("{\"timer\": " + timerValue + "}");
        out.flush();
    }

    @Override
    public void init() {
        // Start a thread or scheduled task to update the timer value periodically
        startTimerTask();
    }

    private void startTimerTask() {
        // Implement the logic to update the timer value (e.g., every second)
        // and store it in the timerValue variable.
        // You can use a TimerTask, ExecutorService, or other methods for this.
    }
    
}
