# Spring-boot-batch

- code from: <http://www.javainuse.com/spring/bootbatch>
- spring batch tutorial with boot <http://walkingtechie.blogspot.kr/2017/03/spring-batch-with-spring-boot.html>

- in memory jobrepository issue: <http://stackoverflow.com/questions/25077549/spring-batch-without-persisting-metadata-to-database>
- spring-boot issue: <https://github.com/spring-projects/spring-boot/issues/3708>
- spring batch jobrepository를 h2DB로 쓰는 방법: <https://groups.google.com/forum/#!topic/ksug/fG8OmyKrJCE>
- <https://divinespear.blogspot.kr/2015/02/spring-boot-spring-batch.html>

>Spring-Batch needs a datasource that is registered under the name "dataSource" in the spring-context. If no spring-bean with that name is found, it creates its own. [http://stackoverflow.com/questions/37626682/spring-datasource-initialize-false-not-working]

**afterPropertiesSet()**

> afterPropertiesSet in interface org.springframework.beans.factory.InitializingBean
> 스프링은 InitializingBean 인터페이스에 정의된 메서드를 호출해서 빈 객체가 초기화를 진행할 수 있도록 한다. 

**JobExplorer**

JobRepository에 접근하여 배치작업에 대한 정보를 얻는 것

- ReadOnly, 그래서 Getter밖에 없다.

**JobRepository**

> 배치 작업중의 정보를 저장하는 역할을 수행함, 어떤 job이 언제 수행되고 언제 끝났고, 몇번 수행되었는지 배치 작업 수행과 관련된 모든 metadata가 저장되어 있다.
> CRUD를 지원

**MapJobExplorerFactoryBean**

> A FactoryBean that automates the creation of a SimpleJobExplorer using in-memory DAO implementations.

