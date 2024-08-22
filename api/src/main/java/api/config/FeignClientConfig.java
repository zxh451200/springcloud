package api.config;


import api.client.fallback.OrderFeignClientFallbackFactory;
import feign.Logger;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Bean;

public class FeignClientConfig {

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public RequestInterceptor userInfoRequestInterceptor() {
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate requestTemplate) {
//                requestTemplate.header("user-info", "Bearer " + token);

//                requestTemplate.header("Authorization", "Bearer " + token);
            }
        };
    }


    @Bean
    public OrderFeignClientFallbackFactory orderFeignClientFallbackFactory(){
        return new OrderFeignClientFallbackFactory();
    }

}
