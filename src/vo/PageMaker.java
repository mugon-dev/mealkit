package vo;

public class PageMaker {
	private int pageSize = 3; 
	private int startPage;  
	private int endPage; 
	private int currentPage = 1; 
	private int start ; 
	private int end;
	private int totalCount;  
	private boolean prev; 
	private boolean next;
	
	public PageMaker() {}
	public PageMaker(int currentPage, int totalCount) { 
		this.currentPage = currentPage;
		this.totalCount = totalCount;
		
		start = (currentPage - 1) * pageSize;
		end = start + (pageSize - 1); 
		endPage = (int)(Math.ceil(currentPage / (double)pageSize)) * pageSize;
		startPage = (endPage - pageSize) + 1;
		int totalPage = (int)(Math.ceil(totalCount / (double)pageSize));
		if(endPage > totalPage) {
			endPage = totalPage; 
		}
		
		System.out.println("start: " + start + " || end: " + end + " || startPage: " + startPage  
							+ " || endPage: " + endPage + " || totalPage: " + totalPage);
		
		prev = startPage == 1 ? false : true; 
		next = endPage == totalPage ? false : true;
	}
	public PageMaker(int currentPage, int totalCount, int pageSize) { 
		this.currentPage = currentPage;
		this.totalCount = totalCount;
		this.pageSize = pageSize;
		
		start = (currentPage - 1) * pageSize;
		end = start + (pageSize - 1); 
		endPage = (int)(Math.ceil(currentPage / (double)pageSize)) * pageSize;
		startPage = (endPage - pageSize) + 1;
		int totalPage = (int)(Math.ceil(totalCount / (double)pageSize));
		if(endPage > totalPage) {
			endPage = totalPage; 
		}
		
		System.out.println("start: " + start + " || end: " + end + " || startPage: " + startPage  
							+ " || endPage: " + endPage + " || totalPage: " + totalPage);
		
		prev = startPage == 1 ? false : true; 
		next = endPage == totalPage ? false : true;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	public int getStartPage() {
		return startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public int getStart() {
		return start;
	}
	public int getEnd() {
		return end;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public boolean isPrev() {
		return prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	
}
