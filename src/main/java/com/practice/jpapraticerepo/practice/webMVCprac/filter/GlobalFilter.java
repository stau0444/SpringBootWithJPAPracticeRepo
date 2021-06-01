package com.practice.jpapraticerepo.practice.webMVCprac.filter;

import com.practice.jpapraticerepo.practice.webMVCprac.wrapper.CachedBodyHttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.http.HttpRequest;

@WebFilter(urlPatterns = "/api/filter")
@Slf4j
public class GlobalFilter implements Filter {


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        CachedBodyHttpServletRequest req =
                new CachedBodyHttpServletRequest((HttpServletRequest)request);
        ContentCachingResponseWrapper resp = new ContentCachingResponseWrapper((HttpServletResponse) response);


        StringBuffer sb = new StringBuffer();

        BufferedReader reader = req.getReader();
        reader.lines().forEach(s -> {sb.append(s);});


        log.info("filter 들어옴");
        log.info("requestBody:{}",sb);

        chain.doFilter(req,resp);

        resp.copyBodyToResponse();
    }
}
