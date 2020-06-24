package com.wildadventure.booking.models;

public class UpdatePaymentRequest {

	private boolean paid;
	private Long id;
	
	public UpdatePaymentRequest() {
		
	}
	
	public UpdatePaymentRequest(boolean paid, Long id) {
		super();
		this.paid = paid;
		this.id = id;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
