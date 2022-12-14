package com.fastcampus.jpa.bookmanager.service;

import com.fastcampus.jpa.bookmanager.domain.Comment;
import com.fastcampus.jpa.bookmanager.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Transactional
    public void init() {
        for(int i = 0; i < 10; i++){
            var comment = new Comment();
            comment.setComment("최고에요");

            commentRepository.save(comment);
        }
    }

    @Transactional(readOnly = true)  //더티 체크 방지  Transactional 사용시 entity 캐시가 남아있으면 스스로 저장이나 수정 쿼리를 일으킴
    public void updateSomething() {
        List<Comment> comments = commentRepository.findAll();

        for(Comment comment : comments){
            comment.setComment("별로에요");
//            commentRepository.save(comment);
        }
    }

    @Transactional
    public void insertSomething() {
//        var comment = new Comment();
        var comment =commentRepository.findById(1L).get();
        comment.setComment("이건뭐죠?");
//        commentRepository.save(comment);
    }
}
