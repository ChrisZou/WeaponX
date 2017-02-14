package com.chriszou.weaponx;

import java.util.ArrayList;
import java.util.Comparator;

import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Func2;

/**
 * Created by xiaochuang on 07/11/2016.
 */

public class ArrayListX<E> extends ArrayList<E> implements ListX<E> {
    @Override
    public <R> ListX<R> map(Func1<? super E, ? extends R> func) {
        ArrayListX<R> result = new ArrayListX<>();
        for (E elem : this) {
            result.add(func.call(elem));
        }

        return result;
    }

    public <R> R reduce(R initialValue, final Func2<R, ? super E, R> accumulator) {
        R result = initialValue;
        for (E elem: this) {
            result = accumulator.call(result, elem);
        }
        return result;
    }

    @Override
    public boolean any(Func1<? super E, Boolean> predicate) {
        for (E e : this) {
            if (predicate.call(e)) return true;
        }

        return false;
    }

    @Override
    public boolean all(Func1<? super E, Boolean> predicate) {
        for (E e : this) {
            if (!predicate.call(e)) return false;
        }

        return true;
    }

    @Override
    public boolean none(Func1<? super E, Boolean> predicate) {
        for (E e : this) {
            if (predicate.call(e)) return false;
        }

        return true;
    }

    @Override
    public int count(final Func1<? super E, Boolean> predicate) {
        int count = 0;
        for (E e : this) {
            if (predicate.call(e)) count ++;
        }

        return count;
    }

    @Override
    public E find(Func1<? super E, Boolean> predicate) {
        for (E e : this) {
            if (predicate.call(e)) return e;
        }
        return null;
    }

    /**
     * Filters items by only those that satisfy a specified predicate.
     * @param predicate
     * @return A ListX containing only those items that the filter evaluates as {@code true}.
     *  Return an empty list if none of the items in this list satisfies the {@code predicate}
     */
    @Override
    public ArrayListX<E> select(Func1<? super E, Boolean> predicate) {
        ArrayListX<E> result = new ArrayListX<>();
        for (E e : this) {
            if (predicate.call(e)) result.add(e);
        }

        return result;
    }

    /**
     * Find the index of the first element that satisfies the given predicate
     * @param predicate
     * @return the index of the first element that satisfies the given predicate, or -1 if none found.
     */
    @Override
    public int findIndex(Func1<? super E, Boolean> predicate) {
        for (int i = 0; i < size(); i++) {
            if (predicate.call(get(i))) return i;
        }

        return -1;
    }

    @Override
    public E first() {
        return size() > 0 ? get(0) : null;
    }

    @Override
    public E last() {
        return size() > 0 ? get(size() -1) : null;
    }

    @Override
    public ListX<E> take(int count) {
        return null;
    }

    @Override
    public ListX<E> sort() {
        return null;
    }

    @Override
    public ListX<E> sortBy(Comparator<E> comparator) {
        return null;
    }

    @Override
    public void each(final Action1<? super E> action) {
        for (E e : this) {
            action.call(e);
        }
    }

    @Override
    public void eachWithIndex(Action1<? super E> onNext) {

    }

}
