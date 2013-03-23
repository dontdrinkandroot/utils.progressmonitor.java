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

import java.util.List;



public interface ProgressMonitor {

	void setProgress(int progress);


	int getProgress();


	String getMessage();


	int getAccumulatedProgress();


	String getAccumulatedMessage();


	String getAccumulatedMessage(String separator);


	void setMessage(String message);


	ProgressMonitor createChildMonitor(int startPercent, int endPercent);


	ProgressStatus getProgressStatus();


	ProgressStatus getProgressStatus(String separator);


	List<String> getAccumulatedMessages();

}
