package forexApp;

import forexApp.comunication.ComunicationChannel;
import forexApp.forexData.ForexData;
import forexApp.messages.Message;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ComunicationChannelTest {

public static class Fixtures {
    static ComunicationChannel comunicationChannel = new ComunicationChannel(new ForexData("DAT_MT_EURUSD_M1_202011.txt"));
   }

    @Test
    void getResponse_getProperResponse_givenRequest(){
        //given
        String message = "";
        //when

        String answer = Fixtures.comunicationChannel.getResponse(new Message(message));
        String propperAnswer = "No such command. type 'help' for commands list";
        //than
        assertEquals(answer,propperAnswer);
    }
    @Test
    void getResponse_getProperResponse_givenRequest2(){
        //given
        String message = "get 2020.11.13 14:37";
        String propperAnswer = "1.18332,1.18334,1.18327,1.18328";
        //when
        String answer = Fixtures.comunicationChannel.getResponse(new Message(message));
        //than
        assertEquals(answer,propperAnswer);
    }
    @Test
    void getResponse_getProperResponse_givenRequest3(){
        //given
        String message = "get 2020.11.13 14";
        String propperAnswer = "1.18249,1.18348,1.18241,1.18327";
        //when
        String answer = Fixtures.comunicationChannel.getResponse(new Message(message));
        //than
        assertEquals(answer,propperAnswer);
    }
    @Test
    void getResponse_getProperResponse_givenRequest4(){
        //given
        String message = "get 2020.11.13";
        String propperAnswer = "1.18038,1.18374,1.18007,no data";
        //when
        String answer = Fixtures.comunicationChannel.getResponse(new Message(message));
        //than
        assertEquals(answer,propperAnswer);
    }
    @Test
    void getResponse_getProperResponse_givenRequest5(){
        //given
        String message = "get high 2020.11.13 14:37";
        String propperAnswer = "1.18334";
        //when
        String answer = Fixtures.comunicationChannel.getResponse(new Message(message));
        //than
        assertEquals(answer,propperAnswer);
    }
    @Test
    void getResponse_getProperResponse_givenRequest6(){
        //given
        String message = "get high 2020.11.13 14";
        String propperAnswer = "1.18348";
        //when
        String answer = Fixtures.comunicationChannel.getResponse(new Message(message));
        //than
        assertEquals(answer,propperAnswer);
    }
    @Test
    void getResponse_getProperResponse_givenRequest7(){
        //given
        String message = "get high 2020.11.13";
        String propperAnswer = "1.18374";
        //when
        String answer = Fixtures.comunicationChannel.getResponse(new Message(message));
        //than
        assertEquals(answer,propperAnswer);
    }
    @Test
    void getResponse_getProperResponse_givenRequest8(){
        //given
        String message = "get low 2020.11.13 14:37";
        String propperAnswer = "1.18327";
        //when
        String answer = Fixtures.comunicationChannel.getResponse(new Message(message));
        //than
        assertEquals(answer,propperAnswer);
    }
    @Test
    void getResponse_getProperResponse_givenRequest9(){
        //given
        String message = "get low 2020.11.13 14";
        String propperAnswer = "1.18241";
        //when
        String answer = Fixtures.comunicationChannel.getResponse(new Message(message));
        //than
        assertEquals(answer,propperAnswer);
    }
    @Test
    void getResponse_getProperResponse_givenRequest10(){
        //given
        String message = "get low 2020.11.13";
        String propperAnswer = "1.18007";
        //when
        String answer = Fixtures.comunicationChannel.getResponse(new Message(message));
        //than
        assertEquals(answer,propperAnswer);
    }
    @Test
    void getResponse_getProperResponse_givenRequest11(){
        //given
        String message = "get open 2020.11.13 14:37";
        String propperAnswer = "1.18332";
        //when
        String answer = Fixtures.comunicationChannel.getResponse(new Message(message));
        //than
        assertEquals(answer,propperAnswer);
    }
    @Test
    void getResponse_getProperResponse_givenRequest12(){
        //given
        String message = "get open 2020.11.13 14";
        String propperAnswer = "1.18249";
        //when
        String answer = Fixtures.comunicationChannel.getResponse(new Message(message));
        //than
        assertEquals(answer,propperAnswer);
    }

    @Test
    void getResponse_getProperResponse_givenRequest13(){
        //given
        String message = "get open 2020.11.13";
        String propperAnswer = "1.18038";
        //when
        String answer = Fixtures.comunicationChannel.getResponse(new Message(message));
        //than
        assertEquals(answer,propperAnswer);
    }
    @Test
    void getResponse_getProperResponse_givenRequest14(){
        //given
        String message = "get close 2020.11.13 14:37";
        String propperAnswer = "1.18328";
        //when
        String answer = Fixtures.comunicationChannel.getResponse(new Message(message));
        //than
        assertEquals(answer,propperAnswer);
    }
    @Test
    void getResponse_getProperResponse_givenRequest15(){
        //given
        String message = "get close 2020.11.13 14";
        String propperAnswer = "1.18327";
        //when
        String answer = Fixtures.comunicationChannel.getResponse(new Message(message));
        //than
        assertEquals(answer,propperAnswer);
    }
    @Test
    void getResponse_getProperResponse_givenRequest16(){
        //given
        String message = "get close 2020.11.13";
        String propperAnswer = "no data";
        //when
        String answer = Fixtures.comunicationChannel.getResponse(new Message(message));
        //than
        assertEquals(answer,propperAnswer);
    }
    @Test
    void getResponse_getProperResponse_givenRequest17(){
        //given
        String message = "volatility 2020.11.13 14:37";
        String propperAnswer = "0.00007";
        //when
        String answer = Fixtures.comunicationChannel.getResponse(new Message(message));
        //than
        assertEquals(answer,propperAnswer);
    }
    @Test
    void getResponse_getProperResponse_givenRequest18(){
        //given
        String message = "volatility 2020.11.13 14";
        String propperAnswer = "0.00107";
        //when
        String answer = Fixtures.comunicationChannel.getResponse(new Message(message));
        //than
        assertEquals(answer,propperAnswer);
    }
    @Test
    void getResponse_getProperResponse_givenRequest19(){
        //given
        String message = "volatility 2020.11.13";
        String propperAnswer = "0.00367";
        //when
        String answer = Fixtures.comunicationChannel.getResponse(new Message(message));
        //than
        assertEquals(answer,propperAnswer);
    }
    @Test
    void getResponse_getProperResponse_givenRequest20(){
        //given
        String message = "most_volatile_day";
        String propperAnswer = "0.01678";
        //when
        String answer = Fixtures.comunicationChannel.getResponse(new Message(message));
        //than
        assertEquals(answer,propperAnswer);
    }
    @Test
    void getResponse_getProperResponse_givenRequest21(){
        //given
        String message = "most_volatile_hour";
        String propperAnswer = "0.00832";
        //when
        String answer = Fixtures.comunicationChannel.getResponse(new Message(message));
        //than
        assertEquals(answer,propperAnswer);
    }
    @Test
    void getResponse_getProperResponse_givenRequest22(){
        //given
        String message = "average_minutely_volatility";
        String propperAnswer = "0.00016";
        //when
        String answer = Fixtures.comunicationChannel.getResponse(new Message(message));
        //than
        assertEquals(answer,propperAnswer);
    }

    @Test
    void getResponse_getProperResponse_givenRequest24(){
        //given
        String message = "average_hourly_volatility";
        String propperAnswer = "0.00144";
        //when
        String answer = Fixtures.comunicationChannel.getResponse(new Message(message));
        //than
        assertEquals(answer,propperAnswer);
    }
    @Test
    void getResponse_getProperResponse_givenRequest25(){
        //given
        String message = "average_daily_volatility";
        String propperAnswer = "0.00648";
        //when
        String answer = Fixtures.comunicationChannel.getResponse(new Message(message));
        //than
        assertEquals(answer,propperAnswer);
    }
    @Test
    void getResponse_getProperResponse_givenRequest26(){
        //given
        String message = "quit";
        String propperAnswer = "quit";
        //when
        String answer = Fixtures.comunicationChannel.getResponse(new Message(message));
        //than
        assertEquals(answer,propperAnswer);
    }
    @Test
    void getResponse_getProperResponse_givenRequest27(){
        //given
        String message = "help";
        String propperAnswer = "help";
        //when
        String answer = Fixtures.comunicationChannel.getResponse(new Message(message));
        //than
        assertEquals(answer,propperAnswer);
    }
}