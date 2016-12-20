/**
 * Copyright (c) 2010-2016 by the respective copyright holders.
 * <p>
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.rfxcom.internal.messages;

import org.junit.Test;
import org.openhab.binding.rfxcom.internal.exceptions.RFXComException;
import org.openhab.binding.rfxcom.internal.exceptions.RFXComMessageNotImplementedException;

import javax.xml.bind.DatatypeConverter;

import static org.junit.Assert.assertEquals;
import static org.openhab.binding.rfxcom.internal.messages.RFXComEnergyMessage.SubType.ELEC2;

/**
 * Test for RFXCom-binding
 *
 * @author Martin van Wingerden
 * @since 1.9.0
 */
public class RFXComEnergyMessageTest {
    @Test
    public void testSomeMessages() throws RFXComException, RFXComMessageNotImplementedException {
        String hexMessage = "115A01071A7300000003F600000000350B89";
        byte[] message = DatatypeConverter.parseHexBinary(hexMessage);
        RFXComEnergyMessage msg = (RFXComEnergyMessage) RFXComMessageFactory.createMessage(message);
        assertEquals("SubType", ELEC2, msg.subType);
        assertEquals("Seq Number", 7, msg.seqNbr);
        assertEquals("Sensor Id", "6771", msg.getDeviceId());
        assertEquals("Count", 0, msg.count);
        // TODO what is the expected behaviour
        assertEquals("Instant usage", 1014d / 230, msg.instantAmp, 0.01);
        assertEquals("Total usage", 60.7d / 230, msg.totalAmpHour, 0.01);
        assertEquals("Signal Level", (byte) 8, msg.signalLevel);
        assertEquals("Battery Level", (byte) 9, msg.batteryLevel);

        byte[] decoded = msg.decodeMessage();

        // TODO
        // assertEquals("Message converted back", hexMessage, DatatypeConverter.printHexBinary(decoded));
    }
}
