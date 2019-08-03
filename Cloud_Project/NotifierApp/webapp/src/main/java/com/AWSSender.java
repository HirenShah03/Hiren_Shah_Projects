package com;


import com.amazonaws.auth.AWSCredentialsProviderChain;
import com.amazonaws.auth.InstanceProfileCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;
//@Author Hiren

public class AWSSender {

    public static void sendData(String data) {
        
        System.out.println("Sending data: "+data);
        AmazonSNS amazonSNS = getAmazonSNS();
        System.out.println("Getting ARN........");
        String arn = System.getenv("sns_arn");
        System.out.println("ARN - " + arn);
        PublishRequest publishRequest = new PublishRequest(arn, data);
        System.out.println("Publish Request created.......");
        PublishResult publishResult = amazonSNS.publish(publishRequest);
        System.out.println("Result published - " + publishResult.getMessageId());
    }


    public static AmazonSNS getAmazonSNS() {
        AWSCredentialsProviderChain providerChain = new AWSCredentialsProviderChain(
                InstanceProfileCredentialsProvider.getInstance(),
                new ProfileCredentialsProvider()
        );
        return AmazonSNSClientBuilder.standard().withCredentials(providerChain).build();
    }
}
