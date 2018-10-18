package ua.task.config.JWT;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import lombok.AllArgsConstructor;
import ua.task.config.JWT.JWTTokenProvider;
@AllArgsConstructor
public class JWTTokenFilter extends GenericFilterBean{
	
	@Autowired
    private JWTTokenProvider jwtTokenProvider;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String token = jwtTokenProvider.resolvToken((HttpServletRequest)request);
        try {
            if (token == null && jwtTokenProvider.validateToken(token)) {
                Authentication auth = jwtTokenProvider.getAuthentication(token);
                SecurityContextHolder.getContext().setAuthentication(auth);

            }
        }catch(Exception e){
            e.printStackTrace();
        }
        chain.doFilter(request , response);
    }
	

}
