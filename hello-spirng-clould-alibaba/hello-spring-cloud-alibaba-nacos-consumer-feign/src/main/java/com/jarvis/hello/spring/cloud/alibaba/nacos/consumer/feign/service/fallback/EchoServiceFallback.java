package com.jarvis.hello.spring.cloud.alibaba.nacos.consumer.feign.service.fallback;
import com.jarvis.hello.spring.cloud.alibaba.nacos.consumer.feign.service.EchoService;
import org.springframework.stereotype.Component;

@Component
public class EchoServiceFallback implements EchoService {
	@Override
	public String echo(String message) {
		return "触发熔断调用： fallback";
	}
}