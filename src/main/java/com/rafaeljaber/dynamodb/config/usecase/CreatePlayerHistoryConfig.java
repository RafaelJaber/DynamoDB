package com.rafaeljaber.dynamodb.config.usecase;

import com.rafaeljaber.dynamodb.adapter.CreatePlayerHistoryAdapter;
import com.rafaeljaber.dynamodb.application.core.usecase.CreatePlayerHistoryUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreatePlayerHistoryConfig {

    @Bean
    public CreatePlayerHistoryUseCase createPlayerHistoryUseCase(
            CreatePlayerHistoryAdapter createPlayerHistoryAdapter
    ) {
        return new CreatePlayerHistoryUseCase(createPlayerHistoryAdapter);
    }
}
