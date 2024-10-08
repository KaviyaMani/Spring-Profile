# Spring Boot Profiles
    managing configurations in different environments easily(db details, logging details, can control bean creation based on profile)
    flexible way of handling environment specific values
    Ex: Have a property default.msg = Welcome to app in application.properties
        Using @Value("${default.msg}") private String message; use it in controller
    Add application-dev.properties/ application-test.properties based on you need and configure the values
    Mention the active profile in application.properties using spring.profiles.active=dev or JVM System parameter -Dspring.profiles.active=dev
    Can active profile using pom.xml <profiles>   <profile>  <id>dev</id> <activation> <activeByDefault>true</activeByDefault> </activation> <properties> <spring.profiles.active>dev</spring.profiles.active> </properties> </profile>
    If you did not provide active profile **default application.properties** will be considered
    default property files is always loaded, if required property not found in dev or test default value will be used. Can keep common values here
    Can give all profile details in same application.properties using spring.config.activate.on-profile=dev then give the properties
### Configure bean based on profile
    @Profile("dev")     @Component      public class MyBeanConfig{...}
    @Profile({"prod", "dev"}) @Bean public MyBean getBean() { return new MyBean(); }
### To see active profile
    Through @Value("${spring.profiles.active:}") or Environment

### Binding external properties to POJO
    Using @ConfigurationProperties
    create properties in application.properties with same prefix
    add @EnableConfigurationProperties(AppProperties.class) to main class
    Use it by @Autowired AppProperties appProperties;