package com.trading.watchlist.UserWatchlist.configuration;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import com.trading.watchlist.UserWatchlist.model.UserTicker;
import org.springframework.context.annotation.Bean;
import java.util.Map;
import java.util.HashMap;

@Configuration
public class KafkaConfiguration {

	public ProducerFactory<String,UserTicker> producerFactory() {
		Map<String,Object> configMap = new HashMap<>();
		configMap.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"127.0.0.1:9092");
		configMap.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
		configMap.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,JsonSerializer.class);

		return new DefaultKafkaProducerFactory(configMap);
	}

	@Bean
	public KafkaTemplate<String,UserTicker> kafkaTemplate(){
		return new KafkaTemplate<>(producerFactory());
	}
}
