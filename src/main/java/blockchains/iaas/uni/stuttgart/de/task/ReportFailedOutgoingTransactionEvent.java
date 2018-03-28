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
public class ReportFailedOutgoingTransactionEvent extends SimpleEchoTask {
    protected String getMessage(DelegateExecution execution) {
        return "The target address " + execution.getVariable("targetAddress") +
                " is incorrect. Please contact our customer support to reclaim your weis";
    }
}
