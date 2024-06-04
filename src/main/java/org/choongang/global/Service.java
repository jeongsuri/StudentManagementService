package org.choongang.global;



public interface Service<T> {
    default void process(T form) {}
    default T process() {
        return null;
    }
    default <T> T get(int no) { return null; }

<<<<<<< HEAD
}
=======
    }
>>>>>>> 965e93ea22c9fa06e69ebc635257bc14e6665e69

