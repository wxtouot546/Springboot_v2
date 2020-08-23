package com.fc.test.service;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.hutool.core.util.StrUtil;
import com.fc.test.common.base.BaseService;
import com.fc.test.common.support.ConvertUtil;
import com.fc.test.mapper.auto.ThDiscussMapper;
import com.fc.test.mapper.auto.ThDiscussRelationGroupMapper;
import com.fc.test.mapper.auto.ThHistoryMapper;
import com.fc.test.mapper.auto.ThIpMapper;
import com.fc.test.mapper.auto.ThTaskMapper;
import com.fc.test.mapper.auto.ThTaskSplitMapper;
import com.fc.test.mapper.auto.ThUserMapper;
import com.fc.test.model.auto.ThDiscuss;
import com.fc.test.model.auto.ThDiscussRelationGroup;
import com.fc.test.model.auto.ThHistory;
import com.fc.test.model.auto.ThIp;
import com.fc.test.model.auto.ThTask;
import com.fc.test.model.auto.ThTaskExample;
import com.fc.test.model.auto.ThTaskSplit;
import com.fc.test.model.auto.ThUser;
import com.fc.test.model.custom.Tablepar;
import com.fc.test.util.PaChongUtil;
import com.fc.test.util.SnowflakeIdWorker;
import com.fc.test.util.StringUtils;
import com.fc.test.util.xgltUtil;

/**
 *  ThTaskService
 * @Title: ThTaskService.java 
 * @Package com.fc.test.service 
 * @author ssss_自动生成
 * @email ssss@qq.com
 * @date 2020-08-09 13:18:53  
 **/
@Service
public class ThTaskService implements BaseService<ThTask, ThTaskExample>{
	@Autowired
	private ThTaskMapper thTaskMapper;
	@Autowired
	private ThUserMapper thUserMapper;
	@Autowired
	private ThDiscussMapper thDiscussMapper;
	@Autowired
	private ThTaskSplitMapper thTaskSplitMapper;
	@Autowired
	private ThDiscussRelationGroupMapper thDiscussRelationGroupMapper;
	@Autowired
	private ThHistoryMapper thHistoryMapper;
	@Autowired
	private ThIpMapper thIpMapper;
	
      	   	      	      	      	      	      	      	      	      	      	      	      	      	      	      	
	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	 public PageInfo<ThTask> list(Tablepar tablepar,String searchText,String status){
	        ThTaskExample testExample=new ThTaskExample();
	        testExample.setOrderByClause("id ASC");
	        if(StrUtil.isNotEmpty(searchText)){
	        	testExample.createCriteria().andUrlLike("%"+searchText+"%");
	        }
			if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
	        	testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
	        }
			if(StrUtil.isNotEmpty(status)) {
				testExample.setStatus(status);
			}
	        PageHelper.startPage(tablepar.getPageNum(), tablepar.getPageSize());
	        // 在这里吧所有的用户ID 都拿出来存起来
	        
