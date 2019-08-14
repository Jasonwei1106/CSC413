package homework1;

import java.util.*;

public class PostData {
    private final static Map<Integer, PostData> postInfo = new HashMap<>();

    private int postID, userID;
    private String data;

    public PostData(int POST, int USER, String DATA) {
        this.postID = POST;
        this.userID = USER;
        this.data = DATA;
    }

    public String getPostData() {
        return this.data;
    }

    public int getPostID() {
        return this.postID;
    }

    public int getUserID() {
        return this.userID;
    }
}
