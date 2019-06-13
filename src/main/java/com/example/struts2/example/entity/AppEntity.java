package com.example.struts2.example.entity;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public abstract class AppEntity
		implements Comparable<AppEntity> {

	@Override
	public String toString() {

		ReflectionToStringBuilder builder = new ReflectionToStringBuilder(this);
		builder.setExcludeNullValues(true);
		return builder.toString();
	}

	@Override
	public boolean equals(Object obj) {

		return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public int hashCode() {

		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public int compareTo(AppEntity o) {

		return CompareToBuilder.reflectionCompare(this, o);
	}

}
