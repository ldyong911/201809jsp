package kr.or.ddit.lprod.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.lprod.model.LprodVO;
import kr.or.ddit.lprod.service.ILprodService;
import kr.or.ddit.lprod.service.LprodServiceImpl;
import kr.or.ddit.util.model.PageVO;

@WebServlet("/lprodPagingList")
public class LprodPagingListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private ILprodService lprodService;
	
	@Override
	public void init() throws ServletException {
		lprodService = new LprodServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageStr = request.getParameter("page");
		String pageSizeStr = request.getParameter("pageSize");
		
		int page = pageStr == null ? 1 : Integer.parseInt(pageStr);
		int pageSize = pageSizeStr == null ? 5 : Integer.parseInt(pageSizeStr);
		
		PageVO pageVO = new PageVO(page, pageSize);
		
		Map<String, Object> resultMap = lprodService.selectLprodPagingList(pageVO);
		List<LprodVO> lprodList = (List<LprodVO>)resultMap.get("lprodList");
		int lprodCnt = (Integer)resultMap.get("lprodCnt");
		
		request.setAttribute("lprodList", lprodList);
		request.setAttribute("lprodCnt", lprodCnt);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("page", page);
		
		request.getRequestDispatcher("/lprod/lprodPagingList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}