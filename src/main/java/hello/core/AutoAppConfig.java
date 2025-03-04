package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/*
    @ComponentScan : @Component Annotation이 붙은 모든 빈을 자동으로 주입해준다.
    (@Component 뿐만 아니라, @Controller, @Service, @Repository, @Configuration 도 자동 주입 대상이다)
    excludeFilters란, 이 중에서도 제외할 클래스의 조건을 설정 (현재는 Configuration Annotation이 붙은 클래스는 제외 대상)
    현재 AppConfig.class, TestConfig.class 수동으로 빈을 주입해주고 있기 때문에 제외 대상.
    * 스프링부트에서 자동으로 생성되는 @SpringBootApplication에 자동으로 @ComponentScan이 들어있다

    basePackages란, 탐색할 패키지의 시작 위치를 지정하는 것
    모든 자바 클래스를 다 컴포넌트 스캔하면 시간이 오래 걸린다. 그래서 꼭 필요한 위치부터 탐색하도록 시작 위치를 지정할 수 있다.
 */

@Configuration
@ComponentScan(
        basePackages = "hello.core",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
    /*
        이전에는 AppConfig에서 @Bean으로 직접 설정 정보를 작성했고, 의존관계도 수동으로 직접 명시했다.
        이제는 이런 설정 정보 자체가 없기 때문에, 의존관계 주입도 해당 클래스 안에서 해야한다.
        이떄 사용하는 것이 @Autowired이다. 자동으로 의존관계를 주입해주는 역할!
     */

}
