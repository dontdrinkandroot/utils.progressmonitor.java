/**
 * Copyright (C) 2013 Philip W. Sorst <philip@sorst.net>
 * and individual contributors as indicated
 * by the @authors tag.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.dontdrinkandroot.utils.progressmonitor;

import net.dontdrinkandroot.utils.progressmonitor.impl.SimpleProgressMonitor;

import org.junit.Assert;
import org.junit.Test;


public class ProgressMonitorTest
{

	@Test
	public void testWorkflow()
	{
		SimpleProgressMonitor rootMonitor = new SimpleProgressMonitor();
		rootMonitor.setMessage("rootMessage");

		Assert.assertEquals(0, rootMonitor.getProgress());
		Assert.assertEquals("rootMessage", rootMonitor.getMessage());

		Assert.assertEquals(0, rootMonitor.getAccumulatedProgress());
		Assert.assertEquals("rootMessage", rootMonitor.getAccumulatedMessage());

		ProgressMonitor aMonitor = rootMonitor.createChildMonitor(0, 40);
		aMonitor.setMessage("aMessage");

		Assert.assertEquals(0, aMonitor.getProgress());
		Assert.assertEquals("aMessage", aMonitor.getMessage());

		Assert.assertEquals(0, aMonitor.getAccumulatedProgress());
		Assert.assertEquals("aMessage", aMonitor.getAccumulatedMessage());

		Assert.assertEquals(0, rootMonitor.getProgress());
		Assert.assertEquals("rootMessage", rootMonitor.getMessage());

		Assert.assertEquals(0, rootMonitor.getAccumulatedProgress());
		Assert.assertEquals("rootMessage - aMessage", rootMonitor.getAccumulatedMessage());

		ProgressMonitor bMonitor = aMonitor.createChildMonitor(0, 50);
		bMonitor.setMessage("bMessage");

		Assert.assertEquals(0, bMonitor.getProgress());
		Assert.assertEquals("bMessage", bMonitor.getMessage());

		Assert.assertEquals(0, bMonitor.getAccumulatedProgress());
		Assert.assertEquals("bMessage", bMonitor.getAccumulatedMessage());

		Assert.assertEquals(0, aMonitor.getProgress());
		Assert.assertEquals("aMessage", aMonitor.getMessage());

		Assert.assertEquals(0, aMonitor.getAccumulatedProgress());
		Assert.assertEquals("aMessage - bMessage", aMonitor.getAccumulatedMessage());

		Assert.assertEquals(0, rootMonitor.getProgress());
		Assert.assertEquals("rootMessage", rootMonitor.getMessage());

		Assert.assertEquals(0, rootMonitor.getAccumulatedProgress());
		Assert.assertEquals("rootMessage - aMessage - bMessage", rootMonitor.getAccumulatedMessage());

		bMonitor.setProgress(50);
		bMonitor.setMessage("bMessage50");

		Assert.assertEquals(50, bMonitor.getProgress());
		Assert.assertEquals("bMessage50", bMonitor.getMessage());

		Assert.assertEquals(50, bMonitor.getAccumulatedProgress());
		Assert.assertEquals("bMessage50", bMonitor.getAccumulatedMessage());

		Assert.assertEquals(0, aMonitor.getProgress());
		Assert.assertEquals("aMessage", aMonitor.getMessage());

		Assert.assertEquals(25, aMonitor.getAccumulatedProgress());
		Assert.assertEquals("aMessage - bMessage50", aMonitor.getAccumulatedMessage());

		Assert.assertEquals(0, rootMonitor.getProgress());
		Assert.assertEquals("rootMessage", rootMonitor.getMessage());

		Assert.assertEquals(10, rootMonitor.getAccumulatedProgress());
		Assert.assertEquals("rootMessage - aMessage - bMessage50", rootMonitor.getAccumulatedMessage());

		bMonitor.setProgress(100);
		bMonitor.setMessage("bMessage100");

		Assert.assertEquals(100, bMonitor.getProgress());
		Assert.assertEquals("bMessage100", bMonitor.getMessage());

		Assert.assertEquals(100, bMonitor.getAccumulatedProgress());
		Assert.assertEquals("bMessage100", bMonitor.getAccumulatedMessage());

		Assert.assertEquals(0, aMonitor.getProgress());
		Assert.assertEquals("aMessage", aMonitor.getMessage());

		Assert.assertEquals(50, aMonitor.getAccumulatedProgress());
		Assert.assertEquals("aMessage - bMessage100", aMonitor.getAccumulatedMessage());

		Assert.assertEquals(0, rootMonitor.getProgress());
		Assert.assertEquals("rootMessage", rootMonitor.getMessage());

		Assert.assertEquals(20, rootMonitor.getAccumulatedProgress());
		Assert.assertEquals("rootMessage - aMessage - bMessage100", rootMonitor.getAccumulatedMessage());

		ProgressMonitor cMonitor = aMonitor.createChildMonitor(50, 100);
		cMonitor.setMessage("cMessage");

		Assert.assertEquals(0, cMonitor.getProgress());
		Assert.assertEquals("cMessage", cMonitor.getMessage());

		Assert.assertEquals(0, cMonitor.getAccumulatedProgress());
		Assert.assertEquals("cMessage", cMonitor.getAccumulatedMessage());

		Assert.assertEquals(50, aMonitor.getProgress());
		Assert.assertEquals("aMessage", aMonitor.getMessage());

		Assert.assertEquals(50, aMonitor.getAccumulatedProgress());
		Assert.assertEquals("aMessage - cMessage", aMonitor.getAccumulatedMessage());

		Assert.assertEquals(0, rootMonitor.getProgress());
		Assert.assertEquals("rootMessage", rootMonitor.getMessage());

		Assert.assertEquals(20, rootMonitor.getAccumulatedProgress());
		Assert.assertEquals("rootMessage - aMessage - cMessage", rootMonitor.getAccumulatedMessage());

		cMonitor.setProgress(50);
		cMonitor.setMessage("cMessage50");

		Assert.assertEquals(50, cMonitor.getProgress());
		Assert.assertEquals("cMessage50", cMonitor.getMessage());

		Assert.assertEquals(50, cMonitor.getAccumulatedProgress());
		Assert.assertEquals("cMessage50", cMonitor.getAccumulatedMessage());

		Assert.assertEquals(50, aMonitor.getProgress());
		Assert.assertEquals("aMessage", aMonitor.getMessage());

		Assert.assertEquals(75, aMonitor.getAccumulatedProgress());
		Assert.assertEquals("aMessage - cMessage50", aMonitor.getAccumulatedMessage());

		Assert.assertEquals(0, rootMonitor.getProgress());
		Assert.assertEquals("rootMessage", rootMonitor.getMessage());

		Assert.assertEquals(30, rootMonitor.getAccumulatedProgress());
		Assert.assertEquals("rootMessage - aMessage - cMessage50", rootMonitor.getAccumulatedMessage());

		cMonitor.setProgress(100);
		cMonitor.setMessage("cMessage100");

		Assert.assertEquals(100, cMonitor.getProgress());
		Assert.assertEquals("cMessage100", cMonitor.getMessage());

		Assert.assertEquals(100, cMonitor.getAccumulatedProgress());
		Assert.assertEquals("cMessage100", cMonitor.getAccumulatedMessage());

		Assert.assertEquals(50, aMonitor.getProgress());
		Assert.assertEquals("aMessage", aMonitor.getMessage());

		Assert.assertEquals(100, aMonitor.getAccumulatedProgress());
		Assert.assertEquals("aMessage - cMessage100", aMonitor.getAccumulatedMessage());

		Assert.assertEquals(0, rootMonitor.getProgress());
		Assert.assertEquals("rootMessage", rootMonitor.getMessage());

		Assert.assertEquals(40, rootMonitor.getAccumulatedProgress());
		Assert.assertEquals("rootMessage - aMessage - cMessage100", rootMonitor.getAccumulatedMessage());

		rootMonitor.setProgress(80);
		rootMonitor.setMessage("rootMessage80");

		Assert.assertEquals(80, rootMonitor.getProgress());
		Assert.assertEquals("rootMessage80", rootMonitor.getMessage());

		Assert.assertEquals(80, rootMonitor.getAccumulatedProgress());
		Assert.assertEquals("rootMessage80", rootMonitor.getAccumulatedMessage());
	}

	@Test
	public void testInvalidParameters()
	{
		try {
			new SimpleProgressMonitor(0, null);
			Assert.fail("Exception expected");
		} catch (IllegalArgumentException e) {
			/* Expected */
		}

		try {
			new SimpleProgressMonitor(-1, "");
			Assert.fail("Exception expected");
		} catch (IllegalArgumentException e) {
			/* Expected */
		}

		try {
			new SimpleProgressMonitor(101, "");
			Assert.fail("Exception expected");
		} catch (IllegalArgumentException e) {
			/* Expected */
		}

		ProgressMonitor monitor = new SimpleProgressMonitor();
		try {
			monitor.setProgress(-1);
			Assert.fail("Exception expected");
		} catch (IllegalArgumentException e) {
			/* Expected */
		}

		try {
			monitor.setProgress(101);
			Assert.fail("Exception expected");
		} catch (IllegalArgumentException e) {
			/* Expected */
		}

		try {
			monitor.setMessage(null);
			Assert.fail("Exception expected");
		} catch (IllegalArgumentException e) {
			/* Expected */
		}
	}

}
