package br.com.fis.camel.SpringbootCamelRest;

import javax.ws.rs.core.MediaType;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.ancientprogramming.fixedformat4j.format.FixedFormatManager;
import com.ancientprogramming.fixedformat4j.format.impl.FixedFormatManagerImpl;

import br.com.fis.camel.req.InBean;
import br.com.fis.camel.res.OutBean;

@SpringBootApplication
@ComponentScan(basePackages="br.com.fis.camel")
public class Application{

    @Value("${server.port}")
    String serverPort;
    
    @Value("${baeldung.api.path}")
    String contextPath;
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    ServletRegistrationBean servletRegistrationBean() {
        ServletRegistrationBean servlet = new ServletRegistrationBean(new CamelHttpTransportServlet(), contextPath + "/*");
        servlet.setName("CamelServlet");
        return servlet;
    }


    @Component
    class RestApi extends RouteBuilder {

        @Override
        public void configure() {

            restConfiguration().contextPath(contextPath) //
                .port(serverPort)
                .enableCORS(true)
                .apiContextPath("/api-doc")
                .apiProperty("api.title", "CONSULTA CARTOES POR NOME OU CPF")
                .apiProperty("api.version", "v1")
                .apiProperty("cors", "true") // cross-site
                .apiContextRouteId("doc-api")
                .component("servlet")
                .bindingMode(RestBindingMode.json)
                .dataFormatProperty("prettyPrint", "true");
            
				/** 
				The Rest DSL supports automatic binding json/xml contents to/from 
				POJOs using Camels Data Format.
				By default the binding mode is off, meaning there is no automatic 
				binding happening for incoming and outgoing messages.
				You may want to use binding if you develop POJOs that maps to 
				your REST services request and response types. 
				*/         
            
            rest("/api/").description("CONSULTA CARTOES POR NOME OU CPF")
                .id("api-route")
                .post("/bean")
                .produces(MediaType.APPLICATION_JSON)
                .consumes(MediaType.APPLICATION_JSON)
                .bindingMode(RestBindingMode.auto)
                .type(InBean.class)
                .enableCORS(true)
                .to("direct:remoteService");
       
            from("direct:remoteService")
                .routeId("direct-route")
                .tracing()
                .process( new Processor() {
					
					public void process(Exchange exchange) throws Exception {

                        InBean in = (InBean) exchange.getIn().getBody();
                        FixedFormatManager manager = new FixedFormatManagerImpl();
                        
            			String in1 = "Q2211461800OK                                                                              4092     =RC=                   20170821      12064382028868                                                                                    WEBSERVICE0004934940444646061TLIBE R OLIVEIRA           C106140030004934940444646004           N0000000000000000004934940444646087TDAIGE DE ASSIS            C201160030004934940444646004           N00000000000000000049349404446461030DAIGE DE ASSIS             202180030004934940444646004           N00000000000000000049349404446461110LIBE R OLIVEIRA            111180030004934940444646004           N0000000000000000005409050005703013TLIBE R OLIVEIRA           C103171040005409050005703005           N00000000000000000054090500057030210GERALDA R OLIVEIRA        C203171040005409050005703005           N00000000000000000054090500057030390LIBE R OLIVEIRA            112211040005409050005703005           N000000000000000                                                0000000                               000000000000000                                                0000000                               000000000000000                                                0000000                               000000000000000                                                0000000                               000000000000000                                                0000000                               000000000000000                                                0000000                               000000000000000                                                0000000                               000000000000000                                                0000000                               000000000000000                                                0000000                               000000000000000                                                0000000                               000000000000000                                                0000000                               000000000000000                                                0000000                               000000000000000                                                0000000                               000000000000000                                                0000000                               000000000000000                                                0000000                               000000000000000                                                0000000                               000000000000000                                                0000000                               000000000000000                                                0000000                               000000000000000                                                0000000                               000000000000000                                                0000000                               000000000000000                                                0000000                               000000000000000                                                0000000                               000000000000000                                                0000000                               000000000000000                                                0000000                               000000000000000                                                0000000                               000000000000000                                                0000000                               000000000000000                                                0000000                               000000000000000                                                0000000                               000000000000000                                                0000000                               000000000000000                                                0000000                               000000000000000                                                                                                              ";
            			OutBean out = manager.load(OutBean.class, in1);
                        
            			exchange.getIn().setBody(out);
						
					}
				})
                .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(201));
        }
    }
}