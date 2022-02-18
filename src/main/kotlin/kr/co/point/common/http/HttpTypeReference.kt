package kr.co.point.common.http

import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

class HttpTypeReference {

    private var type: Type? = null

    fun HttpTypeReference() {
        val superClassType = javaClass.genericSuperclass
        if (superClassType is ParameterizedType) {
            type = superClassType.actualTypeArguments[0]
        } else {
            throw IllegalArgumentException("TypeReference는 항상 실제 타입 파라미터 정보가 있어야 합니다.")
        }
    }

    fun getType(): Type? {
        return type
    }
}

//public static List<VirtualnumberApiDTO> api050List_Result (String type) {
//    Map<String, Object> map = Http050.api050List(type);
//    var bodyExpire = (Map<?,?>) map.get("body");
//    try {
//        final HttpTypeReference<List<VirtualnumberApiDTO>> typeReference = new HttpTypeReference<>(){};
//
//        return new Gson().fromJson(new ObjectMapper().writeValueAsString(bodyExpire.get("rec")),
//            typeReference.getType());
//    } catch (JsonProcessingException e) {
//        e.printStackTrace();
//        return null;
//    }
//}