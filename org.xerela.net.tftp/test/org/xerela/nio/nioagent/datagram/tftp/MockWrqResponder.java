/*
 * The contents of this file are subject to the Mozilla Public License
 * Version 1.1 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://www.mozilla.org/MPL/
 * 
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 * 
 * The Original Code is Ziptie Client Framework.
 * 
 * The Initial Developer of the Original Code is AlterPoint.
 * Portions created by AlterPoint are Copyright (C) 2006,
 * AlterPoint, Inc. All Rights Reserved.
 * 
 * Contributor(s):
 */

package org.xerela.nio.nioagent.datagram.tftp;

import java.net.InetSocketAddress;

import org.xerela.nio.common.Bool;
import org.xerela.nio.nioagent.Interfaces.BinaryCodec;
import org.xerela.nio.nioagent.datagram.tftp.WrqResponder;

import junit.framework.Assert;


public class MockWrqResponder extends WrqResponder
{
    public MockWrqResponder()
    {
        super(null, null, null, null);
    }

    @Override
    public BinaryCodec respondToWrq(InetSocketAddress local, InetSocketAddress remote, String filename, String mode, Bool terminate)
    {
        Assert.assertEquals("foo", filename);
        Assert.assertEquals("bar", mode);
        return null;
    }
}