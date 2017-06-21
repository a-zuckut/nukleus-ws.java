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
 * RFC-6455, section 5.8 "Extensibility"
 */
public class ExtensibilityIT
{
    private final K3poRule k3po = new K3poRule()
            .addScriptRoot("route", "org/reaktivity/specification/nukleus/ws/control/route")
            .addScriptRoot("client", "org/reaktivity/specification/ws/extensibility")
            .addScriptRoot("server", "org/reaktivity/specification/nukleus/ws/streams/extensibility");

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

    @Ignore("Binary vs close")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.send.text.frame.with.rsv.1/handshake.request.and.frame",
        "${server}/client.send.text.frame.with.rsv.1/handshake.response.and.frame" })
    public void shouldFailWebSocketConnectionWhenClientSendTextFrameWithRsv1()
            throws Exception
    {
        k3po.finish();
    }

    @Ignore("Binary vs close")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.send.binary.frame.with.rsv.1/handshake.request.and.frame",
        "${server}/client.send.binary.frame.with.rsv.1/handshake.response.and.frame" })
    public void shouldFailWebSocketConnectionWhenClientSendBinaryFrameWithRsv1()
            throws Exception
    {
        k3po.finish();
    }

    @Ignore("aborted")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.send.close.frame.with.rsv.1/handshake.request.and.frame",
        "${server}/client.send.close.frame.with.rsv.1/handshake.response.and.frame" })
    public void shouldFailWebSocketConnectionWhenClientSendCloseFrameWithRsv1()
            throws Exception
    {
        k3po.finish();
    }

    @Ignore("Not yet implemented")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.send.ping.frame.with.rsv.1/handshake.request.and.frame",
        "${server}/client.send.ping.frame.with.rsv.1/handshake.response.and.frame" })
    public void shouldFailWebSocketConnectionWhenClientSendPingFrameWithRsv1()
            throws Exception
    {
        k3po.finish();
    }

    @Ignore("Not yet implemented")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.send.pong.frame.with.rsv.1/handshake.request.and.frame",
        "${server}/client.send.pong.frame.with.rsv.1/handshake.response.and.frame" })
    public void shouldFailWebSocketConnectionWhenClientSendPongFrameWithRsv1()
            throws Exception
    {
        k3po.finish();
    }

    @Ignore("Binary vs close")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.send.text.frame.with.rsv.2/handshake.request.and.frame",
        "${server}/client.send.text.frame.with.rsv.2/handshake.response.and.frame" })
    public void shouldFailWebSocketConnectionWhenClientSendTextFrameWithRsv2()
            throws Exception
    {
        k3po.finish();
    }

    @Ignore("binary vs close")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.send.binary.frame.with.rsv.2/handshake.request.and.frame",
        "${server}/client.send.binary.frame.with.rsv.2/handshake.response.and.frame" })
    public void shouldFailWebSocketConnectionWhenClientSendBinaryFrameWithRsv2()
            throws Exception
    {
        k3po.finish();
    }

    @Ignore("aborted")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.send.close.frame.with.rsv.2/handshake.request.and.frame",
        "${server}/client.send.close.frame.with.rsv.2/handshake.response.and.frame" })
    public void shouldFailWebSocketConnectionWhenClientSendCloseFrameWithRsv2()
            throws Exception
    {
        k3po.finish();
    }

    @Ignore("Not yet implemented")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.send.ping.frame.with.rsv.2/handshake.request.and.frame",
        "${server}/client.send.ping.frame.with.rsv.2/handshake.response.and.frame" })
    public void shouldFailWebSocketConnectionWhenClientSendPingFrameWithRsv2()
            throws Exception
    {
        k3po.finish();
    }

    @Ignore("Not yet implemented")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.send.pong.frame.with.rsv.2/handshake.request.and.frame",
        "${server}/client.send.pong.frame.with.rsv.2/handshake.response.and.frame" })
    public void shouldFailWebSocketConnectionWhenClientSendPongFrameWithRsv2()
            throws Exception
    {
        k3po.finish();
    }

    @Ignore("binary vs close")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.send.text.frame.with.rsv.3/handshake.request.and.frame",
        "${server}/client.send.text.frame.with.rsv.3/handshake.response.and.frame" })
    public void shouldFailWebSocketConnectionWhenClientSendTextFrameWithRsv3()
            throws Exception
    {
        k3po.finish();
    }

    @Ignore("Binary vs close")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.send.binary.frame.with.rsv.3/handshake.request.and.frame",
        "${server}/client.send.binary.frame.with.rsv.3/handshake.response.and.frame" })
    public void shouldFailWebSocketConnectionWhenClientSendBinaryFrameWithRsv3()
            throws Exception
    {
        k3po.finish();
    }

    @Ignore("aborted")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.send.close.frame.with.rsv.3/handshake.request.and.frame",
        "${server}/client.send.close.frame.with.rsv.3/handshake.response.and.frame" })
    public void shouldFailWebSocketConnectionWhenClientSendCloseFrameWithRsv3()
            throws Exception
    {
        k3po.finish();
    }

    @Ignore("Not yet implemented")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.send.ping.frame.with.rsv.3/handshake.request.and.frame",
        "${server}/client.send.ping.frame.with.rsv.3/handshake.response.and.frame" })
    public void shouldFailWebSocketConnectionWhenClientSendPingFrameWithRsv3()
            throws Exception
    {
        k3po.finish();
    }

    @Ignore("Not yet implemented")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.send.pong.frame.with.rsv.3/handshake.request.and.frame",
        "${server}/client.send.pong.frame.with.rsv.3/handshake.response.and.frame" })
    public void shouldFailWebSocketConnectionWhenClientSendPongFrameWithRsv3()
            throws Exception
    {
        k3po.finish();
    }

    @Ignore("binary vs close")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.send.text.frame.with.rsv.4/handshake.request.and.frame",
        "${server}/client.send.text.frame.with.rsv.4/handshake.response.and.frame" })
    public void shouldFailWebSocketConnectionWhenClientSendTextFrameWithRsv4()
            throws Exception
    {
        k3po.finish();
    }

    @Ignore("binary vs close")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.send.binary.frame.with.rsv.4/handshake.request.and.frame",
        "${server}/client.send.binary.frame.with.rsv.4/handshake.response.and.frame" })
    public void shouldFailWebSocketConnectionWhenClientSendBinaryFrameWithRsv4()
            throws Exception
    {
        k3po.finish();
    }

    @Ignore("aborted")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.send.close.frame.with.rsv.4/handshake.request.and.frame",
        "${server}/client.send.close.frame.with.rsv.4/handshake.response.and.frame" })
    public void shouldFailWebSocketConnectionWhenClientSendCloseFrameWithRsv4()
            throws Exception
    {
        k3po.finish();
    }

    @Ignore("Not yet implemented")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.send.ping.frame.with.rsv.4/handshake.request.and.frame",
        "${server}/client.send.ping.frame.with.rsv.4/handshake.response.and.frame" })
    public void shouldFailWebSocketConnectionWhenClientSendPingFrameWithRsv4()
            throws Exception
    {
        k3po.finish();
    }

    @Ignore("Not yet implemented")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.send.pong.frame.with.rsv.4/handshake.request.and.frame",
        "${server}/client.send.pong.frame.with.rsv.4/handshake.response.and.frame" })
    public void shouldFailWebSocketConnectionWhenClientSendPongFrameWithRsv4()
            throws Exception
    {
        k3po.finish();
    }

    @Ignore("binary vs close")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.send.text.frame.with.rsv.5/handshake.request.and.frame",
        "${server}/client.send.text.frame.with.rsv.5/handshake.response.and.frame" })
    public void shouldFailWebSocketConnectionWhenClientSendTextFrameWithRsv5()
            throws Exception
    {
        k3po.finish();
    }

    @Ignore("binary vs close")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.send.binary.frame.with.rsv.5/handshake.request.and.frame",
        "${server}/client.send.binary.frame.with.rsv.5/handshake.response.and.frame" })
    public void shouldFailWebSocketConnectionWhenClientSendBinaryFrameWithRsv5()
            throws Exception
    {
        k3po.finish();
    }

    @Ignore("aborted")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.send.close.frame.with.rsv.5/handshake.request.and.frame",
        "${server}/client.send.close.frame.with.rsv.5/handshake.response.and.frame" })
    public void shouldFailWebSocketConnectionWhenClientSendCloseFrameWithRsv5()
            throws Exception
    {
        k3po.finish();
    }

    @Ignore("Not yet implemented")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.send.ping.frame.with.rsv.5/handshake.request.and.frame",
        "${server}/client.send.ping.frame.with.rsv.5/handshake.response.and.frame" })
    public void shouldFailWebSocketConnectionWhenClientSendPingFrameWithRsv5()
            throws Exception
    {
        k3po.finish();
    }

    @Ignore("Not yet implemented")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.send.pong.frame.with.rsv.5/handshake.request.and.frame",
        "${server}/client.send.pong.frame.with.rsv.5/handshake.response.and.frame" })
    public void shouldFailWebSocketConnectionWhenClientSendPongFrameWithRsv5()
            throws Exception
    {
        k3po.finish();
    }

    @Ignore("binary vs close")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.send.text.frame.with.rsv.6/handshake.request.and.frame",
        "${server}/client.send.text.frame.with.rsv.6/handshake.response.and.frame" })
    public void shouldFailWebSocketConnectionWhenClientSendTextFrameWithRsv6()
            throws Exception
    {
        k3po.finish();
    }

    @Ignore("binary vs close")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.send.binary.frame.with.rsv.6/handshake.request.and.frame",
        "${server}/client.send.binary.frame.with.rsv.6/handshake.response.and.frame" })
    public void shouldFailWebSocketConnectionWhenClientSendBinaryFrameWithRsv6()
            throws Exception
    {
        k3po.finish();
    }

    @Ignore("aborted")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.send.close.frame.with.rsv.6/handshake.request.and.frame",
        "${server}/client.send.close.frame.with.rsv.6/handshake.response.and.frame" })
    public void shouldFailWebSocketConnectionWhenClientSendCloseFrameWithRsv6()
            throws Exception
    {
        k3po.finish();
    }

    @Ignore("Not yet implemented")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.send.ping.frame.with.rsv.6/handshake.request.and.frame",
        "${server}/client.send.ping.frame.with.rsv.6/handshake.response.and.frame" })
    public void shouldFailWebSocketConnectionWhenClientSendPingFrameWithRsv6()
            throws Exception
    {
        k3po.finish();
    }

    @Ignore("Not yet implemented")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.send.pong.frame.with.rsv.6/handshake.request.and.frame",
        "${server}/client.send.pong.frame.with.rsv.6/handshake.response.and.frame" })
    public void shouldFailWebSocketConnectionWhenClientSendPongFrameWithRsv6()
            throws Exception
    {
        k3po.finish();
    }

    @Ignore("binary vs close")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.send.text.frame.with.rsv.7/handshake.request.and.frame",
        "${server}/client.send.text.frame.with.rsv.7/handshake.response.and.frame" })
    public void shouldFailWebSocketConnectionWhenClientSendTextFrameWithRsv7()
            throws Exception
    {
        k3po.finish();
    }

    @Ignore("binary vs close")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.send.binary.frame.with.rsv.7/handshake.request.and.frame",
        "${server}/client.send.binary.frame.with.rsv.7/handshake.response.and.frame" })
    public void shouldFailWebSocketConnectionWhenClientSendBinaryFrameWithRsv7()
            throws Exception
    {
        k3po.finish();
    }

    @Ignore("aborted")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.send.close.frame.with.rsv.7/handshake.request.and.frame",
        "${server}/client.send.close.frame.with.rsv.7/handshake.response.and.frame" })
    public void shouldFailWebSocketConnectionWhenClientSendCloseFrameWithRsv7()
            throws Exception
    {
        k3po.finish();
    }

    @Ignore("Not yet implemented")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.send.ping.frame.with.rsv.7/handshake.request.and.frame",
        "${server}/client.send.ping.frame.with.rsv.7/handshake.response.and.frame" })
    public void shouldFailWebSocketConnectionWhenClientSendPingFrameWithRsv7()
            throws Exception
    {
        k3po.finish();
    }

    @Ignore("Not yet implemented")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.send.pong.frame.with.rsv.7/handshake.request.and.frame",
        "${server}/client.send.pong.frame.with.rsv.7/handshake.response.and.frame" })
    public void shouldFailWebSocketConnectionWhenClientSendPongFrameWithRsv7()
            throws Exception
    {
        k3po.finish();
    }

}
