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
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.apache.log4j.BasicConfigurator;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Unit test for simple App.
 */
public class AppTest
        extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * creates an instance of App class and execute javapart() method
     * Rigourous Test :-)
     */
    public void testJavapart() throws InterruptedException {
        long start = System.currentTimeMillis();
        App appInstance=new App();
        appInstance.javapart();
        long end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start) + " ms.");
        assertTrue( true );
    }


    /**
     * creates an instance of App class and execute javapartwithoutscripting()
     */

    public void testJavaPartWithoutScripting(){
        long start = System.currentTimeMillis();
        App appInstance=new App();
        appInstance.javapartwithoutscripting();
        long end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start) + " ms.");
        assertTrue( true );
    }
    /**
     * creates an insance of App class and execute siddhipart() method
     * @throws InterruptedException
     */

    public void testSiddhi() throws InterruptedException {
        long start = System.currentTimeMillis();
        App appInstance=new App();
        appInstance.siddhipart();
        long end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start) + " ms.");
        assertTrue( true );

    }






}
