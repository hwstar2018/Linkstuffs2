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
package org.thingsboard.server.dao.model.sql;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.thingsboard.server.common.data.alarm.AlarmInfo;

@Data
@EqualsAndHashCode(callSuper = true)
public class AlarmInfoEntity extends AbstractAlarmEntity<AlarmInfo> {

    private String originatorName;

    public AlarmInfoEntity() {
        super();
    }

    public AlarmInfoEntity(AlarmEntity alarmEntity) {
        super(alarmEntity);
    }

    @Override
    public AlarmInfo toData() {
        return new AlarmInfo(super.toAlarm(), this.originatorName);
    }
}
