package camp.nextstep.edu.github.domain

/**
 * 클래스에 대한 간단한 설명이나 참고 url을 남겨주세요.
 * Created by jeongjinhong on 2022. 08. 05..
 */
//공부용 주석 :
// data class는 == 을 할때 생성자내의 값들을 자동으로 다 비교해줌,,
// 단 주생성자가 아닌 프로퍼티값은 비교해주지않기에 프로퍼티도 비교를 원하면 직접 equals를 오버라이드해서 구현해야함
data class Github(
    val fullName: String?,
    val description: String?
)