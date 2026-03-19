package org.springframework.samples.petclinic;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import jakarta.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AccessLogFilter implements Filter {

        private static final Logger log = LoggerFactory.getLogger("ACCESS");

        @Override
        public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
                        throws IOException, ServletException {

                HttpServletRequest request = (HttpServletRequest) req;

                long start = System.currentTimeMillis();
                chain.doFilter(req, res);
                long duration = System.currentTimeMillis() - start;

                log.info("{} {} {}ms", request.getMethod(), request.getRequestURI(), duration);
        }

}
