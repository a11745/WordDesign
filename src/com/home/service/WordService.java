package com.home.service;
import java.util.List;
import com.home.domain.Words;

public interface WordService {
	public Boolean addWord(String wordName,String quality,Integer userid,String chinese);
	public List<Words> achieve(Integer userid,Integer state);
	public Boolean editWord(Integer id,String wordName,String quality,Integer userid,String chinese);
	public Boolean delWord(Integer id,Integer userid);
	public Boolean studyWord(Integer id,String wordName,String quality,Integer userid,String chinese);
	public Boolean okWord(Integer id,Integer userid);
	
}
