package blockchains.iaas.uni.stuttgart.de.task;

import blockchains.iaas.uni.stuttgart.de.config.Configuration;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Random;
import java.util.logging.Logger;

/********************************************************************************
 * Copyright (c) 2018 Institute for the Architecture of Application System -
 * University of Stuttgart
 * Author: Ghareeb Falazi
 *
 * This program and the accompanying materials are made available under the
 * terms the Apache Software License 2.0
 * which is available at https://www.apache.org/licenses/LICENSE-2.0.
 *
 * SPDX-License-Identifier: Apache-2.0
 ********************************************************************************/

/**
 * The ReceiveTask should expect a message with the name:
 * message_{operationName}_{execution.processInstanceId}
 *
 * The ReceiveEvent should expect a message with the name:
 * error_{operationName}_{execution.processInstanceId}
 *
 * operationName should be unique for each blockchain-based operation in the model
 */
public abstract class SubscriptionTask implements JavaDelegate {

    final static Logger log = Logger.getLogger("EXCHANGE-REQUESTS");


    String getSourceBlockchainId(){
        return Configuration.getInstance().properties.getProperty("source-blockchain-id");
    }

    String getTargetBlockchainId(){
        return Configuration.getInstance().properties.getProperty("target-blockchain-id");
    }

    String getMessageEndPointUrl(){
        return String.format("%s/%s", Configuration.getInstance().properties.getProperty("engine-rest-api-url"), "message");
    }

    private String generateCorrelationId(DelegateExecution execution){
        return getOperationName() + "_" + execution.getProcessInstanceId();
    }

    protected abstract Object generateRequest(DelegateExecution execution, String correlationId);
    protected abstract String getOperationName();
    protected abstract String getBALOperationUrlSegment();

    public void execute(DelegateExecution execution) throws Exception {
        log.info("Executing Task: " + execution.getCurrentActivityName());

        final Object requestMessage = generateRequest(execution, generateCorrelationId(execution));
        final String balUrl = String.format("%s/%s", Configuration.getInstance().properties.getProperty("bal-rest-api-url"),
                getBALOperationUrlSegment());
        log.info("Sending request to " + balUrl);

        final Client client = ClientBuilder.newClient();
        final Response response = client.target(balUrl)
                .request(MediaType.APPLICATION_XML)
                .post(Entity.entity(requestMessage, MediaType.APPLICATION_XML));

        log.info("BAL server responded with code: "+ response.getStatus());

    }
}
