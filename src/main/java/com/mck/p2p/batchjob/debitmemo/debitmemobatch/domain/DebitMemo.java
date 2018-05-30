package com.mck.p2p.batchjob.debitmemo.debitmemobatch.domain;

public class DebitMemo {

	private String id;
	private String description;
	private String supplier;
	
	public DebitMemo(){
		
	}
	
	public DebitMemo(String id, String description,String supplier) {
		super();
		this.id = id;
		this.description = description;
		this.supplier =supplier;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	
	@Override
	public String toString() {
		return "DebitMemo [id=" + id + ", "
				+ "description=" + description + ", "
						+ "supplier=" + supplier + "]";
	}
	
}
