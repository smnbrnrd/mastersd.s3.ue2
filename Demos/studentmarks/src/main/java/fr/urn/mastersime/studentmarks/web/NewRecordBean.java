package fr.urn.mastersime.studentmarks.web;

import fr.urn.mastersime.studentmarks.domain.EvaluationRecord;
import fr.urn.mastersime.studentmarks.domain.EvaluationReport;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("newRecord")
@ViewScoped
public class NewRecordBean implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EvaluationReport marks;

    private EvaluationRecord mark = new EvaluationRecord();

    public EvaluationRecord getMark() {
        return mark;
    }

    public void setMark(EvaluationRecord mark) {
        this.mark = mark;
    }

    public String addRecord() {
        marks.addRecord(mark);
        mark = new EvaluationRecord(); // Reset the form
        return "report?faces-redirect=true";
    }

}
