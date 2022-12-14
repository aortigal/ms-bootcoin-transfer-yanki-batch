package com.bank.msbootcointransferyankibatch.producer;

import com.bank.msbootcointransferyankibatch.models.utils.DataEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {

    private static final Logger log = LoggerFactory.getLogger(KafkaProducer.class);

    @Value("${kafka.topic.transactionYanki}")
    private String topicTransactionYanki;

    @Value("${kafka.topic.paymentYanki}")
    private String topicPaymentYanki;

    @Value("${kafka.topic.transactionBootCoin}")
    private String topicTransactionBootCoin;

    @Autowired
    private KafkaTemplate<String, DataEvent<?>> producer;

    public void sendMessageTransactionYanki(DataEvent<?> dataEvent) {
        log.info("Producing topic {}, message {}",topicTransactionYanki, dataEvent.toString());
        this.producer.send(topicTransactionYanki, dataEvent);
    }

    public void sendMessagePaymentYanki(DataEvent<?> dataEvent) {
        log.info("Producing topic {}, message {}",topicPaymentYanki, dataEvent.toString());
        this.producer.send(topicPaymentYanki, dataEvent);
    }

    public void sendMessageTransactionBootCoin(DataEvent<?> dataEvent) {
        log.info("Producing topic {}, message {}",topicTransactionBootCoin, dataEvent.toString());
        this.producer.send(topicTransactionBootCoin, dataEvent);
    }

}