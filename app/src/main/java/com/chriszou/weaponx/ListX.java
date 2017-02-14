package com.chriszou.weaponx;

import java.util.Comparator;
import java.util.List;

/**
 * Created by xiaochuang on 07/11/2016.
 */

public interface ListX<E> extends List<E>{
    void each(final Action1<? super E> onNext);
    void eachWithIndex(final Action1<? super E> onNext);

    <R> ListX<R> map(Func1<? super E, ? extends R> func);
    <R> R reduce(R initialValue, Func2<R, ? super E, R> accumulator);

    boolean any(Func1<? super E, Boolean> predicate);
    boolean all(Func1<? super E, Boolean> predicate);
    boolean none(Func1<? super E, Boolean> predicate);

    int count(Func1<? super E, Boolean> predicate);
    E find(Func1<? super E, Boolean> predicate);
    ListX<E> select(Func1<? super E, Boolean> predicate);
    int findIndex(Func1<? super E, Boolean> predicate);

    E first();
    E last();
    ListX<E> take(int count);

    ListX<E> sort();
    ListX<E> sortBy(Comparator<E> comparator);
}
