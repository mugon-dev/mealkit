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
}
