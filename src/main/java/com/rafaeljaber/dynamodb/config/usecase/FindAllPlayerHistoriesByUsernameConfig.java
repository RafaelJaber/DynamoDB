package com.rafaeljaber.dynamodb.config.usecase;

import com.rafaeljaber.dynamodb.adapter.FindAllPlayerHistoriesByUsernameAdapter;
import com.rafaeljaber.dynamodb.application.core.usecase.FindAllPlayerHistoriesByUsernameUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindAllPlayerHistoriesByUsernameConfig {

    @Bean
    public FindAllPlayerHistoriesByUsernameUseCase findAllPlayerHistoriesByUsernameUseCase(
            FindAllPlayerHistoriesByUsernameAdapter findAllPlayerHistoriesByUsernameAdapter
    ) {
        return new FindAllPlayerHistoriesByUsernameUseCase(findAllPlayerHistoriesByUsernameAdapter);
    }

}
