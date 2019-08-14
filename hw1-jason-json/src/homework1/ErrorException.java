package homework1;

import java.net.MalformedURLException;

class ErrorException extends MalformedURLException {

        public ErrorException(String message)
        {
            super(message);
        }
    }
