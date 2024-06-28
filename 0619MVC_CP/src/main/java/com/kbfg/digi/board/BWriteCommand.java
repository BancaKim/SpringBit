package com.kbfg.digi.board;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.kbfg.digi.Command;
import com.kbfg.digi.DAO.BoardDAO;
import com.kbfg.digi.DTO.BoardBean;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


public class BWriteCommand implements Command {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		BoardDAO boarddao=new BoardDAO();
	   	BoardBean boarddata=new BoardBean();
	   	
		String realFolder="";
   		String saveFolder="/boardupload";
   		
   		int fileSize=5*1024*1024;
   		
   		realFolder=request.getRealPath(saveFolder);
   		
   		boolean result=false;
   		
   		try{
   			MultipartRequest multi=null;
   			multi=new MultipartRequest(request,
   					realFolder,
   					fileSize,
   					"euc-kr",
   					new DefaultFileRenamePolicy());
   			
   			boarddata.setBOARD_NAME(multi.getParameter("BOARD_NAME"));
   			boarddata.setBOARD_PASS(multi.getParameter("BOARD_PASS"));
	   		boarddata.setBOARD_SUBJECT(multi.getParameter("BOARD_SUBJECT"));
	   		boarddata.setBOARD_CONTENT(multi.getParameter("BOARD_CONTENT"));
	   		boarddata.setBOARD_FILE(
	   				multi.getFilesystemName((String)multi.getFileNames().nextElement()));
	   		
	   		result=boarddao.boardInsert(boarddata);

	   		if(result==false){
	   			System.out.println("게시글 업로드에 실패하였습니다.");
	   		}
	   		System.out.println("게시글 업로드에 성공하였습니다.");
	   		
	   		
  		}catch(Exception ex){
   			ex.printStackTrace();
   		}
	}  	
}