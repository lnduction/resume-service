package com.testresume.repository;

import com.testresume.entity.Resume;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ResumeRepository extends MongoRepository<Resume, String> {

    Resume findByUid(String uid);

    int countByUid(String uid);

    List<Resume> findAll();

    Resume findById(ObjectId id);


}
