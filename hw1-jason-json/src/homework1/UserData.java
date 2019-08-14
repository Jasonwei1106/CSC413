package homework1;

import java.util.*;

public class UserData {
    private final static Map<Integer, UserData> userInfo = new HashMap<>();

    private String username;
    private int userID;

    public UserData(String USERNAME, int USERID) {
        this.username = USERNAME;
        this.userID = USERID;

        userInfo.put(userID, this);
    }

    public String getUserName() {
        return this.username;
    }

    public int getUserID() {
        return this.userID;
    }
}
