package com.epam.feel.server.util;

import junit.framework.Assert;
import org.junit.Test;

public class QueryUtilsTest {

    @Test
    public void testLikeExpressions() {
        Assert.assertEquals(QueryUtils.getLikeExpression(""), "%");
        Assert.assertEquals(QueryUtils.getLikeExpression("aa"), "%aa%");
        Assert.assertEquals(QueryUtils.getLikeExpression("a b c"), "%a%b%c%");
        Assert.assertEquals(QueryUtils.getLikeExpression(" a      b        c        "), "%a%b%c%");
    }

}
