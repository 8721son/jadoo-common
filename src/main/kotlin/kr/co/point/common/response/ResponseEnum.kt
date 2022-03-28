package kr.co.point.common.response

enum class ResponseEnum (var code: Int, var message: String?) {
    ERROR(0, "알 수 없는 오류입니다."),

    QNA_LIST_SELECT_SUCCESS(200, "문의하기 리스트 조회가 완료되었습니다."),
    QNA_DETAIL_SELECT_SUCCESS(200, "문의하기 조회가 완료되었습니다."),
    QNA_DETAIL_SELECT_FAIL(-200, "존재하지 않은 문의하기입니다."),
    QNA_DETAIL_DIFF_SELECT_FAIL(-300, "자기가 쓴 글만 읽을 수 있습니다."),
    QNA_SAVE_SUCCESS(200, "문의하기 작성이 완료되었습니다."),

    COUPANG_MAIN_SELECT_SUCCESS(200, "쿠팡 메인 조회가 완료되었습니다."),
    COUPANG_CATEGORY_SELECT_SUCCESS(200, "카테고리 조회가 완료되었습니다."),
    COUPANG_CATEGORY_PRODUCT_SELECT_SUCCESS(200, "상품 (카테고리) 조회가 완료되었습니다."),
    COUPANG_GOLDEN_PRODUCT_SELECT_SUCCESS(200, "상품 (골드 박스) 조회가 완료되었습니다."),
    COUPANG_PL_PRODUCT_SELECT_SUCCESS(200, "상품 (PL) 조회가 완료되었습니다."),
    COUPANG_SEARCH_PRODUCT_SELECT_SUCCESS(200, "상품 검색이 완료되었습니다."),
    COUPANG_SEARCH_PRODUCT_SELECT_FAIL(-200, "검색 횟수를 초과했습니다."),
    COUPANG_BANNER_SELECT_SUCCESS(200, "배너 조회가 완료되었습니다."),
    COUPANG_CATEGORY_SELECT_FAIL(-200, "존재하지 않는 카테고리입니다."),
    COUPANG_LOGIN_SUCCESS(200, "로그인 확인이 완료되었습니다."),
    COUPANG_LOGIN_FAIL(-200, "로그인 확인이 실패했습니다."),
    COUPANG_LOGIN_AUTH_FAIL(-200, "문자인증 확인이 실패했습니다."),
    COUPANG_LOGIN_AUTH_SUCCESS(200, "문자인증 확인이 완료되었습니다."),


    MYPOINT_SELECT_SUCCESS(200, "브릭스 내역 조회가 완료 되었습니다."),

    MEMBER_EMAIL_SELECT_FAIL(-200, "회원 조회를 실패했습니다."),
    MEMBER_SELECT(200, "회원 조회를 성공했습니다."),
    MEMBER_EMAIL_FAIL(-200, "이메일이 중복입니다."),
    MEMBER_NICKNAME_FAIL(-200, "닉네임이 중복입니다."),
    MEMBER_CERT_CHECK_FAIL(-200, "이미 가입된 회원입니다."),
    MEMBER_CERT_CHECK_SANCTION_FAIL(-300, "제재 된 회원입니다."),
    MEMBER_CERT_UID_FAIL(-400, "인증되지 않은 회원입니다."),
    MEMBER_CERT_CHECK_SUCCESS(200, "가입 가능합니다"),
    MEMBER_EMAIL_SUCCESS(200, "사용할 수 있는 이메일입니다."),
    MEMBER_NICKNAME_SUCCESS(200, "사용할 수 있는 닉네임입니다."),
    MEMBER_EMAIL_CERT_SUCCESS(200, "이메일 인증이 완료되었습니다."),
    MEMBER_EMAIL_FIND_SUCCESS(200, "이메일 찾기가 완료되었습니다."),
    MEMBER_PASSWORD_FIND_SUCCESS(200, "비밀번호 찾기가 완료되었습니다."),
    MEMBER_PASSWORD_RESET_SUCCESS(200, "비밀번호 초기화가 완료되었습니다."),
    MEMBER_EMAIL_AUTH_FAIL(-200, "인증번호 전송에 실패했습니다."),
    MEMBER_EMAIL_CERT_FAIL(-200, "잘못된 코드입니다."),
    MEMBER_PASSWORD_RESET_FAIL(-400, "잘못된 접근입니다."),
    MEMBER_PASSWORD_INCONSISTENCY_FAIL(-300, "비밀번호가 일치하지 않습니다."),
    MEMBER_CREATE(200, "회원가입을 성공했습니다."),
    MEMBER_CREATE_ERROR(-200, "인증 실패입니다."),
    MEMBER_FAIL(0, "회원 조회를 실패했습니다."),
    MEMBER_DETAIL_FAIL(-400, "회원 조회를 실패했습니다."),
    MEMBER_POINT_LACK_FAIL(-300, "포인트가 부족합니다."),
    MEMBER_EDIT_SUCCESS(200, "회원 정보 수정을 성공했습니다."),
    MEMBER_EDIT_OAUTH_SUCCESS(200, "정상적으로 반영되었습니다."),
    MEMBER_EDIT_OAUTH_FAIL(-200, "중복됨."),
    MEMBER_EXIT_REASON_FAIL(-400, "탈퇴 사유가 없습니다."),
    MEMBER_EXIT_SUCCESS(200, "탈퇴가 완료되었습니다."),
    MEMBER_EDIT_FAIL(-200, "회원 정보 수정을 실패했습니다."),
    MEMBER_EDIT_DUPLICATE(-200, "중복됨."),
    MEMBER_EDIT_BLACK_LIST(-300, "사용할 수 없는 닉네임입니다."),
    MEMBER_EDIT_FRIEND(200, "프렌드 변경에 성공했습니다."),
    MEMBER_EDIT_FRIEND_FAIL(-200, "프렌드 변경에 실패했습니다."),

