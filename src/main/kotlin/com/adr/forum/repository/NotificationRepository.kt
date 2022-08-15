package com.adr.forum.repository

import com.adr.forum.model.Notification
import org.springframework.data.jpa.repository.JpaRepository

interface NotificationRepository: JpaRepository<Notification, String> {
    abstract fun findByIdPayment(paymentId: String): Notification

}