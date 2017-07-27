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
import org.apache.log4j.BasicConfigurator;
import org.wso2.siddhi.core.SiddhiAppRuntime;
import org.wso2.siddhi.core.SiddhiManager;
import org.wso2.siddhi.core.event.Event;
import org.wso2.siddhi.core.query.output.callback.QueryCallback;
import org.wso2.siddhi.core.stream.input.InputHandler;
import org.wso2.siddhi.core.util.EventPrinter;

import java.util.ArrayList;

/**
 * class includes seperate methods to handle an event Stream using Siddhi and java.
 *
 */
public class App
{
    /**
     *defines an  input stream
     * query has a filter
     * @throws InterruptedException
     */
    public void siddhipart() throws InterruptedException {

        String definition = "@config(async = 'true') define stream players(playerName string,country string,TestAverage float,TestStrikeRate float,ODIAverage float,ODIStrikeRate float,T20Average float,T20StrikeRate float,BattingStyle string);";
        String query = "@info(name = 'query1') from players[TestAverage>45.0 and (ODIAverage>40.0 or ODIStrikeRate>100.0) and not(T20Average<10.0 or T20StrikeRate>150.0)] select playerName, BattingStyle insert into sqaud;";
        SiddhiManager siddhiManager = new SiddhiManager();

        SiddhiAppRuntime siddhiAppRuntime=siddhiManager.createSiddhiAppRuntime(definition + query);
        siddhiAppRuntime.addCallback("query1",new QueryCallback() {
            @Override
            public void receive(long timeStamp, Event[] inEvents, Event[] removeEvents) {
               // EventPrinter.print(timeStamp, inEvents, removeEvents);
            }

        });
        InputHandler inputHandler = siddhiAppRuntime.getInputHandler("players");
        siddhiAppRuntime.start();



        for(int i=1;i<=1000000;i++){
            inputHandler.send(new Object[]{"Upul Tharanga","Sri Lanka",33.0f,62.5f,32.5f,80.5f,16.3f,116.3f,"LHB"});
            inputHandler.send(new Object[]{"Anjelo Mathews","Sri Lanka",47.6f,65.3f,42.1f,83.4f,26.3f,136.3f,"RHB"});
            inputHandler.send(new Object[]{"Asela Gunaratne","Sri Lanka",53.7f,57.4f,36.5f,85.5f,36.3f,146.7f,"RHB"});
            inputHandler.send(new Object[]{"Joe Root","England",55.8f,52.5f,52.7f,88.3f,24.9f,128.3f,"RHB"});
            inputHandler.send(new Object[]{"Ben Stokes","England",41.2f,72.5f,43.6f,90.7f,22.3f,133.8f,"LHB"});
            inputHandler.send(new Object[]{"Kane Williamson","New Zealand",54.2f,48.7f,45.1f,79.3f,29.3f,119.3f,"RHB"});
            inputHandler.send(new Object[]{"Steve Smith","Australia",63.3f,51.5f,50.5f,82.7f,16.3f,112.2f,"RHB"});
            inputHandler.send(new Object[]{"AB de Villiers","South Africa",51.9f,62.1f,52.5f,101.5f,33.3f,156.3f,"RHB"});
            inputHandler.send(new Object[]{"Hashim Amla","South Africa",47.8f,47.5f,52.5f,86.5f,26.3f,127.3f,"RHB"});
            inputHandler.send(new Object[]{"Virat Kholi","India",52.0f,66.5f,53.5f,89.5f,30.3f,136.3f,"RHB"});
            inputHandler.send(new Object[]{"Rohit Sharma","India",32.0f,62.5f,42.5f,93.5f,26.3f,141.3f,"RHB"});




        }
        siddhiAppRuntime.shutdown();


    }

