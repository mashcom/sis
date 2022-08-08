package mashcom.co.zw.sis.services;

import mashcom.co.zw.sis.models.Exam;
import mashcom.co.zw.sis.models.ExamResult;
import mashcom.co.zw.sis.models.ExamType;
import mashcom.co.zw.sis.repositories.ExamRepository;
import mashcom.co.zw.sis.repositories.ExamResultRepository;
import mashcom.co.zw.sis.repositories.ExamTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamService {

    @Autowired
    ExamRepository examRepository;

    @Autowired
    ExamTypeRepository examTypeRepository;

    @Autowired
    ExamResultRepository examResultRepository;

    public ExamType saveExamType(ExamType examType) {
        return examTypeRepository.save(examType);
    }

    public Exam saveExam(Exam exam) {
        return examRepository.save(exam);
    }

    public ExamResult saveExamResult(ExamResult examResult) {
        return examResultRepository.save(examResult);
    }
}
