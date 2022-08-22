package com.adr.forum.domain

import com.adr.forum.util.createEmptyJsonNotification
import com.adr.forum.util.createJsonNotification
import com.adr.forum.util.createNotification

import com.adr.forum.repository.NotificationRepository
import com.adr.forum.service.NotificationService

import io.mockk.mockk
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.test.context.ActiveProfiles

@ActiveProfiles("dev")
internal class NotificationServiceTest {
    private val notificationRepository = mockk<NotificationRepository>()
    private val notificationService = NotificationService(notificationRepository)

    @Test
    fun `Should save notification`() {
        Assertions.assertEquals(notification.idPayment, notificationService.save(notificationJson).idPayment)
    }

    @Test
    fun `Should throw exception when json body is null`(){

        Assertions.assertThrows(Exception::class.java) {
            notificationService.save(emptyNotificationJson)
        }
    }


    private val notification = createNotification()
    private val notificationJson = createJsonNotification()
    private val emptyNotificationJson = createEmptyJsonNotification()

}