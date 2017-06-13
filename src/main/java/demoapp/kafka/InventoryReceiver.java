package demoapp.kafka;

import demoapp.dto.InventoryDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class InventoryReceiver {

    @KafkaListener(topics = "${kafka.topic.ims.icc.inventory}")
    public void receive(InventoryDTO inventoryDTO) {
        log.info("Received: {}", inventoryDTO);
    }

}
