package com.example.shi.service;

import com.example.shi.dto.PageDto;
import com.example.shi.dto.QuestionDto;
import com.example.shi.mapper.QuestionMapper;
import com.example.shi.mapper.UserMapper;
import com.example.shi.model.Question;
import com.example.shi.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;

    public PageDto list(Integer page, Integer size) {
        PageDto pageDto = new PageDto();
        Integer totalCount = questionMapper.count();
        pageDto.setPagination(totalCount, page, size);
        if (page < 1) {
            page = 1;
        }
        if (page > pageDto.getTotalPage()) {
            page = pageDto.getTotalPage();
        }

        Integer offset = size * (page - 1);
        List<Question> questions = questionMapper.list(offset, size);
        List<QuestionDto> questionDtoList = new ArrayList<>();

        for (Question question : questions) {
            User user = userMapper.findById(question.getCreator());
            QuestionDto questionDto = new QuestionDto();
            BeanUtils.copyProperties(question, questionDto);
            questionDto.setUser(user);
            questionDtoList.add(questionDto);
        }
        pageDto.setQuestions(questionDtoList);
        return pageDto;
    }
}
