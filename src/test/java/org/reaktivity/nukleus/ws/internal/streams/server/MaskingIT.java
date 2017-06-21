/**
 * Copyright 2016-2017 The Reaktivity Project
 *
 * The Reaktivity Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package org.reaktivity.nukleus.ws.internal.streams.server;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.rules.RuleChain.outerRule;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.DisableOnDebug;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;
import org.kaazing.k3po.junit.annotation.Specification;
import org.kaazing.k3po.junit.rules.K3poRule;
import org.reaktivity.reaktor.test.ReaktorRule;

/**
 * RFC-6455 section 5.1 "Overview" section 5.3 "Client-to-Server Masking"
 */
public class MaskingIT
{
    private final K3poRule k3po = new K3poRule()
            .addScriptRoot("route", "org/reaktivity/specification/nukleus/ws/control/route")
            .addScriptRoot("client", "org/reaktivity/specification/ws/masking")
            .addScriptRoot("server", "org/reaktivity/specification/nukleus/ws/streams/masking");

    private final TestRule timeout = new DisableOnDebug(new Timeout(5, SECONDS));

    private final ReaktorRule nukleus = new ReaktorRule()
            .directory("target/nukleus-itests")
            .commandBufferCapacity(1024)
            .responseBufferCapacity(1024)
            .counterValuesBufferCapacity(1024)
            .nukleus("ws"::equals)
            .clean();

    @Rule
    public final TestRule chain = outerRule(nukleus).around(k3po).around(timeout);

    @Ignore("Not yet implemented")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/send.text.payload.not.masked/handshake.request.and.frame",
        "${server}/send.text.payload.not.masked/handshake.response.and.frame" })
    public void shouldFailWebSocketConnectionWhenSendTextFrameNotMasked()
            throws Exception
    {
        k3po.finish();
    }

    @Ignore("aborted")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/send.binary.payload.not.masked/handshake.request.and.frame",
        "${server}/send.binary.payload.not.masked/handshake.response.and.frame" })
    public void shouldFailWebSocketConnectionWhenSendBinaryFrameNotMasked()
            throws Exception
    {
        k3po.finish();
    }
}
