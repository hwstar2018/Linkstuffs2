/**
 * Copyright © 2016-2023 The Linkstuffs Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.service.telemetry;

import org.springframework.web.socket.CloseStatus;
import org.thingsboard.server.service.telemetry.cmd.v2.CmdUpdate;
import org.thingsboard.server.service.telemetry.cmd.v2.DataUpdate;
import org.thingsboard.server.service.telemetry.sub.TelemetrySubscriptionUpdate;

/**
 * Created by ashvayka on 27.03.18.
 */
public interface TelemetryWebSocketService {

    void handleWebSocketSessionEvent(TelemetryWebSocketSessionRef sessionRef, SessionEvent sessionEvent);

    void handleWebSocketMsg(TelemetryWebSocketSessionRef sessionRef, String msg);

    void sendWsMsg(String sessionId, TelemetrySubscriptionUpdate update);

    void sendWsMsg(String sessionId, CmdUpdate update);

    void close(String sessionId, CloseStatus status);
}
