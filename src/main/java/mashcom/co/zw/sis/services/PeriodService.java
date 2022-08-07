package mashcom.co.zw.sis.services;

import mashcom.co.zw.sis.models.ActivePeriodRegistration;
import mashcom.co.zw.sis.models.ActivePeriodResults;
import mashcom.co.zw.sis.models.Period;
import mashcom.co.zw.sis.repositories.ActivePeriodRegistrationRepository;
import mashcom.co.zw.sis.repositories.ActivePeriodResultRepository;
import mashcom.co.zw.sis.repositories.PeriodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeriodService {

    @Autowired
    PeriodRepository periodRepository;

    @Autowired
    ActivePeriodRegistrationRepository activePeriodRegistrationRepository;

    @Autowired
    ActivePeriodResultRepository activePeriodResultRepository;

    public Period savePeriod(Period period) {
        return periodRepository.save(period);
    }

    public ActivePeriodRegistration saveRegistrationPeriod(ActivePeriodRegistration period) {
        return activePeriodRegistrationRepository.save(period);
    }

    public ActivePeriodResults saveResultsPeriod(ActivePeriodResults period) {
        return activePeriodResultRepository.save(period);
    }

    public Boolean deleteResultsPeriod(ActivePeriodResults period) {
        activePeriodResultRepository.delete(period);
        var periodDeleted = activePeriodResultRepository.findById(period.getPeriodId());
        return periodDeleted.isEmpty();
    }

    public Boolean deleteRegistrationPeriod(ActivePeriodRegistration period) {
        activePeriodRegistrationRepository.delete(period);
        var periodDeleted = activePeriodRegistrationRepository.findById(period.getPeriodId());
        return periodDeleted.isEmpty();
    }


}
