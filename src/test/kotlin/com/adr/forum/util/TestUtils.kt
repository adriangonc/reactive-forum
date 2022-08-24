package com.adr.forum.util

import com.adr.forum.model.Notification
import io.mockk.InternalPlatformDsl.toStr
import java.time.LocalDateTime
import java.util.*

fun createNotification(): Notification {
    return Notification(
        id = UUID.randomUUID().toStr(),
        creationDate = LocalDateTime.now(),
        idPayment = idPayment,
        notificationBody = notificationMap.toString(),
        notificationSource = "Test",
        statusPayment = "PAID",
        userEmail = "teste@teste.com"
    )
}

fun createJsonNotification(): Map<String, Any> {
    return notificationMap
}

fun createEmptyJsonNotification(): Map<String, Any> {
    return notificationMapEmpty
}

val notificationMap = hashMapOf<String, Any>("id" to "A1B2_id_payment", "status" to "PAID")
val notificationMapEmpty = hashMapOf<String, Any>()
const val idPayment = "A1B2_id_payment"
