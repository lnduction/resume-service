package com.testresume.service.Impl;

import com.testresume.entity.Resume;
import com.testresume.exeption.CantCompleteClientRequestException;
import com.testresume.repository.ResumeRepository;
import com.testresume.service.ResumeService;
import com.testresume.util.CreateUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeServiceImpl implements ResumeService {

    @Autowired
    private ResumeRepository resumeRepository;

    private static final int MAX_COUNT_GENERATE_UID = 5;

    private String generateAccountUid(Resume resume) throws CantCompleteClientRequestException {
        String baseUid = CreateUID.generateProfileUid(resume);
        String uid = baseUid;
        for (int i = 0; resumeRepository.countByUid(uid) > 0; i++) {
            uid = CreateUID.regenerateUidWithRandomSuffix(baseUid);
            if (i >= MAX_COUNT_GENERATE_UID)
                throw new CantCompleteClientRequestException("Can't generate unique uid for profile: " + baseUid + " : maxTryCountToGenerateUid detected");
        } return uid;
    }

    @Override
    public void saveResume(Resume resume) {
        resume.setUid(generateAccountUid(resume));
        Resume res = resumeRepository.findById(resume.getId());
        if (res != null) resumeRepository.delete(res);
        resumeRepository.save(resume);
    }

    @Override
    public void removeResume(String uid) {
        Resume resume = resumeRepository.findByUid(uid);
        if (resume != null) resumeRepository.delete(resume);
    }

    @Override
    public List<Resume> getResume() {
        return resumeRepository.findAll();
    }

    @Override
    public Resume findResume(String uid) {
        return resumeRepository.findByUid(uid);
    }
}
