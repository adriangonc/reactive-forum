package com.adr.forum.service

import com.adr.forum.model.Notification
import com.adr.forum.repository.NotificationRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class NotificationService(private val repository: NotificationRepository) {

    private val logger = LoggerFactory.getLogger(javaClass)

    fun findyAll(): MutableList<Notification> {
        return repository.findAll()
    }

    fun findByPaymentId(paymentId: String): MutableList<Notification>? {
        try {
            return repository.findByIdPayment(paymentId)
        } catch (e: Exception) {
            print(e.stackTraceToString())
        }
        return null
    }

    fun save(jsonNotification: Map<String, Object>) {


        var notification = Notification(
            notificationBody = jsonNotification.toString(),
            notificationSource = "Pagseguro",
            idPayment = jsonNotification["id"].toString(),
            statusPayment = jsonNotification["status"].toString()
        )
        try {
            repository.saveAndFlush(notification)
            logger.info(
                "Notification received " +
                        " idPayment: " + notification.idPayment +
                        " statusPayment: " + notification.statusPayment
            )
        } catch (e: Exception) {
            print(e.message)
        }

    }

}