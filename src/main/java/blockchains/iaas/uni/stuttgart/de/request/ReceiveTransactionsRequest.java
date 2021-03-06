package blockchains.iaas.uni.stuttgart.de.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

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

@XmlRootElement(name = "ReceiveTransactionsRequest")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class ReceiveTransactionsRequest {

    private String blockchainId;

    private String subscriptionId;

    private double requiredConfidence;

    private String epUrl;

    private String from;

    @XmlElement(name="EndPointUrl")
    public String getEpUrl() {
        return epUrl;
    }

    public void setEpUrl(String epUrl) {
        this.epUrl = epUrl;
    }

    @XmlElement(name="From")
    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    @XmlElement(name="BlockchainId")
    public String getBlockchainId() {
        return blockchainId;
    }

    public void setBlockchainId(String blockchainId) {
        this.blockchainId = blockchainId;
    }

    @XmlElement(name="SubscriptionId")
    public String getSubscriptionId() {
        return subscriptionId;
    }


    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    @XmlElement(name="RequiredConfidence")
    public double getRequiredConfidence() {
        return requiredConfidence;
    }


    public void setRequiredConfidence(double requiredConfidence) {
        this.requiredConfidence = requiredConfidence;
    }


}
