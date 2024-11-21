package oo;

import java.util.ArrayList;
import java.util.List;

public abstract class ClassLeaderSubject {

    protected List<ClassLeaderChangeObserver> classLeaderChangeObservers = new ArrayList<>();

    public void attach(ClassLeaderChangeObserver classLeaderChangeObserver) {
        classLeaderChangeObservers.add(classLeaderChangeObserver);
    }

    void noticeAllObserver(Klass klass) {
        classLeaderChangeObservers.stream()
                .forEach(classLeaderChangeObserver -> classLeaderChangeObserver.noticeKlassLeaderUpdate(klass));
    }

}
