/**
 * Copyright (c) 2014-2016 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.rfxcom.internal.exceptions;

/**
 * Exception for when RFXCOM messages have a value that we don't understand.
 *
 * @author James Hewitt-Thomas - Initial contribution
 */
public class RFXComUnknownValueException extends RFXComException {

    private static final long serialVersionUID = 402781611495845169L;

    public Class<?> enumeration;
    public String value;

    public RFXComUnknownValueException() {
        super();
    }

    public RFXComUnknownValueException(String message) {
        super(message);
    }

    public RFXComUnknownValueException(String message, Throwable cause) {
        super(message, cause);
    }

    public RFXComUnknownValueException(Throwable cause) {
        super(cause);
    }

    public RFXComUnknownValueException(Class<?> enumeration, String value) {
        super("Unknown value for " + enumeration.getName() + ": " + value);
        this.enumeration = enumeration;
        this.value = value;
    }
}
