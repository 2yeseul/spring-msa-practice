package com.example.apigatewayservice.configuration

import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.cloud.gateway.route.builder.filters
import org.springframework.cloud.gateway.route.builder.routes
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

//@Configuration
class FilterConfig {

    //@Bean
    fun gatewayRoutes(builder: RouteLocatorBuilder): RouteLocator {
        return builder.routes {
            route {
                this.path("/first-service/**")
                this.filters {
                    this.addRequestHeader("first-request", "first-request-header")
                    this.addResponseHeader("first-response", "first-response-header")
                }
                this.uri("http://localhost:8081")
            }

            route {
                this.path("/second-service/**")
                this.filters {
                    this.addRequestHeader("second-request", "second-request-header")
                    this.addResponseHeader("second-response", "second-response-header")
                }
                this.uri("http://localhost:8082")
            }
        }
    }
}