package HM12;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class StringChangerServiceUnitTest {
    @Spy
    @InjectMocks
    private StringChangerService stringChangerService;


    @Mock
    private StringLowerUpperService lowerUpperService;


    @Before
    public void setUp() {
        when(lowerUpperService.toUpper(Mockito.anyString())).thenReturn("Upper");
    }

    @Test(expected = NullPointerException.class)
    public void testAddStartUpperInputLowerNull() {
        when(lowerUpperService.toLower(Mockito.isNull())).thenThrow(NullPointerException.class);
        stringChangerService.addStartUpperInputLower("some", null);
    }

    @Test
    public void addStartUpperInputLowerVerify() {
        stringChangerService.addStartUpperInputLower("start", "input");
        verify(lowerUpperService, times(1)).toLower("input");
        verify(lowerUpperService, times(1)).toUpper("start");
    }

    @Test
    public void addStartUpperInputLower() {
        when(lowerUpperService.toLower(Mockito.anyString())).thenReturn("lower");
        String expected = "Upperlower";
        String actual = stringChangerService.addStartUpperInputLower("qw", "qw");
        assertEquals(expected, actual);
    }

    @Test
    public void addStartAndEnd() {

        doReturn("Start").when(stringChangerService).addStart(Mockito.anyString(), Mockito.anyString());
        String expected = "Startend";
        String actual = stringChangerService.addStartAndEnd("start", "end", "input");
        assertEquals(expected, actual);
    }

    @Test
    public void testAddStartAndEndVerify() {
        stringChangerService.addStartAndEnd("start", "END", "input");
        verify(stringChangerService).addStart("start", "input");
    }

    @Test(expected = IllegalArgumentException.class)
    public void addStartAndEndTotalLower() {

        doReturn(stringChangerService.addStart(Mockito.anyString(), Mockito.anyString())).when(lowerUpperService).toLower(Mockito.anyString());

        stringChangerService.addStartAndEndTotalLower("start", "end", "start");
        verify(lowerUpperService).toLower("startstartend");
    }


}




