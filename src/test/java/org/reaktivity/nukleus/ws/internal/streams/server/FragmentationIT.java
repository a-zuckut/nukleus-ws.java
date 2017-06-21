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
 * RFC-6455, section 5.4 "Fragmentation"
 */
public class FragmentationIT
{
    private final K3poRule k3po = new K3poRule()
            .addScriptRoot("route", "org/reaktivity/specification/nukleus/ws/control/route")
            .addScriptRoot("client", "org/reaktivity/specification/ws/fragmentation")
            .addScriptRoot("server", "org/reaktivity/specification/nukleus/ws/streams/fragmentation");

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

    @Ignore("Not implemented yet")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.send.continuation.payload.length.125.not.fragmented/handshake.request.and.frame",
        "${server}/client.send.continuation.payload.length.125.not.fragmented/handshake.response.and.frame" })
    public void shouldFailWebSocketConnectionWhenClientSendContinuationFrameWithPayloadNotFragmented()
            throws Exception
    {
        k3po.finish();
    }

    @Ignore("Not implemented yet")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.send.continuation.payload.length.125.fragmented/handshake.request.and.frames",
        "${server}/client.send.continuation.payload.length.125.fragmented/handshake.response.and.frame" })
    public void shouldFailWebSocketConnectionWhenClientSendContinuationFrameWithPayloadFragmented()
            throws Exception
    {
        k3po.finish();
    }

    @Ignore("binary instead of text")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.echo.text.payload.length.125.not.fragmented/handshake.request.and.frame",
        "${server}/client.echo.text.payload.length.125.not.fragmented/handshake.response.and.frame" })
    public void shouldEchoClientSendTextFrameWithPayloadNotFragmented()
            throws Exception
    {
        k3po.finish();
    }

    @Ignore("Not implemented yet")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.echo.text.payload.length.0.fragmented/handshake.request.and.frames",
        "${server}/client.echo.text.payload.length.0.fragmented/handshake.response.and.frame" })
    public void shouldEchoClientSendTextFrameWithEmptyPayloadFragmented()
            throws Exception
    {
        k3po.finish();
    }

    @Ignore("Not implemented yet")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.echo.text.payload.length.0.fragmented.with.injected.ping.pong/handshake.request.and.frames",
        "${server}/client.echo.text.payload.length.0.fragmented.with.injected.ping.pong/handshake.response.and.frame" })
    public void shouldEchoClientSendTextFrameWithEmptyPayloadFragmentedAndInjectedPingPong()
            throws Exception
    {
        k3po.finish();
    }

    @Ignore("Not implemented yet")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.echo.text.payload.length.125.fragmented/handshake.request.and.frames",
        "${server}/client.echo.text.payload.length.125.fragmented/handshake.response.and.frame" })
    public void shouldEchoClientSendTextFrameWithPayloadFragmented()
            throws Exception
    {
        k3po.finish();
    }

    @Ignore("Not implemented yet")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.echo.text.payload.length.125.fragmented.with.some.empty.fragments/handshake.request.and.frames",
        "${server}/client.echo.text.payload.length.125.fragmented.with.some.empty.fragments/handshake.response.and.frame" })
    public void shouldEchoClientSendTextFrameWithPayloadFragmentedWithSomeEmptyFragments()
            throws Exception
    {
        k3po.finish();
    }

    @Ignore("Not implemented yet")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.echo.text.payload.length.125.fragmented.but.not.utf8.aligned/handshake.request.and.frames",
        "${server}/client.echo.text.payload.length.125.fragmented.but.not.utf8.aligned/handshake.response.and.frame" })
    public void shouldEchoClientSendTextFrameWithPayloadFragmentedEvenWhenNotUTF8Aligned()
            throws Exception
    {
        k3po.finish();
    }

    @Ignore("Not implemented yet")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.echo.text.payload.length.125.fragmented.with.injected.ping.pong/handshake.request.and.frames",
        "${server}/client.echo.text.payload.length.125.fragmented.with.injected.ping.pong/handshake.response.and.frame" })
    public void shouldEchoClientSendTextFrameWithPayloadFragmentedAndInjectedPingPong()
            throws Exception
    {
        k3po.finish();
    }

    @Ignore("binary instead of close")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.send.text.payload.length.125.fragmented.but.not.continued/handshake.request.and.frames",
        "${server}/client.send.text.payload.length.125.fragmented.but.not.continued/handshake.response.and.frame" })
    public void shouldFailWebSocketConnectionWhenClientSendTextFrameWithPayloadFragmentedButNotContinued()
            throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.echo.binary.payload.length.125.not.fragmented/handshake.request.and.frame",
        "${server}/client.echo.binary.payload.length.125.not.fragmented/handshake.response.and.frame" })
    public void shouldEchoClientSendBinaryFrameWithPayloadNotFragmented()
            throws Exception
    {
        k3po.finish();
    }

    @Ignore("Not implemented yet")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.echo.binary.payload.length.0.fragmented/handshake.request.and.frames",
        "${server}/client.echo.binary.payload.length.0.fragmented/handshake.response.and.frame" })
    public void shouldEchoClientSendBinaryFrameWithEmptyPayloadFragmented()
            throws Exception
    {
        k3po.finish();
    }

    @Ignore("Not implemented yet")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.echo.binary.payload.length.0.fragmented.with.injected.ping.pong/handshake.request.and.frames",
        "${server}/client.echo.binary.payload.length.0.fragmented.with.injected.ping.pong/handshake.response.and.frame" })
    public void shouldEchoClientSendBinaryFrameWithEmptyPayloadFragmentedAndInjectedPingPong()
            throws Exception
    {
        k3po.finish();
    }

    @Ignore("Not implemented yet")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.echo.binary.payload.length.125.fragmented/handshake.request.and.frames",
        "${server}/client.echo.binary.payload.length.125.fragmented/handshake.response.and.frame" })
    public void shouldEchoClientSendBinaryFrameWithPayloadFragmented()
            throws Exception
    {
        k3po.finish();
    }

    @Ignore("Not implemented yet")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.echo.binary.payload.length.125.fragmented.with.some.empty.fragments/handshake.request.and.frames",
        "${server}/client.echo.binary.payload.length.125.fragmented.with.some.empty.fragments/handshake.response.and.frame" })
    public void shouldEchoClientSendBinaryFrameWithPayloadFragmentedWithSomeEmptyFragments()
            throws Exception
    {
        k3po.finish();
    }

    @Ignore("Not implemented yet")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.echo.binary.payload.length.125.fragmented.with.injected.ping.pong/handshake.request.and.frames",
        "${server}/client.echo.binary.payload.length.125.fragmented.with.injected.ping.pong/handshake.response.and.frame" })
    public void shouldEchoClientSendBinaryFrameWithPayloadFragmentedAndInjectedPingPong()
            throws Exception
    {
        k3po.finish();
    }

    @Ignore("binary instead of close")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.send.binary.payload.length.125.fragmented.but.not.continued/handshake.request.and.frames",
        "${server}/client.send.binary.payload.length.125.fragmented.but.not.continued/handshake.response.and.frame" })
    public void shouldFailWebSocketConnectionWhenClientSendBinaryFrameWithPayloadFragmentedButNotContinued()
            throws Exception
    {
        k3po.finish();
    }

    @Ignore("aborted")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.send.close.payload.length.2.fragmented/handshake.request.and.frames",
        "${server}/client.send.close.payload.length.2.fragmented/handshake.response.and.frame" })
    public void shouldFailWebSocketConnectionWhenClientSendCloseFrameWithPayloadFragmented()
            throws Exception
    {
        k3po.finish();
    }

    @Ignore("Not implemented yet")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.send.ping.payload.length.0.fragmented/handshake.request.and.frames",
        "${server}/client.send.ping.payload.length.0.fragmented/handshake.response.and.frame" })
    public void shouldFailWebSocketConnectionWhenClientSendPingFrameWithPayloadFragmented()
            throws Exception
    {
        k3po.finish();
    }

    @Ignore("Not implemented yet")
    @Test
    @Specification({
        "${route}/server/controller",
        "${client}/client.send.pong.payload.length.0.fragmented/handshake.request.and.frames",
        "${server}/client.send.pong.payload.length.0.fragmented/handshake.response.and.frame" })
    public void shouldFailWebSocketConnectionWhenClientSendPongFrameWithPayloadFragmented()
            throws Exception
    {
        k3po.finish();
    }

}

