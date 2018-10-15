package me.snowdrop.reactiveweb;

import org.junit.Test;

import io.reactivex.Observable;

import static junit.framework.Assert.assertTrue;

public class SimpleObservableTest {

    String result = "";

    // Simple subscription to a fix value
    @Test
    public void returnAValue() {
        result = "";
        Observable<String> observer = Observable.just("Hello"); // provides datea
        observer.subscribe(s -> result = s); // Callable as subscriber
        assertTrue(result.equals("Hello"));
    }
}
