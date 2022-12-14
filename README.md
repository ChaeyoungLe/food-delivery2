![image](https://user-images.githubusercontent.com/487999/79708354-29074a80-82fa-11ea-80df-0db3962fb453.png)

# 예제 - 음식배달

본 예제는 MSA/DDD/Event Storming/EDA 를 포괄하는 분석/설계/구현/운영 전단계를 커버하도록 구성한 예제입니다.
이는 클라우드 네이티브 애플리케이션의 개발에 요구되는 체크포인트들을 통과하기 위한 예시 답안을 포함합니다.
- 체크포인트 : https://workflowy.com/s/assessment-check-po/T5YrzcMewfo4J6LW

## Model
www.msaez.io/#/storming/WYA32zfMDRQhJxkToRJuDE9i5zp2/d5226685a623b8b323accd0c25bb7041

![image](https://user-images.githubusercontent.com/45279406/203244496-55c57b1f-e1cc-4730-bb87-ec04a297b5b8.png)


# 서비스 시나리오

배달의 민족 커버하기 - https://1sung.tistory.com/106

기능적 요구사항
1. 고객이 메뉴를 선택하여 주문한다
1. 고객이 결제한다
1. 주문이 되면 주문 내역이 입점상점주인에게 전달된다
1. 상점주인이 확인하여 요리해서 배달 출발한다
1. 상점주인은 주문을 거절 할 수 있다.
1. 상점주인은 주문 수락 후 요리 시작과 요리 마침을 시스템 상태에 입력한다.
1. 상점주인이 확인하여 요리해서 배달 출발한다
1. 상점주인은 쿠폰을 발행할 수 있다.
1. 고객이 주문을 취소할 수 있다
1. 주문이 취소되면 배달이 취소된다
1. 고객이 주문상태를 중간중간 조회한다
1. 주문상태가 바뀔 때 마다 카톡으로 알림을 보낸다

비기능적 요구사항
1. 트랜잭션
    1. 결제가 되지 않은 주문건은 아예 거래가 성립되지 않아야 한다  Sync 호출 
1. 장애격리
    1. 상점관리 기능이 수행되지 않더라도 주문은 365일 24시간 받을 수 있어야 한다  Async (event-driven), Eventual Consistency
    1. 결제시스템이 과중되면 사용자를 잠시동안 받지 않고 결제를 잠시후에 하도록 유도한다  Circuit breaker, fallback
1. 성능
    1. 고객이 자주 상점관리에서 확인할 수 있는 배달상태를 주문시스템(프론트엔드)에서 확인할 수 있어야 한다  CQRS
    1. 배달상태가 바뀔때마다 카톡 등으로 알림을 줄 수 있어야 한다  Event driven
    
    
## 1.추가 기능
1. 쿠폰이 발행될 시 카카오 알림

![image](https://user-images.githubusercontent.com/45279406/203252598-35adbae1-46eb-44a4-bda8-dbcccf59968a.png)

![image](https://user-images.githubusercontent.com/45279406/203252997-18b08840-4fb0-47bd-9ae6-89429edbc023.png)

2. 상점주인은 주문을 거절 할 수 있으며 고객에게 알림이 간다

![image](https://user-images.githubusercontent.com/45279406/203254785-e1bb4f12-cad6-47ff-b961-e1da137dfcb0.png)

![image](https://user-images.githubusercontent.com/45279406/203254883-64b3fae2-59e7-4e14-a8c4-9434f9652b36.png)



3. 상점주인이 요리를 시작하거나 완료시 고객에게 알림이 간다.

![image](https://user-images.githubusercontent.com/45279406/203255172-8324a596-ef5b-4fde-af4e-adbd8a2dd2ff.png)

![image](https://user-images.githubusercontent.com/45279406/203254964-03d0026a-98bd-4a57-aa1a-e8ea22c38434.png)



## cors
![image](https://user-images.githubusercontent.com/45279406/203258906-bc8fd96d-5bf1-4a4a-afbd-edb5ff26d979.png)

![image](https://user-images.githubusercontent.com/45279406/203259273-d00186d2-587a-4490-9ae3-d399b9f9bb56.png)


## gateway
```
spring:
  profiles: docker
  cloud:
    gateway:
      routes:
        - id: app
          uri: http://app:8080
          predicates:
            - Path=/payments/**, /orders/**, /menus/**
        - id: store
          uri: http://store:8080
          predicates:
            - Path=/orders/**, /topMenus/**
        - id: kakao
          uri: http://kakao:8080
          predicates:
            - Path=/notificationLogs/**, /orderStates/**
        - id: delivery
          uri: http://delivery:8080
          predicates:
            - Path=/deliveItems/**, /checkItems/**
        - id: frontend
          uri: http://frontend:8080
          predicates:
            - Path=/**
      globalcors:
        corsConfigurations:
          '[/**]':
            allowedOrigins:
              - "*"
            allowedMethods:
              - "*"
            allowedHeaders:
              - "*"
            allowCredentials: true
```
