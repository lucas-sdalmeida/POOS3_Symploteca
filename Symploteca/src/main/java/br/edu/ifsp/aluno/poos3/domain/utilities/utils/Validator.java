package br.edu.ifsp.aluno.poos3.domain.utilities.utils;

import java.util.Collection;

public abstract class Validator<T> {
    public abstract Notification validate(T object);

    public static boolean isNullOrEmpty(String string) {
        return string == null || string.isEmpty();
    }

    public static boolean isNullOrEmpty(Collection collection) {
        return collection == null || collection.isEmpty();
    }
}
