package br.com.patrick.aplicacaobackend.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("RestFULL API com java spring boot")
                        .version("v1")
                        .description("descrição")
                        .termsOfService("termos de serviço")
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0.html")));
    }

    /*
    * Bean é um objeto que é instanciado, montado e gerenciado pelo spring Ioc container
    * */
}
