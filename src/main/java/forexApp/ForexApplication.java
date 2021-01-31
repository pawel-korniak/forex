package forexApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <h1>Forex App</h1>
 * main controller accessed by localhost:8080/
 * select file from '/data' directory
 * type 'help' to get available commands
 * history of session saved in logs/logfile-yyyy-mm-ddThh:mm:ss.txt
 *
 * also possible te get response by request to localhost:8080/request/{your_request}
 * for example localhost:8080/request/get low 2020.11.01 17:20
 *
 * request for localhost:8080/EURUSD/yyyy/mm/dd/hh/mm gives you all data of that date
 *
 * try DOCKER image at pawelkorniak/forex
 *
 * @author  Paweł Korniak
 * @version HW3.0
 * @since   2021-01-31
 */
@SpringBootApplication
public class ForexApplication {

    public static void main(String[] args) {
        SpringApplication.run(ForexApplication.class, args);
    }

}
