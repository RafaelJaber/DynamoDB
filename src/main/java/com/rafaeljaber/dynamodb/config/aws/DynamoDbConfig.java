package com.rafaeljaber.dynamodb.config.aws;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

@Configuration
public class DynamoDbConfig {

    @Bean
    public DynamoDbClient dynamoDbClient(AwsBasicCredentials awsBasicCredentials) {
        return DynamoDbClient.builder()
                .region(Region.US_EAST_2)
                .credentialsProvider(StaticCredentialsProvider.create(awsBasicCredentials))
                .build();
    }

    @Bean
    public AwsBasicCredentials awsBasicCredentials(
            @Value("${jaber.aws.access-key}") String accessKey,
            @Value("${jaber.aws.secret-key}") String secretKey
    ) {
        return AwsBasicCredentials.create(accessKey, secretKey);
    }
}
