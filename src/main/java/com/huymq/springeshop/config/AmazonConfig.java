package com.huymq.springeshop.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmazonConfig {
    @Bean
    public AmazonS3 s3() {
        AWSCredentialsProvider credentials = new AWSStaticCredentialsProvider(
                new BasicAWSCredentials("1c9b2b3da38b74b2aac20b2ebd41bb1a2371584b",
                "a2TH/GPxIKfnhPAhC9Y2zsbq9Vka42agAiSA3Ta2gS0="));
        // Your namespace
        String namespace = "nrwotue76dtr";
        
        // The region to connect to
        String region = "ap-tokyo-1";
        
        // Create an S3 client pointing at the region
        String endpoint = String.format("%s.compat.objectstorage.%s.oraclecloud.com",namespace,region);
        AwsClientBuilder.EndpointConfiguration endpointConfiguration = new AwsClientBuilder.EndpointConfiguration(endpoint, region);
        AmazonS3 client = AmazonS3ClientBuilder
            .standard()
            .withCredentials(credentials)
            .withEndpointConfiguration(endpointConfiguration)
            .disableChunkedEncoding()
            .enablePathStyleAccess()
            .build();

            return client;

    }
}