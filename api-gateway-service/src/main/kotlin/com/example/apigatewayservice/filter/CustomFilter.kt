package com.example.apigatewayservice.filter

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.cloud.gateway.filter.GatewayFilter
import org.springframework.cloud.gateway.filter.GatewayFilterChain
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory
import org.springframework.http.server.reactive.ServerHttpRequest
import org.springframework.http.server.reactive.ServerHttpResponse
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono

@Component
class CustomFilter : AbstractGatewayFilterFactory<CustomFilter.Config>(
    Config::class.java
) {
    private val log: Logger = LoggerFactory.getLogger(CustomFilter::class.java)

    override fun apply(config: Config): GatewayFilter {
        return GatewayFilter { exchange: ServerWebExchange, chain: GatewayFilterChain ->
            val request: ServerHttpRequest = exchange.request
            val response: ServerHttpResponse = exchange.response

            log.info("Custom PRE filter : request uri -> ${request.id}")

            chain.filter(exchange).then(Mono.fromRunnable {
                log.info("Custom POST filter : response code -> ${response.statusCode}")
            })
        }
    }

    object Config {

    }
}

