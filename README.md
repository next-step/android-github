# android-github

## 1 단계 - GitHub(모듈 분리)
### 프로그래밍 요구 사항
- 순수 코틀린 모듈인 domain 모듈을 만든다.
- 순수 코틀린 모듈인 data 모듈을 만든다.
- data 모듈은 domain 모듈에 의존해야 한다.
- app 모듈은 domain 모듈에 의존해야 한다.

## 2단계 - GitHub(HTTP)
###기능 요구사항
- GitHub Repository 목록을 가져올 수 있어야 한다.
- GET, https://api.github.com/repositories
- full_name, description 필드만

###프로그래밍 요구사항
- Repository 목록을 가져오는 기능은 data 모듈에 구현되어야 한다.
- data 모듈의 구현체는 모두 internal class로 선언한다.
- HTTP 요청을 통해 가져오는 구현체에 대한 테스트 코드를 작성한다.
- OkHttp MockWebServer 이용