    MY_BANNER_LIST_SUCCESS(200, "배너 조회를 성공했습니다."),
    MD_LIST_SUCCESS(200, "MD 상품 조회를 성공했습니다."),
    MAGAZINE_LIST_SUCCESS(200, "매거진 조회를 성공했습니다."),
    MAGAZINE_CATEGORY_LIST_SUCCESS(200, "매거진 카테고리 조회를 성공했습니다."),

    KEYWORD_LIST_SUCCESS(200, "추천 키워드 조회를 성공했습니다."),

    MEMBER_DUPLICATION_EMAIL(-1, "이메일이 중복됩니다."),
    MEMBER_EMAIL_CHECK_FAIL(-2, "이메일 인증을 진행해주세요."),
    MEMBER_EMAIL_CODE_FAIL(-3, "이메일 인증코드를 확인해주세요."),
    MEMBER_VALIDATION_PHONE(-4, "전화번호를 확인해주세요."),
    MEMBER_VALIDATION_PASSWORD(-5, "패스워드를 확인해주세요."),
    MEMBER_VALIDATION_IMPORT(-6, "인증에 실패했습니다."),
    MEMBER_DUPLICATION_PHONE(-7, "이미 가입된 전화번호입니다."),
    MEMBER_SANCTION(-8, "이용이 중지된 사용자입니다."),


    FCM_CREATE(200, "FCM 생성을 성공했습니다."),
    FCM_TOKEN_EXIST(-200, "토큰이 이미 존재합니다."),
    FCM_TOKEN_NOT_EXIST(-200, "토큰이 존재하지 않습니다."),
    FCM_TOKEN_MEMBER_UPDATE(200, "FCM 토큰 회원 매칭이 완료되었습니다."),
    FCM_TOKEN_AGREE_UPDATE(200, "알림 동의 여부가 수정되었습니다."),
    FCM_TOKEN_AGREE_SELECT(200, "알림 동의 조회가 완료되었습니다."),

    MY_FAIL(-200, "회원 조회(Friends)를 실패했습니다."),
    MY_SUCCESS(200, "회원 조회를 성공했습니다."),

    INTRODUCE_SUCCESS(200, "정보 조회를 성공했습니다."),

    AUTH_400_FAIL(0, "인증 서버 오류입니다."),
    AUTH_FAIL(0, "인증 정보가 유효하지 않습니다."),

    POINT_SELECT(200, "포인트 조회를 성공했습니다."),

    TAG_SELECT_SUCCESS(200, "태그 조회를 성공했습니다."),
    TAG_NO(-300, "태그가 존재하지 않습니다."),

    MEMBER_TAG_DUPLICATION(-200, "이미 존재하는 태그입니다."),
    MEMBER_TAG_SAVE_SUCCESS(200, "태그 생성이 완료되었습니다."),
    MEMBER_TAG_DELETE_SUCCESS(200, "태그 삭제가 완료되었습니다."),
    MEMBER_TAG_SELECT_SUCCESS(200, "태그 조회를 성공했습니다."),

