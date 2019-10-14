package blockchains.iaas.uni.stuttgart.de.task;

import blockchains.iaas.uni.stuttgart.de.config.Configuration;
import blockchains.iaas.uni.stuttgart.de.request.SubmitTransactionRequest;
import org.camunda.bpm.engine.delegate.DelegateExecution;

import java.math.BigInteger;
import java.nio.DoubleBuffer;

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
public class SubmitTransactionTask extends SubscriptionTask {
    private final static double REQUIRED_CONFIDENCE = 50.0;


    protected Object generateRequest(DelegateExecution execution, String correlationId) {
        final SubmitTransactionRequest request = new SubmitTransactionRequest();
        request.setBlockchainId(getTargetBlockchainId());
        request.setEpUrl(getMessageEndPointUrl());
        request.setSubscriptionId(correlationId);
        request.setTo((String) execution.getVariable("targetAddress"));
        request.setRequiredConfidence(REQUIRED_CONFIDENCE);
        final double exchangeRate = Double.valueOf(Configuration.getInstance().properties.getProperty("exchange-rate"));
        final long value = (long) (
                (Long) execution.getVariable("value") * exchangeRate);
        request.setValue(BigInteger.valueOf(value));
        log.info("Exchange rate (wei->satoshi) is: " + Configuration.getInstance().properties.getProperty("exchange-rate")
                + ". Sending " + value + " satoshis to " + request.getTo());

        return request;
    }

    protected String getOperationName() {
        return "submitTransaction";
    }

    protected String getBALOperationUrlSegment() {
        return "submit-transaction";
    }
}
