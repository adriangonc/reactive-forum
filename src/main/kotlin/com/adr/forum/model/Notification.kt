package com.adr.forum.model

import java.time.LocalDateTime
import java.util.UUID
import javax.persistence.*

@Entity
@Table(name="TB_NOTIFICATION")
data class Notification (
    @Id
    var id: String = generateId(),
    val creationDate : LocalDateTime = java.time.LocalDateTime.now(),
    val notificationBody: String,
    val notificationSource: String,
    val idPayment: String,
    val statusPayment: String
) {
    companion object {
        private const val prefix = "NOTIFICATION_"

        private fun generateId(): String {
            return prefix + UUID.randomUUID().toString()
        }
    }
}