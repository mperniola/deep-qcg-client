/*
 * Copyright © 2019 I.N.F.N.
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

package it.infn.ba.deep.qcg.client;

import feign.RequestLine;
import feign.Param;
import feign.Headers;

import it.infn.ba.deep.qcg.client.model.Job;
import it.infn.ba.deep.qcg.client.model.JobCollection;
//import it.infn.ba.deep.qcg.client.model.JobCollection;
import it.infn.ba.deep.qcg.client.model.JobDescription;
import it.infn.ba.deep.qcg.client.model.Resources;
//import it.infn.ba.deep.qcg.client.model.JobDescriptionResources;
import it.infn.ba.deep.qcg.client.utils.QcgException;

public interface Qcg {
	
	
  @RequestLine("GET /jobs  ")
  JobCollection getJobs();

  @RequestLine("GET /jobs?page={page}&page_size={page_size}")
  JobCollection getJobs(@Param("page") int page, @Param("page_size") int page_size);

  @RequestLine("GET /jobs/{id}")
  Job getJob(@Param("id") String id);

  @RequestLine("GET /resources")
  Resources getResources();

  @Headers("Content-Type: application/json")
  @RequestLine("POST /jobs/")
  Job createJob(JobDescription job) throws QcgException;  
  
  @RequestLine("DELETE /jobs/{id}")
  void deleteJob(@Param("id") String id) throws QcgException;

  
}