    CAMPAIGN_SELECT_FAIL(-200, "캠패인이 존재하지 않습니다."),
    CAMPAIGN_LIKE_SAVE_SUCCESS(200, "관심 캠패인이 등록되었습니다."),
    CAMPAIGN_LIKE_CALCEL_SUCCESS(200, "관심 캠패인이 취소가 완료되었습니다."),
    CAMPAIGN_LIKE_SELECT_SUCCESS(200, "관심 캠패인 조회가 완료되었습니다."),
    CAMPAIGN_DONATE_SELECT_SUCCESS(200, "후원한 캠패인 조회가 완료되었습니다."),
    CAMPAIGN_CURRENT_SELECT_SUCCESS(200, "진행중인 캠패인 조회가 완료되었습니다."),
    CAMPAIGN_TAG_LIKE_SELECT_SUCCESS(200, "내가 등록한 TAG와 관련된 캠패인 조회가 완료되었습니다."),
    CAMPAIGN_ALL_SELECT_SUCCESS(200, "캠패인 조회가 완료되었습니다."),
    CAMPAIGN_DEADLINE_SELECT_SUCCESS(200, "마감 임박 캠패인 조회가 완료되었습니다."),
    CAMPAIGN_DETAIL_SELECT_SUCCESS(200, "캠패인 상세내역 조회가 완료되었습니다."),
    CAMPAIGN_TAG_SEARCH_SELECT_SUCCESS(200, "캠패인 태그 검색이 완료되었습니다."),
    CAMPAIGN_SEARCH_SELECT_SUCCESS(200, "캠패인 검색이 완료되었습니다."),
    CAMPAIGN_DETAIL_SELECT_FAIL(-200, "캠패인 상세내역이 없습니다."),
    CAMPAIGN_CONTRIBUTOR_SELECT_SUCCESS(200, "후원자 목록 조회에 성공했습니다."),

    CATEGORY_LIST_SELECT_SUCCESS(200, "카테고리 목록 조회에 성공했습니다."),
    RANK_SELECT_SUCCESS(200, "랭킹 조회에 성공했습니다."),

    FOUNDATION_LIST_SUCCESS(200, "후원사 목록 조회에 성공했습니다."),
    FOUNDATION_DETAIL_SUCCESS(200, "후원사 상세 조회에 성공했습니다."),
    FOUNDATION_CAMPAIGN_SUCCESS(200, "후원사 관련 캠페인 조회가 완료되었습니다."),


    DONATE_SUCCESS(200, "기부를 성공했습니다."),

    FILE_SAVE(200, "파일 저장에 성공하였습니다."),
    FILE_SAVE_FAIL(1, "파일 저장에 실패하였습니다. 관리자에게 문의해주세요."),
    FILE_DETAIL_DELETE_SUCCESS(200, "파일 삭제가 완료되었습니다."),

    BOOTPAY_SUBMIT_SUCCESS(200,"결제 승인에 성공했습니다."),
    BOOTPAY_PG_FAIL(-600,"PG 오류입니다. 확인 후 연락드리겠습니다."),
    BOOTPAY_SUBMIT_CANCEL(-100,"결제가 취소되었습니다."),
    BOOTPAY_SUBMIT_FAIL(-300,"결제에 실패했습니다."),
    BOOTPAY_SEVICE_ERROR(-400,"부트페이 서버와 통신에 실패했습니다."),
    BOOTPAY_AUTH_SUCCESS(200,"성인 인증에 성공했습니다."),
    BOOTPAY_AUTH_FAIL(-200,"성인 인증에 실패했습니다."),
    BOOTPAY_VBANK_SELECT(200,"가상계좌 결제정보 조회에 성공했습니다."),
    BOOTPAY_AUTH_CHECK_SUCCESS(200,"인증에 성공했습니다."),
    BOOTPAY_AUTH_CHECK_FAIL(-200,"인증에 실패했습니다."),
    BOOTPAY_PRICE_FAIL(-500,"결제는 100원 단위로만 가능합니다."),

    ORDER_NOT_FOUND(-200,"주문을 찾을 수 없습니다."),

    COUPANG_SYNC_SUCCESS(200, "동기화가 완료되었습니다."),
    COUPANG_SYNC_JSON_FAIL(-200, "Json 변환 오류입니다."),
    COUPANG_SYNC_NO_DATA(-300, "내역이 존재하지 않습니다."),
    COUPANG_VIDEO_LIST_SUCCESS(200, "비디오 리스트 조회가 완료되었습니다."),
    COUPANG_VIDEO_SUCCESS(200, "비디오 조회를 성공했습니다."),
    COUPANG_VIDEO_FAIL(-200, "비디오 조회를 실패했습니다."),

