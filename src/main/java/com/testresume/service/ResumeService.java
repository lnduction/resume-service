package com.testresume.service;

import com.testresume.entity.Resume;

import java.util.List;

public interface ResumeService {

    public void saveResume(Resume resume);
    public void removeResume(String uid);
    public List<Resume> getResume();
    public Resume findResume(String uid);
}
