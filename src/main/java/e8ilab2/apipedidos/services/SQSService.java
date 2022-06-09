package e8ilab2.apipedidos.services;

import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.GetQueueUrlRequest;
import software.amazon.awssdk.services.sqs.model.GetQueueUrlResponse;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;

import static e8ilab2.apipedidos.services.AWSCredentials.awsCredentialsDispatcher;

public class SQSService {
    public static void sendMessage(String message){

        SqsClient sqsClient = SqsClient.builder()
                .region(Region.US_EAST_1)
                .credentialsProvider(awsCredentialsDispatcher())
                .build();

        GetQueueUrlRequest request = GetQueueUrlRequest.builder()
                .queueName("sqs-e8-desafio2")
                .queueOwnerAWSAccountId("755977887883").build();
        GetQueueUrlResponse createResult = sqsClient.getQueueUrl(request);

        sendMessage(sqsClient, createResult.queueUrl(), message);

        sqsClient.close();
    }

    public static void sendMessage(SqsClient sqsClient, String queueUrl, String message) {
        SendMessageRequest sendMsgRequest = SendMessageRequest.builder()
                .queueUrl(queueUrl)
                .messageBody(message)
                .build();
        sqsClient.sendMessage(sendMsgRequest);
    }
}
