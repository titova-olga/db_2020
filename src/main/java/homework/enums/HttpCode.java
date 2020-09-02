package homework.enums;

import java.util.HashMap;
import java.util.Map;

public enum HttpCode {

    INFORMATIONAL(1) {
        @Override
        void sendMessage() {
            System.out.println("Informational...");
        }
    },

    SUCCESS(2) {
        @Override
        void sendMessage() {
            System.out.println("Success...");
        }
    },

    REDIRECTION(3) {
        @Override
        void sendMessage() {
            System.out.println("Redirection...");
        }
    },

    CLIENT_ERROR(4) {
        @Override
        void sendMessage() {
            System.out.println("Client error...");
        }
    },

    SERVER_ERROR(5) {
        @Override
        void sendMessage() {
            System.out.println("System error...");
        }
    };

    private final int headDigitInCode;

    HttpCode(int headDigitInCode) {
        this.headDigitInCode = headDigitInCode;
    }

    abstract void sendMessage();

    private static final Map<Integer, HttpCode> HTTP_CODE_MAP;

    static {
        HTTP_CODE_MAP = new HashMap<>();
        for (HttpCode code : HttpCode.values()) {
            HTTP_CODE_MAP.put(code.headDigitInCode, code);
        }
    }

    public static HttpCode findByKey(int headDigit) {
        return HTTP_CODE_MAP.get(headDigit);
    }

    /*public HttpCode getHandlerByHeadDigit(int headDigit) {
        for (HttpCode httpCode : HttpCode.values()) {
            if (httpCode.headDigitInCode == headDigit) {
                return httpCode;
            }
        }
        return null;
    }*/
}