    /**
     * creates instances of events(Player Objects)
     * filter them using an if statement
     */
    public void javapart(){
        Player p1=new Player();
        p1.setBattingStyle("LHB");
        p1.setCountry("Sri Lanka");
        p1.setName("Upul Tharanga");
        p1.setTestAverage(33.0f);
        p1.setTestStrikeRate(62.5f);
        p1.setODIAverage(32.5f);
        p1.setODIStrikeRate(80.5f);
        p1.setT20Average(16.3f);
        p1.setT20StrikeRate(116.3f);

        Player p2=new Player();
        p2.setBattingStyle("RHB");
        p2.setCountry("Sri Lanka");
        p2.setName("Anjelo Mathews");
        p2.setTestAverage(47.6f);
        p2.setTestStrikeRate(65.3f);
        p2.setODIAverage(42.1f);
        p2.setODIStrikeRate(83.4f);
        p2.setT20Average(26.3f);
        p2.setT20StrikeRate(136.3f);

        Player p3=new Player();
        p3.setBattingStyle("RHB");
        p3.setCountry("Sri Lanka");
        p3.setName("Asela Gunaratne");
        p3.setTestAverage(53.7f);
        p3.setTestStrikeRate(57.4f);
        p3.setODIAverage(36.5f);
        p3.setODIStrikeRate(85.5f);
        p3.setT20Average(36.3f);
        p3.setT20StrikeRate(146.7f);

        Player p4=new Player();
        p4.setBattingStyle("RHB");
        p4.setCountry("England");
        p4.setName("Joe Root");
        p4.setTestAverage(55.8f);
        p4.setTestStrikeRate(52.5f);
        p4.setODIAverage(52.7f);
        p4.setODIStrikeRate(88.3f);
        p4.setT20Average(24.9f);
        p4.setT20StrikeRate(128.3f);

        Player p5=new Player();
        p5.setBattingStyle("LHB");
        p5.setCountry("England");
        p5.setName("Ben Stokes");
        p5.setTestAverage(41.2f);
        p5.setTestStrikeRate(72.5f);
        p5.setODIAverage(43.6f);
        p5.setODIStrikeRate(90.7f);
        p5.setT20Average(22.3f);
        p5.setT20StrikeRate(133.8f);

        Player p6=new Player();
        p6.setBattingStyle("RHB");
        p6.setCountry("New Zealand");
        p6.setName("Kane Williamson");
        p6.setTestAverage(54.2f);
        p6.setTestStrikeRate(48.7f);
        p6.setODIAverage(45.1f);
        p6.setODIStrikeRate(79.3f);
        p6.setT20Average(29.3f);
        p6.setT20StrikeRate(119.3f);

        Player p7=new Player();
        p7.setBattingStyle("RHB");
        p7.setCountry("Australia");
        p7.setName("Steve Smith");
        p7.setTestAverage(63.3f);
        p7.setTestStrikeRate(51.5f);
        p7.setODIAverage(50.5f);
        p7.setODIStrikeRate(82.7f);
        p7.setT20Average(16.3f);
        p7.setT20StrikeRate(112.2f);

        Player p8=new Player();
        p8.setBattingStyle("RHB");
        p8.setCountry("South Africa");
        p8.setName("AB de  Villiers");
        p8.setTestAverage(51.9f);
        p8.setTestStrikeRate(62.1f);
        p8.setODIAverage(52.5f);
        p8.setODIStrikeRate(101.5f);
        p8.setT20Average(33.3f);
        p8.setT20StrikeRate(156.3f);

        Player p9=new Player();
        p9.setBattingStyle("RHB");
        p9.setCountry("South Africa");
        p9.setName("Hashim Amla");
        p9.setTestAverage(47.8f);
        p9.setTestStrikeRate(47.5f);
        p9.setODIAverage(52.5f);
        p9.setODIStrikeRate(86.5f);
        p9.setT20Average(26.3f);
        p9.setT20StrikeRate(127.3f);

        Player p10=new Player();
        p10.setBattingStyle("RHB");
        p10.setCountry("India");
        p10.setName("Virat Kholi");
        p10.setTestAverage(52.0f);
        p10.setTestStrikeRate(66.5f);
        p10.setODIAverage(53.5f);
        p10.setODIStrikeRate(89.5f);
        p10.setT20Average(30.3f);
        p10.setT20StrikeRate(136.3f);

        Player p11=new Player();
        p11.setBattingStyle("RHB");
        p11.setCountry("India");
        p11.setName("Rohit Sharma");
        p11.setTestAverage(32.0f);
        p11.setTestStrikeRate(62.5f);
        p11.setODIAverage(42.5f);
        p11.setODIStrikeRate(93.5f);
        p11.setT20Average(26.3f);
        p11.setT20StrikeRate(141.3f);

        ArrayList<Player> playersList= new ArrayList<Player>();
        playersList.add(p1);
        playersList.add(p2);
        playersList.add(p3);
        playersList.add(p4);
        playersList.add(p5);
        playersList.add(p6);
        playersList.add(p7);
        playersList.add(p8);
        playersList.add(p9);
        playersList.add(p10);
        playersList.add(p11);

        ArrayList<ChosenPlayer> chosenPlayersList= new ArrayList<ChosenPlayer>();


        for(int i=1;i<=1000000;i++){
            for(Player player:playersList){
                if(player.getTestAverage()>45.0 & (player.getODIAverage()>40.0 | player.getODIStrikeRate()>100.0)& !(player.getT20Average()<10.0 |player.getT20StrikeRate()>150.0)){
                    ChosenPlayer chosenPlayer=new ChosenPlayer();
                    chosenPlayer.setName(player.getName());
                    chosenPlayer.setBattingStyle(player.getBattingStyle());
                    chosenPlayer.setCountry(player.getCountry());
                    chosenPlayersList.add(chosenPlayer);
                }
            }




        }

        for(ChosenPlayer chosenPlayer:chosenPlayersList){
            /*System.out.print(chosenPlayer.getName()+" ");
            System.out.print(chosenPlayer.getCountry()+" ");
            System.out.print(chosenPlayer.getBattingStyle());
            System.out.println("");*/
        }




    }

    public static void main( String[] args ) throws InterruptedException {



    }
}
