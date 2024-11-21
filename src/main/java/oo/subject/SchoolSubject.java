package oo.subject;

import oo.observer.SchoolObserver;

import java.util.ArrayList;
import java.util.List;

public abstract class SchoolSubject {

    protected List<SchoolObserver> schoolObservers = new ArrayList<>();

    public void attach(SchoolObserver schoolObserver) {
        schoolObservers.add(schoolObserver);
    }

    public void noticeAllObserver() {
        schoolObservers.stream()
                .forEach(classLeaderObserver -> classLeaderObserver.noticeSchoolStart());
    }

}
