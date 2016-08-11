/*******************************************************************************
 * Educational Online Test Delivery System
 * Copyright (c) 2013 American Institutes for Research
 * 
 * Distributed under the AIR Open Source License, Version 1.0
 * See accompanying file AIR-License-1_0.txt or at
 * https://bitbucket.org/sbacoss/eotds/wiki/AIR_Open_Source_License
 ******************************************************************************/
package com.sales.module.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ResponseError {

    public static final String GLOBAL_MESSAGE_KEY = "applicationErrors";
    private Map<String, List<String>> messages;

    public ResponseError() {
        // empty default constructor
    }

    public ResponseError(final String... msgs) {
        this.messages = new HashMap<String, List<String>>();
        if (msgs != null) {
            this.messages.put(GLOBAL_MESSAGE_KEY, Arrays.asList(msgs));
        }
    }

    public ResponseError(final Map<String, List<String>> messageMap) {
        this.messages = messageMap;
    }

    public Map<String, List<String>> getMessages() {
        return messages;
    }

    public void setMessages(final Map<String, List<String>> msgMap) {
        this.messages = msgMap;
    }

}
