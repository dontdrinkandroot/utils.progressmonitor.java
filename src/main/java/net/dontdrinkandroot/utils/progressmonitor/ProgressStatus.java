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

import java.io.Serializable;


/**
 * This object holds the current status of a {@link ProgressMonitor}.
 */
public class ProgressStatus implements Serializable
{

	/** The current message. */
	private String message;

	/** The current percentage. */
	private Integer progress;


	/**
	 * Create a new Progress with percentage set to zero and an empty message.
	 */
	public ProgressStatus()
	{
		this.message = "";
		this.progress = 0;
	}

	/**
	 * Create a new Progress Status with the given percentage and message.
	 */
	public ProgressStatus(int percent, String message)
	{
		this.message = message;
		this.progress = percent;
	}

	/**
	 * Get the current message.
	 * 
	 * @return The current message.
	 */
	public final String getMessage()
	{
		return this.message;
	}

	/**
	 * Set the current message.
	 * 
	 * @param message
	 *            The current message.
	 */
	public final void setMessage(final String message)
	{
		this.message = message;
	}

	/**
	 * Get the current percentage.
	 * 
	 * @return The current percentage.
	 */
	public final Integer getProgress()
	{
		return this.progress;
	}

	/**
	 * Set the current percentage.
	 * 
	 * @param percent
	 *            The current percentage.
	 */
	public final void setProgress(final Integer percent)
	{
		this.progress = percent;
	}

}
