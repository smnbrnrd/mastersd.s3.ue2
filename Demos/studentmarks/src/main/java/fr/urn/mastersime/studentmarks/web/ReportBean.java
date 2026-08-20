package fr.urn.mastersime.studentmarks.web;

import fr.urn.mastersime.studentmarks.domain.EvaluationReport;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("report")
@SessionScoped
public class ReportBean implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EvaluationReport marks;

    public EvaluationReport getMarks() {
        return marks;
    }

}