    AREA_SELECT_SUCCESS(200,"지역 조회에 성공했습니다."),
    TALENT_CATEGORY_SUCCESS(200,"카테고리 조회에 성공했습니다."),
    TALENT_REGISTER_SUCCESS(200,"재능기부 프로젝트 저장에 성공했습니다."),
    TALENT_ATTENDANCE_SUCCESS(200,"재능기부 프로젝트 참여에 성공했습니다."),
    TALENT_ATTENDANCE_FAIL(-200,"재능기부 프로젝트 참여에 실패했습니다."),
    TALENT_EXIT_SUCCESS(200,"재능기부 프로젝트 참여 취소에 성공했습니다."),
    TALENT_EXIT_FAIL(-200,"재능기부 프로젝트 참여 취소에 실패했습니다."),
    TALENT_INTEREST_SUCCESS(200,"재능기부 관심 등록에 성공했습니다."),
    TALENT_INTEREST_FAIL(-200,"재능기부 관심 등록에 실패했습니다."),
    TALENT_INTEREST_CANCEL_SUCCESS(200,"재능기부 관심 등록 취소에 성공했습니다."),
    TALENT_INTEREST_CANCEL_FAIL(-200,"재능기부 관심 등록 취소에 실패했습니다."),
    TALENT_CANCEL_SUCCESS(-200,"재능기부 중단에 성공했습니다."),
    TALENT_CANCEL_FAIL(-200,"재능기부 중단에 실패했습니다."),
    TALENT_FIND_SUCCESS(200,"재능기부 조회에 성공했습니다."),
    TALENT_COMMENT_SUCCESS(200,"재능기부 문의 작성에 성공했습니다."),
    TALENT_COMMENT_FAIL(-200,"재능기부 문의 작성에 실패했습니다."),
    TALENT_REPLY_SUCCESS(200,"문의 댓글 작성에 성공했습니다."),
    TALENT_REPLY_FAIL(-200,"문의 댓글 작성에 실패했습니다."),
    TALENT_GIFT_SUCCESS(200,"브릭스 선물에 성공했습니다."),
    TALENT_GIFT_FAIL(-200,"브릭스 선물에 실패했습니다."),

    PARTNERS_PURCHASE_LIST_SUCCESS(200,"구매 내역 조회에 성공했습니다."),
    PARTNERS_CHANGE_LIST_SUCCESS(200,"교환/환불 내역 조회에 성공했습니다."),
    PARTNERS_REVIEW_WRITE_SUCCESS(200,"리뷰 작성에 성공했습니다."),
    PARTNERS_REVIEW_WRITE_ALREADY(200,"이미 리뷰를 작성하였습니다."),
    PARTNERS_REVIEW_SELECT_SUCCESS(200,"리뷰 조회에 성공했습니다."),
    PARTNERS_REVIEW_DELETE_SUCCESS(200,"리뷰 삭제에 성공했습니다."),
    PARTNERS_REVIEW_DELETE_FAIL(-200,"리뷰 삭제에 실패했습니다."),
    PARTNERS_LIKE_SUCCESS(200,"관심 등록에 성공했습니다."),
    PARTNERS_LIKE_CANCEL_SUCCESS(200,"관심 등록 취소에 성공했습니다."),
    PARTNERS_LIKE_LIST_SUCCESS(200,"관심 파트너스 조회에 성공했습니다."),
    PARTNERS_CONFIRM_SUCCESS(200,"구매 확정에 성공했습니다."),

    PARTNERS_MAIN_BANNER_SUCCESS(200,"파트너스 배너 조회에 성공했습니다."),
    PARTNERS_MAIN_CATEGORY_SUCCESS(200,"카테고리 조회에 성공했습니다."),
    PARTNERS_MAIN_LATEST_SUCCESS(200,"최근 본 목록 조회에 성공했습니다."),
    PARTNERS_MAIN_POPULAR_SUCCESS(200,"인기 상품 조회에 성공했습니다."),
    PARTNERS_MAIN_LIKE_PRODUCT_SUCCESS(200,"관심 상품 조회에 성공했습니다."),
    PARTNERS_MAIN_LIKE_PARTNERS_SUCCESS(200,"관심 파트너스 조회에 성공했습니다."),
    PARTNERS_CATEGORY_SEARCH_SUCCESS(200,"카테고리 조회에 성공했습니다."),
    PARTNERS_PRODUCT_SEARCH_SUCCESS(200,"파트너스 상품 조회에 성공했습니다."),

    CRAWLING_FAIL(0, "크롤링을 실패했습니다."),

    ADMOB_VERIFY_SUCCESS(200, "광고 시청 검증에 성공했습니다."),
    ADMOB_VERIFY_FAIL(-200, "광고 시청 검증에 실패했습니다."),
    ADMOB_FAIL_LOG_SUCCESS(200, "광고 실패 로그 저장에 성공했습니다.");

}