# Step2(2023-08-30) #
    * GitHub(HTTP)
        * [x] GET, https://api.github.com/repositories
        * [x] full_name, description 필드만
        * [x] Repository 목록을 가져오는 기능은 data 모듈에 구현되어야 한다.
        * [x] data 모듈의 구현체는 모두 internal class로 선언한다.
        * [x]HTTP 요청을 통해 가져오는 구현체에 대한 테스트 코드를 작성한다.

# Step1(2023-08-29) #
    * GitHub(모듈 분리)
        * [x] 순수 코틀린 모듈인 domain 모듈을 만든다.
        * [x] 순수 코틀린 모듈인 data 모듈을 만든다.
        * [x] data 모듈은 domain 모듈에 의존해야 한다.
        * [x] app 모듈은 domain 모듈에 의존해야 한다.
    * 1차 피드백
        * [x] Android Studio linebreak 설정 추가
