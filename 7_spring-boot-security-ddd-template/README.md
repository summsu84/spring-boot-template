Spring Security DDD API


## 개요
- application, domain, infrastructure 레이어로 분리
### application layer
- 
### domain layer
- 비지니스 로직 적용
- application과 infrastructure layer 로부터 고립

### infrastructure layer
- 어플리케이션 동작에 필요한 것들을 위한 레이어
- 데이터베이스 설정, 스프링 설정
- 도메인과 인터페이싱


### project 구조

- domain
>- model : 저장 데이터를 제어 (@Entity, Domain 기능 클래스)
>- service : 기능을 제어하는 패키지 (서비스 Interface)
- infrastructure
>- config
>- service-name-on-domain
- interfaces
>- controller
>- facade
- application




참고
- https://daddyprogrammer.org/post/636/springboot2-springsecurity-authentication-authorization/
- https://kuleeblog.wordpress.com/2017/01/19/java-spring-ddd-domain-driven-design-%EC%84%A4%EA%B3%84-%EB%B0%A9%EB%B2%95%EB%A1%A0-2-project-packaging/
