package com.example.mockito.mockitodemo.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeBusinessImplStubTest {

    @Test
    void test() {
        DataServiceStubs dataServiceStubs = new DataServiceStubs();
        SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceStubs);
        int res = businessImpl.findTheGreatestFromAllData();
        assertEquals(100, res);
    }
}

/*
    Mocking Using Stubs -> Create a Stub of the method if the method have not been implemented.
    i) One problem with creating stubs is we are making changes to the interface then we will have to make changes to the
    stub class as well.
    ii) Another problem with stubs is if we want to test multiple scenarios then we will have to create multiple stubs
    for each scenario.
 */
class DataServiceStubs implements DataService {

    @Override
    public int[] retrieveAllData() {
        return new int[]{25, 35, 100};
    }
}
