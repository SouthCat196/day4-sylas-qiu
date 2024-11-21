package oo.subject;

import oo.Klass;
import oo.observer.ClassLeaderObserver;

import java.util.ArrayList;
import java.util.List;

public abstract class ClassLeaderSubject {

    protected List<ClassLeaderObserver> classLeaderObservers = new ArrayList<>();

    public void attach(ClassLeaderObserver classLeaderObserver) {
        classLeaderObservers.add(classLeaderObserver);
    }

    public void noticeAllObserver(Klass klass) {
        classLeaderObservers.stream()
                .forEach(classLeaderObserver -> classLeaderObserver.noticeKlassLeaderUpdate(klass));
    }

}
