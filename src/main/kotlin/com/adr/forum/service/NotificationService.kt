package com.adr.forum.service

import com.adr.forum.exception.NotFoundException
import com.adr.forum.model.Notification
import com.adr.forum.repository.NotificationRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.io.IOException
import java.util.regex.Pattern

@Service
class NotificationService(private val repository: NotificationRepository) {

    private val logger = LoggerFactory.getLogger(javaClass)

    fun findAll(): MutableList<Notification> {
        return repository.findAll()
    }

    fun findByPaymentId(paymentId: String): MutableList<Notification>? {
        return repository.findByIdPayment(paymentId).ifEmpty { throw NotFoundException("Notificacao nao encontrada!") }
    }


    fun save(jsonNotification: Map<String, Any>): Notification {

        if(jsonNotification.isNullOrEmpty()){
            throw Exception("Empty Json")
        }

        var notification = Notification(
            notificationBody = jsonNotification.toString(),
            notificationSource = "Pagseguro",
            idPayment = jsonNotification["id"].toString(),
            statusPayment = jsonNotification["status"].toString(),
            userEmail = getEmailAddressInString(jsonNotification["payment_method"].toString())
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
        return notification
    }

    fun getEmailAddressInString(text: String): String {
        var email: String = "nd"
        val matcher =
            Pattern.compile("[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}")
                .matcher(text)
        while (matcher.find()) {
            email = (matcher.group())
            return email
        }
        return email
    }


}