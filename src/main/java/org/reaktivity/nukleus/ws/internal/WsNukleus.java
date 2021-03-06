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
package org.reaktivity.nukleus.ws.internal;

import java.io.Closeable;

import org.reaktivity.nukleus.Nukleus;
import org.reaktivity.nukleus.ws.internal.conductor.Conductor;
import org.reaktivity.nukleus.ws.internal.router.Router;
import org.reaktivity.nukleus.ws.internal.watcher.Watcher;

public final class WsNukleus extends Nukleus.Composite
{
    public static final String NAME = "ws";

    private final Closeable cleanup;

    WsNukleus(
        Conductor conductor,
        Watcher watcher,
        Router router,
        Closeable cleanup)
    {
        super(conductor, watcher, router);
        this.cleanup = cleanup;
    }

    @Override
    public String name()
    {
        return WsNukleus.NAME;
    }

    @Override
    public void close() throws Exception
    {
        super.close();
        cleanup.close();
    }
}
