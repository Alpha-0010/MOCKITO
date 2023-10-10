package com.example.mockito.mockitodemo.business;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SomeBusinessImplMockTest {

    @Test
    void test1() {
        DataService dataServiceMock = mock(DataService.class);
//        dataServiceMock.retrieveAllData() => new int[]{25, 35, 100};

        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{25, 35, 100});
        SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);
        int res = businessImpl.findTheGreatestFromAllData();
        assertEquals(100, res);
    }

    @Test
    void test2() {
        DataService dataServiceMock = mock(DataService.class);

        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{35});
        SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);
        int res = businessImpl.findTheGreatestFromAllData();
        assertEquals(35,res);
    }

    /*
    * Making using Mockito even Simpler. By using these 2 annotations now we don't need to create dataServiceMock and
    * an instance of SomeBusinessImpl for each of the test cases.
    * */
    @Mock
    private DataService dataServiceMock;

    @InjectMocks
    private SomeBusinessImpl businessImpl;

    @Test
    void test3() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{25, 35, 100});
        int res = businessImpl.findTheGreatestFromAllData();
        assertEquals(100, res);
    }

    @Test
    void test4() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{});
        assertEquals(Integer.MIN_VALUE, businessImpl.findTheGreatestFromAllData());
    }
}
