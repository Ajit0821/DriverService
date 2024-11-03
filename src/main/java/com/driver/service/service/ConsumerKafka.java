package com.driver.service.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerKafka {
        @KafkaListener(topics = "ride-events", groupId = "driver-group")
        public void consumeBookingEvent(Object message) {
            // Handle payment for the booking here
            System.out.println("Payment Service processing booking: " + message.toString());
            // You can also produce another event after processing (e.g., "payment-successful")
        }
    }
