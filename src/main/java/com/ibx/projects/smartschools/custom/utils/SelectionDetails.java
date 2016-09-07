package com.ibx.projects.smartschools.custom.utils;

public class SelectionDetails {
	
	private Long totalElements;
	private Long startIndex;
	private Long currentPage;
	private Long totalPages;
	private String baseItemRestUri;

	public SelectionDetails() {
		// TODO Auto-generated constructor stub
	}
	
	public SelectionDetails(Long totalElements, Long startIndex,
			Long currentPage, Long totalPages, String baseItemRestUri) {
		super();
		this.totalElements = totalElements;
		this.startIndex = startIndex;
		this.currentPage = currentPage;
		this.totalPages = totalPages;
		this.baseItemRestUri = baseItemRestUri;
	}

	public Long getTotalElements() {
		return totalElements;
	}

	public Long getStartIndex() {
		return startIndex;
	}

	public Long getCurrentPage() {
		return currentPage;
	}

	public Long getTotalPages() {
		return totalPages;
	}

	public String getBaseItemRestUri() {
		return baseItemRestUri;
	}

	public void setTotalElements(Long totalElements) {
		this.totalElements = totalElements;
	}

	public void setStartIndex(Long startIndex) {
		this.startIndex = startIndex;
	}

	public void setCurrentPage(Long currentPage) {
		this.currentPage = currentPage;
	}

	public void setTotalPages(Long totalPages) {
		this.totalPages = totalPages;
	}

	public void setBaseItemRestUri(String baseItemRestUri) {
		this.baseItemRestUri = baseItemRestUri;
	}

}
