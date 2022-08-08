//package com.rsc.ckl.boottest.service;
//
//import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletRegistrationBean;
//import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
//import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
//import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.context.support.FileSystemXmlApplicationContext;
//import org.springframework.web.servlet.DispatcherServlet;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.handler.DispatcherServletWebRequest;
//import org.springframework.web.servlet.mvc.Controller;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.Arrays;
//
///**
// * @author chenkuilin
// * @date 2022/8/8
// * @desc
// */
//public class TestApplicationContext {
//
//
//    public static void main(String[] args) {
//
////        textClassPathXmlApplicationContext();
////        textFileSystemXmlApplicationContext();
////        textAnnotationConfigApplicationContext();
////        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
////        for (String name : beanFactory.getBeanDefinitionNames()) {
////            System.out.println(name);
////        }
////
////        System.out.println("-------------------------------");
////
////        //在BeanFactory上多的功能  通过后增强处理
////        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
////        reader.loadBeanDefinitions(new ClassPathResource("b01.xml"));
////        reader.loadBeanDefinitions(new FileSystemResource("D:\\tools\\ideaProject\\bootTest\\src\\main\\resources\\b01.xml"));
////        for (String name : beanFactory.getBeanDefinitionNames()) {
////            System.out.println(name);
////        }
//
//        AnnotationConfigServletWebServerApplicationContext context =
//                new AnnotationConfigServletWebServerApplicationContext(WebConfig.class);
//
//    }
//
//    private static void textClassPathXmlApplicationContext(){
//        ClassPathXmlApplicationContext contenxt = new ClassPathXmlApplicationContext("b01.xml");
//        for (String name : contenxt.getBeanDefinitionNames()) {
//            System.out.println(name);
//        }
//    }
//
//    private static void textFileSystemXmlApplicationContext(){
//        FileSystemXmlApplicationContext contenxt = new FileSystemXmlApplicationContext("D:\\tools\\ideaProject\\bootTest\\src\\main\\resources\\b01.xml");
//        for (String name : contenxt.getBeanDefinitionNames()) {
//            System.out.println(name);
//        }
//    }
//
//    private static void textAnnotationConfigApplicationContext(){
//        AnnotationConfigApplicationContext contenxt = new AnnotationConfigApplicationContext(Config.class);
//        for (String name : contenxt.getBeanDefinitionNames()) {
//            System.out.println(name);
//        }
//        System.out.println(contenxt.getBean(Bean2.class).getBean1());
//    }
//
//    @Configuration
//    public static class WebConfig{
//        //tomcat容器
//        @Bean
//        public ServletWebServerFactory servletWebServerFactory(){
//            return new TomcatServletWebServerFactory();
//        }
//        //前端控制器  任何请求都会进来
//        @Bean
//        public DispatcherServlet dispatcherServlet(){
//            return new DispatcherServlet();
//        }
//        //注册前端控制器
//        @Bean
//        public DispatcherServletRegistrationBean registrationBean(DispatcherServlet dispatcherServlet){
//            return new DispatcherServletRegistrationBean(dispatcherServlet,"/");
//        }
//        //处理器接收到请求
//        @Bean("/hello")
//        public Controller controller1(){
//            return (request, response) -> {
////                System.out.println(request.getParameter("oid"));
//                request.getParameterMap().forEach( (k,v) ->{
//                    System.out.println(k + "----" + Arrays.toString(v));
//                });
//                response.getWriter().println("hello");
//                return null;
//            };
//        }
//    }
//
//
//    @Configuration
//    static class Config{
//
//        @Bean
//        public Bean1 bean1(){
//            return new Bean1();
//        }
//
//        @Bean
//        public Bean2 bean2(Bean1 bean1){
//            Bean2 bean2 = new Bean2();
//            bean2.setBean1(bean1);
//            return bean2;
//        }
//
//    }
//
//    private static class Bean1{
//
//    }
//
//    private static class Bean2{
//
//        private Bean1 bean1;
//
//        public Bean1 getBean1() {
//            return bean1;
//        }
//
//        public void setBean1(Bean1 bean1) {
//            this.bean1 = bean1;
//        }
//    }
//
//}
