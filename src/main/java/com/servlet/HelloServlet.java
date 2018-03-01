package com.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @name:
 * @author:liangxian.chen@hand-china.com
 * @date: Created in 20:00 2018/02/08
 * @Modified By:
 * @description：
 */
public class HelloServlet extends HttpServlet{

    @Override
    public void init() throws ServletException {
        //推荐重写无参的init()方法，因为不用手工调用super.init()方法。
        //   重写init()并不是必须，如果需要在servlet实例化的时候执行一些初始化的动作，才需要重写此方法.
        System.out.println("=============init without parameters=============");
        super.init();
    }
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("=============init with parameters=============");
        super.init(config);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("=============service=============");
        //super.service(req, resp);
        PrintWriter writer =resp.getWriter();
        writer.write("hello world...");
        writer.close();
    }

    @Override
    public void destroy() {
        //此方法在Tomcat停止时调用，故可以做一些资源释放，日志记录的动作。
        System.out.println("=============destroys=============");
        super.destroy();
    }




}
