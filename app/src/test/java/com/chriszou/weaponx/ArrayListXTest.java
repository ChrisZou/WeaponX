package com.chriszou.weaponx;

import com.chriszou.weaponx.ArrayListX;
import com.chriszou.weaponx.ArrayListX;
import com.chriszou.weaponx.ListX;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by xiaochuang on 05/12/2016.
 */
public class ArrayListXTest {
    ArrayListX<String> mList;
    ArrayListX<String> emptyList;
    @Before
    public void setUp() throws Exception {
        mList = new ArrayListX<>();
        mList.add("Hello");
        mList.add("World");
        mList.add("ChrisZou");
        mList.add("");

        emptyList = new ArrayListX<>();
    }

    @Test
    public void map() throws Exception {
        ListX<Integer> results = mList.map(new Func1<String, Integer>() {
            @Override
            public Integer call(String s) {
                return s.length();
            }
        });

        ArrayListX<Integer> expected = new ArrayListX<>();
        expected.add(5);
        expected.add(5);
        expected.add(8);
        expected.add(0);

        ae(results, expected);
    }


    @Test
    public void reduce() throws Exception {
        Integer result = mList.reduce(0, new Func2<Integer, String, Integer>() {
            @Override
            public Integer call(Integer integer, String s) {
                return integer + s.length();
            }
        });

        ae(18, result);
    }

    @Test
    public void any() throws Exception {
        boolean shouldBeFalse = mList.any(new Func1<String, Boolean>() {
            @Override
            public Boolean call(String s) {
                return s.length() == 1;
            }
        });
        af(shouldBeFalse);

        boolean shouldBeTrue = mList.any(new Func1<String, Boolean>() {
            @Override
            public Boolean call(String s) {
                return s.equals("ChrisZou");
            }
        });
        at(shouldBeTrue);
    }


    @Test
    public void all() throws Exception {
        boolean shouldBeFalse = mList.all(new Func1<String, Boolean>() {
            @Override
            public Boolean call(String s) {
                return s.length() > 0;
            }
        });
        af(shouldBeFalse);

        boolean shouldBeTrue = mList.all(new Func1<String, Boolean>() {
            @Override
            public Boolean call(String s) {
                return s != null;
            }
        });
        at(shouldBeTrue);
    }

    @Test
    public void none() throws Exception {
        boolean shouldBeFalse = mList.none(new Func1<String, Boolean>() {
            @Override
            public Boolean call(String s) {
                return s.length() > 7;
            }
        });
        af(shouldBeFalse);

        boolean shouldBeTrue = mList.none(new Func1<String, Boolean>() {
            @Override
            public Boolean call(String s) {
                return s.length() > 9;
            }
        });
        at(shouldBeTrue);
    }

    @Test
    public void count() throws Exception {
        ae(2, mList.count(new Func1<String, Boolean>() {
            @Override
            public Boolean call(String s) {
                return s.length() == 5;
            }
        }));

        ae(0, mList.count(new Func1<String, Boolean>() {
            @Override
            public Boolean call(String s) {
                return s.length() > 10;
            }
        }));
    }

    @Test
    public void find() throws Exception {
        ae("ChrisZou", mList.find(new Func1<String, Boolean>() {
            @Override
            public Boolean call(String s) {
                return s.length() == 8;
            }
        }));
    }

    @Test
    public void select() throws Exception {
        ListX<String> expected = new ArrayListX<>();
        expected.add("Hello");
        expected.add("World");

        ae(expected, mList.select(new Func1<String, Boolean>() {
            @Override
            public Boolean call(String s) {
                return s.length() == 5;
            }
        }));

        ae(new ArrayListX<>(), mList.select(new Func1<String, Boolean>() {
            @Override
            public Boolean call(String s) {
                return s.equals("hey, yoo!");
            }
        }));
    }

    @Test
    public void findIndex() throws Exception {
        ae(2, mList.findIndex(new Func1<String, Boolean>() {
            @Override
            public Boolean call(String s) {
                return s.length() == 8;
            }
        }));

        ae(-1, mList.findIndex(new Func1<String, Boolean>() {
            @Override
            public Boolean call(String s) {
                return s.length() == 3;
            }
        }));
    }

    @Test
    public void first() throws Exception {
        ae("Hello", mList.first());
        ae(null, emptyList.first());
    }

    @Test
    public void last() throws Exception {
        ae("", mList.last());
        ae(null, emptyList.last());
    }

    @Test
    public void take() throws Exception {

    }

    @Test
    public void sort() throws Exception {

    }

    @Test
    public void sortBy() throws Exception {

    }

    @Test
    public void each() throws Exception {

    }

    @Test
    public void eachWithIndex() throws Exception {

    }

    private void ae(Object expected, Object actual) {
        Assert.assertEquals(expected, actual);
    }

    private void af(boolean actual) {
        Assert.assertFalse(actual);
    }

    private void at(boolean actual) {
        Assert.assertTrue(actual);
    }

}