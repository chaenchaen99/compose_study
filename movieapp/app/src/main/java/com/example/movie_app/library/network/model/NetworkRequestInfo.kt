package com.example.movie_app.library.network.model

class NetworkRequestInfo private constructor(
    //private constructor : 생성자를 외부에서 직접호출하지 못하도록 제한
    //이를 통해 Builder 클래스를 통해서만 객체를 생성할 수 있다
    val method: RequestType,
    val parameters: String?,
    val headers: Map<String, String>,
    val body: Any?,
) {

    class Builder(private val method: RequestType = RequestType.GET) {

        private val headers: MutableMap<String, String> = mutableMapOf()
        private var parameters: String? = null
        private var body: Any? = null

        fun withQueryParameters(queryParameters: String) = apply {//apply를 사용해 체이닝 가능하도록 설정
            parameters = queryParameters
        }

        fun withHeaders(headerMap: Map<String, String>) = apply {
            headers.putAll(headerMap)
        }

        fun withBody(requestBody: Any) = apply {
            body = requestBody
        }

        fun build(): NetworkRequestInfo {
            return NetworkRequestInfo(method, parameters, headers, body)
        }
    }
}
