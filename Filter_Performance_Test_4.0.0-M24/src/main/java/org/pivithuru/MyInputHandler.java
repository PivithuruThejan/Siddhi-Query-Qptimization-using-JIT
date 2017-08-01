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

import com.sun.org.apache.xpath.internal.SourceTree;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.math.BigDecimal;

public class MyInputHandler {
    /**
     * Simulate the process of Siddhi Input Handler
     */
    private MySiddhiAppRuntime mySiddhiAppRuntime;
    private String name;
    private String country;
    private float TestAverage;
    private float TestStrikeRate;
    private float ODIAverage;
    private float ODIStrikeRate;
    private float T20Average;
    private float T20StrikeRate;
    private String battingStyle;

    private String statement;
    ScriptEngineManager factory;
    ScriptEngine engine ;

    /**
     * Instanciates require variables
     * @param mySiddhiAppRuntime
     * @param statement
     */
    public MyInputHandler(MySiddhiAppRuntime mySiddhiAppRuntime,String statement) {
        this.mySiddhiAppRuntime=mySiddhiAppRuntime;
        this.statement=statement;
        this.factory = new ScriptEngineManager();
        this.engine = factory.getEngineByName("JavaScript");

    }

    /**
     * Check whether input event can be selected
     * Expression for if-else statement is generated using a script engine
     * @param player
     */

    public void send(Player player)  {
        TestAverage=player.getTestAverage();
        TestStrikeRate=player.getTestStrikeRate();
        ODIAverage=player.getODIAverage();
        ODIStrikeRate=player.getODIStrikeRate();
        T20Average=player.getT20Average();
        T20StrikeRate=player.getT20StrikeRate();
        name=player.getName();
        country=player.getCountry();
        battingStyle=player.getBattingStyle();
        String statementNew=statement.replaceAll("TestAverage",Float.toString(TestAverage)).replaceAll("ODIAverage",Float.toString(ODIAverage)).replaceAll("ODIStrikeRate",Float.toString(ODIStrikeRate)).replaceAll("T20Average",Float.toString(T20Average)).replaceAll("T20StrikeRate",Float.toString(T20StrikeRate)).replaceAll("TestStrikeRate",Float.toString(T20StrikeRate)).replaceAll("country",country).replaceAll("name",name).replaceAll("battingStyle",battingStyle);

        try {
             Object result = engine.eval(statementNew);




             if(result.equals(1)){
                 mySiddhiAppRuntime.addCallback(player);


             }

        } catch (ScriptException e) {
            e.printStackTrace();
        }



    }

    /**
     * Check whether input event can be selected
     * Expression for if-else statement is hard coded
     * @param player
     */
    public void sendoriginal(Player player){
        TestAverage=player.getTestAverage();
        TestStrikeRate=player.getTestStrikeRate();
        ODIAverage=player.getODIAverage();
        ODIStrikeRate=player.getODIStrikeRate();
        T20Average=player.getT20Average();
        T20StrikeRate=player.getT20StrikeRate();
        name=player.getName();
        country=player.getCountry();
        battingStyle=player.getBattingStyle();
        if(TestAverage>45.0&(ODIAverage>40.0 |ODIStrikeRate >100.0) & !(T20Average <10.0 | T20StrikeRate >150.0)){
            mySiddhiAppRuntime.addCallback(player);


        }
    }
}
