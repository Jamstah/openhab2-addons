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
import static org.openhab.binding.rfxcom.internal.messages.RFXComBaseMessage.PacketType.CURTAIN1;

import org.junit.Test;
import org.openhab.binding.rfxcom.internal.exceptions.RFXComException;
import org.openhab.binding.rfxcom.internal.exceptions.RFXComMessageNotImplementedException;

/**
 * Test for RFXCom-binding
 *
 * @author Martin van Wingerden
 * @since 1.9.0
 */
public class RFXComCurtain1MessageTest {
    @Test
    public void checkForSupportTest() throws RFXComException, RFXComMessageNotImplementedException {
        RFXComMessageFactory.createMessage(CURTAIN1);
    }

    @Test
    public void basicBoundaryCheck() throws RFXComException, RFXComMessageNotImplementedException {
        RFXComCurtain1Message intf = (RFXComCurtain1Message) RFXComMessageFactory.createMessage(CURTAIN1);

        // This is a place where its easy to make mistakes in coding, and can result in errors, normally
        // array bounds errors
        intf.subType = RFXComCurtain1Message.SubType.HARRISON;
        intf.command = RFXComCurtain1Message.Commands.OPEN;
        byte[] message = intf.decodeMessage();
        assertEquals("Wrong packet length", message[0], message.length - 1);
        assertEquals("Wrong packet type", CURTAIN1.toByte(), message[1]);
    }

    // TODO please add tests for real messages
}
