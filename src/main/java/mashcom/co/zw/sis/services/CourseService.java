package mashcom.co.zw.sis.services;

import mashcom.co.zw.sis.models.Course;
import mashcom.co.zw.sis.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public Optional<Course> findById(Integer id){
        return courseRepository.findById(id);
    }

    public Course saveNewCourse(Course course){
        return courseRepository.save(course);
    }


}
