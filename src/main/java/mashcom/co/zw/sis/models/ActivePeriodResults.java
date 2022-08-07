package mashcom.co.zw.sis.models;

import javax.persistence.*;

@Entity
@Table(name = "active_period_results")
public class ActivePeriodResults {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer periodId;


    public Integer getPeriodId() {
        return periodId;
    }

    public void setPeriodId(Integer periodId) {
        this.periodId = periodId;
    }
}
