package blockchains.iaas.uni.stuttgart.de.task;

import blockchains.iaas.uni.stuttgart.de.request.EnsureTransactionStateRequest;
import org.camunda.bpm.engine.delegate.DelegateExecution;

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
public class EnsureTransactionTask extends SubscriptionTask {
    private final static long WAIT_FOR = 12L;


    protected Object generateRequest(DelegateExecution execution, String correlationId) {
        final EnsureTransactionStateRequest request = new EnsureTransactionStateRequest();
        request.setBlockchainId(getSourceBlockchainId());
        request.setEpUrl(getMessageEndPointUrl());
        request.setSubscriptionId(correlationId);
        request.setTxId((String)execution.getVariable("transactionId"));
        request.setWaitFor(WAIT_FOR);
        return request;
    }

    protected String getOperationName() {
        return "ensureTransactionState";
    }

    protected String getBALOperationUrlSegment() {
        return "ensure-transaction-state";
    }
}
