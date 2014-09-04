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
package net.dontdrinkandroot.utils.progressmonitor.impl;

import java.util.ArrayList;
import java.util.List;

import net.dontdrinkandroot.utils.progressmonitor.ProgressMonitor;
import net.dontdrinkandroot.utils.progressmonitor.ProgressStatus;


/**
 * A ProgressMonitor that does not update. Can be used if a progress monitor is required as an argument.
 * 
 * @author Philip W. Sorst <philip@sorst.net>
 * 
 */
public class DummyProgressMonitor implements ProgressMonitor
{

	@Override
	public void setProgress(int progress)
	{
		/* Noop */
	}

	@Override
	public int getProgress()
	{
		return 0;
	}

	@Override
	public String getMessage()
	{
		return "";
	}

	@Override
	public int getAccumulatedProgress()
	{
		return 0;
	}

	@Override
	public String getAccumulatedMessage()
	{
		return "";
	}

	@Override
	public String getAccumulatedMessage(String separator)
	{
		return "";
	}

	@Override
	public void setMessage(String message)
	{
		/* Noop */
	}

	@Override
	public ProgressMonitor createChildMonitor(int startPercent, int endPercent)
	{
		return this;
	}

	@Override
	public ProgressStatus getProgressStatus()
	{
		return new ProgressStatus();
	}

	@Override
	public ProgressStatus getProgressStatus(String separator)
	{
		return new ProgressStatus();
	}

	@Override
	public List<String> getAccumulatedMessages()
	{
		return new ArrayList<String>();
	}

}
