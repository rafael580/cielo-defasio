package br.com.cielo.bootcampdesafio04.config;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/custom-h2-console")
public class H2ConsoleServlet extends org.h2.server.web.JakartaWebServlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);

    }


}