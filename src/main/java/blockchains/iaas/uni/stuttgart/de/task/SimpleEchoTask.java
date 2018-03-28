package blockchains.iaas.uni.stuttgart.de.task;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

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
public abstract class SimpleEchoTask implements JavaDelegate {

    private final static Logger log = Logger.getLogger("EXCHANGE-REQUESTS");
    protected abstract String getMessage(DelegateExecution execution);
    public void execute(DelegateExecution execution) throws Exception {
        log.info("Sending message to client: " + getMessage(execution));
    }
}
