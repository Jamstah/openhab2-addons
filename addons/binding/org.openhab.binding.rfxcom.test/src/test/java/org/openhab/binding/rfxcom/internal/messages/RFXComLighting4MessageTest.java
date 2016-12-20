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
import static org.openhab.binding.rfxcom.internal.messages.RFXComBaseMessage.PacketType.LIGHTING4;

import org.junit.Test;
import org.openhab.binding.rfxcom.internal.exceptions.RFXComException;
import org.openhab.binding.rfxcom.internal.exceptions.RFXComMessageNotImplementedException;

/**
 * Test for RFXCom-binding
 *
 * @author Martin van Wingerden
 * @since 1.9.0
 */
public class RFXComLighting4MessageTest {
    @Test
    public void checkForSupportTest() throws RFXComException, RFXComMessageNotImplementedException {
        RFXComMessageFactory.createMessage(LIGHTING4);
    }

    @Test
    public void basicBoundaryCheck() throws RFXComException, RFXComMessageNotImplementedException {
        RFXComLighting4Message intf = (RFXComLighting4Message) RFXComMessageFactory.createMessage(LIGHTING4);

        // This is a place where its easy to make mistakes in coding, and can result in errors, normally
        // array bounds errors
        intf.subType = RFXComLighting4Message.SubType.PT2262;
        intf.command = RFXComLighting4Message.Commands.ON;
        byte[] message = intf.decodeMessage();
        assertEquals("Wrong packet length", message[0], message.length - 1);
        assertEquals("Wrong packet type", LIGHTING4.toByte(), message[1]);
    }

    // TODO please add tests for real messages
}
