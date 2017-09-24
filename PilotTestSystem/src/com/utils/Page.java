package com.utils;
import java.sql.SQLException;
public class Page {
		//当前页码
		private int curPage;
		//每一页显示的题目数量
		private int pageSize;
		//从数据库查询得到总共的记录
		private int rowCount;
		//// 该值通过pageSize和rowCount计算得到的总页码
		private int pageCount;
		public Page(){}
		public Page(int curPage,int pageSize,int rowCount,int pageCount){
			this.curPage=curPage;
			this.pageSize=pageSize;
			this.rowCount=rowCount;
			this.pageCount=pageCount;
		}
		public int getCurPage() {
			return curPage;
		}
		public void setCurPage(int curPage) {
				this.curPage = curPage;
		}
		public int getPageSize() {
			return pageSize;
		}
		public void setPageSize(int pageSize) {
			this.pageSize = pageSize;
		}
		public int getRowCount() {
			return rowCount;
		}
		public void setRowCount(int rowCount) {
			this.rowCount = rowCount;
		}
		public void setPageCount(int pageCount) {
			this.pageCount = pageCount;
		}
		public int getPageCount() {
			return pageCount;
		}
		
		public int setPage(int rowCount ) throws SQLException{
			this.rowCount=rowCount;
		//计算pageCount
		if(this.rowCount%this.pageSize==0){
			pageCount=rowCount/pageSize;
		}
		else{
			pageCount=rowCount/pageSize+1;
		}
		return pageCount;
		
	}



}
