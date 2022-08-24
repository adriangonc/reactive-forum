package com.adr.forum.util

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.ContextStoppedEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Service

@Service
class StartStopEventListener {

    @Value("\${spring.profiles.active}")
    lateinit var env: String

    @EventListener
    fun onStartup(event: ApplicationReadyEvent) = print("Profile de inicializacao: ${env}")

    @EventListener
    fun onShutdown(event: ContextStoppedEvent) = print("Aplicacao desligada!")

}