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



public class SimpleProgressMonitor implements ProgressMonitor {

	public static final String SEPARATOR = " - ";

	private int progress = 0;

	private String message = "";

	private SimpleProgressMonitor childMonitor;

	private int startPercent;

	private int endPercent;


	public SimpleProgressMonitor() {

		/* Default constructor, noop */
	}


	public SimpleProgressMonitor(int progress, String message) {

		this.setProgress(progress);
		this.setMessage(message);
	}


	@Override
	public ProgressMonitor createChildMonitor(int startPercent, int endPercent) {

		if (startPercent > endPercent) {
			throw new IllegalArgumentException("startPercent must be smaller equals endPercent");
		}

		if (startPercent < 0 || startPercent > 100) {
			throw new IllegalArgumentException("startPercent must be in [0, 100]");
		}

		if (endPercent < 0 || endPercent > 100) {
			throw new IllegalArgumentException("endPercent must be in [0, 100]");
		}

		this.progress = startPercent;
		this.startPercent = startPercent;
		this.endPercent = endPercent;

		return this.childMonitor = new SimpleProgressMonitor();
	}


	@Override
	public void setMessage(String message) {

		if (message == null) {
			throw new IllegalArgumentException("Message must not be null");
		}

		this.message = message;
	}


	@Override
	public void setProgress(int progress) {

		if (progress < 0 || progress > 100) {
			throw new IllegalArgumentException("Progress must be in [0, 100]");
		}

		this.childMonitor = null;
		this.progress = progress;
	}


	@Override
	public int getProgress() {

		return this.progress;
	}


	@Override
	public String getMessage() {

		return this.message;
	}


	@Override
	public int getAccumulatedProgress() {

		if (this.childMonitor == null) {
			return this.progress;
		}

		int childAccumulatedProgress = this.childMonitor.getAccumulatedProgress();
		int rangeSize = this.endPercent - this.startPercent;

		return this.startPercent + (rangeSize * childAccumulatedProgress / 100);
	}


	@Override
	public String getAccumulatedMessage() {

		if (this.childMonitor == null) {
			return this.message;
		}

		return this.message + SimpleProgressMonitor.SEPARATOR + this.childMonitor.getAccumulatedMessage();
	}


	@Override
	public String getAccumulatedMessage(String separator) {

		if (this.childMonitor == null) {
			return this.message;
		}

		return this.message + separator + this.childMonitor.getAccumulatedMessage(separator);
	}


	@Override
	public ProgressStatus getProgressStatus() {

		return new ProgressStatus(this.getAccumulatedProgress(), this.getAccumulatedMessage());
	}


	@Override
	public ProgressStatus getProgressStatus(String separator) {

		return new ProgressStatus(this.getAccumulatedProgress(), this.getAccumulatedMessage(separator));
	}


	@Override
	public List<String> getAccumulatedMessages() {

		List<String> messages = new ArrayList<String>();
		messages.add(this.message);
		if (this.childMonitor != null) {
			this.childMonitor.addAccumulatedMessages(messages);
		}

		return messages;
	}


	private void addAccumulatedMessages(List<String> messages) {

		messages.add(this.message);
		if (this.childMonitor != null) {
			this.childMonitor.addAccumulatedMessages(messages);
		}
	}

}
