package kr.co.point.common.entity.importData

import kr.co.point.common.enum_package.type.ImportType
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Import(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(updatable = false, insertable = false)
        var idx: Int? = null,

        @Enumerated(EnumType.STRING)
        var type: ImportType = ImportType.Join,

        var orderId: String? =null,
        var birth: String = "" /*(deprecated) birthday 를 사용해주세요. 관련공지내용 인증결과-생년월일 UNIX timestamp. 연, 월, 일만 의미있고
                           시,분,초는 의미없음 */,
        var birthday: String = "" /*인증결과-생년월일 ISO8601 형식의 문자열. YYYY-MM-DD 10자리 문자열*/,
        var carrier : String = "" /*인증결과-사용된 휴대폰번호의 통신사(신용카드 본인인증의 경우 해당사항없음). 통신사 사전승인이
                                    이뤄지지 않으면 carrier 속성은 존재하지 않습니다. 통신사 사전승인이 필요하므로 cs@iamport.kr 로
                                    다날 CPID 와 함께 사용승인 요청주시면 안내도와드리겠습니다. = ['SKT', 'KT', 'LGT', 'SKT_MVNO',
                                    'KT_MVNO', 'LGT_MVNO']*/,
        var certified: Boolean = true /*인증성공여부*/,
        var certified_at: String = "" /*인증처리시각 UNIX timestamp*/,
        var foreigner:  Boolean = false /*인증결과-외국인여부. true:외국인, false:내국인. 다날 본인인증서비스 계약시 외국인 구분기능
                                 추가 요청을 해주셔야 사용이 가능합니다. */,
        var foreigner_v2: Boolean = false,
        var gender: String? = null /*인증결과-성별. male:남성, female:여성*/,
        var imp_uid: String = "" /* string 타입의 아임포트 SMS본인인증처리 고유번호 */,
        var merchant_uid: String = "" /*string 타입의 가맹점 주문번호*/,
        var name: String = "" /*인증결과-실명 */,
        var origin: String = "" /*본인인증 프로세스가 진행된 웹 페이지의 URL*/,
        var pg_provider: String = "" /*SMS본인인증 제공 PG사 명칭. danal(다날)*/,
        var pg_tid: String = "" /*PG사 SMS본인인증결과 고유번호*/,
        var phone: String = "" /*인증결과-사용된 휴대폰번호(신용카드 본인인증의 경우 해당사항없음). 특수기호없이 숫자로만 구성된
                             휴대폰번호가 전달됨. 통신사 사전승인이 이뤄지지 않으면 phone 속성은 존재하지 않습니다. 통신사 사전승인이 필
                             요하므로 cs@iamport.kr 로 다날 CPID 와 함께 사용승인 요청주시면 안내도와드리겠습니다.*/,
        var unique_in_site: String? = null /*가맹점 내 개인 고유구분 식별키(다날 매뉴얼 기준 DI). 본인인증 PG MID별로 할당되는 개인 식별키 ,*/,
        var unique_key: String = "" /*개인 고유구분 식별키(다날 매뉴얼 기준 CI)*/,

        @CreationTimestamp
        var createDate: LocalDateTime = LocalDateTime.now(),

        @UpdateTimestamp
        var updateDate: LocalDateTime? = null,
)