package demoapp.kafka;

import demoapp.dto.InventoryDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Slf4j
@Component
public class InventorySender {

    @Autowired
    private KafkaTemplate<String, InventoryDTO> kafkaTemplate;

    @Value("${kafka.topic.ims.icc.inventory}")
    private String kafkaTopic;

    public void send(final InventoryDTO inventoryDTO) {
        // the KafkaTemplate provides asynchronous send methods returning a Future
        ListenableFuture<SendResult<String, InventoryDTO>> future = kafkaTemplate.send(kafkaTopic, inventoryDTO);

        // you can register a callback with the listener to receive the result of the send asynchronously
        future.addCallback(new ListenableFutureCallback<SendResult<String, InventoryDTO>>() {
            @Override
            public void onSuccess(SendResult<String, InventoryDTO> result) {
                String uniqueOffset = String.format("%s-%s-%s", result.getRecordMetadata().topic(),
                        result.getRecordMetadata().partition(),
                        result.getRecordMetadata().offset());
                log.debug("success with offset={}", uniqueOffset);
            }

            @Override
            public void onFailure(Throwable ex) {
                log.error("failure: {}", ex.getMessage(), ex);
            }
        });

    }
}
