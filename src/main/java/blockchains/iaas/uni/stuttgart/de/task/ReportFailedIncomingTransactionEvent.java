package blockchains.iaas.uni.stuttgart.de.task;

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
public class ReportFailedIncomingTransactionEvent extends SimpleEchoTask {
    protected String getMessage(DelegateExecution execution) {
        return "Transaction with hash " + execution.getVariable("transactionId") +
                " has been invalidated. Your exchange request has beed rejected!";
    }
}
