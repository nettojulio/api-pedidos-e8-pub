package e8ilab2.apipedidos.security;


import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Filters extends OncePerRequestFilter{

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {


            HttpGet get = new HttpGet("http://localhost:8080/validar");//variavel ambiente
            HttpClientBuilder clientBuilder = HttpClientBuilder.create();
            CloseableHttpClient client = clientBuilder.build();
            get.addHeader("Content-Type", "application/json");
            get.addHeader("Accept","text/plain");
            get.addHeader("Authorization",request.getHeader("Authorization"));
            var response2 = client.execute(get);
            response2.getCode();
            if(response2.getCode() > 204){
              response.sendError(401, "Nao autorizado");
              return;
            }


        filterChain.doFilter(request, response);
    }

}
