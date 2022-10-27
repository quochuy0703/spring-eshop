package com.huymq.springeshop.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class AmazonConfig {

    @Autowired
    private Environment env;

    @Bean
    public AmazonS3 s3() {
        AWSCredentialsProvider credentials = new AWSStaticCredentialsProvider(
                new BasicAWSCredentials(env.getProperty("s3.accessKey"),
                env.getProperty("s3.secretKey")));
        // Your namespace
        String namespace = env.getProperty("s3.namespace");
        
        // The region to connect to
        String region = env.getProperty("s3.region");
        
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