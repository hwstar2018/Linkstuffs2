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
package org.thingsboard.server.common.data.alarm;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class AlarmInfo extends Alarm {

    private static final long serialVersionUID = 2807343093519543363L;

    @ApiModelProperty(position = 19, value = "Alarm originator name", example = "Thermostat")
    private String originatorName;

    public AlarmInfo() {
        super();
    }

    public AlarmInfo(Alarm alarm) {
        super(alarm);
    }

    public AlarmInfo(Alarm alarm, String originatorName) {
        super(alarm);
        this.originatorName = originatorName;
    }

    public String getOriginatorName() {
        return originatorName;
    }

    public void setOriginatorName(String originatorName) {
        this.originatorName = originatorName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        AlarmInfo alarmInfo = (AlarmInfo) o;

        return originatorName != null ? originatorName.equals(alarmInfo.originatorName) : alarmInfo.originatorName == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (originatorName != null ? originatorName.hashCode() : 0);
        return result;
    }
}
