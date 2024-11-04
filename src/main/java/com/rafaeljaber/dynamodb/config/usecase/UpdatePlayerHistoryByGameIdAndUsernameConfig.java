package com.rafaeljaber.dynamodb.config.usecase;

import com.rafaeljaber.dynamodb.adapter.UpdatePlayerHistoryAdapter;
import com.rafaeljaber.dynamodb.application.core.usecase.FindPlayerHistoryByGameIdUseCase;
import com.rafaeljaber.dynamodb.application.core.usecase.UpdatePlayerHistoryByGameIdAndUsernameUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdatePlayerHistoryByGameIdAndUsernameConfig {

    @Bean
    public UpdatePlayerHistoryByGameIdAndUsernameUseCase updatePlayerHistoryByGameIdAndUsernameUseCase(
            FindPlayerHistoryByGameIdUseCase findPlayerHistoryByGameIdUseCase,
            UpdatePlayerHistoryAdapter updatePlayerHistoryAdapter
    ) {
        return new UpdatePlayerHistoryByGameIdAndUsernameUseCase(
                findPlayerHistoryByGameIdUseCase,
                updatePlayerHistoryAdapter
        );
    }

}
