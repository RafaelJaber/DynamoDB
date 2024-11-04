package com.rafaeljaber.dynamodb.config.usecase;

import com.rafaeljaber.dynamodb.adapter.FindPlayerHistoryByGameIdAndUsernameAdapter;
import com.rafaeljaber.dynamodb.application.core.usecase.FindPlayerHistoryByGameIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindPlayerHistoryByGameIdConfig {

    @Bean
    public FindPlayerHistoryByGameIdUseCase findPlayerHistoryByGameIdUseCase(
            FindPlayerHistoryByGameIdAndUsernameAdapter findPlayerHistoryByGameIdAndUsernameAdapter
    ) {
        return new FindPlayerHistoryByGameIdUseCase(findPlayerHistoryByGameIdAndUsernameAdapter);
    }

}
