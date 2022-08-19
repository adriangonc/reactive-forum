package com.adr.forum.controller

import com.adr.forum.model.Notification
import com.adr.forum.service.NotificationService
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/notification")
class NotificationController(private val service: NotificationService) {

    @PostMapping
    @Transactional
    fun receiveNotification(@RequestBody payload: Map<String, Any>){
        service.save(payload)
    }

    @GetMapping("/list")
    fun notifications(): MutableList<Notification> {
        return service.findAll()
    }

    @GetMapping("/payment/{id}")
    fun notificationByPaymentId(@PathVariable id: String): MutableList<Notification>? {
        return service.findByPaymentId(id)
    }
}