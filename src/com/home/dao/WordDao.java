package com.home.dao;

import java.util.List;

import com.home.domain.Words;

public interface WordDao {
	public int addWord(String wordName,String quality,Integer userid,String chinese);
	public List<Words> achieve(Integer userid,Integer state);
	public int editWord(Integer id,String wordName,String quality,Integer userid,String chinese);
	public int delWord(Integer id,Integer userid);
	public List<Words> studyWord(Integer id,String wordName,String quality,Integer userid,String chinese);
	public int okWord(Integer id,Integer userid);
}
