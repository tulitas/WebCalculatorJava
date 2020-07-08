package app.servlets;


import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/calculator")
public class CalculatorServlet extends HttpServlet {
    private List<String> list = new ArrayList<String>();
    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        dbRun();
        String solve = request.getParameter("solve");
        String answer = null;
        String deal = null;
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        try {
            System.out.println(engine.eval(solve));
            answer = String.valueOf(engine.eval(solve));
            deal = (solve + " = " + answer);
            list.add(deal);
            System.out.println(list);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        request.setAttribute("deal", deal);
        request.setAttribute("answer", answer);
        request.setAttribute("list", list);
        getServletContext().getRequestDispatcher("/WEB-INF/views/calculator.jsp").forward(request, response);

    }

    private void dbRun() {
        try{
            String url = "jdbc:mysql://localhost/calc";
            String username = "root";
            String password = "root";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                System.out.println("connected");
            }
        }
        catch(Exception ex){
            System.out.println("connection failed");
            System.out.println(ex);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/views/calculator.jsp")
                .include(request, response);
    }

}
