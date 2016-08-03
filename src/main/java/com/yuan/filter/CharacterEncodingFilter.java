package com.yuan.filter;


import javax.servlet.*;
import java.io.IOException;

/**
 * Created by admin on 2016/7/30.
 */
public class CharacterEncodingFilter implements Filter {
    String encoding=null;
    FilterConfig filterConfig=null;
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig=filterConfig;
        this.encoding=filterConfig.getInitParameter("encoding");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (encoding != null) {
            servletRequest.setCharacterEncoding(encoding);
            servletResponse.setContentType("text/html;charset=" + encoding);
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    public void destroy() {
         this.encoding=null;
         this.filterConfig=null;
    }
}
