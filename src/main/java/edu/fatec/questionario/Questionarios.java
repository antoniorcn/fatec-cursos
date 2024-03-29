/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package edu.fatec.questionario;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.ajp.AjpNioProtocol;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages= {"edu.fatec.questionario.controller", "edu.fatec.questionario.services"})
public class Questionarios {
    @Value("${tomcat.ajp.port}")
    int ajpPort;

    @Value("${tomcat.ajp.remoteauthentication}")
    String remoteAuthentication;

    @Value("${tomcat.ajp.enabled}")
    boolean tomcatAjpEnabled;

    public static void main(String[] args) {
        SpringApplication.run(Questionarios.class, args);
    }



    @Bean
    public TomcatServletWebServerFactory servletContainer() {

        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        if (tomcatAjpEnabled)
        {
            Connector ajpConnector = new Connector("org.apache.coyote.ajp.AjpNioProtocol");
            AjpNioProtocol protocol= (AjpNioProtocol)ajpConnector.getProtocolHandler();
            protocol.setSecret("myapjsecret");
            ajpConnector.setPort(ajpPort);
            ajpConnector.setSecure(true);
            ajpConnector.setAllowTrace(false);
            ajpConnector.setScheme("https");
            tomcat.addAdditionalTomcatConnectors(ajpConnector);
        }

        return tomcat;
    }

}

