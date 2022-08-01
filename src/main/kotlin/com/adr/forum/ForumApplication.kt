package com.adr.forum

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
@EnableCaching
@OpenAPIDefinition(info = Info(title = "Reactive Forum", version = "1.0", description = "Documentation APIs v1.0"))
class ForumApplication

fun main(args: Array<String>) {
	runApplication<ForumApplication>(*args)
}
