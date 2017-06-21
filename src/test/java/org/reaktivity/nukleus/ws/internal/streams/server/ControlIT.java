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
 * RFC-6455, section 5.5 "Control Frames"
 */
public class ControlIT
{
    private final K3poRule k3po = new K3poRule()
            .addScriptRoot("route", "org/reaktivity/specification/nukleus/ws/control/route")
            .addScriptRoot("client", "org/reaktivity/specification/ws/control")
            .addScriptRoot("server", "org/reaktivity/specification/nukleus/ws/streams/control");

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

    @Ignore("No way to read or write 0 length data frame at high level: reaktivity/k3po-nukleus-ext.java#11")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.send.close.payload.length.0/handshake.request.and.frame",
        "${server}/client.send.close.payload.length.0/handshake.response.and.frame" })
    public void shouldEchoClientCloseFrameWithEmptyPayload() throws Exception
    {
        k3po.finish();
    }

    @Ignore("Aborted")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.send.close.payload.length.1/handshake.request.and.frame",
        "${server}/client.send.close.payload.length.1/handshake.response.and.frame" })
    public void shouldEchoClientCloseFrameWithPayloadSize1() throws Exception
    {
        k3po.finish();
    }

    @Ignore("Aborted")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.send.close.payload.length.125/handshake.request.and.frame",
        "${server}/client.send.close.payload.length.125/handshake.response.and.frame" })
    public void shouldEchoClientCloseFrameWithPayload() throws Exception
    {
        k3po.finish();
    }

    @Ignore("Aborted")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.send.close.payload.length.126/handshake.request.and.frame",
        "${server}/client.send.close.payload.length.126/handshake.response.and.frame" })
    public void shouldFailWebSocketConnectionWhenClientSendCloseFrameWithPayloadTooLong()
            throws Exception
    {
        k3po.finish();
    }

    @Ignore("Not yet implemented")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.send.ping.payload.length.0/handshake.request.and.frame",
        "${server}/client.send.ping.payload.length.0/handshake.response.and.frame" })
    public void shouldPongClientPingFrameWithEmptyPayload() throws Exception
    {
        k3po.finish();
    }

    @Ignore("Not yet implemented")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.send.ping.payload.length.125/handshake.request.and.frame",
        "${server}/client.send.ping.payload.length.125/handshake.response.and.frame" })
    public void shouldPongClientPingFrameWithPayload() throws Exception
    {
        k3po.finish();
    }

    @Ignore("Not yet implemented")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.send.ping.payload.length.126/handshake.request.and.frame",
        "${server}/client.send.ping.payload.length.126/handshake.response.and.frame" })
    public void shouldFailWebSocketConnectionWhenClientSendPingFrameWithPayloadTooLong()
            throws Exception
    {
        k3po.finish();
    }

    @Ignore("Not yet implemented")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.send.pong.payload.length.0/handshake.request.and.frame",
        "${server}/client.send.pong.payload.length.0/handshake.response.and.frame" })
    public void shouldReceiveClientPongFrameWithEmptyPayload() throws Exception
    {
        k3po.finish();
    }

    @Ignore("Not yet implemented")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.send.pong.payload.length.125/handshake.request.and.frame",
        "${server}/client.send.pong.payload.length.125/handshake.response.and.frame" })
    public void shouldReceiveClientPongFrameWithPayload() throws Exception
    {
        k3po.finish();
    }

    @Ignore("Not yet implemented")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.send.pong.payload.length.126/handshake.request.and.frame",
        "${server}/client.send.pong.payload.length.126/handshake.response.and.frame" })
    public void shouldFailWebSocketConnectionWhenClientSendPongFrameWithPayloadTooLong()
            throws Exception
    {
        k3po.finish();
    }

    @Ignore("Not yet implemented")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.send.opcode.0x0b/handshake.request.and.frame",
        "${server}/client.send.opcode.0x0b/handshake.response.and.frame" })
    public void shouldFailWebSocketConnectionWhenClientSendOpcode11Frame()
            throws Exception
    {
        k3po.finish();
    }

    @Ignore("Not yet implemented")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.send.opcode.0x0c/handshake.request.and.frame",
        "${server}/client.send.opcode.0x0c/handshake.response.and.frame" })
    public void shouldFailWebSocketConnectionWhenClientSendOpcode12Frame()
            throws Exception
    {
        k3po.finish();
    }

    @Ignore("Not yet implemented")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.send.opcode.0x0d/handshake.request.and.frame",
        "${server}/client.send.opcode.0x0d/handshake.response.and.frame" })
    public void shouldFailWebSocketConnectionWhenClientSendOpcode13Frame()
            throws Exception
    {
        k3po.finish();
    }

    @Ignore("Not yet implemented")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.send.opcode.0x0e/handshake.request.and.frame",
        "${server}/client.send.opcode.0x0e/handshake.response.and.frame" })
    public void shouldFailWebSocketConnectionWhenClientSendOpcode14Frame()
            throws Exception
    {
        k3po.finish();
    }

    @Ignore("Not yet implemented")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.send.opcode.0x0f/handshake.request.and.frame",
        "${server}/client.send.opcode.0x0f/handshake.response.and.frame" })
    public void shouldFailWebSocketConnectionWhenClientSendOpcode15Frame()
            throws Exception
    {
        k3po.finish();
    }

}
