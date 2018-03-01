package com.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @name:
 * @author:liangxian.chen@hand-china.com
 * @date: Created in 17:21 2018/02/09
 * @Modified By:
 * @description：
 */
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 8359411223091931725L;



    /*@Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.service(req, resp);
        String userName = req.getParameter("uname");
        String password = req.getParameter("upwd");

        System.out.println("用户名==> " + userName);
        System.out.println("密码==> " + password);
    }*/

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        System.out.println("=======in the doGet Method=======");
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        System.out.println("=======in the doPost Method=======");
        String userName = req.getParameter("uname");
        String password = req.getParameter("upwd");

        System.out.println("用户名==> " + userName);
        System.out.println("密码==> " + password);

        String forward = null;

        if (userName.equals("spring") && password.equals("123456")){
            //请求转发，只可在同应用中进行转发
            forward = "/servlet/success.jsp";
            //forward="https://www.zhihu.com/";
            RequestDispatcher rd = req.getRequestDispatcher(forward);
            rd.forward(req,resp);

            //请求重定向，可在不同应用中进行转发
            //resp.sendRedirect(req.getContextPath()+"/servlet/success.jsp");
            //resp.sendRedirect(forward);
        }else{
            //请求转发
            forward = "/servlet/error.jsp";
            RequestDispatcher rd = req.getRequestDispatcher(forward);
            rd.forward(req,resp);

            //请求重定向
            //resp.sendRedirect(req.getContextPath()+"/servlet/error.jsp");
        }
    }
}
