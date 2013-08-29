/*
 * Copyright 2012-2013 Dennis Hörsch.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.dennishoersch.web.chat.tomcat;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.websocket.StreamInbound;
import org.apache.catalina.websocket.WebSocketServlet;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

import de.dennishoersch.web.chat.ClientConnection;

/**
 * @author hoersch
 * 
 */
public class TomcatWebSocketServlet extends WebSocketServlet implements BeanFactoryAware {
    private static final long serialVersionUID = 1L;

    private BeanFactory beanFactory;

    @Override
    protected StreamInbound createWebSocketInbound(String string, HttpServletRequest request) {
        ClientConnection connection = beanFactory.getBean(ClientConnection.class);
        return (StreamInbound) connection.getWebSocket();
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
}
