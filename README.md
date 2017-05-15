# Spring-boot-batch

- code from: <http://www.javainuse.com/spring/bootbatch>
- spring batch tutorial with boot <http://walkingtechie.blogspot.kr/2017/03/spring-batch-with-spring-boot.html>

## 기능적 요소

- 배치작업의 재시도, 재시작, 건너뛰기 등의 정책을 설정 가능
- Commit 개수, Rollback 개수, 재시도 횟수 등 배치 실행 통계정보를 제공

## 구성 요소

- Job repository: Job Execution 관련 메타데이터를 저장하는 기반 컴포넌트
- Job Launcher: Job Execution을 실행하는 기반 컴포넌트
- Job: 배치 처리를 의미하는 어플리케이션 컴포넌트(Step은 Job의 각 단계)
- Tasklet: Step내에서 반복 또는 트랜잭션 처리 용도로 사용되는 단일 연산

## 이슈 사례

- 데이터양이 증가할수록 성능 저하 현상 (조인해주세요)
- DB Connection timeout (paging으로 데이터를 잘라 읽어주세요)
