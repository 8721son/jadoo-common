package kr.co.point.common.http

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory
import org.springframework.util.MultiValueMap
import org.springframework.web.client.HttpClientErrorException
import org.springframework.web.client.HttpServerErrorException
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder

fun get(
    url: String,
    method: HttpMethod
): Map<String, Any> {
    return httpEntity(
        HttpHeaders(), "", null, url, method,
        MutableMap::class.java
    )
}

fun get(
    httpHeaders: HttpHeaders,
    url: String,
    method: HttpMethod
): Map<String, Any> {
    return httpEntity(httpHeaders, "", null, url, method, MutableMap::class.java)
}

fun get(
    httpHeaders: HttpHeaders,
    url: String,
    method: HttpMethod,
    paramMap: MutableMap<Any, Any>
): Map<String, Any> {
    return httpEntity(httpHeaders, "", paramMap, url, method, MutableMap::class.java)
}

fun get(
    httpHeaders: HttpHeaders,
    param: String,
    url: String,
    method: HttpMethod,
    responseType: Class<*>
): Map<String, Any> {
    return httpEntity(httpHeaders, param, null, url, method, responseType)
}

fun get(
    httpHeaders: HttpHeaders,
    paramMap: Map<Any, Any>,
    url: String,
    method: HttpMethod,
    responseType: Class<*>
): Map<String, Any> {
    return httpEntity(httpHeaders, null, paramMap, url, method, responseType)
}

private fun httpEntity(
    httpHeaders: HttpHeaders,
    param: String?,
    paramMap: Map<Any, Any>?,
    url: String,
    method: HttpMethod,
    responseType: Class<*>

): Map<String, Any> {

    val map: MutableMap<String, Any> = HashMap()
    try {
        val factory = HttpComponentsClientHttpRequestFactory()

        // 타임아웃 설정 5초
        factory.setConnectTimeout(5000)
        factory.setReadTimeout(5000)
        val restTemplate = RestTemplate(factory)

        val entity: HttpEntity<*> = if (param != null) {
            HttpEntity(param, httpHeaders)
        } else {
            HttpEntity(ObjectMapper().writeValueAsString(paramMap), httpHeaders)
        }
        val resultMap = restTemplate.exchange(
            UriComponentsBuilder.fromHttpUrl(url)
                                .build()
                                .toString(),
            method,
            entity,
            responseType
        )
        map["statusCode"] = resultMap.statusCodeValue //http status code를 확인
        map["header"] = resultMap.headers //헤더 정보 확인
        map["body"] = resultMap.body!! //실제 데이터 정보 확인
        
    } catch (e: HttpClientErrorException) {
        
        map["statusCode"] = e.rawStatusCode
        map["header"] = e.statusText
        map["body"] = e.message.toString()
        
    } catch (e: HttpServerErrorException) {

        map["statusCode"] = e.rawStatusCode
        map["header"] = e.statusText
        map["body"] = e.message.toString()
        
    } catch (e: Exception) {
        
        map["statusCode"] = 415
        map["body"] = "Exception: " + e.message
        
    }
    return map
}



fun httpForm(url: String, formMap: MultiValueMap<String, String>): MutableMap<String, Any> {

    val map: MutableMap<String, Any> = HashMap()
    try {

        val factory = HttpComponentsClientHttpRequestFactory()
        factory.setConnectTimeout(5000)
        factory.setReadTimeout(5000)

        val restTemplate = RestTemplate(factory)

        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_FORM_URLENCODED

        val request: HttpEntity<*> = HttpEntity(formMap, headers)

        val resultMap = restTemplate.exchange(
            UriComponentsBuilder.fromHttpUrl(url)
                .build()
                .toString(),
            HttpMethod.POST,
            request,
            MutableMap::class.java
        )

        map["statusCode"] = resultMap.statusCodeValue //http status code를 확인
        map["header"] = resultMap.headers //헤더 정보 확인
        map["body"] = resultMap.body!! //실제 데이터 정보 확인

    } catch (e: HttpClientErrorException) {

        map["statusCode"] = e.rawStatusCode
        map["header"] = e.statusText
        map["body"] = e.message.toString()

    } catch (e: HttpServerErrorException) {

        map["statusCode"] = e.rawStatusCode
        map["header"] = e.statusText
        map["body"] = e.message.toString()

    } catch (e: Exception) {

        map["statusCode"] = 415
        map["body"] = "Exception: " + e.message

    }
    return map

}