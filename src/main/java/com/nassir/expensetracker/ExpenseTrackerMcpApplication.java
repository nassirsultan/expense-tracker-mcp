package com.nassir.expensetracker;

import com.nassir.expensetracker.tools.PingTools;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExpenseTrackerMcpApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseTrackerMcpApplication.class, args);
	}

	@Bean
	ToolCallbackProvider tools(PingTools pingTools) {
		return MethodToolCallbackProvider.builder()
				.toolObjects(pingTools)
				.build();
	}
}