package com.janita.remote.one.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author cai x d
 * created on 2017/3/4
 * 题目表:文件夹下的题目
 */
@SuppressWarnings("serial")
public class Question implements Serializable {
	
	/**
	 * 题目ID
	 */
	private	String id;
	/**
	 * 所属题库（目录）的code值
	 */
	private String catalogCode;
	/**
	 * 所属学科的id 
	 */
	private Long subjectId;
	/**
	 * 问题的题目 
	 */
	private String questionTitle;
	/**
	 * 问题的正确答案 
	 */
	private String rightAnswer;
	/**
	 * 问题的难度 
	 */
	private Integer difficulty;
	/**
	 * 关联知识点  主要关联知识点的id和name
	 */
	private List<Knowledge> relativeKnowledge;
	/**
	 * 是否分享  0是未共享 1是共享
	 */
	private Integer isShare;
	/**
	 * 被引用次数 
	 */
	private Integer quoteTimes;
	/**
	 * 浏览次数 
	 */
	private Integer viewTimes;
	/**
	 * 类型,1:单选，2：多选，3：判断，4：问答,....
	 */
	private Integer questionType;
	/**
	 * 是否删除
	 */
	private int isDel;
	/**
	 * 创建时间,时间戳，currentMiss/1000
	 */
	private Long createTime;
	/**
	 * 更新时间 
	 */
	private Long updateTime;
	/**
	 * 作者id:数据类型由其他项目的表决定
	 */
	private String teacherId;
	/**
	 * 作者的名字 
	 */
	private String teacherName;
	/**
	 * 选项的类型，图片或文字，1 图片，2文字
	 */
	private Integer itemType;
	/**
	 * 题目的答案
	 */
	private List<QuestionItem> questionItems;

	/**
	 * 题目分析
	 */
	private String analyzeQuestion;

	public Question() {
	}

	@Override
	public String toString() {
		return "Question{" +
				"id='" + id + '\'' +
				", catalogCode='" + catalogCode + '\'' +
				", subjectId=" + subjectId +
				", questionTitle='" + questionTitle + '\'' +
				", rightAnswer='" + rightAnswer + '\'' +
				", difficulty=" + difficulty +
				", relativeKnowledge=" + relativeKnowledge +
				", isShare=" + isShare +
				", quoteTimes=" + quoteTimes +
				", viewTimes=" + viewTimes +
				", questionType=" + questionType +
				", isDel=" + isDel +
				", createTime=" + createTime +
				", updateTime=" + updateTime +
				", teacherId='" + teacherId + '\'' +
				", teacherName='" + teacherName + '\'' +
				", itemType=" + itemType +
				", questionItems=" + questionItems +
				", analyzeQuestion='" + analyzeQuestion + '\'' +
				'}';
	}

	public String getAnalyzeQuestion() {
		return analyzeQuestion;
	}

	public void setAnalyzeQuestion(String analyzeQuestion) {
		this.analyzeQuestion = analyzeQuestion;
	}

	public Question(String id, String catalogCode, Long subjectId, String questionTitle, String rightAnswer, Integer difficulty, List<Knowledge> relativeKnowledge, Integer isShare, Integer quoteTimes, Integer viewTimes, Integer questionType, int isDel, Long createTime, Long updateTime, String teacherId, String teacherName, Integer itemType, List<QuestionItem> questionItems, String analyzeQuestion) {
		this.id = id;
		this.catalogCode = catalogCode;
		this.subjectId = subjectId;
		this.questionTitle = questionTitle;
		this.rightAnswer = rightAnswer;
		this.difficulty = difficulty;
		this.relativeKnowledge = relativeKnowledge;
		this.isShare = isShare;
		this.quoteTimes = quoteTimes;
		this.viewTimes = viewTimes;
		this.questionType = questionType;
		this.isDel = isDel;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.itemType = itemType;
		this.questionItems = questionItems;
		this.analyzeQuestion = analyzeQuestion;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCatalogCode() {
		return catalogCode;
	}

	public void setCatalogCode(String catalogCode) {
		this.catalogCode = catalogCode;
	}

	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public String getRightAnswer() {
		return rightAnswer;
	}

	public void setRightAnswer(String rightAnswer) {
		this.rightAnswer = rightAnswer;
	}

	public Integer getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Integer difficulty) {
		this.difficulty = difficulty;
	}

	public List<Knowledge> getRelativeKnowledge() {
		return relativeKnowledge;
	}

	public void setRelativeKnowledge(List<Knowledge> relativeKnowledge) {
		this.relativeKnowledge = relativeKnowledge;
	}

	public Integer getIsShare() {
		return isShare;
	}

	public void setIsShare(Integer isShare) {
		this.isShare = isShare;
	}

	public Integer getQuoteTimes() {
		return quoteTimes;
	}

	public void setQuoteTimes(Integer quoteTimes) {
		this.quoteTimes = quoteTimes;
	}

	public Integer getViewTimes() {
		return viewTimes;
	}

	public void setViewTimes(Integer viewTimes) {
		this.viewTimes = viewTimes;
	}

	public Integer getQuestionType() {
		return questionType;
	}

	public void setQuestionType(Integer questionType) {
		this.questionType = questionType;
	}

	public int getIsDel() {
		return isDel;
	}

	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public Long getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Long updateTime) {
		this.updateTime = updateTime;
	}

	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public Integer getItemType() {
		return itemType;
	}

	public void setItemType(Integer itemType) {
		this.itemType = itemType;
	}

	public List<QuestionItem> getQuestionItems() {
		return questionItems;
	}

	public void setQuestionItems(List<QuestionItem> questionItems) {
		this.questionItems = questionItems;
	}


}
