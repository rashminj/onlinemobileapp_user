package com.cg.oma.Resposeinfo;

public class ResponseInfo {
	private int status;
    private String acknowledgement;
    private String msg;
    private String path;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getAcknowledgement() {
		return acknowledgement;
	}
	public void setAcknowledgement(String acknowledgement) {
		this.acknowledgement = acknowledgement;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public ResponseInfo(int status, String acknowledgement, String msg, String path) {
        super();
        this.status = status;
        this.acknowledgement = acknowledgement;
        this.msg = msg;
        this.path = path;
    }
	@Override
	public String toString() {
		return "ResponseInfo [status=" + status + ", acknowledgement=" + acknowledgement + ", msg=" + msg + ", path="
				+ path + "]";
	}
    
    
}
