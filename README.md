# Step3(2023-09-01) #
    * GitHub(UI)
        * [x] 앱을 실행하면 리스트 형태의 GitHub Repository UI가 보여야 한다.
        * [x] MVVM 패턴으로 구현한다.
        * [x] Dagger2, Hilt를 이용하여 의존성을 주입한다.
        * [x] Domain 테스트 코드 추가
        * [x] ViewModel 테스트 코드 추가

# Step2(2023-08-30) #
    * GitHub(HTTP)
        * [x] GET, https://api.github.com/repositories
        * [x] full_name, description 필드만
        * [x] Repository 목록을 가져오는 기능은 data 모듈에 구현되어야 한다.
        * [x] data 모듈의 구현체는 모두 internal class로 선언한다.
        * [x]HTTP 요청을 통해 가져오는 구현체에 대한 테스트 코드를 작성한다.
    * 1차 피드백
        * [x] Mapper 함수 최상단으로 끌어올리기
        * [x] githubRepository.json 필요없는 부분 제거
        * [x] 테스트 코드 함수명 수정
        * [x] GithubService 주석 수정

# Step1(2023-08-29) #
    * GitHub(모듈 분리)
        * [x] 순수 코틀린 모듈인 domain 모듈을 만든다.
        * [x] 순수 코틀린 모듈인 data 모듈을 만든다.
        * [x] data 모듈은 domain 모듈에 의존해야 한다.
        * [x] app 모듈은 domain 모듈에 의존해야 한다.
    * 1차 피드백
        * [x] Android Studio linebreak 설정 추가
