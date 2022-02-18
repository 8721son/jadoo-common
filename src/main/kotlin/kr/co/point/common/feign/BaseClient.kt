package kr.co.point.common.feign

import org.springframework.web.bind.annotation.GetMapping

interface BaseClient {
    @GetMapping("/actuator/health")
    fun health(): ActuatorHealthResponse
}

class ActuatorHealthResponse {
    var status: String = ""
}