/*
* Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
* WSO2 Inc. licenses this file to you under the Apache License,
* Version 2.0 (the "License"); you may not use this file except
* in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied. See the License for the
* specific language governing permissions and limitations
* under the License.
*/
package org.pivithuru;

public class Player {
    /**
     * class to keep the values of input stream events
     */

    private String name;
    private String country;
    private float TestAverage;
    private float TestStrikeRate;
    private float ODIAverage;
    private float ODIStrikeRate;
    private float T20Average;
    private float T20StrikeRate;
    private String BattingStyle;

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public float getTestAverage() {
        return TestAverage;
    }

    public float getTestStrikeRate() {
        return TestStrikeRate;
    }

    public float getODIAverage() {
        return ODIAverage;
    }



    public float getT20Average() {
        return T20Average;
    }

    public float getT20StrikeRate() {
        return T20StrikeRate;
    }

    public String getBattingStyle() {
        return BattingStyle;

    }

    public float getODIStrikeRate() {
        return ODIStrikeRate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setTestAverage(float testAverage) {
        TestAverage = testAverage;
    }

    public void setTestStrikeRate(float testStrikeRate) {
        TestStrikeRate = testStrikeRate;
    }

    public void setODIStrikeRate(float ODIStrikeRate) {
        this.ODIStrikeRate = ODIStrikeRate;
    }

    public void setODIAverage(float ODIAverage) {
        this.ODIAverage = ODIAverage;
    }

    public void setT20Average(float t20Average) {
        T20Average = t20Average;
    }

    public void setT20StrikeRate(float t20StrikeRate) {
        T20StrikeRate = t20StrikeRate;
    }

    public void setBattingStyle(String battingStyle) {
        BattingStyle = battingStyle;
    }
}
