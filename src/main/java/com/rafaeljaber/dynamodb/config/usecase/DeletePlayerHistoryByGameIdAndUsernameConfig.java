package com.rafaeljaber.dynamodb.config.usecase;

import com.rafaeljaber.dynamodb.application.core.usecase.DeletePlayerHistoryByGameIdAndUsernameUseCase;
import com.rafaeljaber.dynamodb.application.core.usecase.FindPlayerHistoryByGameIdUseCase;
import com.rafaeljaber.dynamodb.application.ports.out.DeletePlayerHistoryOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeletePlayerHistoryByGameIdAndUsernameConfig {


    @Bean
    public DeletePlayerHistoryByGameIdAndUsernameUseCase deletePlayerHistoryByGameIdAndUsernameUseCase(
            FindPlayerHistoryByGameIdUseCase findPlayerHistoryByGameIdUseCase,
            DeletePlayerHistoryOutputPort deletePlayerHistoryOutputPort
    ) {
        return new DeletePlayerHistoryByGameIdAndUsernameUseCase(
                findPlayerHistoryByGameIdUseCase,
                deletePlayerHistoryOutputPort
        );
    }

}
