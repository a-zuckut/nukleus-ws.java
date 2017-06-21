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
 * RFC-6455, section 5.2 "Base Framing Protocol"
 */
public class ClosingHandshakeIT
{
    private final K3poRule k3po = new K3poRule()
            .addScriptRoot("route", "org/reaktivity/specification/nukleus/ws/control/route")
            .addScriptRoot("client", "org/reaktivity/specification/ws/closing")
            .addScriptRoot("server", "org/reaktivity/specification/nukleus/ws/streams/closing");

    private final TestRule timeout = new DisableOnDebug(new Timeout(8, SECONDS));

    private final ReaktorRule nukleus = new ReaktorRule()
        .directory("target/nukleus-itests")
        .commandBufferCapacity(1024)
        .responseBufferCapacity(1024)
        .counterValuesBufferCapacity(1024)
        .nukleus("ws"::equals)
        .clean();

    @Rule
    public final TestRule chain = outerRule(nukleus).around(k3po).around(timeout);

    @Ignore("No way to read or write 0 length data frame at high level: reaktivity/k3po-nukleus-ext.java#11")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.send.empty.close.frame/handshake.request.and.frame",
        "${server}/client.send.empty.close.frame/handshake.response.and.frame" })
    public void shouldCompleteCloseHandshakeWhenClientSendEmptyCloseFrame()
            throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.send.close.frame.with.code.1000/handshake.request.and.frame",
        "${server}/client.send.close.frame.with.code.1000/handshake.response.and.frame" })
    public void shouldCompleteCloseHandshakeWhenClientSendCloseFrameWithCode1000()
            throws Exception
    {
        k3po.finish();
    }

    @Ignore("Aborted")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.send.close.frame.with.code.1000.and.reason/handshake.request.and.frame",
        "${server}/client.send.close.frame.with.code.1000.and.reason/handshake.response.and.frame" })
    public void shouldCompleteCloseHandshakeWhenClientSendCloseFrameWithCode1000AndReason()
            throws Exception
    {
        k3po.finish();
    }

    @Ignore("Aborted")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.send.close.frame.with.code.1000.and.invalid.utf8.reason/handshake.request.and.frame",
        "${server}/client.send.close.frame.with.code.1000.and.invalid.utf8.reason/handshake.response.and.frame" })
    public void shouldFailWebSocketConnectionWhenClientSendCloseFrameWithCode1000AndInvalidUTF8Reason()
            throws Exception
    {
        k3po.finish();
    }

    @Ignore("Aborted")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.send.close.frame.with.code.1001/handshake.request.and.frame",
        "${server}/client.send.close.frame.with.code.1001/handshake.response.and.frame" })
    public void shouldCompleteCloseHandshakeWhenClientSendCloseFrameWithCode1001()
            throws Exception
    {
        k3po.finish();
    }

    @Ignore("Aborted")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.send.close.frame.with.code.1005/handshake.request.and.frame",
        "${server}/client.send.close.frame.with.code.1005/handshake.response.and.frame" })
    public void shouldFailWebSocketConnectionWhenClientSendCloseFrameWithCode1005()
            throws Exception
    {
        k3po.finish();
    }

    @Ignore("Aborted")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.send.close.frame.with.code.1006/handshake.request.and.frame",
        "${server}/client.send.close.frame.with.code.1006/handshake.response.and.frame" })
    public void shouldFailWebSocketConnectionWhenClientSendCloseFrameWithCode1006()
            throws Exception
    {
        k3po.finish();
    }

    @Ignore("Aborted")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.send.close.frame.with.code.1015/handshake.request.and.frame",
        "${server}/client.send.close.frame.with.code.1015/handshake.response.and.frame" })
    public void shouldFailWebSocketConnectionWhenClientSendCloseFrameWithCode1015()
            throws Exception
    {
        k3po.finish();
    }

}