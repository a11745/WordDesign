package com.home.serviceImpl;

import java.util.List;

import com.home.dao.WordDao;
import com.home.daoImpl.WordDaoImpl;
import com.home.domain.Words;
import com.home.service.WordService;

public class WordServiceImpl implements WordService {

	@Override
	public Boolean addWord(String wordName, String quality,Integer userid,String chinese) {
		WordDao wordDao =  new WordDaoImpl();
		int i = wordDao.addWord(wordName, quality,userid,chinese);
		if (i>0) {
			return true;
		}
		
		return false;
	}

	@Override
	public List<Words> achieve(Integer userid,Integer state) {
		WordDao wordDao =  new WordDaoImpl();
		List<Words> list = wordDao.achieve(userid,state);
		return list;
	}

	@Override
	public Boolean editWord(Integer id,String wordName, String quality, Integer userid, String chinese) {
		WordDao wordDao =  new WordDaoImpl();
		int i = wordDao.editWord(id,wordName, quality,userid,chinese);
		if (i>0) {
			return true;
		}
		
		return false;
	}

	@Override
	public Boolean delWord(Integer id, Integer userid) {
		WordDao wordDao =  new WordDaoImpl();
		int i = wordDao.delWord(id, userid);
		if (i>0) {
			return true;
		}
		
		return false;
	}

	@Override
	public Boolean studyWord(Integer id, String wordName, String quality, Integer userid, String chinese) {
		WordDao wordDao =  new WordDaoImpl();
		List<Words> list = wordDao.studyWord(id,wordName, quality,userid,chinese);
		
		if (list!=null&&list.size()>0) {
			return true;
		}
		
		return false;
	}

	@Override
	public Boolean okWord(Integer id, Integer userid) {
		WordDao wordDao =  new WordDaoImpl();
		int i = wordDao.okWord(id, userid);
		if (i>0) {
			return true;
		}
		
		return false;
	}
	

}
