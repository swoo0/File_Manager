package kr.co.file.controller;

import java.io.IOException;

import kr.co.file.annotation.RequestMapping;
import kr.co.file.service.FileService;
import kr.co.file.service.FileServiceImpl;
import kr.co.file.service.MapService;
import kr.co.file.service.MapServiceImpl;

public class FileController {

	private FileService fileService = FileServiceImpl.getInstance();
	private MapService mapService = MapServiceImpl.getInstance();
	
	@RequestMapping(url = "/file/list")
	public void list() throws IOException {
		fileService.getFileList();
	}

	@RequestMapping(url = "/file/create")
	public void createFile() throws IOException {
		fileService.createFile();
	}

	@RequestMapping(url = "/file/delete")
	public void deleteFile() throws IOException {
		fileService.deleteFile();
	}

	@RequestMapping(url = "/file/content/read")
	public void readFileContent() throws IOException {
		fileService.readFileContent();
	}

	@RequestMapping(url = "/file/content/write")
	public void writeFileContent() throws IOException {
		fileService.writeFileContent();
	}
	
	@RequestMapping(url = "/subway/list")
	public void subwayList() throws Exception {
		mapService.getSubwayList();
	}
	
}
