package com.donada.dataweave;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class MockitoSanityTest {
    @Test
    void mockitoWorks() {
        DataSource ds = Mockito.mock(DataSource.class);
        assertNotNull(ds);
    }
}