	        List<ThTask> list= thTaskMapper.selectByExample(testExample);
	        if(null != list && list.size() != 0) {
	        	for(int s = 0; s < list.size(); s++) {
	        		String userName="";
	        		String duscussName = "";
	        		// 判断是否有用户
	        		if(null != list.get(s).getUserIds() && !list.get(s).getUserIds().equals("")) {
	        			String[] s1=list.get(s).getUserIds().split(",");
	        			for(int t = 0; t < s1.length; t++) {
	        				ThUser us = new ThUser();
	        				us.setId(Integer.parseInt(s1[t]));
	        				ThUser usName = thUserMapper.selectAllbyisid(us);
	        				// 如果不为空添加用户名
	        				if(null != usName) {
	        					userName += usName.getUserId() + ",";
	        				}
	        			}
	        			if(!userName.equals("")) {
	        				// 去掉最后一个逗号 添加进去
	        				list.get(s).setUserNames(userName.substring(0,userName.length()-1));
	        			}
	        		}
	        		if(null != list.get(s).getDuscussIds() && !list.get(s).getDuscussIds().equals("")) {
	        			// 这里写评论
	        			String[] s2=list.get(s).getDuscussIds().split(",");
	        			for(int t = 0; t < s2.length; t++) {
	        				ThDiscuss scName = thDiscussMapper.selectByPrimaryKey(Integer.parseInt(s2[t]));
	        				// 如果不为空添加评论内容
	        				if(null != scName) {
	        					duscussName += scName.getDiscussName() + ",";
	        				}
	        			}
	        			if(!duscussName.equals("")) {
	        				// 去掉最后一个逗号 添加进去
	        				list.get(s).setDuscussNames(duscussName.substring(0,duscussName.length()-1));
	        			}
	        			
	        		}
	        		
	        	}
	        }
	        PageInfo<ThTask> pageInfo = new PageInfo<ThTask>(list);
	        return  pageInfo;
	 }

	@Override
	public int deleteByPrimaryKey(String ids) {
					
			Integer[] integers = ConvertUtil.toIntArray(",", ids);
			List<Integer> stringB = Arrays.asList(integers);
			ThTaskExample example=new ThTaskExample();
			example.createCriteria().andIdIn(stringB);
			return thTaskMapper.deleteByExample(example);
			
				
	}
	
	
	@Override
	public ThTask selectByPrimaryKey(String id) {
				
			Integer id1 = Integer.valueOf(id);
			return thTaskMapper.selectByPrimaryKey(id1);
				
	}

	
	@Override
	public int updateByPrimaryKeySelective(ThTask record) {
		thTaskSplitMapper.deleteByPrimaryKeys(record.getId());
		// 创建任务
		List<ThTaskSplit> sp = sps(record);
		
		if(null != sp && sp.size() != 0) {
			thTaskSplitMapper.insertList(sp);
			// 插入成功后面开始执行任务  爬虫   新启动一个线程 例如：tiezi+id
			Thread thread = new Thread(){
				public void run(){
					pachong(record.getId());
				}
			};
			// 线程名字
			thread.setName("task"+record.getId());
			thread.start();
		}
		return thTaskMapper.updateByPrimaryKeySelective(record);
	}
	
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(ThTask record) {
				
		record.setId(null);
		int number = thTaskMapper.insertSelective(record);
		// 创建任务
		List<ThTaskSplit> sp = sps(record);
		
		if(null != sp && sp.size() != 0) {
			thTaskSplitMapper.insertList(sp);
			// 插入成功后面开始执行任务  爬虫   新启动一个线程 例如：tiezi+id
			Thread thread = new Thread(){
				public void run(){
					pachong(record.getId());
				}
			};
			// 线程名字
			thread.setName("task"+record.getId());
			thread.start();
		}
		return number;
	}
	
	/**
	 * 开始/暂停
	 */
	public boolean startOrEnd(String ids,int type) {
		boolean sw = true;
		ThTask chaxun = thTaskMapper.selectByPrimaryKey(Integer.parseInt(ids));
		// 任务开始
		if(type == 0) {
			Character ss = chaxun.getIsdel();
			Integer old = chaxun.getOldNumber();
			if((null == old ? 0 : old) < chaxun.getNumber()) {
				// 更改状态为开始
				chaxun.setIsdel('0');
				chaxun.setUpdateTime(new Date());
				thTaskMapper.updateByPrimaryKeySelective(chaxun);
			}else {
				chaxun.setIsdel('2');
				chaxun.setUpdateTime(new Date());
				thTaskMapper.updateByPrimaryKeySelective(chaxun);
				return sw;
			}
			Thread thread = new Thread(){
				public void run(){
					pachong(Integer.parseInt(ids));
				}
			};
			// 线程名字
			thread.setName("task"+Integer.parseInt(ids));
			thread.start();
		// 任务结束
		}else {
			boolean js = jieshu(ids);
			if(js) {
				// 更改状态为暂停
				chaxun.setIsdel('1');
				chaxun.setUpdateTime(new Date());
				thTaskMapper.updateByPrimaryKeySelective(chaxun);
			}
		}
		return sw;
	}
	public boolean jieshu(String ids) {
		
		ThreadGroup currentGroup = Thread.currentThread().getThreadGroup();

		int noThreads = currentGroup.activeCount();

		Thread[] lstThreads = new Thread[noThreads];

		currentGroup.enumerate(lstThreads);
		

		for (int i = 0; i < noThreads; i++) {
			if(lstThreads[i].getName().equals("task"+ids)) {
				lstThreads[i].interrupt();
				return true;
			}
		}
		return false;
	}
	
	public List<ThTaskSplit> sps(ThTask record) {
		List <ThTaskSplit> list= new ArrayList<>();
		if(record.getType().equals('3')) {
			for(int t = 0; t < record.getNumber(); t++) {
				ThTaskSplit sp = new ThTaskSplit();
				sp.setTaskId(record.getId());
				sp.setUserId(0);
				// 根据评论组随机进行分配 根据评论组查询评论
				sp.setDiscussId(0);
				sp.setType(0);
				sp.setCreateTime(new Date());
				list.add(sp);
			}
		}else {
			String[] s1=record.getUserIds().split(",");
			for(int t = 0; t < s1.length; t++) {
				ThTaskSplit sp = new ThTaskSplit();
				sp.setTaskId(record.getId());
				sp.setUserId(Integer.parseInt(s1[t]));
				// 根据评论组随机进行分配 根据评论组查询评论
				List<ThDiscussRelationGroup> lls = thDiscussRelationGroupMapper.selectByPrimaryidd(record.getDiscussGroupId());
				if(null == lls || lls.size() == 0) {
					// 一定默认有一条评论
					sp.setDiscussId(0);
				}else {
					sp.setDiscussId(lls.get((t+1)%lls.size()).getDiscussId());
				}
				sp.setType(0);
				sp.setCreateTime(new Date());
				list.add(sp);
			}
		}
		
		return list;
	}
	
	/**
	 * 根据任务id 执行爬虫
	 * 
	 */
	public boolean pachong(Integer id) {
		
		 List<ThTaskSplit> list = thTaskSplitMapper.selectAllius(id);
		 try {
			 ThTask chaxun = thTaskMapper.selectByPrimaryKey(id);
			 int switchs = 0;
			 Character isd = chaxun.getIsdel();
			 if(null != list && list.size() != 0 && !isd.equals('2')) {
				 for(ThTaskSplit ts :list) {
					 int fe = 0;
					 ThUser rus = new ThUser();
					 rus.setId(ts.getUserId());
					 ThUser uk  =  thUserMapper.selectAllbyisid(rus);
					 // 评论 thDiscussMapper
					 ThDiscuss dis =  thDiscussMapper.selectByPrimaryKey(ts.getDiscussId());
					 ThIp ss = thIpMapper.selectByPrimaryKey(Integer.parseInt(uk.getIpId()));
					 // 爬虫
					 PaChongUtil pac = new PaChongUtil();
					 if(!chaxun.getType().equals('3')) {
						 fe = pac.pachong(Integer.parseInt(chaxun.getType().toString()),uk.getUserId(),uk.getPassword(),
								 dis.getDiscussName(),chaxun.getUrl(),chaxun.getNumber(),ss.getIp(),uk.getId()+"");
					 }else {
						 // 随机选出IP扔进去
						 List<ThIp> thiplist =  thIpMapper.selectAll(null);
						 Random random = new Random();
						 String ipp = thiplist.get(random.nextInt(thiplist.size())).getIp();
						 pac.pachong(Integer.parseInt(chaxun.getType().toString()),null,null,null,chaxun.getUrl(),1,ipp,uk.getId()+"");
					 }
					 
					 if(!chaxun.getType().equals('3')) {
						// 更新积分
						ThUser record = new ThUser();
						rus.setId(ts.getUserId());
						rus.setFraction(fe);
						thUserMapper.updateByPrimaryKeySelective(rus);
					 }
					
					 
					 // 线程沉睡50秒
					 if(chaxun.getType().equals('3')) {
						 Thread.sleep(3000);
					 }else {
						 Random rand = new Random();
						 int selp = rand.nextInt(chaxun.getEnd() == 0 ? 3 : chaxun.getEnd() - chaxun.getStart() + 1) + chaxun.getStart();
						 Thread.sleep(selp*1000);
					 }
					 
					 // 更新主表 
					ThTask thtask = thTaskMapper.selectByPrimaryKey(id);
					// 已完成数量等于 回复数量   那么不执行了
					if((thtask.getOldNumber() == null ? 0 : thtask.getOldNumber()) >= chaxun.getNumber()) {
						ts.setType(1);
						ts.setUpdateTime(new Date());
						thTaskSplitMapper.updateByPrimaryKeySelective(ts);
						
						continue;
					}	
					// 执行完任务  开始更新状态
					ts.setType(1);
					ts.setUpdateTime(new Date());
					thTaskSplitMapper.updateByPrimaryKeySelective(ts);
					//------------------------------------------
					String thids = thtask.getDuscussIds();
					if(null != thids && !thids.equals("")) {
						thids += "," + ts.getDiscussId();
					}else {
						thids = ts.getDiscussId() + "";
					}
					thtask.setDuscussIds(thids);
					Integer old = thtask.getOldNumber();
					if(null == old) {
						thtask.setOldNumber(1);
					}else {
						thtask.setOldNumber(thtask.getOldNumber() + 1);
					}
					thtask.setUpdateTime(new Date());
					// 如果相等更新状态
					if((thtask.getOldNumber() == null ? 0 : thtask.getOldNumber()) == chaxun.getNumber()) {
						thtask.setIsdel('2');
					}
					thTaskMapper.updateByPrimaryKeySelective(thtask);
					//----------  历史纪录    ---------------
					
					ThHistory history = new ThHistory();
					history.setUserId(ts.getUserId());
					// 判断执行内容
					if(chaxun.getType().equals('1')) {
						history.setValue("用户为帖子: "+chaxun.getUrl() + "(执行回复操作)");
					}
					if(chaxun.getType().equals('2')) {
						history.setValue("用户为板块: "+chaxun.getUrl() + "(帖子抓取操作)");
					}
					if(chaxun.getType().equals('3')) {
						history.setValue("用户为帖子: "+chaxun.getUrl() + "(浏览量操作)");
					}
					history.setCreateTime(new Date());
					thHistoryMapper.insertSelective(history);
				}
			 }else {
				 // 如果是0条 那么就更新主表状态
				 chaxun.setIsdel('2');
				 thTaskMapper.updateByPrimaryKeySelective(chaxun);
			 }
		} catch (Exception e) {
			return false;
		}
		 return true;
	}
	
	@Override
	public int updateByExampleSelective(ThTask record, ThTaskExample example) {
		
		return thTaskMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(ThTask record, ThTaskExample example) {
		
		return thTaskMapper.updateByExample(record, example);
	}

	@Override
	public List<ThTask> selectByExample(ThTaskExample example) {
		
		return thTaskMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(ThTaskExample example) {
		
		return thTaskMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(ThTaskExample example) {
		
		return thTaskMapper.deleteByExample(example);
	}
	
	/**
	 * 检查name
	 * @param thTask
	 * @return
	 */
	public int checkNameUnique(ThTask thTask){
		ThTaskExample example=new ThTaskExample();
		example.createCriteria().andUrlEqualTo(thTask.getUrl());
		List<ThTask> list=thTaskMapper.selectByExample(example);
		return list.size();
	}


}
