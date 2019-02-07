package com.dstapplications.model;

import java.io.Serializable;

/**
 * Created by vinod on 12/08/18.
 */
public class DstSevThreeModel implements Serializable{
	
	private String Issue_Type;	
	private String Key;	
	private String Summary;
	private String Assignee;
	private String Reporter;
	private String Status;	
	private String Resolution;	
	private String Created;	
	private String Updated;
	private String Days_since_last_comment;
	private String Stream;	
	private String Priority;
	
	
	public String getIssue_Type() {
		return Issue_Type;
	}
	public void setIssue_Type(String issue_Type) {
		Issue_Type = issue_Type;
	}
	public String getKey() {
		return Key;
	}
	public void setKey(String key) {
		Key = key;
	}
	public String getReporter() {
		return Reporter;
	}
	public void setReporter(String reporter) {
		Reporter = reporter;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getResolution() {
		return Resolution;
	}
	public void setResolution(String resolution) {
		Resolution = resolution;
	}
	public String getCreated() {
		return Created;
	}
	public void setCreated(String created) {
		Created = created;
	}
	public String getStream() {
		return Stream;
	}
	public void setStream(String stream) {
		Stream = stream;
	}
	public String getPriority() {
		return Priority;
	}
	public void setPriority(String priority) {
		Priority = priority;
	}
	public String getSummary() {
		return Summary;
	}
	public void setSummary(String summary) {
		Summary = summary;
	}
	public String getAssignee() {
		return Assignee;
	}
	public void setAssignee(String assignee) {
		Assignee = assignee;
	}
	public String getUpdated() {
		return Updated;
	}
	public void setUpdated(String updated) {
		Updated = updated;
	}
	public String getDays_since_last_comment() {
		return Days_since_last_comment;
	}
	public void setDays_since_last_comment(String days_since_last_comment) {
		Days_since_last_comment = days_since_last_comment;
	}

}
