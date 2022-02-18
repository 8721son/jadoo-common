package kr.co.point.common.util

import kr.co.point.common.enum_package.type.ServiceType

fun type(serviceType: ServiceType, domain: String): String {
    return "$domain${serviceType.serviceName}"
}