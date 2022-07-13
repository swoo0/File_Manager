package kr.co.file.controller;

import java.io.IOException;
import java.sql.SQLException;

import kr.co.file.annotation.Controller;
import kr.co.file.annotation.RequestMapping;
import kr.co.file.service.FileService;
import kr.co.file.service.FileServiceImpl;
import kr.co.file.service.MapService;
import kr.co.file.service.MapServiceImpl;

@Controller
public class FileController {

	private FileService fileService = FileServiceImpl.getInstance();
	private MapService mapService = MapServiceImpl.getInstance();
	
	@RequestMapping(value = "1")
	public void list() throws IOException {
		fileService.getFileList();
	}

	@RequestMapping(value = "2")
	public void createFile() throws IOException {
		fileService.createFile();
	}

	@RequestMapping(value = "3")
	public void deleteFile() throws IOException {
		fileService.deleteFile();
	}

	@RequestMapping(value = "4")
	public void readFileContent() throws IOException {
		fileService.readFileContent();
	}

	@RequestMapping(value = "5")
	public void writeFileContent() throws IOException {
		fileService.writeFileContent();
	}
	
	@RequestMapping(value = "6")
	public void subwayList() throws SQLException {
		mapService.getSubwayList();
	}
	
	@RequestMapping(value = "7")
	public void test() throws SQLException {
		mapService.getPakageList();
	}
			
	@RequestMapping(value = "0")
	public String end() throws Exception {
		return "break";
	}
	
	
}
