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

package de.dennishoersch.web.chat;

import java.io.IOException;

/**
 * @author hoersch
 * 
 */
public interface ClientConnection {

    /**
     * Sends the given message to the connected client.
     * 
     * @param message
     * @throws IOException
     */
    void sendMessage(String message) throws IOException;

    void onOpen();

    void onTextMessage(String message);

    void onClose();
}