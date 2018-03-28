package blockchains.iaas.uni.stuttgart.de.task;

import blockchains.iaas.uni.stuttgart.de.request.ReceiveTransactionsRequest;
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
public class ReceiveTransactionTask extends SubscriptionTask {
    private static final long WAIT_FOR = 1L;

    protected boolean hasErrorCallback() {
        return false;
    }

    protected Object generateRequest(DelegateExecution execution, String correlationId) {
        final ReceiveTransactionsRequest request = new ReceiveTransactionsRequest();
        request.setBlockchainId(super.getSourceBlockchainId());
        request.setEpUrl(super.getMessageEndPointUrl());
        request.setFrom((String)execution.getVariable("sourceAddress"));
        request.setSubscriptionId(correlationId);
        request.setWaitFor(WAIT_FOR);

        return request;
    }

    protected String getOperationName() {
        return "receiveTransaction";
    }

    protected String getBALOperationUrlSegment() {
        return "receive-transaction";
    }
}
