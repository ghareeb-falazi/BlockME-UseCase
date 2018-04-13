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
public class ReportRequestAcceptedEvent extends SimpleEchoTask {
    protected String getMessage(DelegateExecution execution) {
        return "Your request to exchange: "+ execution.getVariable("value") + " weis for satoshis has been received!";
    }
}
