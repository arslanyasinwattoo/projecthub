package com.bnu.springdemo.entity;

// Generated Apr 19, 2014 6:58:41 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * OrderProductId generated by hbm2java
 */
@Embeddable
public class OrderProductId implements java.io.Serializable {

	private long orderId;
	private long productId;

	public OrderProductId() {
	}

	public OrderProductId(long orderId, long productId) {
		this.orderId = orderId;
		this.productId = productId;
	}

	@Column(name = "order_id", nullable = false)
	public long getOrderId() {
		return this.orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	@Column(name = "product_id", nullable = false)
	public long getProductId() {
		return this.productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof OrderProductId))
			return false;
		OrderProductId castOther = (OrderProductId) other;

		return (this.getOrderId() == castOther.getOrderId())
				&& (this.getProductId() == castOther.getProductId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getOrderId();
		result = 37 * result + (int) this.getProductId();
		return result;
	}

}
