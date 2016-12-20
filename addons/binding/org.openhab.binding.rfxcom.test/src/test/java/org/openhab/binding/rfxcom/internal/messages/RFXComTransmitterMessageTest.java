/**
 * Copyright (c) 2010-2016 by the respective copyright holders.
 * <p>
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.rfxcom.internal.messages;

import static org.junit.Assert.assertEquals;
import static org.openhab.binding.rfxcom.internal.messages.RFXComBaseMessage.PacketType.TRANSMITTER_MESSAGE;

import org.junit.Test;
import org.openhab.binding.rfxcom.internal.exceptions.RFXComException;
import org.openhab.binding.rfxcom.internal.exceptions.RFXComMessageNotImplementedException;

/**
 * Test for RFXCom-binding
 *
 * @author Martin van Wingerden
 * @since 1.9.0
 */
public class RFXComTransmitterMessageTest {
    @Test
    public void checkForSupportTest() throws RFXComException, RFXComMessageNotImplementedException {
        RFXComMessageFactory.createMessage(TRANSMITTER_MESSAGE);
    }

    @Test
    public void basicBoundaryCheck() throws RFXComException, RFXComMessageNotImplementedException {
        RFXComTransmitterMessage intf = (RFXComTransmitterMessage) RFXComMessageFactory
                .createMessage(TRANSMITTER_MESSAGE);

        // This is a place where its easy to make mistakes in coding, and can result in errors, normally
        // array bounds errors
        intf.subType = RFXComTransmitterMessage.SubType.RESPONSE;
        intf.response = RFXComTransmitterMessage.Response.ACK;
        byte[] message = intf.decodeMessage();
        assertEquals("Wrong packet length", message[0], message.length - 1);
        assertEquals("Wrong packet type", TRANSMITTER_MESSAGE.toByte(), message[1]);
    }

    // TODO please add tests for real messages
}
